package application;

import java.util.Stack;

public class Teste {

    private static enum Operators {
        SUM('+', 1),
        SUB('-', 1),
        MUL('*', 2),
        DIV('/', 2),
        POW('^', 3),
        UNDF('?', -1);

        private char simbol;
        private int precedence;

        Operators(char simbol, int precedence) {
            this.simbol = simbol;
            this.precedence = precedence;
        }

        public char getSimbol() {
            return simbol;
        }

        public int getPrecedence() {
            return precedence;
        }

        public boolean hasLowerPrecedenceThan(char simbol) {
            Operators operator = Operators.getOperator(simbol);

            return this.precedence <= operator.getPrecedence();
        }

        public static Operators getOperator(char simbol) {
            return switch (simbol) {
                case '+' -> Operators.SUM;
                case '-' -> Operators.SUB;
                case '*' -> Operators.MUL;
                case '/' -> Operators.DIV;
                case '^' -> Operators.POW;
                default -> Operators.UNDF;
            };
        }

        public static boolean isOperator(char simbol) {
            return simbol == SUM.simbol ||
                    simbol == SUB.simbol ||
                    simbol == MUL.simbol ||
                    simbol == DIV.simbol ||
                    simbol == POW.simbol;
        }

        public static Double eval(char simbol, double leftOperand, double rightOperand) {
            return switch (simbol) {
                case '+' -> leftOperand + rightOperand;
                case '-' -> rightOperand - leftOperand;
                case '*' -> leftOperand * rightOperand;
                case '/' -> rightOperand / leftOperand;
                case '^' -> Math.pow(leftOperand, rightOperand);
                default -> 0.0;
            };
        }
    }

    static class Expression {

        public static Double evaluate(String expression) {
            Stack<Double> operands = new Stack<>();
            Stack<Character> operations = new Stack<>();

            String[] tokens = expression.split("(?<=[-+*/()^])|(?=[-+*/()^])");

            for (int i = 0; i < tokens.length; i++) {
                String token = tokens[i];

                if (Character.isDigit(token.charAt(0))) {
                    Double number = Double.valueOf(token);
                    operands.push(number);
                } else if ("(".equals(token)) {
                    operations.push(token.charAt(0));
                } else if (")".equals(token)) {
                    while (operations.peek() != '(') {
                        Double output = performOperation(operands, operations);
                        operands.push(output);
                    }

                    operations.pop();
                } else if (Operators.isOperator(token.charAt(0))) {
                    Operators operator = Operators.getOperator(token.charAt(0));

                    while (!operations.isEmpty() && operator.hasLowerPrecedenceThan(operations.peek())) {
                        Double output = performOperation(operands, operations);
                        operands.push(output);
                    }

                    operations.push(operator.getSimbol());
                }
            }

            while (!operations.isEmpty()) {
                Double output = performOperation(operands, operations);
                operands.push(output);
            }

            return operands.pop();
        }

        private static Double performOperation(Stack<Double> operands, Stack<Character> operations) {
            double left = operands.pop();
            double right = operands.pop();
            char operation = operations.pop();

            return Operators.eval(operation, left, right);
        }
    }

    public static void main(String[] args) {
        System.out.println(Expression.evaluate("10+"));
//        System.out.println(Expression.evaluate("(15/3*4-7)+(19-4^2)") == 16);
    }
}
