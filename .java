import java.util.Scanner;
import java.math.BigInteger;

public class ArmstrongNumber {
    private static boolean isArmstrong(BigInteger n) {
        String s = n.abs().toString();
        int k = s.length();
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            sum = sum.add(BigInteger.valueOf(d).pow(k));
        }
        return sum.equals(n.abs());
    }

    private static void runCheck(String val) {
        BigInteger x = new BigInteger(val);
        if (isArmstrong(x)) {
            System.out.println(x + " is an Armstrong number.");
        } else {
            System.out.println(x + " is not an Armstrong number.");
        }
    }

    private static void runRange(String a, String b) {
        BigInteger start = new BigInteger(a);
        BigInteger end = new BigInteger(b);
        if (start.compareTo(end) > 0) {
            BigInteger t = start; start = end; end = t;
        }
        long t0 = System.nanoTime();
        int count = 0;
        for (BigInteger x = start; x.compareTo(end) <= 0; x = x.add(BigInteger.ONE)) {
            if (isArmstrong(x)) {
                System.out.println(x);
                count++;
            }
        }
        long t1 = System.nanoTime();
        double secs = (t1 - t0) / 1e9;
        System.out.println("Found: " + count + " in " + String.format("%.3f", secs) + "s");
    }

    public static void main(String[] args) {
        if (args.length == 2 && args[0].equalsIgnoreCase("--check")) {
            runCheck(args[1]);
            return;
        }
        if (args.length == 3 && args[0].equalsIgnoreCase("--range")) {
            runRange(args[1], args[2]);
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Number:");
        String val = sc.nextLine().trim();
        runCheck(val);
    }
}
