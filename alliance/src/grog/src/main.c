/*
 * This file is part of the Alliance CAD System
 * Copyright (C) Laboratoire LIP6 - Département ASIM
 * Universite Pierre et Marie Curie
 * 
 * Home page          : http://www-asim.lip6.fr/alliance/
 * E-mail support     : mailto:alliance-support@asim.lip6.fr
 * 
 * This progam is  free software; you can redistribute it  and/or modify it
 * under the  terms of the GNU  General Public License as  published by the
 * Free Software Foundation;  either version 2 of the License,  or (at your
 * option) any later version.
 * 
 * Alliance VLSI  CAD System  is distributed  in the hope  that it  will be
 * useful, but WITHOUT  ANY WARRANTY; without even the  implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 * 
 * You should have received a copy  of the GNU General Public License along
 * with the GNU C Library; see the  file COPYING. If not, write to the Free
 * Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/*******************************************************************************
* Grog : generic rom generator                                                 *
*                                                                              *
* Architecture and leaf cells defined at Bull's research center at les Clayes  *
*                                                                              *
* Leaf cells modifications to meet idps design rules                           *
* version 0.0 on April/June 1992, Frederic Petrot                              *
*                                                                              *
* All programming in Genlib                                                    *
* version 0.0 on April/June 1992, Frederic Petrot                              *
*                                                                              *
* version 0.1, by Frederic Petrot                                              *
* version 1.0, by Frederic Petrot                                              *
* version 1.1, by Frederic Petrot                                              *
* version 1.2, by Frederic Petrot                                              *
*******************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include MUT_H
#include "grog.h"

static void usage(char *);
static int legal(int *);

/*
* main routine
*/
int main(int argc, char *argv[])
{
/* parameters */
int nw = 0; /* word number */
int nb = 0; /* bits number */
int tr = 0; /* through routes */
int zh = 0; /* tri-state output */
int r = 0;  /* output bit order */
int msb = 0; /* most significant bit is called 2^(nbits - 1) by default */
char *codefile = NULL; /* coding input file name */
char blockname[32]; /* block name */
int layout = 0;
int netlist = 0;
int vhdl = 0;
int verilog = 0;
int pat = 0;
int icon = 0;
int outline = 0;
int datasheet = 0;
int silent = 0;
int contactonly = 0;
int nocontact = 0;
int i;

   if (argc < 4)
      usage(argv[0]);

   nb = atoi(argv[1]);
   nw = atoi(argv[2]);
   codefile = argv[3];
   *blockname = '\0';

   for (i = 4; i < argc; i++) {
      if (!strcmp(argv[i], "-o")) {
         if (++i < argc)
            sprintf(blockname, "%s", argv[i]);
         else
            usage(argv[0]);
      } else if (!strcmp(argv[i], "-layout"))
         layout = 1;
      else if (!strcmp(argv[i], "-physicalbox"))
         outline = 1;
      else if (!strcmp(argv[i], "-logicalbox"))
         netlist = 1;
      else if (!strcmp(argv[i], "-vhdl"))
         vhdl = 1;
      else if (!strcmp(argv[i], "-verilog"))
         verilog = 1;
      else if (!strcmp(argv[i], "-pattern"))
         pat = 1;
      else if (!strcmp(argv[i], "-icon"))
         icon = 1;
      else if (!strcmp(argv[i], "-datasheet"))
         datasheet = 1;
      else if (!strcmp(argv[i], "-tr"))
         tr = 1;
      else if (!strcmp(argv[i], "-hz"))
         zh = 1;
      else if (!strcmp(argv[i], "-r"))
         r = 1;
      else if (!strcmp(argv[i], "-msb0"))
         msb = 1;
      else if (!strcmp(argv[i], "-silent"))
         silent = 1;
      else if (!strcmp(argv[i], "-co"))
         contactonly = 1;
      else if (!strcmp(argv[i], "-nc"))
         nocontact = 1;
      else
         usage(argv[0]);
   }

   if (!silent)
      alliancebanner_with_authors("GRoG", GROG, "Generic ROm Generator",
        "1992", ALC,"Frederic Petrot");

   if (!(layout | netlist | vhdl | verilog | outline | datasheet | icon | pat)) {
      fprintf(stderr, "At least one view is to be generated by %s\n", argv[0]);
      usage(argv[0]);
   }
   if (!nb || nb < 1 || nb > 64) {
      fprintf(stderr, "The bits argument must be in the allowed range, 1 to 64\n");
      usage(argv[0]);
   }
   if (!nw) {
      fprintf(stderr, "The words argument must be a legal number, 64 to 4096\n");
      usage(argv[0]);
   }
   if (isdigit((int)*codefile) && layout)
      fprintf(stderr, "Warning : the rom code is going to be random!\n");
   i = legal(&nw);
   if (!i)
      fprintf(stderr, "Warning : words number rounded up to legal value %d\n",
               nw);
   if (i == 2) {
      fprintf(stderr, "The words argument must be in the allowed range\n");
      usage(argv[0]);
   }
   if (*blockname == '\0') {
      sprintf(blockname, "r%dx%d_", nw, nb);
      if (tr)
         strcat(blockname, "t");
      if (zh)
         strcat(blockname, "z");
      if (r)
         strcat(blockname, "r");
      strcat(blockname, codefile);
   }

   grog(blockname, nb, nw, codefile, tr, zh, r, msb, nocontact, contactonly,
         layout, netlist, vhdl, verilog, pat, icon, outline, datasheet);
   if (silent)
      fputs(blockname, stdout);
   return 0;
}

/*
* word number adjustment for proper generator call
*/
static int legal(int *nw)
{
int i;

   for (i = 5; i < 9; i++) 
      if (*nw > (1 << i) && *nw < (1 << (i + 1))) {
         *nw = (1 << (i + 1));
         return 0;
      } else if (*nw == (1 << (i + 1)))
         return 1;

   for (i = 1; i < 8; i++)
      if (i * 512 < *nw && (i + 1) * 512 > *nw) {
         *nw = (i + 1) * 512;
         return 0;
      } else if (*nw == (i + 1) * 512)
         return 1;
   return 2;
}

/*
* usual unix usage message
*/
static void usage(char *s)
{
int i = 0;

   fprintf(stderr, "Usage : %s bits words codefile ", s);
   fprintf(stderr, "[-hz] [-tr] [-r] [-msb0] [-co] [-nc] [-o blockname]\n");
   do
      fputs(" ", stderr);
   while (i++ < strlen(s) + 8);
   fprintf(stderr, "[-layout] [-vhdl] [-verilog] [-pattern] [-icon] [-datasheet]\n");
   do
      fputs(" ", stderr);
   while (--i > 0);
   fprintf(stderr, "[-pattern] [-logicalbox] [-physicalbox]\n");
   exit(1);
}

