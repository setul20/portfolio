#include <iostream>
#include <stdlib.h>
#include <fstream>
#include <string>
using namespace std;  

class Node{ 
public:
  int value;
  Node *left;
  Node *right;
  Node *parent;

  //constructor 
  Node(int key) {
    value = key;
    left = NULL;
    right = NULL;
    parent = NULL;
  }
}; //Node class
 
//Gloal variables applicable to entire tree 
Node *root = NULL;
int numberNodes; 

//Function Declarations
void preorder(Node *z);
void inorder(Node *z);
void postorder(Node *z); 
void insert(Node *z); 
void deleteNode(Node* z); 
void transplant(Node* u, Node* v);
void clearMemory(Node *z); 
Node* minimum(Node *z); 
Node* treeSearch(Node *z, int value);
int height(Node *z); 
int max(int a, int b);
bool isLeaf(Node *z); 

// Main method
int main(int argc, char *argv[]) {
  
  string line; 
  string command;
  string numString;
  int delimIndex; 
  int value;
  Node* nodeExists; 

  //open file 
  ifstream myFile (argv[1]);
  if (myFile.is_open()) {
    while (getline(myFile, line)) {
      //get command from beginning of string
      delimIndex = line.find_first_of(" ");
      command = line.substr(0, delimIndex); 
      
      if (command.compare("insert") == 0) {
	//get the integer for the key
	line = line.substr(delimIndex + 1, line.length());
	delimIndex = line.find_first_of(" ");
	//if there are no more spaces, then the integer is 
	//just the remainder of the text on the line 
	if (delimIndex == -1) {
	  numString = line;
	}
	else {
	  numString = line.substr(0, delimIndex);
	} 
	//converst number as string to number as integer
	value = atoi(numString.c_str());   
	//checks for duplicate values
	nodeExists = treeSearch(root, value); 
	if (nodeExists == NULL) {
	  //call insert method
	  Node *z = new Node(value); 
	  insert(z); 
	}
      } //insert

      else if(command.compare("delete") == 0) {
	//get the integer for the key
	line = line.substr(delimIndex + 1, line.length());
	delimIndex = line.find_first_of(" ");
	if (delimIndex == -1) {
	  numString = line;
	}
	else {
	  numString = line.substr(0, delimIndex);
	}
	value = atoi(numString.c_str());
	//checks that the value is in the tree
	nodeExists = treeSearch(root, value);
	if (nodeExists != NULL) { 
	  // call delete method
	  deleteNode(nodeExists); 
	}
      }//delete
    }//while file has lines left
  } //if file is open 

  //print info about tree
  cout << "Number of nodes in the BST: " << numberNodes << endl;
  cout << "Height of BST: " << height(root) << endl;
  cout << "Pre-order traversal: " << endl; 
  preorder(root);
  cout << endl << "In-order traversal: " << endl;
  inorder(root);
  cout << endl << "Post-order traversal: " << endl;
  postorder(root);
  cout << endl; 

  //close file
  myFile.close();
  clearMemory(root); 
  return 0; 
} //main 

void preorder(Node *z) {
  if (z) {
    cout << z->value << " "; 
    preorder(z->left);
    preorder(z->right);
  }
} //preorder

void inorder(Node *z) {
  if (z) {
    inorder(z->left);
    cout << z->value << " "; 
    inorder(z->right);
  }
} //inorder

void postorder(Node *z) {
  if (z) {
    postorder(z->left);
    postorder(z->right);
    cout << z->value << " "; 
  }
} //postorder

void insert(Node *z) {
  Node *y, *x; 
  
  y = NULL; 
  x = root; 

  //find leaf y to attach new node
  while (x != NULL) {
    y = x; 
    if (z->value < x->value) {
      x = x->left;
    }
    else {
      x = x->right; 
    }
  } //while
  z->parent = y;
  //tree is empty
  if (y == NULL) {
    root = z;
  }
  //z is y's left child
  else if (z->value < y->value) {
    y->left = z;
  }
  //z is y's right child
  else {
    y->right = z; 
  }
numberNodes++; 
} //insert

void deleteNode(Node *z) {
  Node *y = NULL; 
  //If no right child, replace z with z's left child
  if (z->right == NULL) {
    transplant(z, z->left);
  }
  else {
    y = minimum(z->right);
    //if the successor (y) is not z's right child
    if (y->parent != z){
      transplant(y, y->right); 
      y->right = z->right;
      y->right->parent = y; 
    }
    //successor is z's right child
    transplant(z, y); 
    y->left = z->left; 
    if (z->left != NULL) {
      y->left->parent = y;
    }
  }
  delete(z); 
  numberNodes--; 
} //deleteNode

void transplant(Node *u, Node *v) {
  if (u->parent == NULL) {
    root = v;
  }
  else if (u == u->parent->left) {
    u->parent->left = v;
  }
  else {
    u->parent->right = v; 
  }
  if (v != NULL) {
    v->parent = u->parent; 
  }
} //transplant

void clearMemory(Node *z) {
  if (z != NULL) {
    clearMemory(z->left);
    clearMemory(z->right);
    delete(z); 
  }
}

Node* minimum(Node *z) {
  while (z->left != NULL) {
    z = z->left; 
  }
  return z; 
} //minimum


Node* treeSearch(Node *z, int value) {
  if (z==NULL || value == z->value) { 
    return z; 
  }
  if (value < z->value) {
    return treeSearch(z->left, value);
  }
  else {
    return treeSearch(z->right, value); 
  }
} //treeSearch

int height(Node *z) {
  if (z == NULL) {
    return 0; 
  }
  if (isLeaf(z)) {
    return 0;
  }    
  return 1 + max(height(z->left), height(z->right));
}

int max(int a, int b) {
  if (a >= b) {
    return a;
  }
  return b; 
}

bool isLeaf(Node *z) {
  if ((z->left == NULL) && (z->right == NULL)) {
    return true; 
  }
  return false; 
}
