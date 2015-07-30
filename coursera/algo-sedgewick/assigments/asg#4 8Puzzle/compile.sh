CWD="$(cd .. && pwd)"
export CLASSPATH=target:$CWD/lib/stdlib.jar:$CWD/lib/algs4.jar:$CWD/lib/junit-4.12.jar:$CWD/lib/hamcrest-core-1.3.jar

if javac -cp $CLASSPATH -d target -sourcepath src src/Board.java test/EightPuzzleBoardTest.java ; then
    if java -cp $CLASSPATH org.junit.runner.JUnitCore EightPuzzleBoardTest ; then
	    echo "8 elem"
	    # echo 1 2 3 4 5 6 7 8 | java -cp $CLASSPATH Subset 8
	    # echo "5 elem"
	    # echo 1 2 3 4 5 6 7 8 | java -cp $CLASSPATH Subset 5
	    # echo "3 elem"
	    # echo 1 2 3 4 5 6 7 8 | java -cp $CLASSPATH Subset 3
	fi
fi




# echo A B C D E F G H I | java -cp $CLASSPATH Subset 3 

# tests

