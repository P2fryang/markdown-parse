PATH="./"
TESTFILE="MarkdownParseTest.java"
TESTOBJ="MarkdownParseTest"
CLASSPATH="\".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar\""
JUNIT_RUNNER="org.junit.runner.JUnitCore"

echo "javac -cp $CLASSPATH $PATH$TESTFILE"
echo "java -cp $CLASSPATH $JUNIT_RUNNER $TESTOBJ"
javac -cp $CLASSPATH $PATH$TESTFILE
java -cp $CLASSPATH $JUNIT_RUNNER $TESTOBJ