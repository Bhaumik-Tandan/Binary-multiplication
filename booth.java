import java.util.Scanner;

public class a {
    // global variables
    static int n, sc, p = 1, b = 0, q = 0;
    static String qr, br, ac;

    static String pad(String k) {
        String s = "";
        for (int i = 0; i < n - k.length(); i++)
            s += "0";
        return s + k;
    }

    static String add(String p, String d) {
        int i = n - 1;
        int c = 0;
        int s, a, b;
        while (i >= 0) {
            a = Character.getNumericValue(p.charAt(i));
            b = Character.getNumericValue(d.charAt(i));
            s = (a ^ b) ^ c;
            c = a & b | c & (a ^ b);
            d = d.substring(0, i) + s + d.substring(i + 1);
            i -= 1;
        }
        return d;
    }

    static void mul() {
        // %20s will pad as 20 characters
        System.out.printf("%20s %10s %10s %10s %5s\n", "Comment", "AC", "QR", "Q(n+1)", "SC");
        char q1 = '0';
        System.out.printf("%20s %10s %10s %10s %5s\n", "", ac, qr, q1, sc);
        while (sc > 0) {
            // condition for 10 we will subtract
            if (qr.charAt(n - 1) == '1' && q1 == '0') {
                String s = "";
                for (int i = 0; i < n; i++)
                    s = s + (br.charAt(i) == '0' ? "1" : "0");// finding complement
                s = add(pad("1"), s);// 2's complement
                System.out.printf("%20s %10s\n", "AC+BR'+1", s);
                ac = add(ac, s);
                System.out.printf("%20s %10s\n", "", ac);
            } else if (qr.charAt(n - 1) == '0' && q1 == '1') {
                System.out.printf("%20s %10s\n", "AC+BR", br);
                ac = add(ac, br);
                System.out.printf("%20s %10s\n", "", ac);
            }
            q1 = qr.charAt(n - 1);
            qr = ac.charAt(n - 1) + qr.substring(0, n - 1);
            ac = ac.charAt(0) + ac.substring(0, n - 1);
            System.out.printf("%20s %10s %10s %10s %5s\n", "SHIFT", ac, qr, q1, --sc);
        }
        if (p == 1)
            System.out.println(
                    "\n\n\nProduct in binary: " + ac + qr + "\nProduct in decimal: " + Integer.parseInt(ac + qr, 2));
        else {
            br = ac + qr;
            n = n * 2;
            String s = "";
            for (int i = 0; i < n; i++)
                s = s + (br.charAt(i) == '0' ? "1" : "0");// finding complement
            s = add(pad("1"), s);// 2's complement
            System.out.println(

                    "\n\n\nProduct in binary(2's complement of " + ac + qr + "): " + s + "\nProduct in decimal: "
                            + Integer.parseInt(s, 2) * -1);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the input type:- \n1.Binary \n2.Decimal\n");
        int o = s.nextInt();// Takes choice for binary or decimal
        System.out.print("\nEnter the Number of bits: ");
        n = s.nextInt();// take number of bits in which we have to perform operations in
        System.out.print("Enter the Multiplier: ");
        if (o == 1) {// if we enter 1 so it will take binary input and will make it the size of n
            qr = pad(s.next());// by padding 0 before least significant bits
            System.out.print("\nEnter the Multiplicand: ");
            br = pad(s.next());
        } else {
            q = s.nextInt();
            System.out.print("Enter the Multiplicand: ");
            b = s.nextInt();
            if (b < 0) {
                p *= -1;
                br = pad(Integer.toBinaryString((-1) * b));
                String st = "";
                for (int i = 0; i < n; i++)
                    st = st + (br.charAt(i) == '0' ? "1" : "0");// finding complement
                st = add(pad("1"), st);// 2's complement
                br = st;
            } else
                br = pad(Integer.toBinaryString(b));
            if (q < 0) {
                p *= -1;
                qr = pad(Integer.toBinaryString((-1) * q));
                String st = "";
                for (int i = 0; i < n; i++)
                    st = st + (qr.charAt(i) == '0' ? "1" : "0");// finding complement
                st = add(pad("1"), st);// 2's complement
                qr = st;
            } else
                qr = pad(Integer.toBinaryString(q));
        }
        ac = pad("");
        sc = n;
        // System.out.print(br + "\n" + qr);
        mul();
    }
}
