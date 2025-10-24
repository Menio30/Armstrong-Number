import java.util.Scanner; // Import Scanner class to take input from the user

public class Armstrongnumber
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); // Create Scanner object for user input
        int arm = 0, temp; // 'arm' stores the sum of cubes of digits, 'temp' stores the original number

        System.out.println("Enter a Number:"); // Prompt user to enter a number
        int num = sc.nextInt(); // Read the input number from the user

        temp = num; // Store the original number for later comparison

        // Calculate the sum of cubes of each digit
        while(num > 0)
        {
            int rem = num % 10;          // Extract the last digit
            arm = rem * rem * rem + arm; // Add the cube of the digit to 'arm'
            num = num / 10;              // Remove the last digit from 'num'
        }

        // Check if the original number equals the sum of cubes of its digits
        if(temp == arm)
        {
            System.out.println(temp + " is an Armstrong Number"); // True if equal
        }
        else
        {
            System.out.println(temp + " is not an Armstrong Number"); // Otherwise, false
        }
    }
}
