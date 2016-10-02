#include <stdlib.h>

//5 points
//Arguments: s - pointer to a C-style string
//Return value: number of characters contained in string
//Note: This method should not change string s.  By putting const in front of the parameter,
//the compiler will give us an error if we attempt to change s accidentally.
int length(const char *s);

//10 points
//Arguments: s - pointer to a C-style string
//Side effect: The characters in the string are reversed
//Note: This method does NOT create a new string.  It reverses the parameter string.
void reverse(char *s);

//10 points
//Argument: s - pointer to a C-style string
//Return value: A pointer to a NEW C-style string that contains the exact same characters
//as parameter s
char* clone(const char *s);

//10 points
//Arguments s1, s2
//Returns true if the strings are equal, and false if they are not.
int compare(const char *s1, const char *s2);

//10 points
//Arguments s1, s2
//Returns a pointer to a NEW C-style string containing s1 followed by s2.  The new string
//must be exactly the size of s1 and s2 combined.
char* concat(const char *s1, const char *s2);

//10 points
//Arguments: s1, s2 - pointers to C-style strings
//Return value: true - s2 is a substring of s1 or s2 is the null string
//              false - s2 is not a substring of s1
int search(const char *s1, const char *s2);

//20 points
//Arguments: s1, s2 - pointers to C-style strings
//           n - number
//Side effect: The string s2 is inserted in the string s1 following the nth
//             character in s1. If n <= 0, s2 is inserted before the first
//             character in s1. If n is greater than the number of characters
//             contained in s1, s2 is inserted following the the last character
//             in s1.
//Example: if s1 is "ade", s2 is "bc" and we call insert(s1, s2, 1), the result will
//         be "abcde". 
//Assumptions/Limitations: It is assumed that the string, s1, is large enough to 
//                         hold all of the characters in both strings plus the
//                         the null character.
void insert(char *s1, const char *s2, int n);

//25 points
//Arguments: s1, delimter
//Returns a pointer to a char array containing entries for each token in s1.  Think of this
//as a 2-D array.  Each row contains a char* (token).  This function creates a NEW char**
//variable and NEW char* variables for each token.  Your method should be memory efficient.
//In other words, the space created for each token should be an exact fit for the space
//that token needs.  If a token is five characters, allocate 5 bytes (plus null terminator).
//The function also writes the number of tokens into the numTokens variable.
char** tokenize(const char *s1, char delimiter, int *numTokens);
