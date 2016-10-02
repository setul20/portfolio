#include <stdio.h>
#include <stdlib.h>
#include "strings.h"

int length(const char *s)
{
  int i = 1;
  while(s[i] != '\0')
  {
    i++;
  }

  return i;
}

void reverse(char *s)
{
  char temp[length(s)];
  int i = 0, j = 0;
  while(s[i] != '\0')
  {
    temp[i] = s[i];
    i++;
  }

  i--;
  while(i >= 0)
  {
    *(&s[j]) = temp[i];
    j++;
    i--;
  }
}

char* clone(const char *s)
{
  char duplicate[length(s)];
  char *clone;
  int i = 0;
  while(s[i] != '\0')
  {
    duplicate[i] = s[i];
    i++;
  }
  clone = &duplicate[0];

  return clone;
}

int compare(const char *s1, const char *s2)
{
  int lengths1 = length(s1);
  int lengths2 = length(s2);
  int i = 0;

  if (lengths1 == lengths2)
  {
    while(i <= lengths1)
    {
      if (s1[i] != s2[i])
      {
        return 0;
      }

      if (s1[i] == '\0' && s2[i] == '\0')
        return 1;

      i++;
    }
  }
  else
    return 0;

  return 0;
}

char* concat(const char *s1, const char *s2)
{
  int lengths1 = length(s1)-1;
  int lengths2 = length(s2)-1;
  int totallength = lengths1 + lengths2;
  char final[totallength-1];
  int i = 0, j = 0;
  char *finalpointer;

  while(s1[i] != '\0')
  {
    final[i] = s1[i];
    i++;
  }

  while(s2[j] != '\0')
  {
    final[i] = s2[j];
    i++;
    j++;
  }

  finalpointer = &final[0];

  return finalpointer;
}

int search(const char *s1, const char *s2)
{
  int lengths1 = length(s1);
  int lengths2 = length(s2);
  int i = 0, j = 0, count = 0;

  if(s2[0] == '\0')
  {
    return 1;
  }

  while(i <= lengths1)
  {
    if (s1[i] == s2[j])
    {
      break;
    }

    if (i == lengths1)
    {
      return 0;
    }

    i++;
  }

  while(i <= lengths1)
  {
    if(s1[i] == s2[j])
    {
      j++;
      i++;
      count++;
    }
    else
    {
      return 0;
    }

    if (count == lengths2)
    {
      return 1;
    }
  }

  return 0;
}

void insert(char *s1, const char *s2, int n)
{
  int lengths1 = length(s1);
  int lengths2 = length(s2);
  int totallength = lengths1 + lengths2;
  char final[totallength];
  int i = 0, j = 0, k = 0, l = 0;

  if(n <= 0)
  {
    while (s2[i] != '\0')
    {
      final[i] = s2[i];
      i++;
    }

    while (s1[j] != '\0')
    {
      final[i] = s1[j];
      i++;
      j++;
    }
  }
  else if(n >= lengths1)
  {
    while(s1[i] != '\0')
    {
      final[i] = s1[i];
      i++;
    }

    while(s2[j] != '\0')
    {
      final[i] = s2[j];
      i++;
      j++;
    }
  }
  else
  {
    while(i < n)
    {
      final[i] = s1[k];
      i++;
      k++;
    }

    while(s2[j] != '\0')
    {
      final[i] = s2[j];
      i++;
      j++;
    }

    while(s1[k] != '\0')
    {
      final[i] = s1[k];
      i++;
      k++;
    }
  }

  totallength = totallength -1;
  while(l <= totallength)
  {
    s1[l] = final[l];
    l++;
  }
}


char** tokenize(const char *s1, char delimiter, int *numTokens)
{
   int i, leng, numOfTokes;
   numOfTokes = 0;
   leng = length(s1);
   printf("Length = %d\n", leng);
   for (i = 0; i < leng; i++)
   {
       printf("char = %c\n", *(s1 + i));
       if (*(s1 + i)== delimiter){
            numOfTokes++;
       }
   }
   numOfTokes++;
   *numTokens = numOfTokes;
   int tokenSpace[numOfTokes];
   int spaceNeeded,tokeIndex;
   tokeIndex = 0;
   for (i = 0; i < numOfTokes; i++)
   {
      spaceNeeded = 0;
      while ( *(s1 + tokeIndex) != delimiter && *(s1 + tokeIndex) != '\0')
      {
           spaceNeeded++;
           tokeIndex++;
      }
     tokeIndex++;
     tokenSpace[i] = spaceNeeded;
     printf("tokenSpace[%d] = %d\n", i, spaceNeeded);
    }
    char** dblPtr;
    dblPtr = (char**)calloc(numOfTokes, sizeof(char*));
    for (i = 0; i<numOfTokes; i++)
    {
        *(dblPtr + i) = (char*)calloc(tokenSpace[i], sizeof(char));
    }
    int q,r;
    for (i = 0, q =0,r =0; i< leng; i++)
    {
        if(*(s1 + i) != '\0' && *(s1 + i) != delimiter)
        {
           *(*(dblPtr + q) + r) = *(s1 + i);
           printf("%c\n", *(*(dblPtr + q) + r));
          r++;
        }else if( *(s1 + i) == delimiter)
        {
          q++;
          r = 0;
        }
    }
   return dblPtr;
}
