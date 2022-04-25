import classes.Calculator;
import classes.IntsCalculatorAdapter;
import classes.Logger;
import interfaces.Ints;

public class Main {

    public static void main(String[] args) {
        Logger log = Logger.getLogger();
        log.getInfo("Start programme");
        log.getInfo("Using full programme");

        Calculator calc = new Calculator();
        System.out.println(
                calc.newFormula()
                        .addOperand(5)
                        .addOperand(5)
                        .calculate(Calculator.Operation.MULT)
                        .result()
        );

        log.getInfo("Stop using full programme");

        log.getInfo("Start using class adapter");

        Ints adapter = new IntsCalculatorAdapter();
        log.getInfo("Sum");
        int result = adapter.sum(5, 5);
        System.out.println("Result sum is: " + result);

        log.getInfo("Mult");
        result = adapter.mult(5, 5);
        System.out.println("Result mult is: " + result);

        log.getInfo("Pov");
        result = adapter.pow(5, 5);
        System.out.println("Result pov is: " + result);

        log.getInfo("Stop using class adapter");

        log.getInfo("End programme");

    }
}
