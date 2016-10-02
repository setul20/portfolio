#include <iostream>
#include <cstdlib>
#include <sys/time.h>
#include "ArrayQueue.h"
#include "LinkedQueue.h"
using std::cout;
using std::endl;
using std::string;

int main(int argc, const char * argv[]) {
  
  int sampleSize, randomNum; 
  timeval tim; 

  cout << "Testing Queue Implementations..." << endl;
  Queue<int> * q1 = new ArrayQueue<int> {};
  Queue<int> * q2 = new LinkedQueue<int> {};

  sampleSize = 10;
  for (int i = 0; i <sampleSize; i++) {
    randomNum = rand();
    q2->enqueue(randomNum);
  }
  gettimeofday(&tim, NULL);
  double t1= (tim.tv_sec*1000.0) + (tim.tv_usec/1000.0);
  for (int i = 0; i < sampleSize; i++) {
    //q1->dequeue();
    q2->dequeue();
  }
  gettimeofday(&tim, NULL);
  double t2 = (tim.tv_sec * 1000.0) + (tim.tv_usec/1000.0);
  double elapsedTime = t2 -t1;
  cout << elapsedTime << endl;

  delete q1;
  delete q2;
  return EXIT_SUCCESS;
} // main
