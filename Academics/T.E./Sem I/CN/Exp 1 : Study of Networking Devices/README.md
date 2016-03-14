Study of networking devices i.e. repeater, hub, switch, bridge, router, gateway.

Experiment: 1
Aim: To Study different networking devices.

Objective: Students should have the knowledge about working of different devices, their configuration and other features in details so that if required they are in position to choose appropriate device for the use in given situation.

Theory: 
A computer network or data network is a telecommunication network that allows computers to exchange data. In computer networks, networked computing devices pass data to each other along data connections. The connections (network links) between nodes are established using either cable media or wireless media. Below we discuss in brief the components/devices used to establish such networks:

I. HUB
A network hub is a networking device that connects to one or more equipment. For example, a computer can connect to a server, printer and another computer through a network hub. It is useful in sharing of resources and broadcasting data it receives. It helps connects these devices together without having to connect to each other directly. There are three types of network hubs: Passive Hubs, Active Hubs and Intelligent Hubs.
i. Active Hub
An active hub works more than just a connector but also regenerates the data bits to ensure the signals are strong. Another name for an active hub is a multiport repeater. It provides an active participation in the network aside from acting as an interface. It participates in the data communication, such as storing signals received through the input ports, before forwarding them. It can monitor the data it is forwarding and sometimes help improve signals before forwarding them to other connections. Such a feature makes troubleshooting of network problems easier.
ii. Passive Hub
One of the types of a network hub is the so-called passive hub. It's a pass-through that does not do anything more than just broadcast signals it receives through its input port, then sends it out through the output port. It does not do anything to regenerate or process the signals because it only functions as a connector of different wires in a topology.

iii. Intelligent Hub
An intelligent hub can perform everything that the passive hub and active hub do, and help manage the network resources effectively to ensure that the performance of the network is highly efficient. An intelligent hub can help in troubleshooting by pinpointing the actual location of the problem and help identify the root cause and resolution. It is very adaptable to different technologies without any need to change its configuration. The intelligent hub performs different functions such as bridging, routing, and switching and network management.

II. REPEATER
As signals travel along a network cable (or any other medium of transmission), they degrade and become distorted in a process that is called attenuation. If a cable is long enough, the attenuation will finally make a signal unrecognizable by the receiver.
A Repeater enables signals to travel longer distances over a network. Repeaters work at the OSI's Physical layer. A repeater regenerates the received signals and then retransmits the regenerated (or conditioned) signals on other segments.

To pass data through the repeater in a usable fashion from one segment to the next, the packets and the Logical Link Control (LLC) protocols must be the same on the each segment. This means that a repeater will not enable communication, for example, between an 802.3 segment (Ethernet) and an 802.5 segment (Token Ring). That is, they cannot translate an Ethernet packet into a Token Ring packet. In other words, repeaters do not translate anything.

III. BRIDGES
Like a repeater, a bridge can join segments or workgroup LANs. However, a bridge can also divide a network to isolate traffic or problems. For example, if the volume of traffic from one or two computers or a single department is flooding the network with data and slowing down entire operation, a bridge can isolate those computers or that department.
In the following figure, a bridge is used to connect two Segment 1 and 
Segment 2.

Bridges can be used to:
Expand the distance of a segment.
Provide for an increased number of computers on the network.
Reduce traffic bottlenecks resulting from an excessive number of attached computers.

Bridges work at the Data Link Layer of the OSI model. Because they work at this layer, all information contained in the higher levels of the OSI model is unavailable to them. Therefore, they do not distinguish between one protocol and another. 
Bridges simply pass all protocols along the network. Because all protocols pass across the bridges, it is up to the individual computers to determine which protocols they can recognize.
A bridge works on the principle that each network node has its own address. A bridge forwards the packets based on the address of the particular destination node.As traffic passes through the bridge, information about the computer addresses is then stored in the bridge's RAM. The bridge will then use this RAM to build a routing table based on source addresses.There are two types of bridges: Transparent Bridge and Learning Bridge.
i. Transparent Bridge
Transparent bridges are devices which connects more than one network segments with other bridges to make all routingdecisions. A transparent bridge is essentially used to learn theMAC addresses of all nodes and their associated port, to filterincoming frames whose destination MAC addresses are located on the same incoming port, and to forward incoming frames to the destination MAC through their associated port number.There are two types of Transparent Bridge Modes:
Store-and-Forward: Stores the entire frame and verifies the CRCbefore forwarding the frame. If a CRC error is detected, the frame is discarded.
Cut-Through: Forwards the frame just after it reads the destination MAC address without performing a CRC check.
ii. Learning Bridge
A learning bridge has all the capabilities of a basic bridge, but it has one advantage. A learning bridge reduces (to some degree) the amount of broadcast traffic on the LANs. A learning bridge listens to all frames in the two LAN segments just as a basic bridge does and learns where each physical address is located. The learning bridge makes a list of the physical addresses and which port they are connected to. Because it stores each frame as it receives it, it then forwards frames selectively based on the LAN to which that physical address is located. Whenever the learning bridge encounters a frame containing a physical address it does not know, it forwards that frame out all other ports to the other LANs.

IV. SWITCH
Switches control the flow of network traffic based on the address information in each packet. A switch learns which devices are connected to its ports (by monitoring the packets it receives), and then forwards on packets to the appropriate port only. This allows simultaneous communication across the switch, improving bandwidth.
This switching operation reduces the amount of unnecessary traffic that would have occurred if the same information had been sent from every port (as with a hub).
Switches and hubs are often used in the same network; the hubs extend the network by providing more ports, and the switches divide the network into smaller, less congested sections.

V. ROUTER
In an environment consisting of several network segments with different protocols and architecture, a bridge may not be adequate for ensuring fast communication among all of the segments. A complex network needs a device, which not only knows the address of each segment, but also can determine the best path for sending data and filtering broadcast traffic to the local segment. Such device is called a Router.
Routers work at the Network layer of the OSI model meaning that the Routers can switch and route packets across multiple networks. They do this by exchanging protocol-specific information between separate networks.Routers have access to more information in packets than bridges, and use this information to improve packet deliveries. Routers are usually used in a complex network situation because they provide better traffic management than bridges and do not pass broadcast traffic.
Routers can share status and routing information with one another and use this information to bypass slow or malfunctioning connections.
Routers do not look at the destination node address; they only look at the network address. Routers will only pass the information if the network address is known. This ability to control the data passing through the router reduces the amount of traffic between networks and allows routers to use these links more efficiently than bridge.

VI. GATEWAY
Gateways make communication possible between different architectures and environments. They repackage and convert data going from one environment to another so that each environment can understand the other's environment data.
A gateway repackages information to match the requirements of the destination system. Gateways can change the format of a message so that it will conform to the application program at the receiving end of the transfer.
A gateway links two systems that do not use the same:
Communication protocols
Data formatting structures
Languages
Architecture
For example, electronic mail gateways, such as X.400 gateway, receive messages in one format, and then translate it, and forward in X.400 format used by the receiver, and vice versa.
To process the data, the gateway: encapsulates incoming data through the networks complete protocol stack. Encapsulates the outgoing data in the complete protocol stack of the other network to allow transmission.

References : 
     1. Data Communication and networking by Forouzan, 4th editio
     2. Computer Networks by Tanenbaum.