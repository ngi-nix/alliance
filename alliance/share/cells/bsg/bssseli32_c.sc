#cell1 bssseli32_c CMOS schematic 24576 v7r5.6
# 27-May-92 17:59 27-May-92 17:59 dea9106 * .icn pChannelTransistor .sc
# pChannelTransistor .icn nChannelTransistor .sc nChannelTransistor .
V 4
 $H 2 10000 "Asheet" 1 ""; $B "Asheet" 1100 800; $D 2; D
"nChannelTransistor" "nChannelTransistor" 3 "gate" 0 0 1 "source" 30
-20 2 "drain" 30 20 3 3 "chwidth" 1 "chlength" 2 "gateCapacitance" 3;
D "pChannelTransistor" "pChannelTransistor" 3 "gate" 0 0 1 "source" 30
20 2 "drain" 30 -20 3 3 "chwidth" 1 "chlength" 2 "gateCapacitance" 3;
$N 18 "VDD" "VSS1" "VSS1" "IN_1" "VSS" "VDD" "VSS" "L" "OUT_1" "R"
"DAT_2" "L" "OUT_2" "DAT_2" "R" "BULK" "" ""; $C 15; C 10 1 1; C 8
1 2; C 7 1 2; C 9 1 4; C 11 1 5; C 17 1 1; C 16 1 5; C 2 1 8; C
18 1 9; C 4 1 10; C 13 1 11; C 1 1 8; C 19 1 13; C 14 1 11; C 3
1 10; $J 8; J 1 "u2" 3 1 1 10 2 1 17 3 1 2 2 1 0 "17" 2 0 "1"; J 1
"u3" 3 3 1 17 1 1 4 2 1 9 2 1 0 "17" 2 0 "1"; J 2 "u4" 3 2 1 9 1 1 4
3 1 1 2 1 0 "17" 2 0 "1"; J 2 "u5" 3 2 1 9 3 1 1 1 1 10 2 1 0 "17" 2
0 "1"; J 2 "u6" 3 2 1 1 1 1 4 3 1 13 2 1 0 "17" 2 0 "1"; J 2 "u7" 3
2 1 1 3 1 13 1 1 8 2 1 0 "17" 2 0 "1"; J 1 "u8" 3 3 1 13 1 1 4 2 1 18
2 1 0 "17" 2 0 "1"; J 1 "u9" 3 3 1 18 1 1 8 2 1 5 2 1 0 "17" 2 0 "1"
; $I 8; I 1 "u2" "@" 510 470 0 22 2 1 0 "17" 2 0 "1"; I 1 "u3" "@"
510 430 0 22 2 1 0 "17" 2 0 "1"; I 2 "u4" "@" 510 390 0 22 2 1 0 "17"
2 0 "1"; I 2 "u5" "@" 570 390 4 22 2 1 0 "17" 2 0 "1"; I 2 "u6" "@"
510 350 0 22 2 1 0 "17" 2 0 "1"; I 2 "u7" "@" 570 350 4 22 2 1 0 "17"
2 0 "1"; I 1 "u8" "@" 510 310 0 22 2 1 0 "17" 2 0 "1"; I 1 "u9" "@"
570 270 4 22 2 1 0 "17" 2 0 "1"; $E 33; E 20400002 510 470 1 1 1; E
20400002 540 450 2 1 2 2 3; E 20400002 540 490 1 1 3; E 20400002 510
430 1 2 1; E 20400002 540 410 3 2 2 3 2 4 2; E 20400002 510 390 1 3
1; E 20400002 540 370 4 3 3 4 3 5 2 6 2; E 20400002 570 390 1 4 1;
E 20000002 570 470 0; E 20400002 510 350 1 5 1; E 20400002 540 330 3
5 3 6 3 7 3; E 20400002 570 350 1 6 1; E 20400002 510 310 1 7 1; E
20400002 540 290 2 7 2 8 3; E 20400002 570 270 1 8 1; E 20400002 540
250 1 8 2; E 20200002 430 370 + 430 375 "vdd" 1 LB H 0 + 430 355 "" 1
LB H 0 10 0; E 20200002 610 490 + 610 495 "vss1" 1 LB H 0 + 610 475
"" 1 LB H 0 8 0; E 20200002 420 490 + 420 495 "vss1" 1 LB H 0 + 420
475 "" 1 LB H 0 7 0; E 20200002 590 210 + 590 215 "r" 1 LB H 0 + 590
195 "" 1 LB H 0 4 0; E 20200002 430 430 + 430 435 "in_1" 1 LB H 0 +
430 415 "" 1 LB H 0 9 0; E 20200002 430 250 + 430 255 "vss" 1 LB H 0
+ 430 235 "" 1 LB H 0 11 0; E 20200002 610 370 + 610 375 "vdd" 1 LB H
0 + 610 355 "" 1 LB H 0 17 0; E 20000002 490 270 0; E 20200002 610
250 + 610 255 "vss" 1 LB H 0 + 610 235 "" 1 LB H 0 16 0; E 20200002
610 230 + 610 235 "dat_2" 1 LB H 0 + 610 215 "" 1 LB H 0 14 0; E
20200002 490 210 + 490 215 "l" 1 LB H 0 + 490 195 "" 1 LB H 0 2 0; E
20200002 610 410 + 610 415 "out_1" 1 LB H 0 + 610 395 "" 1 LB H 0 18 0
; E 20000002 590 470 0; E 20200002 610 330 + 610 335 "out_2" 1 LB H 0
+ 610 315 "" 1 LB H 0 19 0; E 20200002 430 230 + 430 235 "dat_2" 1 LB
H 0 + 430 215 "" 1 LB H 0 13 0; E 20200002 490 510 + 490 515 "l" 1 LB
H 0 + 490 495 "" 1 LB H 0 1 0; E 20200002 590 510 + 590 515 "r" 1 LB
H 0 + 590 495 "" 1 LB H 0 3 0; $S 22; S 1 9 2; S 8 9 2; S 11 30 2
; S 17 7 2; S 7 23 2; S 19 3 2; S 3 18 2; S 6 4 2; S 10 6 2; S
13 10 2; S 21 4 2; S 22 16 2; S 20 29 2; S 16 25 2; S 24 15 2; S
9 29 2; S 24 32 2; S 5 28 2; S 15 12 2; S 31 26 2; S 27 24 2; S
29 33 2; $Z;