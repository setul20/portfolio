/*
        Filename: rot13lib.c
        Description: rot13 implementation
*/

#include "rot13lib.h"
#include <stdio.h>


// rot13 cipher
void rot13(char * input)
{
   //Your code goes here

   int i;
   for (i=0; input[i] != '\0'; i++)
   {
     if (input[i] >= 'a' && input[i] <= 'm')
     {
       input[i] = input[i] + 13;
     }
     else if (input[i] >= 'A' && input[i] <= 'M')
     {
       input[i] = input[i] + 13;
     }
     else if (input[i] >= 'n' && input[i] <= 'z')
     {
       input[i] = input[i] - 13;
     }
     else if (input[i] >= 'N' && input[i] <= 'Z')
     {
       input[i] = input[i] - 13;
     }
     else
       continue;



   }

   //printf("%s\n",input);

}
