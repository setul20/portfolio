#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/time.h>

//step one of the project
void step1(char *file1, char *file2)
{
  //timing variables
  double timems = 0.0, seconddiff, usecdiff;
  struct timeval start, end;

  gettimeofday(&start, NULL);

  //variables for step one
  FILE *filep1;
  FILE *filep2;
  FILE *filepwrite;
  char temp = '\0';
  char temp1;

  //opening the file
  filep1 = fopen(file1, "r");
  filep2 = fopen(file2, "r");

  //check if the file exists or not
  if (filep1 == NULL && filep2 == NULL)
  {
    printf("File 1 and 2 cannot be found!\n");
    exit(0);
  }
  if (filep1 == NULL)
  {
    printf("File 1 cannot be found!\n");
    exit(0);
  }
  if (filep2 == NULL)
  {
    printf("File 2 cannot be found!\n");
    exit(0);
  }

  //sets buffer to null so no buffering
  setvbuf(filep1, NULL, _IONBF, 0);
  setvbuf(filep2, NULL, _IONBF, 0);

  //opens a file to write
  filepwrite = fopen("diffone.txt", "w");

  //checks if the characters are same or not and than writes it to
  //to the new file created above
  while(temp != EOF)
  {
    temp = getc(filep1);
    temp1 = getc(filep2);

    if (temp != temp1)
    {
      fprintf(filepwrite, "%c", temp);
    }
  }

  //closing all the pointers
  fclose(filep1);
  fclose(filep2);
  fclose(filepwrite);

  //close the time
  gettimeofday(&end, NULL);

  //converts it to millisecond
  seconddiff = (end.tv_sec - start.tv_sec)*1000.0;
  usecdiff = (end.tv_usec - start.tv_usec)/1000.0;
  timems = seconddiff + usecdiff;
  printf("Step One took %f ms long.\n", timems);
}

//step two of the project
void step2(char *file1, char *file2)
{
  //timing variables
  double timems = 0.0, seconddiff, usecdiff;
  struct timeval start, end;

  //starts the time
  gettimeofday(&start, NULL);

  //variables for step two
  FILE *filep1;
  FILE *filep2;
  FILE *filepwrite;
  int size1 = 0, size2 = 0, curpos, curpos1, i = 0, j = 0, diffsize = 0;
  int k = 0, l = 0, m = 0;
  char temp = '\0';
  char temp1 = '\0';
  char *a, *b, *final;

  //opens the file for reading only
  filep1 = fopen(file1, "r");
  filep2 = fopen(file2, "r");

  //checks if the file exists
  if (filep1 == NULL && filep2 == NULL)
  {
    printf("File 1 and 2 cannot be found!\n");
    exit(0);
  }
  if (filep1 == NULL)
  {
    printf("File 1 cannot be found!\n");
    exit(0);
  }
  if (filep2 == NULL)
  {
    printf("File 2 cannot be found!\n");
    exit(0);
  }

  //determins the length of the array needed for file one
  curpos = ftell(filep1);
  fseek(filep1, 0, SEEK_END);
  size1 = ftell(filep1);
  fseek(filep1, curpos, SEEK_SET);

  //alocates the array using the above variable
  a = (char *) calloc(size1, sizeof(char));

  //determins the length of the array needed for file two
  curpos1 = ftell(filep2);
  fseek(filep2, 0, SEEK_END);
  size2 = ftell(filep2);
  fseek(filep2, curpos1, SEEK_SET);

  //alocates the array using the above variable
  b = (char *) calloc(size2, sizeof(char));

  //puts all the characters from file one into an array
  while (temp != EOF)
  {
    temp = getc(filep1);
    a[i] = temp;
    i++;
  }
  //put all the characters from file two into an array
  while (temp1 != EOF)
  {
    temp1 = getc(filep2);
    b[j] = temp1;
    j++;
  }

  //determins the length of array needed for the difference between the two files
  while(b[l] != '\0')
  {
    if(a[k] != b[l])
    {
      diffsize++;
    }
    k++;
    l++;
  }

  //alocates the final array using the variable above
  final = (char *) calloc(diffsize, sizeof(char));

  //opens a file for writing
  filepwrite = fopen("difftwo.txt", "w");

  //puts the difference into the last array made above and writes that to the new
  //file created above
  l = 0;
  k = 0;
  while(b[l] != '\0')
  {
    if (a[k] != b[l])
    {
      final[m] = b[l];
      fprintf(filepwrite, "%c", final[m]);
    }
    k++;
    l++;
    m++;
  }

  //closing all the pointers
  fclose(filep1);
  fclose(filep2);
  fclose(filepwrite);

  //freeing all the alocated space
  free(a);
  free(b);
  free(final);

  //closes the times
  gettimeofday(&end, NULL);

  //converts it to millisecond
  seconddiff = (end.tv_sec - start.tv_sec)*1000.0;
  usecdiff = (end.tv_usec - start.tv_usec)/1000.0;
  timems = seconddiff + usecdiff;
  printf("Step Two took %f ms long.\n", timems);
}

int main(int argc, char *argv[])
{
  char file1name[50];
  char file2name[50];

  if (argc != 3)
  {
    printf("Incorrect number of arguments!\n");
    exit(0);
  }

  strcpy(file1name, argv[1]);
  strcpy(file2name, argv[2]);

  step1(file1name, file2name);
  step2(file1name, file2name);




  return 0;
}
