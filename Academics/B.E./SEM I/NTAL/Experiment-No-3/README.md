**Aim :** Download and install nmap. Use it with different options to scan open ports, perform OS​ ​fingerprinting, do a ping scan, tcp port scan, udp port scan, etc.  

**Objective :** Objective of this module to learn nmap installation & use this to scan different ports.  

**Scope :** Used for ip spoofing and port scanning  Technology​: Networking  

**Theory:**

Nmap(Network Mapper) is a security scanner originally written by Gordon Lyon(also known by his pseudonym Fyodor Vaskovich) used to discover hosts and services on a computer network, thus creating a "map" of the network. To accomplish its goal, Nmap sends specially crafted packets to the target host and then analyzes the responses. Unlike many simple port scanners that just send packets at some predefined constant rate, Nmap accounts for the network conditions (latency fluctuations, network congestion, the target interference with the scan) during the run. Also, owing to the large and active user community providing feedback and contributing to its features, Nmap has been able to extend its discovery capabilities beyond simply figuring out whether a host is up or down and which ports are open and closed; it can determine the operating system of the target, names and versions of the listening services, estimated uptime, type of device, and presence of a firewall.

*Nmap features include:*

    Host Discovery – Identifying hosts on a network. For example, listing the hosts which respond to pings or have a particular port open.
    Port Scanning – Enumerating the open ports on one or more target hosts.  
    Version Detection – Interrogating listening network services listening on remote devices to determine the application name and version number.  
    OS Detection – Remotely determining the operating system and some hardware characteristics of network devices. 
    
    
Basic commands working in Nmap  

For target specifications: 

        nmap target‘s URL or IP with spaces between them

For OS detection: 

        nmap -O target-host's URL or IP

For version detection: 

        nmap -sV target-host's URL or IP
        
