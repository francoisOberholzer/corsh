set terminal pngcairo size 800,800 enhanced font 'Verdana,10'
set output "Convergence-C13-16000.png"
set title "Convergence-C13-16000"
#
set xlabel "X1"
set ylabel "X2"
set xrange [-500:500]
set yrange [-500:500]
set grid ytics lt 0 lw 2 lc rgb "#666666"
set grid xtics lt 0 lw 2 lc rgb "#666666"
#
plot "C13_2D_CONVERGENCE_8.dat" using 1:2 title '' pt 7 ps 0.6 lt 0
