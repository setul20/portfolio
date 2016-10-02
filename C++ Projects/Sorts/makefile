run: sort
	./sort -i 5 7 12 47 2 15

runLoop: DataGenerator getAverage
	number=1 ; while [[ $$number -le 50 ]] ; do \
		./DataGenerator ; \
		((number = number + 1)) ; \
	done
	./getAverage

compile: 
	g++ sort.cpp -o sort
	g++ DataGenerator.cpp -o DataGenerator
	g++ getAverage.cpp -o getAverage

sort: sort.cpp
	g++ sort.cpp -o sort

DataGenerator: DataGenerator.cpp
	g++ DataGenerator.cpp -o DataGenerator

getAverage: getAverage.cpp
	g++ getAverage.cpp -o getAverage

clean: 
	rm sort DataGenerator getAverage comparison.txt