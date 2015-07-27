CWD="$(cd .. && pwd)"
export CLASSPATH=target:$CWD/lib/stdlib.jar:$CWD/lib/algs4.jar
javac -cp $CLASSPATH -d target -sourcepath src src/Percolation.java src/PercolationStats.java src/PercolationVisualizer.java src/InteractivePercolationVisualizer.java
#echo "Check Style"
#java -jar $CWD/lib/checkstyle-6.7-all.jar -c /google_checks.xml src/Percolation.java
java -cp $CLASSPATH PercolationVisualizer resources/input20.txt