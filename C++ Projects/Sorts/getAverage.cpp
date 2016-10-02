#include <iostream>
#include <fstream> 
using namespace std; 

int main() {
  
  long count, sum; 
  ifstream myfile("comparison.txt"); 
  sum = 0; 

  while(myfile >> count) {
    sum = sum + count; 
  }
  
  sum = sum / 50; 
  cout << "average: " << sum << endl; 
  return 0; 
} //main 
