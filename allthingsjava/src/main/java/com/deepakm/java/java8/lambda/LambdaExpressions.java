package main.java.com.deepakm.java.java8.lambda;

/**
 * Created by deepakmarathe on 12/6/16.
 */
public class LambdaExpressions {

    public static void main(String[] args) {
        MathOperation add = (int a, int b) -> a + b;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> {
            return a * b;
        };

        System.out.println(add.operation(2, 3));
        System.out.println(subtract.operation(3, 4));
        System.out.println(multiply.operation(3, 4));


        GreetingService greetingService = message -> System.out.println("Hello " + message);
        greetingService.sayHello(" Deepak ");
    }
}
