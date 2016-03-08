

Steps to Demonstrate RMI Application using Java

THe RMI application is composed of four programs :

    Interface program : It contains the definition of methods to be called by client and defined by the server program.

    Implementation program : It contains the definition of methods which are declared in an interface.

    Server program : It contains statement like Naming.rebind to bind the object called bt the client.

    Client program : It contains method calling and Naming.lookup method to locate the object in registry.

Step 1 : Create a new directory, named RMI, for this application, then start your favorite text editor and create a file named AddInterface.java in this directory. In your file, enter the following code which has declaration of add() method.

Step 2 : Write and compile implementation file Add.java which contains definition of method declared in interface.

Step 3 : Create stubs and skeletons using rmic command by specifying implementation class name, i.e. rmic Add.

        rmic Add

Step 4 : Create AddServer.java file and add the following code.

Step 5 : Create AddClient.java file and add the following code which contains calling of sum() method with parameter 10 and 2.

Step 6 : Start RMI registry and minimize it.

        start rmiregistry

Step 7 : Run server program and keep it running.

Step 8 : Open one more command prompt (terminal) and run client program to get the output.
