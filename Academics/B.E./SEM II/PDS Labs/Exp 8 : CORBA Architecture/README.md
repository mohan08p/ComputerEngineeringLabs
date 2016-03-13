CORBA Architecture

To make a client server application where communication is achieved through the CORBA middleware.

To understand the impoertance of CORBA that integrates new components with legacy.

This example illustrate the basic task in building CORBA distributed application using Java IDL. The HelloWorld program has a single operation that returns a string to be printed in distributed environment.

Steps : 
1. The client invokes the satHello method of the HelloServer.
2. The ORB transfers that invocation to the servent object that registered for that IDL interface.
3. The servent's sayHello method runs, returning a java string.
4. The ORB transfers that string back to the client.
5. The client prints the value of the string.

Note : You will need idltojava compiler which uses the IDL-to-Java mapping to convert IDL interfaces definitions to corresponding interfaces, classes and methods which you can then used to implement the client and server code.

Commands to Run the CORBA Application :

1. Command to invoke the idl2java compiler
     idltojava -fno -cpp Hello.idl
   
2. Command to compile HelloClient.java and HelloServer.java
     javac -cp . *.java HelloApp\*.java
    
3. Command to run the name server on port 2000
     timeserv -ORBInitialPort 2000

4. Commad to run teh server
     java HelloServer -ORBInitialPort 2000

5. Command to run the client
     java HelloClient -ORBInitialPort 2000