Exp 8 : Clock Synchronization algorithms

Program to demonstrate Berkeley Clock Synchronization algorithm 

To keep all clocks in a system synchronized with each other.

Clock synchronization deals with understanding the temporal ordering of events produced by concurrent processes. It is useful for synchronizing senders and receivers of messages, controlling joint activity, and the serializing concurrent access to shared objects. The goal is that multiple unrelated processes running on different machines should be in agreement with and be able to make consistent decisions about the ordering of events in a system.

In a Distributed System, the problem takes on more complexity because the global time is not easily known. Most of the Clock Synchronization Solutions on the internet is the Network Time Protocol(NTP) which is a layered client-server architecture based on UDP message passing. Lamport timestamps and Vector clocks are concepts of the logical clocks in a distributed system.


## Berkeley's Algorithm

The Berkeley's Algorithm, does not assume that any machine has an accurate time source with which to synchronize. Instead, it opts for obtaining an average time from participating computers and synchronizing all machines to that average.

The machine involved in the synchronization, each run a time demon process that is responsible for implementing the protocol. One of these machine is elected (or designated) as to be the master. Others are slave. The server polls each machine periodically, asking it for the time. The time at each machine may be estimated by using Cristian's Method to account for network delays. When all the results are in, the master computes the average time (including its own time in the calculation). The hope is that the average cancels out the individual clock tendencies to run fast or slow. 

Instead of sending the updated time back to the slaves, which would introduces further uncertainty due to network delays, it sends each machine the offset by which its clock needs adjustment.

e.g. Three   machines   have   times   of   3:00,   3:25,   and   2:50.   The   machine   with   the   time   of   3:00   is   the  
server   (master).   It   sends   out   a   synchronization   query   to   the   other   machines   in   the   group.   Each  
of   these   machines   sends   a   timestamp   as   a   response   to   the   query.   The   server   now   averages   the  
three timestamps: the two it received and its own, computing (3:00+3:25+2:50)/3 = 3:05. 
Now   it   sends   an   offset   to   each   machine   so   that   the   machine's   time   will   be   synchronized   to   the  
average   once   the   offset   is   applied.   The   machine   with   a   time   of   3:25   gets   sent   an   offset   of  
­0:20   and   the   machine   with   a   time   of   2:50   gets   an   offset   of   +0:15.   The   server   has   to   adjust   its  
own time by +0:05. 
