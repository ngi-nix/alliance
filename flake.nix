# The license for this file is included in the `nix` directory next to this file.

{
  description = "(deprecated) Complete set of free CAD tools and portable libraries for VLSI design";

  # Nixpkgs / NixOS version to use.
  inputs.nixpkgs.url = "github:NixOS/nixpkgs?ref=nixos-21.05";

  outputs = { self, nixpkgs }:
    let
      version = builtins.substring 0 8 self.lastModifiedDate;

      supportedSystems = [ "x86_64-linux" "x86_64-darwin" "aarch64-linux" "aarch64-darwin" ];

      forAllSystems = nixpkgs.lib.genAttrs supportedSystems;

      meta = with nixpkgs.lib; {
        homepage    = "http://coriolis.lip6.fr/";
        platforms   = platforms.all;
      };

      # Nixpkgs instantiated for supported system types.
      nixpkgsFor = forAllSystems (system: import nixpkgs { inherit system; overlays = [ self.overlay ]; });

      alliance =
        { lib, stdenv, fetchurl
        , xorgproto, motif, libX11, libXt, libXpm, bison
        , flex, automake, autoconf, libtool, runtimeShell
        }:

        stdenv.mkDerivation rec {
          pname = "alliance";
          inherit version;

          src = ./alliance/src;

          nativeBuildInputs = [ libtool automake autoconf flex ];
          buildInputs = [ xorgproto motif libX11 libXt libXpm bison ];

          configureFlags = [
            "--prefix=$(out)"
          ];

          preConfigure = ''
            mkdir -p $out/etc

            #texlive for docs seems extreme
            mkdir -p $out/share/alliance
            mv ./documentation $out/share/alliance
            substituteInPlace autostuff \
              --replace "$newdirs documentation" "$newdirs" \
              --replace documentation Solaris

            substituteInPlace sea/src/DEF_grammar_lex.l \
              --replace "ifndef FLEX_BETA" "if (YY_FLEX_MAJOR_VERSION <= 2) && (YY_FLEX_MINOR_VERSION < 6)"
            ./autostuff
          '';

          allianceInstaller = ''
            #!${runtimeShell}
            cp -v -r -n --no-preserve=mode  $out/etc/* /etc/ > /etc/alliance-install.log
          '';

          allianceUnInstaller = ''
            #!${runtimeShell}
            awk '{print \$3}' /etc/alliance-install.log | xargs rm
            awk '{print \$3}' /etc/alliance-install.log | xargs rmdir
            rm /etc/alliance-install.log
          '';

          postInstall = ''
            sed -i "s|ALLIANCE_TOP|$out|" distrib/*.desktop
            mkdir -p $out/share/applications
            cp -p distrib/*.desktop $out/share/applications/
            mkdir -p $out/icons/hicolor/48x48/apps/
            cp -p distrib/*.png $out/icons/hicolor/48x48/apps/

            echo "${allianceInstaller}" > $out/bin/alliance-install
            chmod +x $out/bin/alliance-install

            echo "${allianceUnInstaller}" > $out/bin/alliance-uninstall
            chmod +x $out/bin/alliance-uninstall
          '';

          meta = with lib; {
            description = "(deprecated) Complete set of free CAD tools and portable libraries for VLSI design";
            homepage = "http://coriolis.lip6.fr/";
            license = with licenses; gpl2Plus;
            maintainers = with maintainers; [ l-as ];
            platforms = with platforms; linux;
          };
        };
    in

    rec {
      overlay = final: prev: {
        alliance = final.callPackage alliance {};
      };

      packages = forAllSystems (system: {
        inherit (nixpkgsFor.${system}) alliance;
      });

      defaultPackage = forAllSystems (system: self.packages.${system}.alliance);
    };
}
