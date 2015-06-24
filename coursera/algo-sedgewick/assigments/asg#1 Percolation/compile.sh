CWD="$(cd .. && pwd)"
export CLASSPATH=target:$CWD/lib/stdlib.jar:$CWD/lib/algs4.jar
javac -cp $CLASSPATH -d target -sourcepath src src/Percolation.java src/PercolationStats.java src/PercolationVisualizer.java src/InteractivePercolationVisualizer.java
java -cp $CLASSPATH PercolationVisualizer resources/input20.txt