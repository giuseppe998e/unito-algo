#
# Makefile progetto algoritmi - Esercizio 4
# Per sistema operativo GNU/Linux
#

JAVA_CMD = java
JAVAC_CMD = javac

MKD = mkdir -p
RM = rm -rf

SRCDIR = src
OBJDIR = obj
LIBDIR = lib

JUNIT_JAR = junit-4.12.jar
HAMCREST_JAR = hamcrest-core-1.3.jar

#
.PHONY: build
build: init compile_test
	$(JAVAC_CMD) -cp "$(SRCDIR):$(LIBDIR)/$(JUNIT_JAR):$(LIBDIR)/$(HAMCREST_JAR)" $(SRCDIR)/Main.java -d $(OBJDIR)
	
#
.PHONY: compile_test
compile_test:
	$(JAVAC_CMD) -cp "$(SRCDIR):$(LIBDIR)/$(JUNIT_JAR):$(LIBDIR)/$(HAMCREST_JAR)" $(SRCDIR)/MainTest.java -d $(OBJDIR)

#
.PHONY: init
init:
	$(MKD) "./$(OBJDIR)"
	
#
.PHONY: test
test:
	$(JAVA_CMD) -cp "$(OBJDIR):$(LIBDIR)/$(JUNIT_JAR):$(LIBDIR)/$(HAMCREST_JAR)" MainTest
	
#
.PHONY: clean
clean:
	$(RM) $(OBJDIR)
