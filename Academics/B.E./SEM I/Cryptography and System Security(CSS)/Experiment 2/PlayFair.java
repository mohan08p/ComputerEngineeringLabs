import java.util.*; 
import java.io.*;

class PlayFair
{

	public static void main(String[] args) throws Exception
	{ /*Declartations*/

		String ip; char[] ip_arr; char[] og;
		int len,x=0; char[] cp; String temp; String pt; char ch=' ';
		boolean flag= false; char op[];
		char ptc[];
		char[][] array_op = new char[5][5]; 
		Scanner sc = new Scanner(System.in); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); /*Accept Keyword*/
		System.out.println("Please Enter The Keyword:"); ip = sc.next();
		len = ip.length(); ip_arr = new char[len];
		ip_arr = ip.toCharArray(); /*Accept the Plain Text*/
		System.out.println("Please Enter The Plain Text"); 
		pt = br.readLine();
		pt = pt.replaceAll(" ", ""); 
		ptc = new char[pt.length()]; 
		ptc = pt.toCharArray();
		/*Check if the keyword has a i or a j in it*/ 
		for(int i=0;i<len;i++)
		{
			if((ip_arr[i] == 'i' || ip_arr[i] == 'j'))
			{ 
				flag = true;
			}
			else 
				flag= false;
		}
		if(flag == true)
		{ 
			ch = 't';
		}
		else
			ch = 'i';
		/*Og array for creating a cp array*/ 
		og = new char[26];
		for(int i=97;i<123;i++)
		{ 
			og[i-97] = (char)i;
		}
		/*for(int i = 0; i<26;i++) System.out.print(og[i]+" ");*/
		for(int i=0;i<len;i++)
		{ 
			for(int j=0;j<26;j++)
			{
				if(ip_arr[i] == og[j])
				{ 
					og[j] = '*';
				}	
			}
		}
		cp = new char[26];
		/*If the keyword has a i/j use t*/ 
		if(ch == 'i')
		{
			for(int i=0;i<26;i++)
			{
				if(og[i] == '*' || i == 9)
				{ 
					cp[i] = ' '; continue;
				}
				else
					cp[i] = og[i];
			}
		}
		/*Else use i/j as i*/ 
		else
		{
			for(int i=0;i<26;i++)
			{
				if(og[i] == '*' || i==20)
				{ 
					cp[i] = ' '; continue;
				}
				else
					cp[i] = og[i];
			}
		}
		/*Logic for removing the white spaces and creating a 5x5 matrix for ciphering.*/
		temp= new String(cp); 
		temp = temp.trim();
		temp = temp.replaceAll(" ", ""); 
		System.out.println();
		temp = ip+temp; //System.out.println("Length:"+temp.length()); //System.out.println(temp);
		op = new char[temp.length()]; 
		op = temp.toCharArray(); 
		x=0;
		for(int i=0;i<5;i++)
		{ 
			for(int j=0;j<5;j++)
			{
				if(x == temp.length()) 
					break;
				array_op[i][j] = op[x]; x++;
			}
		}
		System.out.println("Matrix: "); /*Print The Cipher Matrix.*/
		for(int i=0; i<5;i++)
		{ 
			for(int j=0;j<5;j++)
				System.out.print(array_op[i][j]+ " "); 
			System.out.println();
		}
		/*Divide the Input into blocks of 2.*/ 
		int l=0;
		l= pt.length();
		for(int i=0;i<l-2;i++)
		{
			String t1;
			String t2;
			if(pt.charAt(i) == pt.charAt(i+1))
			{ 
				t1 = pt.substring(0,i+1);
				t2 = pt.substring(i+1,l); 
				pt = t1+ "x" + t2;
			}
			int t = pt.length(); 
			if(i == l-3 && t%2 == 1)
			{
				pt = pt+"x";
			}
		}
		System.out.println("Input Plain Text Taken as:"); 
		System.out.println(pt);

		/*Cipher text Logic*/ 
		int t=1;
		String cipher="";
		int x1=0,x2=0,y1=0,y2=0; 
		while(t<l+1)
		{
			char c1 = pt.charAt(t-1); 
			char c2 = pt.charAt(t); 
			for(int i=0;i<5;i++)
			{
				for(int j=0;j<5;j++)
				{ 
					if(array_op[i][j] == c1)
					{
						x1 = i;
						y1 = j;
					}
					else if(array_op[i][j] == c2)
					{
						x2 = i;
						y2 = j;
					}
				}	
			}
			if(x1 == x2)
			{
				int temp1 = y1+1; 
				int temp2 = y2+1; 
				temp1 = temp1%5; 
				temp2 = temp2%5; 
				while(temp1<0)
				{
					temp1 = temp1+5; 
					temp1 = temp1%5;
				}
				while(temp2<0)
				{
					temp2 = temp2+5; 
					temp2 = temp2%5;
				}
				cipher = cipher+ array_op[x1][temp1]; 
				cipher = cipher + array_op[x2][temp2];
			}
			else if(y1 == y2)
			{
				int temp1 = x1-1; 
				int temp2 = x2-1; 
				temp1 = temp1%5; 
				temp2 = temp2%5; 
				while(temp1<0)
				{
					temp1 = temp1+5; 
					temp1 = temp1%5;
				}
				while(temp2<0)
				{
					temp2 = temp2+5; 
					temp2 = temp2%5;
				}
				cipher = cipher+array_op[temp1][y1]; 
				cipher = cipher+array_op[temp2][y2];
			}
			else
			{
				cipher = cipher+array_op[x1][y2]; 
				cipher = cipher+array_op[x2][y1];
			}
		t=t+2;

		}

		System.out.println("Cipher Text is:"); 
		System.out.println(cipher); 
		System.out.print("\n\n\n");

		/*Receiver Side*/
		String op1=""; 
		int oplen =0; 
		char[] op_arr; 
		String oppt=""; 
		char[] opptc ; 
		char[] opog; 
		char[] opcp; 
		char ch1;
		String tempo="";
		char[][] array_op1 = new char[5][5]; /*Accept Keyword*/
		System.out.println("Please Enter The Keyword:"); op1 = sc.next();
		oplen = op1.length(); 
		op_arr = new char[oplen]; 
		op_arr = op1.toCharArray(); 
		if(op1.equals(ip))
		{ /*Accept the Cipher Text*/
			System.out.println("Please Enter The Cipher Text");
			oppt = br.readLine();
			oppt = oppt.replaceAll(" ", ""); 
			opptc = new char[pt.length()]; 
			opptc = oppt.toCharArray();
			/*Check if the keyword has a i or a j in it*/ 
			for(int i=0;i<oplen;i++)
			{
				if((op_arr[i] == 'i' || op_arr[i] =='j'))
				{
					flag = true;
				}
				else 
					flag= false;
			}
			if(flag == true)
			{ 
				ch1 = 't';
			}
			else
				ch1 = 'i';
			/*Og array for creating a opcp array*/ 
			opog = new char[26];
			for(int i=97;i<123;i++)
			{ 
				opog[i-97] = (char)i;
			}
			for(int i=0;i<oplen;i++)
			{
				for(int j=0;j<26;j++)
				{
					if(op_arr[i] == opog[j])
					{
						 opog[j] = '*';
					}
				}
			}
			opcp = new char[26];
			/*If the keyword has a i/j use t*/ 
			if(ch1 == 'i')
			{
				for(int i=0;i<26;i++)
				{
					if(opog[i] == '*' || i == 9)
					{ 
						opcp[i] = ' '; 
						continue;
					}
					else
						opcp[i] = opog[i];
				}
			}
			/*Else use i/j as i*/ 
			else
			{
				for(int i=0;i<26;i++)
				{ 
					if(opog[i] == '*' || i==20)
					{
						opcp[i] = ' '; 
						continue;
					}
					else	
						opcp[i] = opog[i];
				}
			}
			System.out.println("Matrix: "); /*Print The Cipher Matrix.*/
			for(int i=0; i<5;i++)
			{ 
				for(int j=0;j<5;j++)
					System.out.print(array_op[i][j]+ "	");
				System.out.println();
			}
			/*Divide the Input into blocks of 2.*/ 
			int l1=0;
			l1= oppt.length(); 
			for(int i=0;i<l1-2;i++)
			{
				String t1; String t2;
				if(oppt.charAt(i) == oppt.charAt(i+1))
				{
		 			t1 = oppt.substring(0,i+1);
					t2 = oppt.substring(i+1,l); 
					pt = t1+ "x" + t2;
				}
				int tz = oppt.length(); 
				if(i == l-3 && tz%2 == 1)
				{
					oppt = oppt+"x";
				}
			}
			System.out.println("Cipher Text Taken as:"); 
			System.out.println(oppt); 
			System.out.print("\n\n\n");
			/*Decipher Logic*/ 
			int tq=1;
			String decipher=""; 
			x1=0;
			x2=0;
			y1=0;
			y2=0;
			while(tq<l1+1)
			{
				char c1 = oppt.charAt(tq-1); 
				char c2 = oppt.charAt(tq); 
				for(int i=0;i<5;i++)
				{
					for(int j=0;j<5;j++)
					{ 
						if(array_op[i][j] == c1)
						{
							x1 = i;
							y1 = j;
						}
						else if(array_op[i][j] == c2)
						{ 
							x2 = i;
							y2 = j;
						}
					}
				}
			if(x1 == x2)
			{
				int temp1 = y1-1;
				int temp2 = y2-1; 
				temp1 = temp1%5; 
				temp2 = temp2%5; 
				while(temp1<0)
				{
					temp1 = temp1+5; 
					temp1 = temp1%5;
				}
				while(temp2<0)
				{
					temp2 = temp2+5; 
					temp2 = temp2%5;
				}
				decipher = decipher+
				array_op[x1][temp1];
				decipher = decipher +
				array_op[x2][temp2];
			}
			else if(y1 == y2)
			{
		 		int temp1 = x1+1; 
				int temp2 = x2+1; 
				temp1 = temp1%5; 
				temp2 = temp2%5; 
				while(temp1<0)
				{
					temp1 = temp1+5; 
					temp1 = temp1%5;
				}
				while(temp2<0)
				{
					temp2 = temp2+5; 
					temp2 = temp2%5;
				}
				decipher = decipher+array_op1[temp1][y1];
				decipher = decipher+array_op1[temp2][y2];
			}
			else
			{
				decipher = decipher+array_op[x1][y2]; 
				decipher = decipher+array_op[x2][y1];
			}
			tq=tq+2;
			}
		System.out.println("Deciphered Text is:"); 
		System.out.println(decipher);
		}
		else
		{
			System.out.println("Wrong Keyword Entered ! "); 
			System.exit(0);
		}
	}
}