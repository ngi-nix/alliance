#cell1 grprw0_c CMOS schematic 23552 v7r5.6
# 9-Apr-93 17:45 9-Apr-93 17:45 dea9221 * .icn pChannelTransistor .sc
# pChannelTransistor .icn nChannelTransistor .sc nChannelTransistor .
V 4
 $H 2 10000 "Asheet" 1 ""; $B "Asheet" 1100 800; $D 2; D
"nChannelTransistor" "nChannelTransistor" 3 "gate" 0 0 1 "source" 30
-20 2 "drain" 30 20 3 3 "chwidth" 1 "chlength" 2 "gateCapacitance" 3;
D "pChannelTransistor" "pChannelTransistor" 3 "gate" 0 0 1 "source" 30
20 2 "drain" 30 -20 3 3 "chwidth" 1 "chlength" 2 "gateCapacitance" 3;
$N 16 "E1" "VSS1" "E3" "E8" "E5" "N1" "VSS0" "VDD" "CK_11" "E6" "E7"
"N0" "VSS" "BULK" "" ""; $C 12; C 2 1 1; C 4 1 2; C 3 1 3; C 11 1
4; C 10 1 5; C 1 1 6; C 5 1 7; C 6 1 8; C 7 1 9; C 8 1 10; C 9
1 11; C 12 1 12; $J 8; J 1 "u2" 3 2 1 2 1 1 1 3 1 16 2 1 0 "6" 2 0
"1"; J 2 "u6" 3 3 1 15 2 1 8 1 1 1 2 1 0 "6" 2 0 "1"; J 1 "u8" 3 1 1
15 2 1 7 3 1 6 2 1 0 "5" 2 0 "1"; J 2 "u5" 3 1 1 3 2 1 8 3 1 15 2 1 0
"6" 2 0 "1"; J 1 "u4" 3 3 1 15 2 1 16 1 1 3 2 1 0 "6" 2 0 "1"; J 1
"u11" 3 1 1 15 2 1 7 3 1 6 2 1 0 "5" 2 0 "1"; J 2 "u9" 3 3 1 6 1 1 15
2 1 8 2 1 0 "13" 2 0 "1"; J 2 "u10" 3 1 1 15 3 1 6 2 1 8 2 1 0 "13" 2
0 "1"; $I 8; I 1 "u2" "@" 220 160 0 22 2 1 0 "6" 2 0 "1"; I 2 "u6"
"@" 250 340 0 22 2 1 0 "6" 2 0 "1"; I 1 "u8" "@" 360 160 0 22 2 1 0
"5" 2 0 "1"; I 2 "u5" "@" 190 340 0 22 2 1 0 "6" 2 0 "1"; I 1 "u4"
"@" 220 240 0 22 2 1 0 "6" 2 0 "1"; I 1 "u11" "@" 420 160 0 22 2 1 0
"5" 2 0 "1"; I 2 "u9" "@" 420 330 0 22 2 1 0 "13" 2 0 "1"; I 2 "u10"
"@" 360 330 0 22 2 1 0 "13" 2 0 "1"; $E 55; E 20000002 220 390 0; E
20400002 450 310 1 7 3; E 20400002 420 330 1 7 1; E 20400002 280 320
1 2 3; E 20400002 280 360 1 2 2; E 20400002 250 340 1 2 1; E
20000002 280 290 0; E 20000002 220 290 0; E 20000002 280 390 0; E
20400002 190 340 1 4 1; E 20400002 220 360 1 4 2; E 20400002 220 320
1 4 3; E 20400002 360 330 1 8 1; E 20000002 300 160 0; E 20000002
300 340 0; E 20400002 390 310 1 8 3; E 20400002 390 350 1 8 2; E
20200002 150 160 + 150 165 "e1" 1 LB H 0 + 150 145 "" 1 LB H 0 2 0; E
20400002 450 350 1 7 2; E 20000002 450 390 0; E 20400002 250 260 1 5
3; E 20200002 250 100 + 250 105 "vss1" 1 LB H 0 + 250 85 "" 1 LB H 0
4 0; E 20400002 250 140 1 1 2; E 20400002 220 160 1 1 1; E 20400002
250 180 1 1 3; E 20400002 250 220 1 5 2; E 20400002 220 240 1 5 1;
E 20000002 250 290 0; E 20000002 170 340 0; E 20000002 170 240 0; E
20200002 150 240 + 150 245 "e3" 1 LB H 0 + 150 225 "" 1 LB H 0 3 0; E
20400002 360 160 1 3 1; E 20400002 390 140 1 3 2; E 20400002 390 180
1 3 3; E 20400002 420 160 1 6 1; E 20400002 450 140 1 6 2; E
20400002 450 180 1 6 3; E 20000002 450 100 0; E 20000002 390 100 0;
E 20000002 250 270 0; E 20000002 330 270 0; E 20000002 330 330 0; E
20000002 330 160 0; E 20000002 390 390 0; E 20200002 150 370 + 150
375 "e8" 1 LB H 0 + 150 355 "" 1 LB H 0 11 0; E 20200002 150 400 +
150 405 "e5" 1 LB H 0 + 150 385 "" 1 LB H 0 10 0; E 20000002 390 250
0; E 20000002 450 250 0; E 20200002 510 250 + 510 255 "n1" 1 LB H 0
+ 510 235 "" 1 LB H 0 1 0; E 20200002 420 100 + 420 105 "vss0" 1 LB H
0 + 420 85 "" 1 LB H 0 5 0; E 20200002 330 390 + 330 395 "vdd" 1 LB H
0 + 330 375 "" 1 LB H 0 6 0; E 20200002 150 490 + 150 495 "ck_11" 1
LB H 0 + 150 475 "" 1 LB H 0 7 0; E 20200002 150 460 + 150 465 "e6" 1
LB H 0 + 150 445 "" 1 LB H 0 8 0; E 20200002 150 430 + 150 435 "e7" 1
LB H 0 + 150 415 "" 1 LB H 0 9 0; E 20200002 410 470 + 410 475 "n0" 1
LB H 0 + 410 455 "" 1 LB H 0 12 0; $S 41; S 25 26 2; S 7 4 2; S 8
12 2; S 22 23 2; S 8 28 2; S 28 7 2; S 48 49 2; S 19 20 2; S 29
10 2; S 30 29 2; S 30 27 2; S 31 30 2; S 6 15 2; S 14 15 2; S 24
14 2; S 18 24 2; S 11 1 2; S 1 9 2; S 5 9 2; S 9 51 2; S 51 44 2
; S 38 36 2; S 39 33 2; S 21 40 2; S 40 28 2; S 40 41 2; S 41 42
2; S 42 13 2; S 43 41 2; S 43 32 2; S 50 38 2; S 44 20 2; S 17
44 2; S 34 47 2; S 47 16 2; S 37 48 2; S 48 2 2; S 47 48 2; S 39
50 2; S 13 3 2; S 32 35 2; $Z;