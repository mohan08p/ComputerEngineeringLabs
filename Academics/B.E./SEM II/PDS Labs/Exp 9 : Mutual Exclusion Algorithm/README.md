Exp 9 : Mutual Exclusion Algorithm

Program to demonstrate Token Ring for Distributed Mutual Exclusion Algorithm.

Mutual Exclusion :- Systems involving multiple processes are often most easily programmed using critical regions. When a process has to read or update certain shared data structures, it first enters a critical region to achieve mutual exclusion and ensures that no other process will use the shared data structures at the same time. In single processor systems, critical regions are protected using semaphores, monitors, etc.

Token Ring Algorithm

A logical ring is constructed in which each process is assigned a position in the ring, which may be allocated in numerical order of network addresses or some other means. It dose not matter what the ordering is. All that matter is each process knows who is next in line after itself.

