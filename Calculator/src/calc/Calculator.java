package calc;
import calc.operation.*;

public class Calculator {

    public int summa(int... a) {
        Adder adder = new Adder();
        for (int i : a) {
            adder.add(i);
        }
        return adder.getSum();
    }

    public int subtraction(int a, int ... b) {
        Subtractor subtractor = new Subtractor(a);
        for (int i : b) {
            subtractor.reduce(i);
        }
        return subtractor.getSub();
    }

    public int multiplication(int... a) {
        Multiplier multiplier = new Multiplier();
        for (int i : a) {
            multiplier.multiply(i);
        }
        return multiplier.getMult();
    }

    public int division(int a, int ... b) {
        Divisitor divisitor = new Divisitor(a);
        for (int i : b) {
            divisitor.division(i);
        }
        return divisitor.getDiv();
    }

    public long leftShift(long a, int ... x) {
        LeftShift lShift = new LeftShift(a);
        for (int i : x) {
            lShift.leftShift(i);
        }
        return lShift.getNum();
    }
}
