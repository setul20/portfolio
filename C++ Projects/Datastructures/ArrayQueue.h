#ifndef ARRAY_QUEUE_H
#define ARRAY_QUEUE_H
#include "Queue.h"

/**
* An array-based queue implementation.
*/ 
template<typename T>
class ArrayQueue : public Queue<T> {

 public:
  
  int arraySize = 10000;
  T *queue;
  int tail = 0; 
  
  // Default Constructor
  ArrayQueue(void) {
    queue = new T[arraySize]; 
  }

  // Copy Constructor
  ArrayQueue(const ArrayQueue<T> & other) {
    queue = new T[arraySize]; 
    for (int i=0; i < other.tail; i++) {
      queue[i] = other[i];
      (this.tail)++;
    }
  } // ArrayQueue

  // Destructor
  virtual ~ArrayQueue(void) {
    delete[] queue; 
  } // ~ArrayQueue

  void enqueue(T data) {
    if (tail == arraySize) {
      increaseArray(queue);
    }
    queue[tail] = data;
    tail++;
  }

  T dequeue(void) {
    T data = queue[0];
    shiftArray(queue);
    return data; 
  }

  T peek(void) const {
    return queue[0]; 
  }

  const int size(void) const {
    return tail;
  }

  const bool empty() const {
    return size() == 0;
  }

  void shiftArray(T array[]) {
    for (int i = 0; i < tail; i++) {
      queue[i] = array[i+1];
    }
    queue[tail] = 0; 
    tail--;
  }

  void increaseArray(T array[]) {
    arraySize++;
    ArrayQueue(queue); 
  }

}; // ArrayQueue

#endif /* ARRAY_QUEUE_H */
