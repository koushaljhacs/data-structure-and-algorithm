package practice;

import java.util.Scanner;

public class test {
    public static int pinGeneration(int input1, int input2, int input3) {
        int unitDigitOfinput1 = input1 % 10;
        int unitDigitOfinput2 = input2 % 10;
        int unitDigitOfinput3 = input3 % 10;
        int unitDigit = Math.min(Math.min(unitDigitOfinput1, unitDigitOfinput2), unitDigitOfinput3);

        int tensDigitOfinput1 = (input1 / 10) % 10;
        int tensDigitOfinput2 = (input2 / 10) % 10;
        int tensDigitOfinput3 = (input3 / 10) % 10;
        int tensDigit = Math.min(Math.min(tensDigitOfinput1, tensDigitOfinput2), tensDigitOfinput3);

        int hundredDigitOfinput1 = input1 / 100;
        int hundredDigitOfinput2 = input2 / 100;
        int hundredDigitOfinput3 = input3 / 100;
        int hundredDigit = Math.min(Math.min(hundredDigitOfinput1, hundredDigitOfinput2), hundredDigitOfinput3);

        int thousandMaxDigit = 0;
        int[] number = {input1, input2, input3};
        for(int num : number) {
            int temp = num;
            while(temp != 0) {
                thousandMaxDigit = Math.max(thousandMaxDigit, temp % 10);
                temp /= 10;
            }
        }
        
        int PIN = thousandMaxDigit * 1000 + hundredDigit * 100 + tensDigit * 10 + unitDigit;
        return PIN;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int input1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int input2 = scanner.nextInt();

        System.out.print("Enter third number: ");
        int input3 = scanner.nextInt();

        int result = pinGeneration(input1, input2, input3);
        System.out.println("4-Digit PIN: " + result);
        scanner.close();
    }

}
