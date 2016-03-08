import java.util.Scanner;

class LoadBalancer{
    static void printLoad(int servers, int Processes){
        int each=Processes/servers;
        int extra=Processes%servers;
        int total=0;
        for(int i=0;i<servers;i++){
            if(extra-->0){
                total=each+1;
            } else {
                total=each;
            }
            System.out.println("Server "+(char)('A'+i)+" has "+total+" Processes");
        }
    }
    
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the number of Servers and Processes : ");
        int servers=input.nextInt();
        int Processors=input.nextInt();
        while(true){
            printLoad(servers, Processors);
            System.out.println(" 1.Add Servers \n 2.Remove Servers \n 3.Add Processes \n 4.Remove Processes \n 5. Exit");
            switch(input.nextInt()){
                case 1:
                    System.out.print("How many more servers : ");
                    servers+=input.nextInt();
                    break;
                case 2:
                    System.out.println("How many servers to be remove : ");
                    servers-=input.nextInt();
                    break;
                case 3:
                    System.out.println("HOw many more Processors : ");
                    Processors+=input.nextInt();
                    break;
                case 4:
                    System.out.println("How many Processors to be remove : ");
                    Processors-=input.nextInt();
                    break;
                case 5:
                    return;
            }
        }
    }
}