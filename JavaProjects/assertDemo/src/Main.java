import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Get a number in the first argument");
        int number = scanner.nextInt();

        assert number <= 10 : "Number is bigger than 10.";

        System.out.println("Pass");
    }
}