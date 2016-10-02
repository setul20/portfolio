#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int max(int *a, int n)
{
  int i;
  int maximum = a[0];
  
  for (i= 0; i < n; i++)
    {
      if(a[i] > maximum)
	{
	  maximum = a[i];
	}
    }
  return maximum;
}

int main()
{
  srand(time(NULL));

  int i,j;
  int temp [1000];
  clock_t begin, end;
  float spent, spent1, spent2;

  begin = clock();
  // printf("Ramdom max: %d\n",RAND_MAX);
  for (i =0; i < 1000; i++)
    {
      temp [i] = rand()%1000+1;
      //printf("%d\n",temp[i]);
    }

  end = clock();
  spent = ((float)(end-begin))/CLOCKS_PER_SEC;
  printf("Time spent for 1-D Array: %f\n", spent);
  printf("Max is: %d\n", max(temp, 1000));
  
  begin = clock();
  float mat1 [100][100];
  float mat2 [100][100];
  float ans1 [100][100];

  for(i=0; i < 100; i++)
    {
      for (j = 0; j < 100; j++)
	{
	  mat1[i][j] = ((float)rand()/(float)(RAND_MAX));
	  mat2[i][j] = ((float)rand()/(float)(RAND_MAX));
	}
    }

  for (i=0; i < 100; i++)
    {
      for (j = 0; j < 100; j++)
	{
	  ans1[i][j] = mat1[i][j]* mat2[i][j];
	}
    }

  end = clock();
  spent1 = ((float)(end-begin))/CLOCKS_PER_SEC;
  printf("Time spent on 100 2-D Array: %f\n", spent1);

  begin = clock();
  
  float mat3[1000][1000];
  float mat4[1000][1000];
  float ans2[1000][1000];

  for(i = 0; i < 1000; i++)
    {
      for(j = 0; j < 1000; j++)
	{
	  mat3[i][j] = ((float)rand()/(float)(RAND_MAX));
	  mat4[i][j] = ((float)rand()/(float)(RAND_MAX));
	}
    }

  for(i = 0; i < 1000; i++)
    {
      for (j = 0; j < 1000; j++)
	{
	  ans2[i][j] = mat3[i][j]*mat4[i][j];
	}
    }

  end = clock();
  spent2 = ((float)(end-begin))/CLOCKS_PER_SEC;
  printf("Time spent on 1000 2-D Array: %f\n", spent2);
}
