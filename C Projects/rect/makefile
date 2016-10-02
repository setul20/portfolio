main: rect.o main.o
	gcc -g -Wall -o main main.o rect.o
rect.o: rect.c
	gcc -g -Wall -c rect.c
main.o: main.c
	gcc -g -Wall -c main.c
clean:
	rm -f rect.o main.c main