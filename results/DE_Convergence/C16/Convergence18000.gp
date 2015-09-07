set terminal pngcairo size 800,800 enhanced font 'Verdana,10'
set output "Convergence-C16-18000.png"
set title "Convergence-C16-18000"
#
set xlabel "X1"
set ylabel "X2"
set xrange [-10:10]
set yrange [-10:10]
set grid ytics lt 0 lw 2 lc rgb "#666666"
set grid xtics lt 0 lw 2 lc rgb "#666666"
#
plot "C16_2D_CONVERGENCE_9.dat" using 1:2 title '' pt 7 ps 0.6 lt 0
