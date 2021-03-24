import java.util.Scanner;

public class a {
    static int n;
    static String pad(String qr,int br)
    {
        String s="";
        for(int i=0;i<br-qr.length();i++)
        s+="0";
        return s+qr;
    }

    static String add(String p,String d)
    {
        int l=n-1;
        int c=0;
        int a;
        while(l>=0){
            a=(Character.getNumericValue((d.charAt(l)))^(Character.getNumericValue((p.charAt(l)))))^c;
            c=(Character.getNumericValue((d.charAt(l)))&(Character.getNumericValue((p.charAt(l)))))|(c&((Character.getNumericValue((p.charAt(l)))^Character.getNumericValue((d.charAt(l))))));
            d=d.substring(0,l)+Integer.toString(a)+d.substring(l+1);
        l-=1;}
        return d;

    }
    static void mul(String qr,String br)
    {
        System.out.printf("%20s %10s %10s %10s %5s\n","Comment","AC","QR","Q(n+1)","SC");
        int sc=n;
        String ac=pad("0",n);
        char q1='0';
        System.out.printf("%20s %10s %10s %10s %5s\n","",ac,qr,q1,sc);
        while(sc>0)
        {
            //condition for 10 we will subtract
            if(q1=='0' && qr.charAt(n-1)=='1')
            {
               String s="";
               for(int i=0;i<n;i++)
               s=s+(br.charAt(i)=='0'?"1":"0");//finding complement
               s=add(pad("1",n),s);//2's complement
               System.out.printf("%20s %10s\n","AC+BR'+1",s);
               ac=add(ac,s);
               System.out.printf("%20s %10s\n","",ac);
            }
            else if(q1=='1' && qr.charAt(n-1)=='0')
            {
                System.out.printf("%20s %10s\n","AC+BR",br);
               String s="";
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
        System.out.print("Enter the Multiplier: ");
        String qr=s.next();
        System.out.print("\nEnter the Multiplicand: ");
        String br=s.next();
        System.out.print("\nEnter the Number of bits: ");
        n=s.nextInt();
        mul(pad(qr,n),pad(br,n));
    }
}
