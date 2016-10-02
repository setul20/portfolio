#include <iostream>
#include <cstdlib>
#include <sys/time.h>
#include "ArrayStack.h"
#include "LinkedStack.h"
using std::cout;
using std::endl;
using std::string;

int main(int argc, const char * argv[]) {

  int sampleSize, randomNum;
  timeval tim;

  cout << "Testing Stack Implementations..." << endl;
  Stack<int> * s1 = new ArrayStack<int> {};
  Stack<int>  * s2 = new LinkedStack<int> {};

  sampleSize = 1000;
  for (int i = 0; i < sampleSize; i++) {
    randomNum = rand(); 
    s2->push(randomNum); 
  }
  gettimeofday(&tim, NULL);
  double t1 = (tim.tv_sec * 1000.0) + (tim.tv_usec/1000.0);
  for (int i = 0; i < sampleSize; i++) {
    //s1->push(randomNum);
    //s1->pop();
    //s2->push(randomNum);
    s2->pop();
  }
  gettimeofday(&tim, NULL);
  double t2 = (tim.tv_sec * 1000.0) + (tim.tv_usec/1000.0);
  double elapsedTime = t2 - t1; 
  cout << elapsedTime << endl;
  
  delete s1;
  delete s2;
  return EXIT_SUCCESS;
} // main
