import java.math.BigInteger;
import java.util.Scanner;

public class ArmstrongNumberBigOptimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        String input = sc.nextLine(); // Read as String for huge numbers
        BigInteger num = new BigInteger(input);
        BigInteger temp = new BigInteger(input);
        BigInteger arm = BigInteger.ZERO;

        int digits = input.length(); // Number of digits

        // Calculate sum of each digit raised to the power of 'digits'
        for (char c : input.toCharArray()) {
            int digit = Character.getNumericValue(c);
            arm = arm.add(powerBig(digit, digits));
        }

        // Check if Armstrong
        if (arm.equals(temp)) {
            System.out.println(temp + " is an Armstrong Number");
        } else {
            System.out.println(temp + " is not an Armstrong Number");
        }

        sc.close();
    }

    // Optimized BigInteger power using exponentiation by squaring
    public static BigInteger powerBig(int base, int exp) {
        BigInteger result = BigInteger.ONE;
        BigInteger b = BigInteger.valueOf(base);

        while (exp > 0) {
            if (exp % 2 == 1) { // If exponent is odd
                result = result.multiply(b);
            }
            b = b.multiply(b); // Square the base
            exp /= 2;
        }

        return result;
    }
}
