#ifndef LINKED_QUEUE_H
#define LINKED_QUEUE_H
#include "Queue.h"
#include "LinkedList.h"

/**
* An queue implementation based on a doubly linked list.
*/
template<typename T>
class LinkedQueue : public Queue<T> {

  LinkedList<T> *queue; 

 public:
  
  // Default Constructor
  LinkedQueue(void) {
    queue = new LinkedList<T>();
  }

  // Copy Constructor
  LinkedQueue(const LinkedQueue<T> & other) {
    queue = new LinkedList<T>();
    Node<T> *currentNode;
    currentNode = other.head; 
    while (currentNode != NULL) {
      Node<T> *newNode = new Node<T>(currentNode->data);
      newNode->prev = currentNode->prev;
      newNode->next = currentNode->next; 
      if (other.head == currentNode) {
	queue->head = newNode;
      }
      if (other.tail == currentNode) {
	queue->tail = newNode;
      }
      currentNode = currentNode->next; 
    }
  } // LinkedQueue

  // Destructor
  virtual ~LinkedQueue(void) {
    delete queue; 
  } // ~LinkedQueue

  void enqueue(T data) {
    queue->append(data);
  }

  T dequeue(void) {
    Node<T> *currentNode = queue->head; 
    queue->head = currentNode->next; 
    currentNode->next = NULL;
    currentNode->prev = NULL;
    (queue->numberItems)--;
    return currentNode->data; 
  }

  T peek(void) const {
    return queue->get(1);
  }

  const int size(void) const {
    return queue->numberItems; 
  }

  const bool empty() const {
    return size() == 0;
  }

}; // LinkedQueue
#endif /* LINKED_QUEUE_H */
