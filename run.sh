PATH="./"
TESTFILE="MarkdownParseTest.java"
TESTOBJ="MarkdownParseTest"
CLASSPATH="\".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar\""
CLASSPATH_LINUX=".:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar"
JUNIT_RUNNER="org.junit.runner.JUnitCore"

if [ "$1" == "linux" ]
then
echo "Linux"
echo "/usr/bin/javac -cp $CLASSPATH_LINUX $PATH$TESTFILE"
echo "/usr/bin/java -cp $CLASSPATH_LINUX $JUNIT_RUNNER $TESTOBJ"
echo ""
javac -cp $CLASSPATH_LINUX $PATH$TESTFILE
java -cp $CLASSPATH_LINUX $JUNIT_RUNNER $TESTOBJ
else
echo "Windows"
echo "javac -cp $CLASSPATH $PATH$TESTFILE"
echo "java -cp $CLASSPATH $JUNIT_RUNNER $TESTOBJ"
echo ""
javac -cp $CLASSPATH $PATH$TESTFILE
java -cp $CLASSPATH $JUNIT_RUNNER $TESTOBJ
fi
