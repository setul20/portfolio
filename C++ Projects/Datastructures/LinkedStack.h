#ifndef LINKED_STACK_H
#define LINKED_STACK_H
#include "Stack.h"
#include "LinkedList.h"

/**
* A stack implementation based on a doubly linked-list.
*/
template<typename T>
class LinkedStack : public Stack<T> {

  LinkedList<T> *stack; 

 public:

  
  // Default Constructor
  LinkedStack() {
    stack = new LinkedList<T>(); 
  } //LinkedStack

  // Copy Constructor
  LinkedStack(const LinkedStack<T> & other) {
    stack = new LinkedList<T>(); 
    Node<T> *currentNode;
    other.head = currentNode; 
    while (currentNode != NULL) {
      Node<T> *newNode = new Node<T>(currentNode.data);
      newNode->next = currentNode->next;
      newNode->prev = currentNode->prev;
      if (other.head == currentNode) {
	stack->head = newNode;
      }
      if (other.tail == currentNode) {
	stack->tail = newNode; 
      }
      currentNode = currentNode->next;
    }
  } // LinkedStack
  
  // Destructor
  ~LinkedStack(void) {
    delete stack; 
  } // ˜LinkedStack
  
  void push(T data) {
    stack->prepend(data);
  }

   T pop(void) {
    Node<T> *currentNode = stack->head;
    T data = currentNode->data; 
    stack->head = currentNode->next;
    currentNode->next = NULL;
    stack->head->prev = NULL; 
    (stack->numberItems)--; 
    return data;
  }

  T peek(void) const {
    return stack->get(1);
  }

  const int size(void) const {
    return stack->numberItems;
  }

  const bool empty() const {
    return size() == 0; 
  }

}; // LinkedStack

#endif /* LINKED_STACK_H */

