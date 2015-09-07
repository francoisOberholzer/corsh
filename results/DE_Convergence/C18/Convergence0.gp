set terminal pngcairo size 800,800 enhanced font 'Verdana,10'
set output "Convergence-C18-0.png"
set title "Convergence-C18-0"
#
set xlabel "X1"
set ylabel "X2"
set xrange [-50:50]
set yrange [-50:50]
set grid ytics lt 0 lw 2 lc rgb "#666666"
set grid xtics lt 0 lw 2 lc rgb "#666666"
#
plot "C18_2D_CONVERGENCE_0.dat" using 1:2 title '' pt 7 ps 0.6 lt 0
