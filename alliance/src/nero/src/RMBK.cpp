
// -*- C++ -*-
//
// $Id: RMBK.cpp,v 1.1 2002/10/02 21:23:48 jpc Exp $
//
//  /----------------------------------------------------------------\ 
//  |                                                                |
//  |        A l l i a n c e   C A D   S y s t e m                   |
//  |              S i m p l e   R o u t e r                         |
//  |                                                                |
//  |  Author      :                    Jean-Paul CHAPUT             |
//  |  E-mail      :       alliance-support@asim.lip6.fr             |
//  | ============================================================== |
//  |  C++ Module  :       "./RMBK.cpp"                              |
//  | ************************************************************** |
//  |  U p d a t e s                                                 |
//  |                                                                |
//  \----------------------------------------------------------------/




# include  "RDefs.h"




//  /----------------------------------------------------------------\
//  |                     Methods Definitions                        |
//  \----------------------------------------------------------------/


// -------------------------------------------------------------------
// Modifier  :  "CRBox::mbkload()".

void  CRBox::mbkload (MBK::CFig *mbkfig, int z, int rtype)
{
    MBK::MIns::iterator   itIns, endInstances, endOrphans;
  MBK::MLosig::iterator   endSig;
                   long   mX, mY, mZ, x, y, zz;
                   bool   use_global;
        MBK::chain_list  *pChain;
        MBK::locon_list  *pLocon;
        MBK::phcon_list  *pPhcon;
        MBK::losig_list  *pSig;
        MBK::phseg_list  *pSeg, flatSeg;
        MBK::phfig_list  *pModel;
            MBK::CXRect  *rect;
              MBK::CIns  *pIns;
                   CNet  *pNet;
                 string   sig_name, term_name, ins_name;
      CDRGrid::iterator   coord;
                  CNode  *node;


  cmess1 << "\n";
  cmess1 << "  o  Loading design into grid...\n";

  fig = mbkfig;


  // Compute the routing grid size.
  mX = (fig->XAB2 () - fig->XAB1 ()) / D::X_GRID + 1;
  mY = (fig->YAB2 () - fig->YAB1 ()) / D::Y_GRID + 1;
  mZ = z;


  // Selecting the whether to use global routing.
  use_global = (mX + mY) > (2 * D::GLOBAL_HP);
  if (rtype == D::ROUTING_CHOOSE) {
    if (use_global) {
      cmess2 << "     o  Big design, global routing enabled.\n";
      rglobal = true;

      if (z < 5) {
        cmess2 << "        - Forcing 4 routing layers.\n";
        mZ = z = 5;
      }
    } else {
      cmess2 << "     o  Small design, global routing disabled.\n";
      rglobal = false;
    }
  } else {
    if (rtype == D::ROUTING_GLOBAL) {
      rglobal = true;
      if (!use_global) {
        cout << hwarn ("")
             << "  You have enabled global routing on a small design,\n"
             << "  this will waste upper routing layers.\n";
      }
    }
    if (rtype == D::ROUTING_LOCAL ) {
      rglobal = false;
      if (use_global) {
        cout << hwarn ("")
             << "  You have disabled global routing on a big design,\n"
             << "  this will slow down the routing.\n";
      }
    }
  }


  cmess2 << "     o  Allocating grid size ["
         << mX << "," << mY << "," << mZ << "].\n";

  // Allocating the routing grid.
  drgrid = new CDRGrid (mX, mY, mZ);


  rect = new MBK::CXRect (fig->XAB1(), fig->YAB1());


  cmess2 << "     o  Finding obstacles.\n";


  endInstances = fig->instances.end ();
  endOrphans   = fig->orphans.end   ();
  endSig       = fig->lofig.signals.end ();


  // Browse father for obstacles (powers are obstacles) and already
  // routed or partially routed signals.
  for (pSeg = fig->phfig.fig->PHSEG; pSeg != NULL; pSeg = pSeg->NEXT) {
    // There must not be obstacle in the father!
    if (MBK::isobs (pSeg->LAYER)) {
      cerr << hwarn ("")
           << "  An obstacle has been found at design top level, ignored.\n";

      continue;
    }

    // Power grid.
    if ((   MBK::ISVDD (pSeg->NAME)
         || MBK::ISVSS (pSeg->NAME)) && (pSeg->LAYER != MBK::CALU1)) {
      rect->setSeg (*pSeg);
        
      drgrid->nodes->obstacle (rect->grid, MBK::env.layer2z (pSeg->LAYER));

      continue;
    }

    // Unnamed signals : ignored.
    if (pSeg->NAME == NULL) {
      cerr << hwarn ("")
           << "  An unnamed segment has been found at design top level, ignored.\n";

      continue;
    }

    // Partially routed signals.
    if (fig->lofig.signals.find(pSeg->NAME) == endSig) {
      cerr << hwarn ("")
           << "  The segment \"" << pSeg->NAME << "\" at ("
           << MBK::UNSCALE (pSeg->X1) << ","
           << MBK::UNSCALE (pSeg->Y1) << ") ("
           << MBK::UNSCALE (pSeg->X2) << ","
           << MBK::UNSCALE (pSeg->Y2) << ") layer "
           << MBK::layer2a (pSeg->LAYER) << "\n"
           << "  do not not belong to any logical signal : ignored.";

      continue;
    }

    pNet = getnet (pSeg->NAME);

    rect->setSeg  (*pSeg);

    pNet->newaccess ( pSeg->NAME
                    , rect->grid
                    , MBK::env.layer2z (pSeg->LAYER)
                    );
  }


  // Browse layout for terminals.
  for (pPhcon = fig->phfig.fig->PHCON; pPhcon != NULL; pPhcon = pPhcon->NEXT) {
    if (fig->lofig.signals.find(pPhcon->NAME) == endSig) {
      cerr << hwarn ("")
           << "  The terminal \"" << pPhcon->NAME << "\" at ("
           << MBK::UNSCALE (pPhcon->XCON) << ","
           << MBK::UNSCALE (pPhcon->YCON) << ") layer "
           << MBK::layer2a (pPhcon->LAYER) << "\n"
           << "  do not not belong to any logical signal : ignored.\n";

      continue;
    }

    pNet = getnet (pPhcon->NAME);

    term_name  = "external.";
    term_name += pPhcon->NAME;

    flatSeg.X1    = pPhcon->XCON;
    flatSeg.Y1    = pPhcon->YCON;
    flatSeg.X2    = pPhcon->XCON;
    flatSeg.Y2    = pPhcon->YCON;
    flatSeg.WIDTH = MBK::env.layer2width (pPhcon->LAYER);
    flatSeg.LAYER = pPhcon->LAYER;
    flatSeg.NAME  = pPhcon->NAME;

    rect->setSeg  (flatSeg);

    pNet->newaccess ( term_name
                    , rect->grid
                    , MBK::env.layer2z (pPhcon->LAYER)
                    );

  }


  // Browse instances & orphans for obstacles.
  for (itIns = fig->instances.begin(); ; itIns++) {
    if (itIns == endInstances) itIns = fig->orphans.begin ();
    if (itIns == endOrphans  ) break;

    pModel = itIns->second->getmodel ();

    cdebug << "+          - \"" << itIns->first
           << "\" (model \"" << pModel->NAME << "\").\n";


    // Find the obstacles in the current instance :
    // 1. - TALUx segments.
    // 2. - Power Terminals (vdd & vss), in CALUx layers & not CALU1.
    for (pSeg = pModel->PHSEG; pSeg != NULL; pSeg = pSeg->NEXT) {
      if (   MBK::isobs (pSeg->LAYER)
          || ((   MBK::ISVDD (pSeg->NAME)
               || MBK::ISVSS (pSeg->NAME)) && MBK::isCALU (pSeg->LAYER)
                                           && (pSeg->LAYER != MBK::CALU1))) {
        itIns->second->flatseg (flatSeg, *pSeg);
        rect->setSeg (flatSeg);

        drgrid->nodes->obstacle (rect->grid, MBK::env.layer2z (pSeg->LAYER));
      }
    }
  }


  cmess2 << "     o  Loading nets into grid.\n";

  // Process the signals.
  for (pSig = fig->LOSIG (); pSig != NULL; pSig = pSig->NEXT) {
    sig_name = MBK::getsigname (pSig);

    cdebug << "+          - Signal \"" << sig_name << "\".\n";

    // Do not process power nets.
    if (   (MBK::ISVDD ((char*)sig_name.c_str ()) != 0)
        || (MBK::ISVSS ((char*)sig_name.c_str ()) != 0)) continue;

    pNet = getnet (sig_name);

    // Process each terminal of the signal.
    pChain = (MBK::chain_list*)(MBK::getptype (pSig->USER, LOFIGCHAIN)->DATA);

    for (; pChain != NULL; pChain = pChain->NEXT) {
      pLocon = (MBK::locon_list *)(pChain->DATA);

      if (pLocon->TYPE == EXTERNAL) {
        pNet->external = true;


        continue;
      }

      ins_name  = ((MBK::loins_list*)(pLocon->ROOT))->INSNAME;
      pIns      = fig->instances[ins_name];

      term_name = ins_name + "." + pLocon->NAME;

      // Find physical segments / CA of the terminal.
      for (pSeg = pIns->model->PHSEG; pSeg != NULL; pSeg = pSeg->NEXT) {
        if (!MBK::isCALU (pSeg->LAYER)) continue;
        if (pLocon->NAME != pSeg->NAME) continue;

        pIns->flatseg (flatSeg, *pSeg);
        rect->setSeg  (flatSeg);

        pNet->newaccess ( term_name
                        , rect->grid
                        , MBK::env.layer2z (pSeg->LAYER)
                        );
      }
    } // End of "pChain" (terminal) loop.

    // Reorder terminals (nearest).
    pNet->order     ();
    pNet->lockalone ();
    
    cdebug << "+            " << pNet->bb << ".\n";
  } // End of "pSig" (signal) loop.


  // Allocate the net scheduler.
  cmess2 << "     o  Allocating the net scheduler.\n";
  netsched  = new CASimple (&nets, drgrid);


  // Rebuild the power grid from the instances.
  cmess2 << "     o  Reading power grid.\n";
  powers[MBK::CALU1] = new MBK::CPowers ( fig
                                        , C_HORIZONTAL
                                        , MBK::ALU1
                                        , D::WIDTH_VDD
                                        );


  // Forbid the use of the edges of the routing box (only allow
  // peripheral terminals).
  coord = drgrid->origin;

  // Left & Right vertical edges.
  for (x = 0; x < mX; x += mX - 1) {
    for (y = 0; y < mY; y++) {
      for (zz = 1; zz < mZ; zz++) {
        node = &( coord.set(x,y,zz).node() );

        if ( !node->terminal() ) node->data.obstacle = true;
      }
    }
  }

  // Bottom & top horizontal edges.
  for (y = 0; y < mY; y += mY - 1) {
    for (x = 0; x < mX; x++) {
      for (zz = 1; zz < mZ; zz++) {
        node = &( coord.set(x,y,zz).node() );

        if ( !node->terminal() ) node->data.obstacle = true;
      }
    }
  }



  // This flag ensure that a figure has been successfully loaded.
  loaded = true;


  delete rect;
}



// -------------------------------------------------------------------
// Modifier  :  "CRBox::mbksave()".

void  CRBox::mbksave (string &name)
{
                int  x, y, z, mX, mY, mZ;
               bool  inseg;
              CRect  rect;
  CDRGrid::iterator  coord;
              CNode *node;
               CNet *pNextNet, *pNet;
    MBK::phseg_list  seg;
    MBK::phvia_list  via;
    MNet::iterator   itNet, endNet;


  if (!loaded) {
    cerr << hwarn ("")
         << "\n  The MBK figure has not been loaded into the grid yet, nothing"
         << "\n  to save at this point.\n";
      
    return;
  }
  cmess2 << "\n";
  cmess1 << "  o  Dumping routing grid.\n";

  mX = drgrid->X;
  mY = drgrid->Y;
  mZ = drgrid->Z;
  coord = drgrid->origin;
  

  // Horizontal planes loop in both directions.
  for (z = 1; z < mZ; z++) {

    // Loop for horizontal segments.
    for (y = 0; y < mY; y++) {

      inseg = false;
      pNet  = NULL;

      for (x = 0; x < mX; x++) {
        node     = & ( coord.set(x,y,z).node() );
        pNextNet = node->data.owner;

        if (inseg && (pNextNet != pNet)) {
          // We are changing of segment owner.
          // Dump the current one.
          if (seg.X1 < seg.X2) {
            // This is not a "dot" segment (i.e a VIA).
            fig->addphseg (seg);
          }

          // Force segment restarting.
          inseg = false;
        }

        pNet = pNextNet;

        if (pNet) {
          if (!inseg) {
            // We encounter the left edge of a segment.
            inseg = true;

            seg.X1    = fig->XAB1() + x * D::X_GRID;
            seg.Y1    = fig->YAB1() + y * D::Y_GRID;
            seg.Y2    = fig->YAB1() + y * D::Y_GRID;
            seg.NAME  = MBK::namealloc(pNet->name.c_str ());
            seg.WIDTH = MBK::env.z2width (z);

            if (pNet->external) seg.LAYER = MBK::env.z2calu (z);
            else                seg.LAYER = MBK::env.z2alu (z);
          }

          // Update the right edge.
          seg.X2 = fig->XAB1() + x * D::X_GRID;
        } else {
          if (inseg) {
            // Dump the current one.
            if (seg.X1 < seg.X2) {
              // This is not a "dot" segment (i.e a VIA).
              fig->addphseg (seg);
            }
          }

          // We encounter the right edge of a segment.
          inseg = false;
        }
      } // End of "x" loop.

      if (inseg) {
        // This segment touch the AB.
        if (seg.X1 < seg.X2) {
          // This is not a "dot" segment (i.e a VIA).
          fig->addphseg (seg);
        }
      }

    } // End of "y" loop (horizontal segments).

    // Loop for vertical segments.
    for (x = 0; x < mX; x++) {

      inseg = false;
      pNet  = NULL;

      for (y = 0; y < mY; y++) {
        node     = & ( coord.set(x,y,z).node() );
        pNextNet = node->data.owner;

        if (inseg && (pNextNet != pNet)) {
          // We are changing of segment owner.
          // Dump the current one.
          if (seg.Y1 < seg.Y2) {
            // This is not a "dot" segment (i.e a VIA).
            fig->addphseg (seg);
          }

          // Force segment restarting.
          inseg = false;
        }

        pNet = pNextNet;

        if (pNet) {
          if (!inseg) {
            // We encounter the left edge of a segment.
            inseg = true;

            seg.X1    = fig->XAB1() + x * D::X_GRID;
            seg.X2    = fig->XAB1() + x * D::X_GRID;
            seg.Y1    = fig->YAB1() + y * D::Y_GRID;
            seg.NAME  = MBK::namealloc(pNet->name.c_str ());
            seg.WIDTH = MBK::env.z2width (z);

            if (pNet->external) seg.LAYER = MBK::env.z2calu (z);
            else                seg.LAYER = MBK::env.z2alu (z);

          }

          // Update the right edge.
          seg.Y2 = fig->YAB1() + y * D::Y_GRID;
        } else {
          if (inseg) {
            // Dump the current one.
            if (seg.Y1 < seg.Y2) {
              // This is not a "dot" segment (i.e a VIA).
              fig->addphseg (seg);
            }
          }

          // We encounter the right edge of a segment.
          inseg = false;
        }
      } // End of "y" loop.

      if (inseg) {
        // This segment touch the AB.
        if (seg.Y1 < seg.Y2) {
          // This is not a "dot" segment (i.e a VIA).
          fig->addphseg (seg);
        }
      }

    } // End of "x" loop (vertical segments).

  } // End of "z" loop (planes).


  via.DX = 0;
  via.DY = 0;

  // Plane loop for VIAs.
  for (x = 0; x < mX; x++) {
    for (y = 0; y < mY; y++) {

      // Loop on Z axis.
      for (z = 1; z < mZ; z++) {
        node = & ( coord.set(x,y,z).node() );
        if (coord.inside()) pNet = node->data.owner;
        else                pNet = NULL;

        node = & ( coord.set(x,y,z-1).node() );
        if (coord.inside()) pNextNet = node->data.owner;

        if (pNet && (pNet == pNextNet)) {
          via.TYPE = MBK::env.z2via (z);
          via.XVIA = fig->XAB1() + x * D::X_GRID;
          via.YVIA = fig->YAB1() + y * D::Y_GRID;
          via.NAME = MBK::namealloc(pNet->name.c_str ());

          fig->addphvia (via);
        }
      } // End of Z axis loop.
    }
  } // End of plane loop for VIAs.


  // Special case of nets with only one terminal.
  endNet = nets.end ();
  for (itNet = nets.begin(); itNet != endNet; itNet++) {
    if (!itNet->second->external) continue;
    if (itNet->second->size != 1) continue;
    if (itNet->second->terms[0]->rects.size() < 1) continue;

    rect = itNet->second->terms[0]->rects.front ();

    seg.X1    = fig->XAB1() + rect.x1 * D::X_GRID;
    seg.X2    = fig->XAB1() + rect.x2 * D::X_GRID;
    seg.Y1    = fig->YAB1() + rect.y1 * D::Y_GRID;
    seg.Y2    = fig->YAB1() + rect.y2 * D::Y_GRID;
    seg.NAME  = MBK::namealloc(itNet->second->name.c_str ());
    seg.WIDTH = MBK::env.z2width (0);
    seg.LAYER = MBK::env.z2calu (0);

    fig->addphseg (seg);
  }


  // Add powers lines.
  powers[MBK::CALU1]->dump (fig);
  

  cmess1 << "  o  Saving MBK figure \"" << name << "\".\n";
  fig->phfig.saveas (name);
}