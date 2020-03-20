JFLAGS = -g
JC = javac-algs4
JVM = java-algs4

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  Client.java \
		  BagInteger.java

MAIN= Client

default: classes

classes: $(CLASSES:.java=.class)

run:$(MAIN).class
	$(JVM) $(MAIN)

clean:
	$(RM) *.class *~
