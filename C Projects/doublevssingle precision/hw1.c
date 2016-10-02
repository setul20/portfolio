#include <stdio.h>
#include <math.h>

int main()
{
  float sum = 0;
  float sum2 = 0;
  double sum1 = 0;
  double sum3 = 0;
  int i;
  int j;

  for(i = 1; i <= 1000000; i++)
    {
      sum += 1/(3* pow(i,2));
      sum1 += 1/(3* pow(i,2));
    }
  printf("Float sum (single precision & natural order): %20.32f\n", sum);
  printf("Double sum (double precision & natural order): %20.64f\n", sum1);

  for(j = 1000000; j >= 1; j--)
    {
      sum2 += 1/(3* pow(j,2));
      sum3 += 1/(3* pow(j,2));
    }
  printf("Float sum (single precision & reverse order): %20.32f\n",sum2);
  printf("Double sum (double precision & reverse order): %20.64f\n", sum3);

}
