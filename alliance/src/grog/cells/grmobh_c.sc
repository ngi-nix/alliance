#cell1 grmobh_c CMOS schematic 18432 v7r5.6
# 4-Mar-93 18:51 4-Mar-93 18:51 dea9221 * .icn pChannelTransistor .sc
# pChannelTransistor .icn nChannelTransistor .sc nChannelTransistor .
V 4
 $H 2 10000 "Asheet" 1 ""; $B "Asheet" 1100 800; $D 2; D
"nChannelTransistor" "nChannelTransistor" 3 "gate" 0 0 1 "source" 30
-20 2 "drain" 30 20 3 3 "chwidth" 1 "chlength" 2 "gateCapacitance" 3;
D "pChannelTransistor" "pChannelTransistor" 3 "gate" 0 0 1 "source" 30
20 2 "drain" 30 -20 3 3 "chwidth" 1 "chlength" 2 "gateCapacitance" 3;
$N 9 "VDD" "HZ" "VSS" "HZB" "F" "I" "BULK" "" ""; $C 6; C 1 1 1; C
5 1 2; C 2 1 3; C 6 1 4; C 4 1 5; C 3 1 6; $J 10; J 1 "u4" 3 3 1
9 2 1 8 1 1 2 2 1 0 "5" 2 0 "1"; J 1 "u3" 3 1 1 6 2 1 3 3 1 8 2 1 0
"5" 2 0 "1"; J 2 "u10" 3 3 1 8 2 1 9 1 1 4 2 1 0 "10" 2 0 "1"; J 1
"u5" 3 1 1 4 2 1 3 3 1 8 2 1 0 "5" 2 0 "1"; J 1 "u6" 3 1 1 8 2 1 3 3
1 5 2 1 0 "12" 2 0 "1"; J 1 "u13" 3 3 1 5 1 1 8 2 1 3 2 1 0 "12" 2 0
"1"; J 2 "u15" 3 2 1 1 1 1 9 3 1 5 2 1 0 "24" 2 0 "1"; J 2 "u12" 3 3
1 5 2 1 1 1 1 9 2 1 0 "24" 2 0 "1"; J 2 "u9" 3 1 1 6 2 1 1 3 1 9 2 1
0 "10" 2 0 "1"; J 2 "u11" 3 1 1 2 2 1 1 3 1 9 2 1 0 "10" 2 0 "1"; $I
10; I 1 "u4" "@" 430 300 4 22 2 1 0 "5" 2 0 "1"; I 1 "u3" "@" 370
200 0 22 2 1 0 "5" 2 0 "1"; I 2 "u10" "@" 500 300 0 22 2 1 0 "10" 2 0
"1"; I 1 "u5" "@" 500 200 0 22 2 1 0 "5" 2 0 "1"; I 1 "u6" "@" 620
250 0 22 2 1 0 "12" 2 0 "1"; I 1 "u13" "@" 690 250 0 22 2 1 0 "12" 2
0 "1"; I 2 "u15" "@" 690 350 0 22 2 1 0 "24" 2 0 "1"; I 2 "u12" "@"
620 350 0 22 2 1 0 "24" 2 0 "1"; I 2 "u9" "@" 370 400 0 22 2 1 0 "10"
2 0 "1"; I 2 "u11" "@" 500 400 0 22 2 1 0 "10" 2 0 "1"; $E 57; E
20200002 650 480 + 650 485 "vdd" 1 LB H 0 + 650 465 "" 1 LB H 0 1 0;
E 20000002 340 300 0; E 20000002 340 200 0; E 20400002 370 200 1 2 1
; E 20400002 400 180 1 2 2; E 20400002 400 220 1 2 3; E 20400002 530
280 1 3 3; E 20400002 530 320 1 3 2; E 20400002 500 300 1 3 1; E
20400002 500 200 1 4 1; E 20400002 530 180 1 4 2; E 20400002 530 220
1 4 3; E 20400002 620 250 1 5 1; E 20400002 650 230 1 5 2; E
20400002 650 270 1 5 3; E 20400002 720 270 1 6 3; E 20400002 720 370
1 7 2; E 20400002 690 250 1 6 1; E 20200002 450 480 + 450 485 "hz" 1
LB H 0 + 450 465 "" 1 LB H 0 5 0; E 20000002 400 250 0; E 20200002
650 120 + 650 125 "vss" 1 LB H 0 + 650 105 "" 1 LB H 0 2 0; E
20000002 470 200 0; E 20000002 470 300 0; E 20000002 530 250 0; E
20400002 370 400 1 9 1; E 20400002 400 420 1 9 2; E 20400002 400 380
1 9 3; E 20400002 500 400 1 10 1; E 20400002 530 420 1 10 2; E
20400002 530 380 1 10 3; E 20400002 650 330 1 8 3; E 20400002 650
370 1 8 2; E 20400002 620 350 1 8 1; E 20000002 650 470 0; E
20000002 650 130 0; E 20000002 530 130 0; E 20000002 400 130 0; E
20000002 530 470 0; E 20000002 400 470 0; E 20000002 530 350 0; E
20400002 400 320 1 1 3; E 20400002 400 280 1 1 2; E 20400002 430 300
1 1 1; E 20000002 450 400 0; E 20000002 450 300 0; E 20000002 340
400 0; E 20400002 690 350 1 7 1; E 20200002 470 120 + 470 125 "hzb"
1 LB H 0 + 470 105 "" 1 LB H 0 6 0; E 20000002 650 300 0; E 20400002
720 230 1 6 2; E 20400002 720 330 1 7 3; E 20000002 720 130 0; E
20000002 400 350 0; E 20000002 720 470 0; E 20200002 770 300 + 770
305 "f" 1 LB H 0 + 770 285 "" 1 LB H 0 4 0; E 20000002 720 300 0; E
20200002 270 300 + 230 290 "i" 1 LB H 0 + 270 285 "" 1 LB H 0 3 0; $S
49; S 32 34 2; S 37 36 2; S 35 14 2; S 36 35 2; S 36 11 2; S 33
47 2; S 37 5 2; S 29 38 2; S 39 38 2; S 26 39 2; S 38 34 2; S 40
33 2; S 8 40 2; S 40 30 2; S 12 24 2; S 24 7 2; S 24 13 2; S 23
9 2; S 22 23 2; S 22 10 2; S 53 40 2; S 13 18 2; S 44 28 2; S 45
44 2; S 43 45 2; S 46 25 2; S 3 4 2; S 3 2 2; S 2 46 2; S 41 53
2; S 16 56 2; S 21 35 2; S 56 51 2; S 56 55 2; S 44 19 2; S 20
42 2; S 17 54 2; S 48 22 2; S 49 56 2; S 53 27 2; S 6 20 2; S 20
24 2; S 35 52 2; S 52 50 2; S 34 1 2; S 34 54 2; S 49 31 2; S 15
49 2; S 57 2 2; $T 1; T + 400 70 "cell : grmobh_c" 1 LB H 0; $Z;
