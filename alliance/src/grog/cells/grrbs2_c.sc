#cell1 grrbs2_c CMOS schematic 16384 v7r5.6
# 9-Apr-92 10:00 9-Apr-92 10:00 fred * .icn pChannelTransistor .sc
# pChannelTransistor .icn nChannelTransistor .sc nChannelTransistor .
V 4
 $H 2 10000 "Asheet" 1 ""; $B "Asheet" 1100 800; $D 2; D
"pChannelTransistor" "pChannelTransistor" 3 "gate" 0 0 1 "source" 30
20 2 "drain" 30 -20 3 3 "chwidth" 1 "chlength" 2 "gateCapacitance" 3;
D "nChannelTransistor" "nChannelTransistor" 3 "gate" 0 0 1 "source" 30
-20 2 "drain" 30 20 3 3 "chwidth" 1 "chlength" 2 "gateCapacitance" 3;
$N 19 "E1" "E11" "E5" "E3" "E4" "E8" "E13" "E12" "VDD" "E9" "VSS" "E7"
"E2" "E6" "E10" "N1" "E14" "BULK" ""; $C 17; C 17 1 1; C 12 1 2; C
8 1 3; C 6 1 4; C 7 1 5; C 9 1 6; C 14 1 7; C 13 1 8; C 1 1 9;
C 10 1 10; C 2 1 11; C 16 1 12; C 19 1 13; C 15 1 14; C 11 1 15;
C 3 1 16; C 18 1 17; $J 4; J 2 "u6" 3 1 1 1 2 1 19 3 1 16 0; J 1
"u3" 3 1 1 1 2 1 9 3 1 16 0; J 1 "u4" 3 1 1 13 2 1 9 3 1 16 0; J 2
"u7" 3 1 1 13 2 1 11 3 1 19 0; $I 4; I 2 "u6" "@" 490 410 0 22 0; I
1 "u3" "@" 490 630 0 22 0; I 1 "u4" "@" 640 630 0 22 0; I 2 "u7" "@"
490 290 0 22 0; $E 39; E 20200002 110 410 + 110 415 "e1" 1 LB H 0 +
110 395 "" 1 LB H 0 17 0; E 20400002 490 410 1 1 1; E 20200002 790
280 + 790 285 "e11" 1 LB H 0 + 790 265 "" 1 LB H 0 12 0; E 20400002
490 630 1 2 1; E 20400002 520 650 1 2 2; E 20400002 520 610 1 2 3;
E 20400002 640 630 1 3 1; E 20400002 670 650 1 3 2; E 20400002 670
610 1 3 3; E 20200002 790 450 + 790 455 "e5" 1 LB H 0 + 790 435 "" 1
LB H 0 8 0; E 20200002 790 510 + 790 515 "e3" 1 LB H 0 + 790 495 "" 1
LB H 0 6 0; E 20200002 800 480 + 800 485 "e4" 1 LB H 0 + 800 465 "" 1
LB H 0 7 0; E 20200002 790 370 + 790 375 "e8" 1 LB H 0 + 790 355 "" 1
LB H 0 9 0; E 20200002 790 220 + 790 225 "e13" 1 LB H 0 + 790 205 ""
1 LB H 0 14 0; E 20200002 790 250 + 790 255 "e12" 1 LB H 0 + 790 235
"" 1 LB H 0 13 0; E 20400002 490 290 1 4 1; E 20400002 520 270 1 4 2
; E 20400002 520 310 1 4 3; E 20000002 460 410 0; E 20000002 520 670
0; E 20000002 670 670 0; E 20200002 520 770 + 520 775 "vdd" 1 LB H 0
+ 520 755 "" 1 LB H 0 1 0; E 20200002 790 340 + 790 345 "e9" 1 LB H 0
+ 790 325 "" 1 LB H 0 10 0; E 20400002 520 390 1 1 2; E 20200002 520
140 + 520 145 "vss" 1 LB H 0 + 520 125 "" 1 LB H 0 2 0; E 20000002
460 290 0; E 20000002 460 340 0; E 20000002 590 340 0; E 20000002
590 630 0; E 20200002 790 400 + 790 405 "e7" 1 LB H 0 + 790 385 "" 1
LB H 0 16 0; E 20000002 460 630 0; E 20400002 520 430 1 1 3; E
20200002 110 290 + 110 295 "e2" 1 LB H 0 + 110 275 "" 1 LB H 0 19 0;
E 20200002 790 420 + 790 425 "e6" 1 LB H 0 + 790 405 "" 1 LB H 0 15 0
; E 20200002 790 310 + 790 315 "e10" 1 LB H 0 + 790 295 "" 1 LB H 0 11
0; E 20000002 520 580 0; E 20000002 670 580 0; E 20200002 980 580 +
980 585 "n1" 1 LB H 0 + 980 565 "" 1 LB H 0 3 0; E 20200002 790 190 +
790 195 "e14" 1 LB H 0 + 790 175 "" 1 LB H 0 18 0; $S 21; S 19 2 2;
S 19 31 2; S 5 20 2; S 20 21 2; S 8 21 2; S 20 22 2; S 1 19 2; S
18 24 2; S 33 26 2; S 36 6 2; S 37 9 2; S 37 38 2; S 25 17 2; S
26 16 2; S 26 27 2; S 27 28 2; S 28 29 2; S 29 7 2; S 31 4 2; S
36 37 2; S 32 36 2; $T 1; T + 730 140 "cell : grrbs2_c" 1 LB H 0;
$Z;