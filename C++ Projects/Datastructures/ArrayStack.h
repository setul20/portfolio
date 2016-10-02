#ifndef ARRAY_STACK_H
#define ARRAY_STACK_H
#include "Stack.h"
#include <cstddef>
using std::cout;
using std::endl;
using std::string;

/**
* An array-based stack implementation.
*/

template<typename T>
class ArrayStack : public Stack<T> {
  
 public:

   int counter  = 0;
   int arraySize = 10000;
   T *stack; 

  // Default Constructor
  ArrayStack(void) {
    stack = new T[arraySize];
  }

  // Copy Constructor
  ArrayStack(const ArrayStack<T> & other) {
    stack = new T[arraySize];
    for (int i =0; i <= other.length; i++)
      {
	stack[i]=other[i];
      }
    counter = other.counter;
  } // ArrayStack

  void increasesize(T array[]) {
    arraySize++;
    ArrayStack(stack); 
  } // ArrayStack   
  
  // Destructor
  ~ArrayStack(void) {
    delete [] stack;
  } // ~ArrayStack

  void push(T data) {
    if (counter ==  arraySize)
      {
	increasesize(stack);
      }
    stack[counter]=data;
    counter++;
  }

  T pop(void) {
    T data;
    data = stack[counter];
    stack[counter-1]= NULL;
    counter--;
    return data;
  } 
  
  T peek(void) const {
    return stack[counter - 1];
  }

  const int size(void) const {
    return counter;
  }
  
  const bool empty() const {
    return size() == 0;
  }

}; // ArrayStack

#endif /* ARRAY_STACK_H */
