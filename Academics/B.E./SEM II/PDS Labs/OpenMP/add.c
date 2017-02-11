#include <omp.h>   // OpenMP header file
#include <stdio.h>
#include <stdlib.h>
# include <time.h>
#define CHUNKSIZE   100  // Define the chunk which process at a time
#define N       200000

int main (int argc, char *argv[]) 
{
int nthreads, tid, i, chunk;
float a[N], b[N], c[N];

/* Some initializations */
for (i=0; i < N; i++)
  a[i] = b[i] = i * 1.0;
chunk = CHUNKSIZE;


 double start = omp_get_wtime(); // Returns a value in seconds of the time elapsed from some arbitrary, but consistent point.
  for (i=0; i<N; i++)
    {
    c[i] = a[i] + b[i];
    printf("data: c[%d]= %f\n",i,c[i]);
    }
 double end = omp_get_wtime();
printf("time using omp clock %g \n", end - start);
}