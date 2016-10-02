#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main()
{
  FILE *filepointer;
  char filename[80];
  char word[80];
  int wordcount = 0;
  int wordlength;
  int wl3 = 0, wl4 = 0, wl5 = 0, wl6 = 0, wl7 = 0, wl8 = 0, wl9 = 0, wl10 = 0, wl11 = 0, wl12 = 0, wl13 = 0, wl14 = 0, wl15 = 0;


  printf("I will count the words in a file\n");
  printf("Which file would you like to use?\n");
  printf("Filename: ");
  scanf("%s", filename);
  filepointer = fopen(filename, "r");

  if (filepointer == NULL)
  {
    printf("The file could not be opened. Goodbye!\n");
    exit(0);
  }

  while((fscanf(filepointer,"%s", word)) != EOF)
  {
    wordcount++;
    wordlength = strlen(word);

    if (wordlength == 3)
    {
      wl3++;
    }
    else if (wordlength == 4)
    {
      wl4++;
    }
    else if (wordlength == 5)
    {
      wl5++;
    }
    else if (wordlength == 6)
    {
      wl6++;
    }
    else if (wordlength == 7)
    {
      wl7++;
    }
    else if (wordlength == 8)
    {
      wl8++;
    }
    else if (wordlength == 9)
    {
      wl9++;
    }
    else if (wordlength == 10)
    {
      wl10++;
    }
    else if (wordlength == 11)
    {
      wl11++;
    }
    else if (wordlength == 12)
    {
      wl12++;
    }
    else if (wordlength == 13)
    {
      wl13++;
    }
    else if (wordlength == 14)
    {
      wl14++;
    }
    else if (wordlength == 15)
    {
      wl15++;
    }

  }

  printf("There are %d words in the file\n", wordcount);
  printf("There are %d words of length 3\n", wl3);
  printf("There are %d words of length 4\n", wl4);
  printf("There are %d words of length 5\n", wl5);
  printf("There are %d words of length 6\n", wl6);
  printf("There are %d words of length 7\n", wl7);
  printf("There are %d words of length 8\n", wl8);
  printf("There are %d words of length 9\n", wl9);
  printf("There are %d words of length 10\n", wl10);
  printf("There are %d words of length 11\n", wl11);
  printf("There are %d words of length 12\n", wl12);
  printf("There are %d words of length 13\n", wl13);
  printf("There are %d words of length 14\n", wl14);
  printf("There are %d words of length 15\n", wl15);
}
