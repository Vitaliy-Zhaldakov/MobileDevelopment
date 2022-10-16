package calc.operation;

public class LeftShift {
    private long num;
    public LeftShift() { num = 0; }
    public LeftShift(long a) { this.num = a; }

    public void leftShift(int x) {
        num = num << x;
    }
    public long getNum() { return num; }
}
