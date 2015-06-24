javac -d bin -sourcepath src -cp lib/algs4.jar:lib/stdlib.jar src/Percolation.java src/PercolationStats.java
java -cp bin:lib/algs4.jar:lib/stdlib.jar Percolation 10