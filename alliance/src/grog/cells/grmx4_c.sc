#cell1 grmx4_c CMOS schematic 23552 v7r5.6
# 8-Mar-93 11:38 8-Mar-93 11:38 dea9221 * .icn pChannelTransistor .sc
# pChannelTransistor .icn nChannelTransistor .sc nChannelTransistor .
V 4
 $H 2 10000 "Asheet" 1 ""; $B "Asheet" 1100 800; $D 2; D
"nChannelTransistor" "nChannelTransistor" 3 "gate" 0 0 1 "source" 30
-20 2 "drain" 30 20 3 3 "chwidth" 1 "chlength" 2 "gateCapacitance" 3;
D "pChannelTransistor" "pChannelTransistor" 3 "gate" 0 0 1 "source" 30
20 2 "drain" 30 -20 3 3 "chwidth" 1 "chlength" 2 "gateCapacitance" 3;
$N 14 "S1" "CK_13" "BL0" "BL1" "S2" "S3" "BL2" "S0" "BL3" "VSS" "O"
"VDD" "BULK" ""; $C 12; C 6 1 1; C 9 1 2; C 1 1 3; C 2 1 4; C 7
1 5; C 8 1 6; C 3 1 7; C 5 1 8; C 4 1 9; C 12 1 10; C 13 1 11;
C 14 1 12; $J 8; J 1 "u3" 3 3 1 4 1 1 1 2 1 14 2 1 0 "6" 2 0 "1"; J
1 "u2" 3 3 1 3 1 1 8 2 1 14 2 1 0 "6" 2 0 "1"; J 1 "u5" 3 1 1 6 2 1
14 3 1 9 2 1 0 "6" 2 0 "1"; J 2 "u9" 3 3 1 14 1 1 11 2 1 12 2 1 0 "2"
2 0 "4"; J 1 "u4" 3 1 1 5 2 1 14 3 1 7 2 1 0 "6" 2 0 "1"; J 2 "u7" 3
1 1 14 2 1 12 3 1 11 2 1 0 "8" 2 0 "1"; J 1 "u6" 3 1 1 14 3 1 11 2 1
10 2 1 0 "4" 2 0 "1"; J 2 "u8" 3 1 1 2 3 1 14 2 1 12 1 2 0 "1"; $I 8
; I 1 "u3" "@" 470 550 0 22 2 1 0 "6" 2 0 "1"; I 1 "u2" "@" 390 610 0
22 2 1 0 "6" 2 0 "1"; I 1 "u5" "@" 620 410 0 22 2 1 0 "6" 2 0 "1"; I
2 "u9" "@" 790 410 4 22 2 1 0 "2" 2 0 "4"; I 1 "u4" "@" 540 480 0 22
2 1 0 "6" 2 0 "1"; I 2 "u7" "@" 780 350 0 22 2 1 0 "8" 2 0 "1"; I 1
"u6" "@" 780 210 0 22 2 1 0 "4" 2 0 "1"; I 2 "u8" "@" 680 300 0 22 1
2 0 "1"; $E 49; E 20400002 420 630 1 2 3; E 20400002 680 300 1 8 1
; E 20000002 760 210 0; E 20400002 760 390 1 4 3; E 20200002 340 550
+ 340 555 "s1" 1 LB H 0 + 340 535 "" 1 LB H 0 6 0; E 20400002 500 570
1 1 3; E 20000002 760 350 0; E 20200002 340 300 + 340 305 "ck_13" 1
LB H 0 + 340 285 "" 1 LB H 0 9 0; E 20200002 420 650 + 420 655 "bl0"
1 LB H 0 + 420 635 "" 1 LB H 0 1 0; E 20400002 780 350 1 6 1; E
20200002 500 650 + 500 655 "bl1" 1 LB H 0 + 500 635 "" 1 LB H 0 2 0;
E 20400002 390 610 1 2 1; E 20000002 500 350 0; E 20000002 420 350 0
; E 20200002 340 480 + 340 485 "s2" 1 LB H 0 + 340 465 "" 1 LB H 0 7 0
; E 20200002 340 410 + 340 415 "s3" 1 LB H 0 + 340 395 "" 1 LB H 0 8 0
; E 20200002 570 650 + 570 655 "bl2" 1 LB H 0 + 570 635 "" 1 LB H 0 3
0; E 20400002 470 550 1 1 1; E 20000002 570 350 0; E 20000002 650
350 0; E 20400002 540 480 1 5 1; E 20400002 570 460 1 5 2; E
20400002 570 500 1 5 3; E 20400002 620 410 1 3 1; E 20400002 650 390
1 3 2; E 20400002 650 430 1 3 3; E 20400002 420 590 1 2 2; E
20200002 340 610 + 340 615 "s0" 1 LB H 0 + 340 595 "" 1 LB H 0 5 0; E
20400002 500 530 1 1 2; E 20200002 650 650 + 650 655 "bl3" 1 LB H 0 +
650 635 "" 1 LB H 0 4 0; E 20000002 760 280 0; E 20400002 810 370 1
6 2; E 20400002 780 210 1 7 1; E 20400002 810 330 1 6 3; E 20400002
810 230 1 7 3; E 20200002 810 70 + 810 75 "vss" 1 LB H 0 + 810 55 ""
1 LB H 0 12 0; E 20400002 810 190 1 7 2; E 20200002 900 280 + 900
285 "o" 1 LB H 0 + 900 265 "" 1 LB H 0 13 0; E 20000002 810 280 0; E
20000002 860 280 0; E 20000002 860 410 0; E 20400002 790 410 1 4 1;
E 20400002 760 430 1 4 2; E 20400002 710 280 1 8 3; E 20400002 710
320 1 8 2; E 20000002 710 470 0; E 20000002 810 470 0; E 20000002
760 470 0; E 20200002 760 650 + 760 655 "vdd" 1 LB H 0 + 760 635 "" 1
LB H 0 14 0; $S 36; S 26 30 2; S 8 2 2; S 1 9 2; S 28 12 2; S 16
24 2; S 15 21 2; S 5 18 2; S 20 25 2; S 6 11 2; S 19 20 2; S 19
22 2; S 23 17 2; S 13 19 2; S 14 13 2; S 14 27 2; S 13 29 2; S 3
31 2; S 7 4 2; S 3 33 2; S 39 34 2; S 44 31 2; S 36 37 2; S 39
40 2; S 35 39 2; S 42 41 2; S 40 41 0; S 40 38 2; S 31 7 2; S 20
7 2; S 7 10 2; S 45 46 2; S 32 47 2; S 48 47 2; S 43 48 2; S 46
48 2; S 48 49 2; $T 1; T + 440 70 "cell : grmx4_c" 1 LB H 0; $Z;
