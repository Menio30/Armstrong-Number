import java.util.Scanner;
public class Armstrongnumber
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int arm=0,temp;
System.out.println("Enter a Number:");
int num=sc.nextInt();
temp=num;
while(num>0)
{
int rem=num%10;
arm=rem*rem*rem+arm;
num=num/10;
}
if(temp==arm)
{
System.out.println(temp+" is an Armstrong Number");
}
else
{
System.out.println(temp+" is not an Armstrong Number");
}
}
}
