#include <stdio.h>
#include <stdlib.h>
#include "matmult.h"

int main(int argc, char *argv[])
{
	double **m1, **m2, **mr;
	int m1_rows, m1_cols, m2_rows, m2_cols, mr_rows, mr_cols;

   //TODO: Take input for the number of rows and columns of matrix 1 and 2
   //Note: the number of columns of m1 must equal the number of rows of m2 for input to be valid

	printf("Enter the number of rows in matrix 1: ");
	scanf("%d", &m1_rows);
	if ((m1_rows > 20) || (m1_rows < 1)) {
		printf("Each dimension of the matrix must be between 1-20\n");
		exit(0);
	}
	printf("Enter the number of cols in matrix 1: ");
	scanf("%d", &m1_cols);
	if ((m1_cols > 20) || (m1_cols < 1)) {
		printf("Each dimension of the matrix must be between 1-20\n");
		exit(0);
	}
	printf("Enter the amount of rows in matrix 2: ");
	scanf("%d", &m2_rows);
	if ((m2_rows > 20) || (m2_rows < 1)) {
		printf("Each dimension of the matrix must be between 1-20\n");
		exit(0);
	}
	printf("Enter the amount of cols in matrix 2: ");
	scanf("%d", &m2_cols);
	if ((m2_cols > 20) || (m2_cols < 1)) {
		printf("Each dimension of the matrix must be between 1-20\n");
		exit(0);
	}
	if (m2_rows != m1_cols) {
		printf("The number of columns for m1 and number of rows in m2 must be equal.\n");
		exit(0);
	}
	

   //These lines set the number of rows and columns for the result matrix.  Do not remove
	mr_rows = m1_rows;
	mr_cols = m2_cols;

   //TODO: Dynamically allocate space for m1 and m2
	int i;
	m1 = (double**)malloc(m1_rows*sizeof(double*));
	for (i = 0; i<  m1_rows; i++) {
		*(m1 + i) = (double*)malloc(m1_cols*sizeof(double));
	}

	m2 = (double**)malloc(m2_rows*sizeof(double*));
	for (i = 0; i < m2_rows; i++) {
		*(m2 + i) = (double*)malloc(m2_cols*sizeof(double));
	}

   //TODO: Allocate the 2-D array for the result
	
	mr = (double **)calloc(mr_rows, sizeof(double*));
	for (i = 0; i < mr_rows; i++) {
		*(mr + i) = (double*)calloc(mr_cols, sizeof(int));
	}


	int j, k;
	
	// reads input for matrix 1
	
	for (j = 0; j < m1_rows; j++) {
		printf("Enter the values for row %d of matrix 1 (press enter after each):\n", j);
		for (k = 0; k < m1_cols; k++) {
			printf("value %d: ", k);
			scanf("%lf", &m1[j][k]);
			if ((m1[j][k] > 20) || (m1[j][k] < 1)) {
				printf("Each dimension of the matrix must be within range 1-20.\n");
				exit(0);
			}
		}
	}
	
	// reads input for matrix 2
	
	for (j = 0; j < m2_rows; j++) {
		printf("Enter the values for row %d of matrix 2 (press enter after each):\n", j);
		for (k = 0; k < m2_cols; k++) {
			printf("value %d: ", k);
			scanf("%lf", &m2[j][k]);
			if ((m2[j][k] > 20) || (m2[j][k] < 1)) {
				printf("Each dimension of the matrix must be within range 1-20.\n");
				exit(0);
			}
		}
	}
	
	//These two lines perform the matrix multiply and print the result -- Do not remove
	
	matMult(m1, m2, mr, mr_rows, mr_cols, m1_cols);
	printMat(mr, mr_rows, mr_cols);

	//TODO: deallocate is not currently implemented.  You need to implement this function.
   deallocate(m1, m2, mr, m1_rows, m2_rows, mr_rows); 

	return 0;
}

//This function frees all memory previously allocated for all three matrices
void deallocate(double **m1, double **m2, double **mr, int m1_rows, int m2_rows, int mr_rows)
{
	//TODO: You must implement this function.  It should free all memory allocated in main

	int k;
	for (k = 0; k < m1_rows; k++) {
		free(*(m1 + k));
	}
	free (m1);

	for (k = 0; k < m2_rows; k++) {
		free(*(m2 + k));
	}
	free (m2);

	for (k = 0; k < mr_rows; k++) {
		free(*(mr + k));
	}
	free (mr);

}

//This function performs the matrix multiplication and stores the result in mr
void matMult(double **m1, double **m2, double **mr, int mr_rows, int mr_cols, int m1_cols)
{
	int i, j, k;
   for (i=0; i<mr_rows; i++)
	{
	   for (j=0; j<mr_cols; j++)
	   {
		   mr[i][j]=0;
		   for (k=0; k<m1_cols; k++)
			   mr[i][j]+=(m1[i][k]*m2[k][j]);
	   }
	}
}

//This function prints the 2-D array, mr (multiply result)
void printMat(double **mr, int mr_rows, int mr_cols)
{
	int i, j;
	for (i=0; i<mr_rows; i++)
	{
		for (j=0; j<mr_cols; j++)
			printf("%lf\t",mr[i][j]);
	   printf("\n");
	}
}
