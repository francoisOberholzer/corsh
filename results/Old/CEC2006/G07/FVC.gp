set terminal pngcairo size 800,800 enhanced font 'Verdana,10'
set output "FVC.png"
set title "G07-FVC-10D"
#
set xlabel "Fitness"
set ylabel "Violation"
set grid ytics lt 0 lw 2 lc rgb "#666666"
set grid xtics lt 0 lw 2 lc rgb "#666666"
#
plot "FVC.dat" using 1:2 title '' pt 7 ps 0.6 lt 0
