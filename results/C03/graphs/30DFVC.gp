set terminal pngcairo size 800,800 enhanced font 'Verdana,10'
set output "30DFVC.png"
set title "C03-FVC-30D"
#
set xlabel "Fitness"
set ylabel "Violation"
set grid ytics lt 0 lw 2 lc rgb "#666666"
set grid xtics lt 0 lw 2 lc rgb "#666666"
#
plot "data/30DFVC.dat" using 1:2 title '' pt 7 ps 0.6 lt 0
