package Enums;

public class MathOperations {

    public int calculate(Operators operator, int operand1, int operand2) {
        switch (operator) {
            case PLUS:
                return operand1 + operand2;
            case MINUS:
                return operand1 - operand2;
            case MULTIPLY:
                return operand1 * operand2;
            case DIVIDE:
                return operand1 / operand2;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        MathOperations math = new MathOperations();
        System.out.println(math.calculate(Operators.PLUS, 10, 5));     // 15
        System.out.println(math.calculate(Operators.MINUS, 10, 5));    // 5
        System.out.println(math.calculate(Operators.MULTIPLY, 10, 5)); // 50
        System.out.println(math.calculate(Operators.DIVIDE, 10, 5));   // 2
    }
}