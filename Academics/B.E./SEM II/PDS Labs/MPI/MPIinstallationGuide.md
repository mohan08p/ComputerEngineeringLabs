Steps to install & configure the MPI(For Stand-alone machine),

1. Download **MPICH3.2 stable** from following link, 
     http://www.mpich.org/downloads/

2. **Extract** the tar with command, 
	     **tar xvf mpich-3.2.tar.gz**
   And, go into the directory /mpich-3.2


3. Then disable the** fortran** with command,
	     **./configure --disable-fortran**


4. Finally, last command,
	     **make; sudo make all**
     
5. Before compiling the program you need to download some library into your workspace, as given in the steps,
          **sudo apt-get install lam4-dev
          sudo apt-get install libmpich-dev
          sudo apt-get install libopenmpi-dev**


Then we can start executing our **MPI program on gcc compiler**.

For Running MPI cluster with-in a LAN, follow this tutorial guide link, 
http://mpitutorial.com/tutorials/running-an-mpi-cluster-within-a-lan/

**GitHub Tutorials Link** : [MPI programming lessons in C and executable code examples ](https://github.com/wesleykendall/mpitutorial/)

 

 