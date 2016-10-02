
/* C program that to test if a given number is a prime or not */

#include <stdio.h>

/*
 * Test if the input (n) is a prime number.
 * Return:
 *         1 -- prime number
 *         0 -- not a prime number
 */
int isPrime(long n)
{
  int i = 2;
  /* 
   * Your code should be put inside this 
   * function.
   * 
   * Please do not change any other parts
   * of the program. 
   */
  for ( i = 2; i <= n - 1; i++)
    {
      if ( n%i == 0)
	{
	  return 0;
	}
      
    }

  if ( i == n)
    return 1;

  return 1;

}

void checkPrime(long n)
{
  if (isPrime(n))
        printf("%ld is a Prime number\n", n);
  else 
        printf("%ld is not a Prime number\n", n);
}

int main() 
{
  checkPrime(100);
  checkPrime(179424691);
  checkPrime(999962000357);
  checkPrime(4);
  checkPrime(51);
  checkPrime(5413);
  checkPrime(7919);
  return 1;
}

