# 1. Define variables for directories and compiler settings
JAVAC = javac
SRCDIR = src
BINDIR = bin

# -d specifies where to put the .class files
# -sourcepath tells the compiler where to look for source files
JFLAGS = -d $(BINDIR) -sourcepath $(SRCDIR)

# 2. Find all .java files in the A folder
SOURCES = $(wildcard $(SRCDIR)/*.java)

# 3. Default target: runs when you type 'make'
all: directories compile

# 4. Target to create the bin folder if it doesn't exist
directories:
	@mkdir $(BINDIR)

# 5. Target to compile the code
# This depends on $(SOURCES), so it recompiles if source files change
compile: $(SOURCES)
	$(JAVAC) $(JFLAGS) $(SOURCES)

# 6. Target to clean up the compiled files
clean:
	if exist $(BINDIR) rmdir /s /q $(BINDIR)

run:
	java -cp $(BINDIR) Main

.PHONY: all directories compile clean