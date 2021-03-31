public class a {
    static int n;

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
        return c + d;
    }

    public static void main(String[] args) {
        String ds = "10001", dd = "111000000";
        String a, q, b;
        n = ds.length();
        q = dd.substring(dd.length() - n);
        a = pad(dd.substring(0, dd.length() - n));
        b = ds;
        int sc = n;
        System.out.printf("%20s %10s %10s %10s %5s\n", "Comment", "E", "A", "Q", "SC");
        System.out.printf("%20s %10s %10s %10s %5s\n", "", "", a, q, Integer.toBinaryString(sc));
        while (sc > 0) {
            char e = a.charAt(0);
            a = a.substring(1, n) + q.charAt(0);
            q = q.substring(1, n) + "0";
            System.out.printf("%20s %10s %10s %10s\n", "Shl EAQ", e, a, q);
            String s = "";
            for (int i = 0; i < n; i++)
                s = s + (b.charAt(i) == '0' ? "1" : "0");
            s = add(pad("1"), s).substring(1);
            a = add(a, s);
            System.out.printf("%20s %10s %10s\n", "ADD B'+1", "", s);
            if (e == '0')
                e = a.charAt(0);
            a = a.substring(1);
            if (e == '1') {
                q = q.substring(0, n - 1) + "1";
                System.out.printf("%20s %10s %10s\n", "E = 1", "1", a);
                System.out.printf("%20s %10s %10s %10s %5s\n\n", "SET Qn = 1", "1", a, q, Integer.toBinaryString(--sc));
            } else {
                System.out.printf("%20s %10s %10s %10s\n", "E=0,leave Qn=0", "1", a, q);
                System.out.printf("%20s %10s %10s\n", "ADD B", "", b);
                a = add(a, b);
                e = a.charAt(0);
                a = a.substring(1);
                System.out.printf("%20s %10s %10s %10s %5s\n\n", "Restore remainder", e, a, "",
                        Integer.toBinaryString(--sc));
            }
        }
        System.out.printf("%20s\n%20s %10s %10s\n", "Neglect E", "Remainder in A", "", a);
        System.out.printf("%20s %10s %10s %10s", "Qoutient in Q", "", "", q);
    }
}