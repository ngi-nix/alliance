#cell2 * noa4_y sc * 2 CMOS 15360 v8r4.4
# "21-Nov-94 GMT" "16:57:19 GMT" "21-Nov-94 GMT" "16:57:19 GMT" scr * .icn pChannelTransistor .sc pChannelTransistor .icn nChannelTransistor .sc nChannelTransistor .
V 4
 $H 2 10000 "Asheet" 1 ""; $B "Asheet" 1100 800; $D 2; D
"nChannelTransistor" "nChannelTransistor" 3 "gate" 0 0 1 "source" 30
-20 2 "drain" 30 20 3 3 "chwidth" 1 "chlength" 2 "gateCapacitance" 3;
D "pChannelTransistor" "pChannelTransistor" 3 "gate" 0 0 1 "source" 30
20 2 "drain" 30 -20 3 3 "chwidth" 1 "chlength" 2 "gateCapacitance" 3;
$N 11 "F" "VDD" "I0" "I1" "I2" "I3" "VSS" "BULK" "" "" ""; $C 7; C 7
1 1; C 1 1 2; C 4 1 3; C 5 1 4; C 6 1 5; C 3 1 6; C 2 1 7; $J 8
; J 1 "u2" 3 1 1 5 2 1 7 3 1 9 2 1 0 "12" 2 0 "1"; J 1 "u3" 3 1 1 4 2
1 7 3 1 9 2 1 0 "12" 2 0 "1"; J 1 "u4" 3 1 1 3 2 1 7 3 1 9 2 1 0 "12"
2 0 "1"; J 1 "u5" 3 1 1 6 2 1 9 3 1 1 2 1 0 "12" 2 0 "1"; J 2 "u6" 3
1 1 5 2 1 10 3 1 1 2 1 0 "23" 2 0 "1"; J 2 "u7" 3 1 1 4 2 1 11 3 1 10
2 1 0 "23" 2 0 "1"; J 2 "u8" 3 1 1 3 2 1 2 3 1 11 2 1 0 "23" 2 0 "1"
; J 2 "u9" 3 1 1 6 2 1 2 3 1 1 2 1 0 "12" 2 0 "1"; $I 8; I 1 "u2"
"@" 270 120 0 22 2 1 0 "12" 2 0 "1"; I 1 "u3" "@" 460 120 0 22 2 1 0
"12" 2 0 "1"; I 1 "u4" "@" 630 120 0 22 2 1 0 "12" 2 0 "1"; I 1 "u5"
"@" 460 240 0 22 2 1 0 "12" 2 0 "1"; I 2 "u6" "@" 270 330 0 22 2 1 0
"23" 2 0 "1"; I 2 "u7" "@" 270 460 0 22 2 1 0 "23" 2 0 "1"; I 2 "u8"
"@" 270 590 0 22 2 1 0 "23" 2 0 "1"; I 2 "u9" "@" 590 490 0 22 2 1 0
"12" 2 0 "1"; $E 44; E 20400002 270 120 1 1 1; E 20400002 300 100 1
1 2; E 20400002 300 140 1 1 3; E 20400002 460 120 1 2 1; E 20400002
490 100 1 2 2; E 20400002 490 140 1 2 3; E 20400002 630 120 1 3 1;
E 20400002 660 100 1 3 2; E 20400002 660 140 1 3 3; E 20400002 460
240 1 4 1; E 20400002 490 220 1 4 2; E 20400002 490 260 1 4 3; E
20400002 270 330 1 5 1; E 20400002 300 350 1 5 2; E 20400002 300 310
1 5 3; E 20400002 270 460 1 6 1; E 20400002 300 480 1 6 2; E
20400002 300 440 1 6 3; E 20400002 270 590 1 7 1; E 20400002 300 610
1 7 2; E 20400002 300 570 1 7 3; E 20400002 590 490 1 8 1; E
20400002 620 510 1 8 2; E 20400002 620 470 1 8 3; E 20000002 620 310
0; E 20000002 490 310 0; E 20200002 660 310 + 660 315 "f" 1 LB H 0 +
660 295 "f" 1 LB H 0 7 0; E 20000002 620 610 0; E 20200002 620 620 +
620 625 "VDD" 1 LB H 0 + 620 605 "" 1 LB H 0 1 0; E 20200002 130 590
+ 130 595 "i0" 1 LB H 0 + 130 575 "i0" 1 LB H 0 4 0; E 20200002 130
460 + 130 465 "i1" 1 LB H 0 + 130 445 "i1" 1 LB H 0 5 0; E 20200002
130 330 + 130 335 "i2" 1 LB H 0 + 130 315 "i2" 1 LB H 0 6 0; E
20000002 440 240 0; E 20000002 440 490 0; E 20200002 440 520 + 440
525 "i3" 1 LB H 0 + 440 505 "i3" 1 LB H 0 3 0; E 20000002 160 330 0;
E 20000002 160 120 0; E 20000002 190 460 0; E 20000002 190 160 0; E
20000002 460 160 0; E 20000002 220 590 0; E 20000002 220 190 0; E
20000002 630 190 0; E 20200002 490 50 + 490 55 "VSS" 1 LB H 0 + 490
35 "" 1 LB H 0 2 0; $S 34; S 2 5 2; S 5 8 2; S 3 6 2; S 6 9 2; S
6 11 2; S 15 26 2; S 26 25 2; S 12 26 2; S 25 24 2; S 44 5 2; S
14 18 2; S 17 21 2; S 20 28 2; S 28 29 2; S 23 28 2; S 4 40 2; S
37 1 2; S 34 35 2; S 33 10 2; S 33 34 2; S 34 22 2; S 32 36 2; S
36 13 2; S 37 36 2; S 31 38 2; S 38 16 2; S 39 38 2; S 39 40 2;
S 30 41 2; S 41 19 2; S 42 41 2; S 42 43 2; S 7 43 2; S 25 27 2;
$T 1; T + 550 10 "noa4_y" 1 LB H 0; $Z;