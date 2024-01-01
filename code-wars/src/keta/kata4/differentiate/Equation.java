package differentiate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Equation {
    public static BigInteger differentiate(String equation, long x) {
        List<Statement> list = new ArrayList<>();
        // initiating statements
        Arrays.stream(equation.split("\\+")).toList().forEach(item -> {
            if (item.contains("-")) {
                if (item.indexOf('-') != 0) list.add(new Statement(item.split("-")[0]));
                list.add(new Statement(item.substring(item.indexOf("-"))));
            } else list.add(new Statement(item));
        });
        // calculating the result
        return BigDecimal.valueOf(
                        list.stream()
                                .peek(Statement::derivative)
                                .map(item -> item.placement(x))
                                .reduce(Double::sum).orElse(0.0))
                .toBigInteger();
    }

    private static class Statement {
        int coefficient;
        int exponent;
        public Statement(String text) {
            if (text.contains("x")) {
                if (text.indexOf('x') == 0) {
                    this.coefficient = 1;
                } else {
                    if (text.charAt(0) == '-' && text.charAt(1) == 'x') this.coefficient = -1;
                    else this.coefficient = Integer.parseInt(text.split("x")[0]);
                }
                if (text.contains("^")) {
                    this.exponent = Integer.parseInt(text.split("\\^")[1]);
                } else {
                    this.exponent = 1;
                }
            } else {
                this.exponent = 0;
                this.coefficient = Integer.parseInt(text);
            }
        }
        void derivative() {
            switch (this.exponent) {
                case 0 -> this.coefficient = 0;
                case 1 -> this.exponent = 0;
                default -> {
                    this.coefficient *= this.exponent;
                    this.exponent--;
                }
            }
        }
        Double placement(long x) {
            return this.coefficient * Math.pow(x, this.exponent);
        }
        @Override
        public String toString() {
            return this.coefficient + "x^" + this.exponent;
        }
    }
}
