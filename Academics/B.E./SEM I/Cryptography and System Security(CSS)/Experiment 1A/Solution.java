/**
* Created with ComputerEngineeringLabs.
* User: mohan08p
* Date: 2016-10-08
* Time: 08:52 PM
* To change this template use Tools | Templates.
 */
import java.io.*; 

class Solution 
{
     public static void main(String[] args) throws Exception
     { 
          int choice=0;
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
          while(choice !=3)
          {
               System.out.println("\nEnter Choice:"); 
               System.out.println("1. Substitution Cipher"); 
               System.out.println("2. Transposition Cipher"); 
               System.out.println("3. Exit"); 
               System.out.println(); 
               System.out.print("Choice: ");
               choice = Integer.parseInt(br.readLine()); 
               switch(choice)
               {
                    case 1: System.out.println("SUBSTITUTION CIPHER"); substitution();
                    break;
                    case 2: System.out.println("TRANSPOSITION CIPHER"); transposition();
                    break;
                    case 3: System.out.println("CHAL NIKAL LE"); break;
                    default: System.out.println("Wrong Choice Entered"); break;
              }
         }
     }

     public static void substitution() throws Exception
     {
          char[]og={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};               
	     char[]og1={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y',' Z'};
          char[] cp = new char[26]; 
 	     char[] cp1= new char[26]; 
          char[] ip = new char[99]; 
          char[] op ;
          char[] dop;
          char[] dop1 = new char[99]; 
          String acc="";
          String dacc = ""; 
          int key=0;
          int opkey=0; 
          int len1=0; 
          int len2=0; 
          int temp=0; 
          int pos=0;

          BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
          /*Ciphering*/

     	/*Accept The Key*/
          System.out.println("Please Enter the Key:"); 
	     key = Integer.parseInt(br.readLine());
          /*Logic for Shift Array*/ 
	     temp = 26-key; 
	     for(int i=0;i<26;i++)
	     {
               if(i<temp)
		     {
                    cp[i]=og[i+(key)];
	  	          cp1[i]=og1[i+(key)];
	          }
     		else if(i>=temp)
		     {
     			for(int j=0;j<key;j++)
     			{ 
	     			cp[i] = og[j]; 
		     		cp1[i]=og1[i]; 
			     	i++;
 		          }
  	          }
           }

	/*Accept the Plain Text*/
	System.out.println("Please Enter Plain Text:"); 
	acc = br.readLine();
	len1 = acc.length();
	ip = acc.toCharArray(); 
	op = new char[len1]; 
	pos=0;
	/*Logic for Ciphering*/
	for(int j=0; j<ip.length;j++)
	{
		for(int i=0;i<og.length;i++)
		{
			if(ip[j] == og[i] || ip[j] == og1[i])
			{ 
				pos = i;
				if(ip[j] == og[i])
					op[j] = cp[pos];
				else
					op[j] = cp1[pos];
			}
		}
	}
	/*Output Cipher Text */
	System.out.print("The Cipher Text is:"); 
	for(int i=0;i<op.length;i++)
	{
		System.out.print(op[i]);
	}
	System.out.println("");
	/*Deciphering*/ /*Accept the Key */
	System.out.println("Enter The Key:");
	opkey = Integer.parseInt(br.readLine()); /*Accept the Ciper Text*/
	System.out.println("Enter The Cipher Text:"); 
	dacc= br.readLine();
	len2 = dacc.length(); 
	dop = new char[len2];
	dop = dacc.toCharArray(); 
	System.out.println(); 
	String tt= new String(dop); 
	String t1 = new String(op);
	/*Compare ciper input to origanl input*/ 
	boolean t = true;
	for(int i=0; i<dop.length;i++)
	{ 
		if(dop[i] != op[i])
		{
			t=false;
			continue;
		}
		else break;
	}
	/*Deciphering Logic*/ 
	if(opkey == key && t)
	{
		for(int j=0; j<dop.length;j++)
		{ 
			for(int i=0;i<cp.length;i++)
			{
				if(dop[j] == cp[i] || dop[j] == cp1[i])
				{ 
					pos = i;
					if(dop[j] == cp[i]) 
						dop1[j] = og[pos];
					else
						dop1[j] = og1[pos];
				}
			}
		}
		/*Print The Output*/
		System.out.print("The Cipher Text is:"); 
		for(int i=0;i<dop.length;i++)
		{
			System.out.print(dop1[i]);
		}
	}else 
	{
		System.out.println("INVALID KEY OR CIPHER !");
	}
   System.out.println();
   }

  public static void transposition() throws Exception
  { 
	char[] ip;
	char[][] trans;
	char[] op; 
	char[] cip; 
	char[][] ctrans; 
	char[] cop; 
	String acc=""; 
	String opacc=""; 
	int iplen=0;
	int row=0; int rem=0; int x=0;
	int count=0; int oplen=0; int coplen=0;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Please Enter Plain Text:"); acc = br.readLine();
	iplen = acc.length(); 
	ip = new char[iplen];
	ip = acc.toCharArray(); /*Logic for Rows and Column */
	rem = iplen%4; //row = (int) iplen/4; 
	if(rem == 0)
		row = (int) iplen/4;
	else
		row = (int) (iplen/4) + 1; /*Logic For White space between input */
	for(int i=0;i<iplen;i++)
	{	 if(ip[i] == ' ')
	       	 {
		 	ip[i] = '$';
		 }
	}
	System.out.println(); 
	trans = new char[row][4];
	/*Building Matrix */
	for(int i=0;i<row;i++)
	{	for(int j=0;j<4;j++)
		{
			if(x==iplen)
				break; 
			trans[i][j] = ip[x]; 
			x++;
		}
	}
	/*Logic for white spaces in the End of matrix */ 
	if(rem == 1)
	{
		trans[row-1][1] = '$'; 
		trans[row-1][2] = '$'; 
		trans[row-1][3] = '$';
	}
	if(rem == 2)
	{ 
		trans[row-1][2] = '$'; 
		trans[row-1][3] = '$';
	}
	if(rem == 3)
	{ 
		trans[row-1][3] = '$';
	}
	/*Print Matrix*/
	for(int i=0;i<row;i++)
	{ 	for(int j=0;j<4;j++)
		{
			System.out.print(trans[i][j]+ " ");
		}
		System.out.println();
	}
	System.out.println();
	/*Convert Into Single Dimensional Output (Transpose) */ 
	oplen = row*4;
	op = new char[oplen]; 
	x=0;
	for(int i=0;i<4;i++)
	{
		for(int j=0;j<row;j++)
		{ 
			if(x==oplen)
				break; 
			op[x] = trans[j][i]; 
			x++;
		}
	}
	/*Output Cipher Text */
	/*Add this part to comment if working without spaces*/ 
	int[] aray = new int[25];
	for(int i=0;i<25;i++) 
		aray[i] = (i*4)-1;
	x=0;
	boolean flag = false; 
	System.out.print("The Cipher Text Is: "); 
	for(int i=0;i<oplen;i++)
	{
		for(int j=0;j<aray.length;j++)
		{ 
			if(aray[j] == i)
			{
				System.out.print(op[i]+ " "); 
				flag = true;
				break;
			}
		}
		if(flag== false)
		{ 
			System.out.print(op[i]);

		}
		flag= false;
	}
	/* Add this part to comment if working with spaces * /*System.out.print("The Cipher Text Is: "); for(int i=0;i<oplen;i++)
	System.out.print(op[i]);
	System.out.println();*/
	/*Deciphering*/
	/*Accept the Cipher Text*/ 
	System.out.println();
	System.out.println("Please Enter The Cipher Text:"); 
	opacc = br.readLine();
	coplen = opacc.length(); 
	cip = new char[coplen];
	/*Add comment if working with spaces*/ //cip = opacc.toCharArray();
	/* For White spaces in Cipher input*/
	/*Add comments here if working without spaces*/ 
	opacc = opacc.replaceAll("\\s+",""); 
	cip=opacc.toCharArray();
	/*Decipher Matrix*/ 
	x=0;
	ctrans = new char[row][4]; 
	for(int i=0;i<4;i++)
	{
		for(int j=0;j<row;j++)
		{ 
			if(x==coplen)
				break; 
			ctrans[j][i] = cip[x]; 
			x++;
		}
	}
	/*Print Matrix Of Cipher Text*/ 
	for(int i=0;i<row;i++)
	{
		for(int j=0;j<4;j++)
		{
			 System.out.print(ctrans[i][j]+ " ");
		}
		System.out.println();
	}
	System.out.println();
	/*Converting Into Single Dimension Input*/ 
	x=0;
	cop = new char[coplen];
	for(int i=0;i<row;i++)
	{ 	for(int j=0;j<4;j++)
		{
			if(x==coplen)
				break; cop[x] = 
			ctrans[i][j]; 
			x++;
		}
	}
	/*Removing White Spaces From the Text*/ 
	for(int i=0;i<coplen;i++)
	{
		if(cop[i] == '$')
		{ 
			cop[i] = ' ';
		}
	}
	/*Printing The Original Text*/ 
	System.out.print("Original Text: "); 
	for(int i=0;i<coplen;i++)
	{
		System.out.print(cop[i]);
	}	
   System.out.println();	
   }

}