import java.util.Scanner;

public class TwoNumsSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();

        int sum = firstNum + secondNum;
        System.out.println(sum);
    }
}