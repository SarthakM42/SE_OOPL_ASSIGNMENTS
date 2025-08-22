import java.util.Scanner;
public class calc {
    public static double add(double a, double b){
      return a+b;
    }
    public static double subtract(double a, double b){
      return a-b;
    }
    public static double multiply(double a, double b){
      return a*b;
    }
    public static double divide(double a, double b){
      if (b==0){
        System.out.println("Error: Division by zero.");
        return 0;
      }
      return a/b;
}

public static void main(String[] args){
  Scanner scanner = new Scanner(System.in);
  double num1, num2;
  char operator;
  double result = 0;
  System.out.println("Simple Calculator Using Functions");

  System.out.print("Enter first number: ");
  num1 = scanner.nextDouble();
  System.out.print("Enter an opertor (+, -, *, /): ");
  operator = scanner.next().charAt(operator=0);

  System.out.print("Enter second number: ");
  num2 = scanner.nextDouble();
  switch (operator) {
    case '+':
    result = add(num1,num2);
    break;
    case '-':
    result = subtract(num1,num2);
    break;
    case '*':
    result = multiply(num1,num2);
    break;
    case '/':
    result = divide(num1,num2);
    break;
    default: System.out.println("Invalid operator");
    return;
  }
System.out.println("result: " +result);
}
}