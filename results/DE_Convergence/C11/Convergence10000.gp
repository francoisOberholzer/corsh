set terminal pngcairo size 800,800 enhanced font 'Verdana,10'
set output "Convergence-C11-10000.png"
set title "Convergence-C11-10000"
#
set xlabel "X1"
set ylabel "X2"
set xrange [-100:100]
set yrange [-100:100]
set grid ytics lt 0 lw 2 lc rgb "#666666"
set grid xtics lt 0 lw 2 lc rgb "#666666"
#
plot "C11_2D_CONVERGENCE_5.dat" using 1:2 title '' pt 7 ps 0.6 lt 0
