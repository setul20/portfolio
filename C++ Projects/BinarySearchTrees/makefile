CC = g++ 
DEBUG = -g
CFLAGS = -Wall -std=c++11 -c $(DEBUG)
LFLAGS = -Wall $(DEBUG)

run: BST
	./BST input1.txt

all: BST

BST: BST.o
	$(CC) $(LFLAGS) -o BST BST.o

BST.o: BST.cpp
	$(CC) $(CFLAGS) -c BST.cpp

clean: 
	rm *.o BST