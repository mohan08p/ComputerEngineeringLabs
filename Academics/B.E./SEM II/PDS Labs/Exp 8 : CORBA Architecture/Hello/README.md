How to write the IDL interface and translates it into Java with following steps :
(1st and 2nd step of the Hello World Application)

    Writing Hello.idl
    Understanding the IDL file
    Mapping Hello.idl to Java
    Understanding the idlj Compiler Output

1. Writing Hello.idl

2. Understanding the IDL file     
    - Declare the CORBA IDL module
    - Declare the interface
    - Declare the operations
    
3. Mapping Hello.idl to Java
     The tool idlj reads OMG IDL files and creates the required Java files. The idlj compiler defaults to generating only the client-side bindings.

             idlj -fall Hello.idl
       
Mapping 

With an interface this simple, it is easy to see how the IDL statements map to the generated Java statements.

IDL Statement 	      	        Java Statement
module HelloApp; 	    --   	   package HelloApp;
interface Hello 	    --   	   public interface Hello

Because there are only two operations defined in this interface, it is easy to see how the IDL statements map to the generated Java statements.

IDL Statement 	      	        Java Statement
string sayHello(); 	    --       String sayHello();
oneway void shutdown(); --       void Shutdown ();

4. Understanding the idlj Compiler Output
