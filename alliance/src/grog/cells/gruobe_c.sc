#cell1 gruobe_c CMOS schematic 12288 v7r5.6
# 19-Mar-93 17:55 19-Mar-93 17:55 dea9221 * .icn nChannelTransistor .sc
# nChannelTransistor .icn pChannelTransistor .sc pChannelTransistor .
V 4
 $H 2 10000 "Asheet" 1 ""; $B "Asheet" 1100 800; $D 2; D
"nChannelTransistor" "nChannelTransistor" 3 "gate" 0 0 1 "source" 30
-20 2 "drain" 30 20 3 3 "chwidth" 1 "chlength" 2 "gateCapacitance" 3;
D "pChannelTransistor" "pChannelTransistor" 3 "gate" 0 0 1 "source" 30
20 2 "drain" 30 -20 3 3 "chwidth" 1 "chlength" 2 "gateCapacitance" 3;
$N 6 "VDD" "I" "F" "VSS" "BULK" ""; $C 4; C 1 1 1; C 4 1 2; C 5 1
3; C 2 1 4; $J 4; J 2 "u8" 3 1 1 6 3 1 3 2 1 1 2 1 0 "50" 2 0 "1";
J 2 "u7" 3 1 1 2 3 1 6 2 1 1 2 1 0 "14" 2 0 "1"; J 1 "u10" 3 3 1 6 2
1 4 1 1 2 2 1 0 "7" 2 0 "1"; J 1 "u9" 3 3 1 3 1 1 6 2 1 4 2 1 0 "25"
2 0 "1"; $I 4; I 2 "u8" "@" 870 510 0 22 2 1 0 "50" 2 0 "1"; I 2
"u7" "@" 720 510 0 22 2 1 0 "14" 2 0 "1"; I 1 "u10" "@" 720 400 0 22
2 1 0 "7" 2 0 "1"; I 1 "u9" "@" 870 400 0 22 2 1 0 "25" 2 0 "1"; $E
26; E 20400002 720 510 1 2 1; E 20400002 750 420 1 3 3; E 20000002
670 400 0; E 20000002 750 610 0; E 20400002 900 420 1 4 3; E
20200002 900 610 + 900 615 "vdd" 1 LB H 0 + 900 595 "" 1 LB H 0 1 0;
E 20000002 670 450 0; E 20000002 670 510 0; E 20400002 750 490 1 2 3
; E 20200002 590 450 + 590 455 "i" 1 LB H 0 + 590 435 "" 1 LB H 0 4 0
; E 20000002 750 310 0; E 20400002 750 380 1 3 2; E 20400002 750 530
1 2 2; E 20000002 820 450 0; E 20200002 940 450 + 940 455 "f" 1 LB H
0 + 940 435 "" 1 LB H 0 5 0; E 20200002 900 310 + 900 315 "vss" 1 LB
H 0 + 900 295 "" 1 LB H 0 2 0; E 20000002 900 450 0; E 20400002 870
510 1 1 1; E 20000002 820 400 0; E 20400002 720 400 1 3 1; E
20000002 750 450 0; E 20400002 870 400 1 4 1; E 20400002 900 490 1 1
3; E 20400002 900 530 1 1 2; E 20400002 900 380 1 4 2; E 20000002
820 510 0; $S 21; S 7 8 2; S 21 9 2; S 24 6 2; S 8 1 2; S 13 4 2
; S 14 26 2; S 5 17 2; S 16 25 2; S 3 7 2; S 21 14 2; S 10 7 2;
S 17 23 2; S 11 12 2; S 3 20 2; S 19 14 2; S 4 6 2; S 2 21 2; S
26 18 2; S 19 22 2; S 17 15 2; S 11 16 2; $T 1; T + 660 250
"cell : gruobe_c" 1 LB H 0; $Z;
