set terminal pngcairo size 800,800 enhanced font 'Verdana,10'
set output "Violation.png"
set title "G24-Violation"
#
set yrange [0:4]
set xrange [0:3]
set xlabel "X1"
set ylabel "X2"
set zlabel "v"
set grid ytics lt 0 lw 2 lc rgb "#666666"
set grid xtics lt 0 lw 2 lc rgb "#666666"
#
set ticslevel 0.2
#
splot "Violation.dat" using 1:2:3 title '' pt 7 ps 0.3 lt 0, \
