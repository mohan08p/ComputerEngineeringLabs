**Aim:** Study the use of network reconnaissance tools like WHOIS, dig, traceroute, nslookup to gather information about networks and domain registers.  

**Theory:**  

**1. Whois** - whois searches for an object in a WHOIS database. WHOIS is a query and response protocol that is widely used for querying databases that store the registered users of an  Internet resource, such as a domain name or an IP HYPERLINK "http://www.computerhope.com/jargon/a/address.htm" address block, but is also used for a wider range of other information. Most modern versions of whois try to guess the right server to ask for the specified object. If no guess can be made, whois will connect to whois.networksolutions.com for NIC handles or whois.arin.net for IPv4 addresses and network names.     
Examples:  Obtaining the domain WHOIS record for computersolutions.com  
  
 WHOIS record by IP querying   

**2. Dig** - Dig is a networking tool that can query DNS servers for information. It can be very helpful for diagnosing problems with domain pointing and is a good way to verify that yourconfigurationbis working.  
The most basic way to use dig is to specify the domain we wish to query:  
    
    dig example.com  

    dig duckduckgo.com  
    ; <<>> DiG 9.8.1-P1 <<>> duckduckgo.co m ;; global options: +cmd  
     %1 Got answer:   
    %1 ->>HEADER<<- opcode: QUERY, status: NOERROR, id:      64399   
    %1 flags: qr rd ra; QUERY: 1, ANSWER: 4, AUTHORITY: 0,          ADDITIONAL: 0   
    %1 QUESTION SECTION:   
    ;duckduckgo.com. IN A  
    ;; ANSWER SECTION: 

    duckduckgo.com. 99 I N 
    A 107.21.1.61 
    duckduckgo.com. 99 I N 
    A 184.72.106.2 53 
    duckduckgo.com. 99 I N 
    A 184.72.106.5 2 
    duckduckgo.com. 99 I N 
    A 184.72.115.8 6  
    %1 Query time: 33 msec   
    %1 SERVER: 8.8.8.8#53(8.8.8.8)   
    %1 WHEN: Fri Aug 23 14:26:17 2013   
    %1 MSG SIZE  rcvd: 96   
    The lines above act as a header for the query performed. It is possible to run dig in batch mode, so proper labeling of the output is essential to allow for correct analysis.  
    %1 Got answer:   
    %1 ->>HEADER<<- opcode: QUERY, status: NOERROR, id:      64399   
    %1 flags: qr rd ra; QUERY: 1, ANSWER: 4, AUTHORITY: 0,          ADDITIONAL: 0   

    The next section gives us a technical summary of our query results. We can see that the query was successful, certain flags were used, and that 4 "answers" were received.  
    ;; QUESTION SECTION:  
    ;duckduckgo.com. IN A  
    ;; ANSWER SECTION: 

    duckduckgo.com. 99 I N 
    A 107.21.1.61 
    duckduckgo.com. 99 I N 
    A 184.72.106.2 53 
    duckduckgo.com. 99 I N 
    A 184.72.106.5 2 
    duckduckgo.com. 99 I N 
    A 184.72.115.8 6  
    The above section of the output contains the actual results we were looking for. It restates the query and then returns the matching DNS records for that domain name.  
    Here, we can see that there are four "A" records for "duckduckgo.com". By default, "A" records are returned. This gives us the IP addresses that the domain name resolves to.  
     The "99" is the TTL (time to live) before the DNS server rechecks the association between the domain name and the IP address. The "IN" means the class of the record is a standard internet class.  
    %1 Query time: 33 msec   
    %1 SERVER: 8.8.8.8#53(8.8.8.8)   
    %1 WHEN: Fri Aug 23 14:26:17 2013   
    %1 MSG SIZE  rcvd: 96   
    These lines simply provide some statistics about the actual query results. The query time can be indicative of problems with the DNS servers.    

**3. Traceroute** - traceroute prints the route that packets take to a network host. Traceroute utility uses the TTL field in the IP header to achieve its operation. For users who are new to TTL field, this field describes how much hops a particular packet will take while traveling on network. So, this effectively outlines the lifetime of the packet on network. This field is usually set to 32 or 64. Each time the packet is held on an intermediate router, it decreases the TTL value by 1. When a router finds the TTL value of 1 in a received packet then that packet is not forwarded but instead discarded. After discarding the packet, router sends an ICMP error message of Time exceeded back to the source from where packet generated. The ICMP packet that is sent back contains the IP address of the router. So now it can be easily understood that traceroute operates by  sending packets with TTL value starting from 1 and then incrementing by one each time. Each time a router receives the packet, it checks the TTL field, if TTL field is 1 then it discardsthe packet and sends the ICMP error packet containing its IP address and this is what traceroute requires. So traceroute incrementally fetches the IP of all the routers between the source and the destination.  
    
    Example: traceroute example.com 
     traceroute to example.com (64.13.192.208), 64 hops max, 40 byte packets  
    1 72.10.62.1 (72.10.62.1) 1.000 ms 0.739 ms 0.702 ms  
    2 10.101.248.1 (10.101.248.1) 0.683 ms 0.385 ms 0.315 ms  
    3 10.104.65.161 (10.104.65.161) 0.791 ms 0.703 ms 0.686 ms  
    4 10.104.65.161 (10.104.65.161) 0.791 ms 0.703 ms 0.686 ms  
    5 10.0.10.33 (10.0.10.33) 2.652 ms 2.260 ms 5.353 ms  
    6 acmkokeaig.gs01.gridserver.com (64.13.192.208) 3.384 ms 8.001 ms 2.439 ms    

**4.Nslookup** - The nslookup command is used to query internet name servers interactively for information. nslookup, which stands for "name server lookup", is a useful tool for finding out information about a named domain. By default, nslookup will  translate a domain name to an IP address (or vice versa). For instance, to find out what the IP address of microsoft.com is, you  could run the command:  
    
    nslookup microsoft.com  
    Server: 8.8.8.8  
    Address: 8.8.8.8#53  
    Non-authoritative answer:  
    Name:  
    microsoft.com  
    Address: 134.170.185.46  
    Name:  
    microsoft.com  
    Address: 134.170.188.221  
    Here, 8.8.8.8 is the address of our system's Domain Name Server.     
    
    This is the server our system is configured to use to translate domain names into IP addresses. "#53" indicates that we are communicating with it on port 53, which is the standard port number domain name servers use to accept queries. Below this, we have our lookup information for microsoft.com. Our name server returned two entries, 134.170.185.46 and 134.170.188.221. This indicates that microsoft.com uses a round robin setup to distribute server load.   When you access micrsoft.com, you may be directed to either of these servers and your packets will be routed to the correct destination. You can see that we have received a "Non-authoritative answer" to our query. Ananswer is "authoritative" only if our DNS has the complete zone file information for the domain in question. More often, our DNS will have a cache of information representing the last authoritative answer it received when it made a similar query, this information is passed on to you, but the server qualifies it as "non-authoritative": the information was recently received from an authoritative source, but the DNS server is not itself that authority. 
