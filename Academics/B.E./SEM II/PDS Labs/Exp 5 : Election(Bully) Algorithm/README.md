Implementation of Election (Bully) Algorithm

To understand how Election algorithm solves the Coordinator Election problem.

The coordinator election problem is to choose a process from among a group of processes on different processors in a distributed system to act as the central coordinator. Distributed algorithm requires the need of the coordinator to be elected amongst the once which are currently active(as every process knows the priority of every other process in the system).

Solution approach :

Process P sends an election message to all #highernumberd processes in the system. 

If no process responds, then P becomes the coordinator. End.

If a higher process Q responds, it sends a message to P that terminate P's role in the algorithm.

The process Q now calls an election. 

Repeat until no #higherprocess responds. The last process to call an election "wins" the election(i.e. process pursuing maximum priority)

Finally, winner sends a message to other processes announcing itself as the new coordinator.

