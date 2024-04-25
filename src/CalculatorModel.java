import java.util.Observable;

public class CalculatorModel extends Observable {
    private double memory = 0;

    public static double calculate(double num1, double num2, String operator) {
        double result = 0;
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
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    // Handle division by zero error
                    result = Double.NaN;
                }
                break;
            case "sq":
            	result = num1 * num1;
            	break;
            case "sqrt":
            	result = Math.sqrt(num1);
            	break;
        }
        //setChanged();
        //notifyObservers(result);
        return result;
    }

    public void setMemory(double value) {
        memory = value;
    }

    public double getMemory() {
        return memory;
    }

    public void clearMemory() {
        memory = 0;
    }
}
