#include <omp.h>	// OpenMP header file
#include <stdio.h>
#include <stdlib.h>
# include <time.h>
#define CHUNKSIZE   100
#define N       100000

int main (int argc, char *argv[]) 
{
int nthreads, tid, i, chunk;
float a[N], b[N], c[N];

/* Some initializations */
 for (i=0; i < N; i++)
   a[i] = b[i] = i * 1.0;
 chunk = CHUNKSIZE;

 clock_t start_t, end_t, total_t;
 start_t = clock(); // C program clock starts
 double start = omp_get_wtime(); // openMP clock starts
 #pragma omp parallel shared(a,b,c,nthreads,chunk) private(i,tid)
 // open MP code inside this block
  {
  tid = omp_get_thread_num();	// Returns the thread identification number, from 0 to n-1 where n are no of active thread
  if (tid == 0)
    {
    nthreads = omp_get_num_threads();	// Returns the no of threads active in the current parallel region
    printf("Number of threads = %d\n", nthreads);
    }
  printf("Thread %d starting...\n",tid);

  #pragma omp for schedule(dynamic,chunk)
  for (i=0; i<N; i++)
    {
    c[i] = a[i] + b[i];
    printf("Thread %d: c[%d]= %f\n",tid,i,c[i]);
    }	
  }  /* end of parallel section */

 double end = omp_get_wtime(); // OpenMP clock ends
 end_t = clock(); // Sample C code clock ends
 total_t = (double)(end_t - start_t)/ CLOCKS_PER_SEC;
 printf("time using omp clock %g \n", end - start);
 printf("\n Total time taken by openmp in  seconds: %f\n", (double)(total_t ) );

}
// Output is taking 4 threads(Quad vore processor) as 2 cores & 2 hypercores(We can manually change it). So, at max you can run 8 threads efficiently(1 thread per core) and even more than 8 we can run which will queue into message queue. 