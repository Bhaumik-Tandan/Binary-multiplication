import java.util.Scanner;

public class booth {
    
    static String pad(String qr,int br)
    {
        String s="";
        for(int i=0;i<br-qr.length();i++)
        s+="0";
        return s+qr;
    }

    static String add(String p,String d)
    {
        int l=p.length()>p.length()?p.length():d.length();
        p=pad(p,l);
        d=pad(d,l);
        int c=0;
        l-=1;
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
        int sc=qr.length();
        String ac=pad("0",sc>br.length()?sc:br.length());
        char q1='0';
        int p=sc;
        System.out.printf("%20s %10s %10s %10s %5s\n","",ac,qr,q1,sc);
        while(sc>0)
        {
            //condition for 10 we will subtract
            if(q1=='0' && qr.charAt(p-1)=='1')
            {
                
               String s="";
               for(int i=0;i<br.length();i++)
               s=s+(br.charAt(i)=='0'?"1":"0");//finding complement
               s=add("1",s);//2's complement
               System.out.printf("%20s %10s\n","AC+BR'+1",s);
               ac=add(ac,s);
               System.out.printf("%20s %10s\n","",ac);
            }
            else if(q1=='1' && qr.charAt(p-1)=='0')
            {
                System.out.printf("%20s %10s\n","AC+BR",br);
               String s="";
               ac=add(ac,br);
               System.out.printf("%20s %10s\n","",ac);
            }
            q1=qr.charAt(p-1);
            qr=ac.charAt(ac.length()-1)+qr.substring(0,p-1);
            ac=ac.charAt(0)+ac.substring(0,ac.length()-1);
            System.out.printf("%20s %10s %10s %10s %5s\n","SHIFT",ac,qr,q1,--sc);
        }

    }

    public static void main(String[] args)  {
      /*  Scanner s=new Scanner(System.in);
        System.out.print("Enter the Multiplier: ");
        String mp=s.next();
        System.out.print("\nEnter the Multiplicand: ");
        String md=s.next();*/
        String qr="10011",br="10111";
        mul(qr,br);
    }
}
