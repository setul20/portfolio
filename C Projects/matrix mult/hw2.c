#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
  int n = 2;
  double mat1 [n][n];
  double mat2 [n][n];
  double result [n][n];
  double reverse [n][n];
  int i;
  int j;
  double value;
  double value1;
  clock_t begin, end;
  double spent;
  float spent1;

  srand(time(NULL));
  
  for(i = 0; i < n; i++)
    {
      for (j = 0; j < n; j++)
	{
	  value = rand() %1000000+1;
	  value = value/1000000;
	  mat1 [i][j]= value;
	  printf("Matrix 1 at [%d][%d] = %f\n", i,j,mat1[i][j]);
	}
    } 

  printf("\n");

  for (i = 0; i < n; i++)
    {
      for (j = 0; j < n; j++)
	{
	  value1 = rand() %1000000+1;
	  value1 = value1/1000000;
	  mat2 [i][j] = value1;
	  printf("Matrix 2 at [%d][%d] = %f\n", i,j,mat2[i][j]);
	}
    }

  printf("\n");
  begin = clock();

  for (i=0;i<n;i++)
    {
      for (j=0;j<n;j++)
	{
	  result[i][j] = mat1[i][j]*mat2[i][j];
	  printf("Resulting Matrix at [%d][%d] = %f\n", i,j,result[i][j]);
	}
    }

  end = clock();
  spent = ((double)(end-begin))/CLOCKS_PER_SEC;
  spent1 = ((float)(end-begin))/CLOCKS_PER_SEC;
  printf("\nTime spent on straight(double): %f", spent);
  printf("\nTime spent on straight(float): %f\n\n", spent1);

  begin = clock();

  for (i=0;i<n;i++)
    {
      for (j=0;j<n;j++)
	{
	  reverse[i][j] = mat1[j][i]*mat2[j][i];
	  printf("Reverse Matrix at [%d][%d] = %f\n", i,j,reverse[i][j]);
	}
    }

  end = clock();
  spent = ((double)(end-begin))/CLOCKS_PER_SEC;
  spent1 = ((float)(end-begin))/CLOCKS_PER_SEC;
  printf("\nTime spent on reverse: %f", spent);
  printf("\nTime spent on straight(float): %f\n\n", spent1);

  return 1;
}
