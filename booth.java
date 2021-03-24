import java.util.Scanner;

public class a {
    static int n,sc;
    static String qr,br,ac;
    static String pad(String k)
    {
        String s="";
        for(int i=0;i<n-k.length();i++)
        s+="0";
        return s+k;
    }

    static String add(String p,String d)
    {
        int i=n-1;
        int c=0;
        int s,a,b;
        while(i>=0)
        {
            a=Character.getNumericValue(p.charAt(i));
            b=Character.getNumericValue(d.charAt(i));
            s=(a^b)^c;
            c=a&b|c&(a^b);
            d=d.substring(0,i)+s+d.substring(i+1);
            i-=1;
        }
        return d;
    }
    static void mul()
    {
        System.out.printf("%20s %10s %10s %10s %5s\n","Comment","AC","QR","Q(n+1)","SC");
        char q1='0';
        System.out.printf("%20s %10s %10s %10s %5s\n","",ac,qr,q1,sc);
        while(sc>0)
        {
            //condition for 10 we will subtract
            if(qr.charAt(n-1)=='1' && q1=='0')
            {
               String s="";
               for(int i=0;i<n;i++)
               s=s+(br.charAt(i)=='0'?"1":"0");//finding complement
               s=add(pad("1"),s);//2's complement
               System.out.printf("%20s %10s\n","AC+BR'+1",s);
               ac=add(ac,s);
               System.out.printf("%20s %10s\n","",ac);
            }
            else if(qr.charAt(n-1)=='0' && q1=='1')
            { 
               System.out.printf("%20s %10s\n","AC+BR",br);
               ac=add(ac,br);
               System.out.printf("%20s %10s\n","",ac);
            }
            q1=qr.charAt(n-1);
            qr=ac.charAt(n-1)+qr.substring(0,n-1);
            ac=ac.charAt(0)+ac.substring(0,n-1);
            System.out.printf("%20s %10s %10s %10s %5s\n","SHIFT",ac,qr,q1,--sc);
        }

    }

    public static void main(String[] args)  {
        Scanner s=new Scanner(System.in);
        System.out.print("\nEnter the Number of bits: ");
        n=s.nextInt();
        System.out.print("Enter the Multiplier: ");
        qr=pad(s.next());
        System.out.print("\nEnter the Multiplicand: ");
        br=pad(s.next());
        ac=pad("");
        sc=n;
        mul();
    }
}
