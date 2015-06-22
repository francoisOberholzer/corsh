reset
#set terminal pngcairo size 800,800 enhanced font 'Verdana,10'
set terminal post eps 
set size 0.8, 0.8
set output 'G08Fitness2D.eps'

set yrange [0:10]
set xrange [0:10]
set grid ytics lt 0 lw 2 lc rgb "#666666"
set grid xtics lt 0 lw 2 lc rgb "#666666"
set ticslevel 0

set samples 201
set isosample 201

set pm3d
set hidden3d
#set palette defined (0 "#000000", 3 "#005C00", 5 "#FFFF00", 5.8 "#FF0000") 
set view 70, 30

f1(x1,x2) = (sin(2*pi*x1))**3 * sin(2*pi*x2)
f2(x1,x2) = x1**3 * (x1 + x2)

splot (-f1(x,y) / f2(x,y)) title "" lt 1

quit
