#ifndef LINKED_LIST_H
#define LINKED_LIST_H 
#include <iostream>
using namespace std;
// forward declation of LinkedList
template<typename T>
class LinkedList;

/**
* Represents a node in a doubly-linked list.
*/
template<typename T>
class Node {

  friend class LinkedList<T>;
 public: 

  T data;
  Node<T> *prev = NULL;
  Node<T> *next = NULL;

  Node<T>(T value) {
    data = value;
    prev = NULL; 
    next = NULL; 
  }

}; // Node

/**
* A doubly-linked list data structure.
*/
template<typename T>
class LinkedList {
 public:
  Node<T> *head; 
  Node<T> *tail; 
  int numberItems;

  /**
   * Adds an item to the end of this list.
   * @param data the item to append
   */
  void append(T data) {
    // if list is empty 
    Node<T> newNode(data);
    if (empty() == true) {
      head = &newNode;
      tail = &newNode;
      numberItems = 0;
    }
    // if list is not empty 
    else {
      tail->next = &newNode; 
      newNode.prev = tail;
      tail = &newNode; 
    }
    numberItems++;  
  }

  /**
   * Removes all elements from this list.
   */
  void clear(void){
    // no work needs to be done if already empty
    if (empty() != true) {
      Node<T> *nextNode = head;
      Node<T> *currentNode = head; 
      while(nextNode != NULL) {
	nextNode = currentNode.next; 
	delete *currentNode;  
	currentNode = nextNode; 
      } 
      head = NULL;
      tail = NULL;
      numberItems = 0;
    }
  }

  /**
   * Returns the item at the given index location.
   * @param i the index of the item to return
   */
  T get(int i) const { 
    if (i > numberItems) {
      cout << "Index is higher than number of elements" << endl;
      return (T) NULL; 
    } //if
    else {
      int counter = 1;
      if (i == 1) {
	return head->data; 
      }
      else {
	Node<T> *currentNode = head;
	while (counter != i) {
	  currentNode = currentNode->next; 
	  counter++;
	}
	return currentNode->data;
      } 
    } //else
  } // get
 
  /**
   * Adds an item to the list at the specified index location.
   * @param i the index where to insert the item
   * @param data the item to insert
   */
  void insert(int i, T data) {
    int counter = 1;
    Node<T> *currentNode = *head;
    while (counter != (i -1)) {
      currentNode = currentNode.next;
      counter++;
    }
    Node<T> newNode = new Node<T>(data);
    Node<T> *temp1, *temp2;
    temp1 = currentNode.next;
    temp2 = (currentNode.next).prev;
    
    (currentNode.next).prev = newNode;
    currentNode.next = newNode; 
    newNode.prev = temp2;
    newNode.next = temp1;
  }

  /**
   * Adds an item to the beginning of this list.
   * @param data the item to prepend
   */
  void prepend(T data) {
    Node<T> *newNode = new Node<T>(data);
    if (empty() == true) {
      head = newNode;
      tail = newNode; 
      numberItems = 0;
    }
    else {
      newNode->next = head;
      head->prev = newNode;
      head = newNode;
    }
    numberItems++;
  }

  /**
   * Sets the value of element at the given index.
   * @param i the index of the element to set
   * @param data the value to set
   */
  void set(int i, T data) {
    if (i > numberItems) {
      cout << "Index is higher than number of elements" << endl; 
    } //if
    else {
      int counter = 1;
      Node<T> *currentNode = *head; 
      while (counter != i) {
	currentNode = currentNode.next; 
	counter++;
      }
      currentNode.data = data;
    }
  }

  /**
   * Returns the number of elements in this list.
   */
  const int size() const{
    return numberItems;
  }

  /**
   * Returns whether or not this linked list is empty.
   */
  const bool empty() const {
    return size() == 0;
  } // empty

}; // LinkedList

#endif /** LINKED_LIST_H */
