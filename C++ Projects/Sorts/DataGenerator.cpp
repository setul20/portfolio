#include <iostream> 
#include <stdlib.h> 
#include <time.h> 
#include <fstream>
using namespace std; 

void MergeSort(int A[], int p, int r);
void Merge(int A[], int p, int q, int r); 
void InsertionSort(int A[]); 
void QuickSort(int A[], int p, int r); 
int Partition(int A[], int p, int r); 
void Exchange(int A[], int i, int j); 
void PrintArray(int[]);

long count = 0; 
long size = 0; 

int main(int argc, char* argv[]) {

  //for makefile: ./DataGenerator | xargs ./sort
  //prints random numbers to command line of sort along with flag
  /*
  cout << " -i "; 
  long size = 24000;
  srand(time(NULL));
  for (long i = 0; i < size; i++) {
    cout << rand() % 30000 << " "; 
  }
  */

  //create random array
  size = 78000; 
  int A[size]; 
  srand(time(NULL));
  for (long i = 0; i < size; i++) {
    A[i] = rand() % 30000; 
  }
  
  //run sorting algorithm
  InsertionSort(A); 
  cout << "Insertion Sort: ";
  PrintArray(A); 

  // Print counts to a file
  ofstream outfile; 
  outfile.open("comparison.txt", std::ios_base::app); 
  outfile << count << endl; 

  return 0; 
} //main

void MergeSort(int A[], int p, int r) {
  int q; 
  if (p < r) {
    q = (p + r)/ 2; 
    MergeSort(A, p, q);
    MergeSort(A, q + 1, r);
    Merge(A, p, q, r); 
  } //if 
} //MergeSort

void Merge(int A[], int p, int q, int r) {
  int n1, n2, i, j; 
  n1 = q - p +1;
  n2 = r - q;
  int L[n1 + 1]; 
  int R[n2 + 1]; 
  for (i = 0; i < n1; i++) {
    L[i] = A[p + i];
  }
  for(j = 0; j < n2; j++) {
    R[j] = A[q + j + 1]; 
  }
  L[n1] = 32000;
  R[n2] = 32000; 
  i = 0;
  j = 0; 
  for (int k = p; k <= r; k++) {
    if (L[i] <= R[j]){
      count++;
      A[k] = L[i];
      i++; 
    }
    else {
      count++; 
      A[k] = R[j];
      j++; 
    }
  } 
} //Merge

void InsertionSort(int A[]) {
  long i, j, key;   
  for (j = 1; j < size; j++) {
    key = A[j];
    i = j -1; 
    while((i >= 0) && (A[i] > key)) {
      A[i + 1] = A[i];
      i--; 
      count++; 
    }
    count++; 
    A[i + 1] = key; 
  }
} //InsertionSort

void QuickSort(int A[], int p, int r) {
  int q; 
  if (p < r) {
    q = Partition(A, p, r);
    QuickSort(A, p, q - 1);
    QuickSort(A, q +1, r); 
  }
} //QuickSort

int Partition(int A[], int p, int r) {
  long pivot, i, j; 
  pivot = A[r];
  i = p - 1; 
  for (j = p; j <= r -1; j++) {
    if (A[j] <= pivot) {
      i++; 
      Exchange(A, i, j); 
    }
    count++; 
  }
  Exchange(A, i + 1, r); 
  return i + 1;
} //Partition 

void Exchange(int A[], int i, int j) {
  int temp;
  temp = A[i];
  A[i] = A[j];
  A[j] = temp; 
} //Exchange

void PrintArray(int A[]) {
  for (long i = 0; i < size; i++) {
    cout << A[i] << " ";
  }
  cout << endl << "Input size: " << size << endl;
  cout << "Total # comparisons: " << count << endl; 
} //PrintArray
