import java.util.Scanner; 
import java.math.BigInteger; 

class RSA 
{
     static Scanner sc = new Scanner(System.in); 
     static double ee;
     static int p,q,fieN,e,N,x,temp,coprime; 
     static int privatekey,publickey;
     static int q1,r1,r2,r,t1=0,t2=1,t,l=0,var, pt; 
     static boolean flag = false;
     static int[] ct; 
     static BigInteger gg; 
     static char[] ctai;
     static String cipherT,reciveT,decipherT; 
     static int[] rt,dt;
     static char[] rts,rti;

     public static void main(String[] args)
     { 
          p=11;
          q=17;
          N = p*q;
          fieN = (p-1)*(q-1);
          ee = Math.random()*1000+55; 
          e = (int) ee;
          /*Co Prime Array Logic*/ 
          int co[] = new int[fieN];
          for(int i=1,j=0;i<fieN;i++)
          { 
               if(GCD(i,fieN)==1)
               { 
                    co[j++]=i;
               }
          }
          /*Limiter For Array */ 
          for(int i =0;i<fieN;i++)
          {
               if(co[i] == 0)
               {
                    temp=i; 
                    var = i; 
                    break;
               }
          }
          /*Array for Co Prime*/
          int[] cp = new int[temp]; 
          for(int i=0;i<temp;i++) 
               cp[i] = co[i];
          System.out.println("P :"+p);
          System.out.println("Q :"+q);
          System.out.println("N :"+N); 
          System.out.println("Fie(n)" + fieN); l=0;
          coprime = cp[var-7]; 
          publickey = coprime; 
          publickey = 7;
          System.out.println("Public Key is:" + publickey); 
          privatekey = inverse(publickey,fieN);
          privatekey = pri(publickey,fieN); //privatekey = 3;
          System.out.println("Private Key is:" + privatekey); 
          if(flag)
               System.out.println("Private Key is:" +privatekey);
          System.out.println("Please Enter The Plaint Text: ");
          //pt = sc.nextInt();
          String pts = sc.nextLine(); 
          System.out.println();
          ct = new int[pts.length()]; /*Convert Input To Charater Array*/
          char[] ptsn = new char[pts.length()]; 
          ptsn = pts.toCharArray();
          /*Convert Character Array to Integer Array*/ 
          int[] cta = new int[pts.length()]; 
          for(int i=0;i<pts.length();i++)
               cta[i] = (int) ptsn[i]; /*Encryption into Integer Array*/
          for(int i=0;i<pts.length();i++) 
               ct[i] = encrypt(ptsn[i]);
          /* for(int i=0;i<pts.length();i++) System.out.print(ct[i] + " "); */
          System.out.println();
          ctai = new char[ct.length];
          /*Converting Integer Array into Character Array*/
          for(int i=0;i<ct.length;i++) 
               ctai[i] = (char) ct[i];
          //System.out.print("Cipher Text is:"); for(int i=0;i<pts.length();i++)
          System.out.print(" " +ctai[i]); 
          System.out.println();
          /*Convert into String*/
          cipherT = new String(ctai); 
          System.out.println("Cipher Text is: " + cipherT);
          /*Deciphering*/
          /*Accept The Cipher Text*/
          System.out.print("Please Enter Cipher Text: "); 
          reciveT = sc.nextLine();
          /*Convert Into Charater Array*/
          rt = new int[reciveT.length()]; //rt = sc.nextInt();
          rts = new char[reciveT.length()]; 
          rts = reciveT.toCharArray();
          /*Convert TO Integer Array*/ 
          for(int i=0;i<rts.length;i++)
               rt[i] = (int) rts[i];
          dt = new int[reciveT.length()]; /*Decryption Logic*/
          for(int i=0;i<reciveT.length();i++) 
               dt[i] = decrypt(rt[i]);
          //System.out.print("Decrypted Text:"); /*Conert To Character Array*/
          rti = new char[dt.length]; 
          for(int i=0;i<dt.length;i++)
               rti[i] = (char) dt[i];
          /*for(int i=0;i<reciveT.length();i++)     
               System.out.print(" "+rti[i]); 
          for(int i=0;i<reciveT.length();i++) 
               System.out.print(" "+dt[i]);*/

          /*Deciphering Output*/
          decipherT = new String(rti); System.out.println("Decipherd Text is:" +decipherT);
     }
     /*Function To Find GCD*/
     public static int GCD(int a, int b) 
     { 
          if (b==0)
               return a; 
          return GCD(b,a%b);
     }
     /*Function To Find Multiplicative Inverse*/ 
     public static int inverse(int r1, int r2)
     {
          int x1 = r2;
          /*To Find Multiplicative Inverse*/ 
          while(r1 >= 1)
          {
               q1 =(int)r1/r2; 
               r = r1%r2;
               t = t1-(t2*q1);
               r1 = r2;
               r2 = r;
               t1 = t2;
               t2 = t;
               if(t2==x1) 
                    flag = true; 
               else
                    flag = false; 
               if(r==0 || t2 == x1)
               {
                    //flag = true; 
                    break;
               }
               /*else
                    flag = false;*/
          }
          if(t1<0)
          {
               t1 = t1+x1;
          }
          return t1;
     }
     /*Function To Encrypt*/
     public static int encrypt(int pt)
     { 
          BigInteger c;
          Integer te = new Integer(pt);
          BigInteger a = BigInteger.valueOf(te.intValue()); 
          te = new Integer(publickey);
          BigInteger b = BigInteger.valueOf(te.intValue()); 
          te = new Integer(N);
          BigInteger d = BigInteger.valueOf(te.intValue()); 
          c = a.modPow(b,d);
          int tt = c.intValue(); 
          return tt;
     }
     /*Function To Decrypt*/
     public static int decrypt(int rt)
     { 
          BigInteger c;
          Integer te = new Integer(rt);
          BigInteger a = BigInteger.valueOf(te.intValue()); 
          te = new Integer(privatekey);
          BigInteger b = BigInteger.valueOf(te.intValue());
          te = new Integer(N);
          BigInteger d = BigInteger.valueOf(te.intValue()); 
          c = a.modPow(b,d);
          int tt = c.intValue(); 
          return tt;
     }
     /*pri function*/
     public static int pri(int publickey, int fieN)
     { 
          int i=2;
          while((i*publickey)%fieN !=1) 
               i++;
          return i;
     }

}