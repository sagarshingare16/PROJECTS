package calculator;

import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1, num2, result;
        String operator;

        System.out.println("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.println("Enter the second number: ");
        num2 = scanner.nextDouble();

        System.out.println("Enter the operator (+, -, *, /, sqrt, pow, sin, cos, tan): ");
        operator = scanner.next();

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "sqrt":
                result = Math.sqrt(num1);
                break;
            case "pow":
                result = Math.pow(num1, num2);
                break;
            case "sin":
                result = Math.sin(num1);
                break;
            case "cos":
                result = Math.cos(num1);
                break;
            case "tan":
                result = Math.tan(num1);
                break;
            default:
                System.out.println("Invalid operator!");
                return;
        }

        System.out.println("The result is: " + result);
    }
}
