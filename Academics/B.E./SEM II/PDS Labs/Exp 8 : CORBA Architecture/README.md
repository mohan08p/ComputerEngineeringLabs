CORBA Architecture

To make a client server application where communication is achieved through the CORBA middleware.

To understand the impoertance of CORBA that integrates new components with legacy.

The Java IDL Development Process and the Hello World Application

1. Define the remote interface 

2. Compile the remote interface 

3. Implement the server 

4. Implement the client 

5. Start the applications 

1st and 2nd step is explained into Hello directory. Follow those steps and then go for further steps.

3. Implement the Server
    - Creating HelloServer.java
    - Understanding HelloServer.java
    - Compiling the Hello World Server
          Compile it using the following command
         
          javac HelloServer.java HelloApp/*.java
         
4. Implement the client
    - Creating HelloClient.java
    - Understanding HelloClient.java
    - Compiling HelloClient.java
          
          javac HelloClient.java HelloApp/*.java
    
5. Start the applications(To run this client-server application on your development machine):

     1.Start orbd.

          To start orbd from a Solaris, Linux, or Mac OS X command shell, enter:

               orbd -ORBInitialPort 1050 -ORBInitialHost localhost&

          From an MS-DOS system prompt (Windows), enter:

               start orbd -ORBInitialPort 1050 -ORBInitialHost localhost

     2. Start the Hello server.

          To start the Hello server from a Solaris, Linux, or Mac OS X command shell, enter:

               java HelloServer -ORBInitialPort 1050 -ORBInitialHost localhost&

          From an MS-DOS system prompt (Windows), enter:

               start java HelloServer -ORBInitialPort 1050 -ORBInitialHost localhost
               
     3. Run the client application:

               java HelloClient -ORBInitialPort 1050 -ORBInitialHost localhost

     4. The client prints the string from the server to the command line:

               Hello world!!
