#include <stdio.h>
#include <stdlib.h>
# include <time.h>

#define NRA 82                    /* number of rows in matrix A */
#define NCA 82                /* number of columns in matrix A */
#define NCB 82                 /* number of columns in matrix B */

int main (int argc, char *argv[])
{
int	i, j, k, rc;           /* misc */
double	a[NRA][NCA],           /* matrix A to be multiplied */
	b[NCA][NCB],           /* matrix B to be multiplied */
	c[NRA][NCB], wtime;  /* result matrix C */


 clock_t start_t, end_t, total_t;
 start_t = clock();
      printf("Initializing arrays...\n");
      for (i=0; i<NRA; i++)
         for (j=0; j<NCA; j++)
            a[i][j]= i+j;
      for (i=0; i<NCA; i++)
         for (j=0; j<NCB; j++)
            b[i][j]= i*j;

      

      for (k=0; k<NCB; k++)
	{
         for (i=0; i<NRA; i++)
         {
             
	c[i][k] = 0.0;
            for (j=0; j<NCA; j++)
		{
               c[i][k] = c[i][k] + a[i][j] * b[j][k];
		}
	printf("%6.2f\t",c[i][k]);
         }
}

 end_t = clock();
total_t = (double)(end_t - start_t)*1000/ CLOCKS_PER_SEC;
   printf("\n Total time taken by CPU in milli seconds: %f\n", (double)(total_t ) );
}
