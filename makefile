build:
	javac -d bin -sourcepath src src/*.java
	jar cfev Exer4.jar Main -C bin .

debug-build:
		javac -d bin -sourcepath src src/*.java -g
		jar cfev Exer4.jar Main -C bin .
