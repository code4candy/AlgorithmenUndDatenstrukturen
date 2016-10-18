# see for more information README.md
JC = javac
JCFLAGS = -g
JBINDIR = bin	# :-) BITTE KEIN SLASH AM ANFANG VOM PFAD 'bin' SETZEN! 
		# Erlaubt: ./bin oder bin; 
		# Kritisch: /bin  :-) Beim Aufruf vom Target/Goal 'clean' oder 'distclean' mit Adminrechte könnte es Probleme geben!

JAVA = java
JAVAFLAGS = -cp

JDOC = javadoc
JDOCDIR = java-doc

MAINCLASS= excercise01/Main
TESTCLASS= excercise01/AlgorithmTest

SOURCES = ./src/excercise01/Main.java \
 	  ./src/excercise01/Algorithm.java \
	  ./src/excercise01/AlgorithmTest.java
	  
default:
	echo 'Run target default'
	mkdir -p $(JBINDIR)
	$(JC) $(JCFLAGS) $(SOURCES) -d $(JBINDIR)

run-app:
	@echo 'Run target run-app'
	cd $(JBINDIR); $(JAVA) $(JAVAFLAGS) . $(MAINCLASS)	

run-test:
	@echo 'Run target run-test'
	cd $(JBINDIR); $(JAVA) $(JAVAFLAGS) . $(TESTCLASS)	
	
doc:
	@echo 'Run target doc' 
	$(JDOC) -version -author -d $(JDOCDIR) $(SOURCES)		

clean:
	@echo 'Run target clean'
	$(RM) -r $(JBINDIR)

distclean: clean
	@echo 'Run target distclean'
	$(RM) -r $(JDOCDIR)

release: distclean default doc	