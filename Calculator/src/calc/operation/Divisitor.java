package calc.operation;

public class Divisitor {
    private int div;
    public Divisitor() { div = 0; }
    public Divisitor(int a) { this.div = a; }

    public void division(int b) {
        div /= b;
    }
    public int getDiv() { return div; }
}
