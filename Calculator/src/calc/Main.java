package calc;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello dude");
        Calculator calc = new Calculator();
        System.out.println("2+2 = "+ calc.summa(2,2));
        System.out.println("2-2-2 = "+ calc.subtraction(2,2,2));
        System.out.println("2*2 = "+ calc.multiplication(2,2));
        System.out.println("4/2 = "+ calc.division(4,2));
        System.out.println("64 << 3 = "+ calc.leftShift(64,3));
    }
}
