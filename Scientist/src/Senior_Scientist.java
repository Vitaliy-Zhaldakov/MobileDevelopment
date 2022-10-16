public class Senior_Scientist extends Scientist {

    public Senior_Scientist(int salary, int seniority) {
        super(salary, seniority);
    }

    public String toString() {
        return "Старший НС, зарплата: " + this.getSalary() + ", стаж: " + this.getSeniority();
    }

    @Override
    public double countSalary() {
        return Math.round(this.getSalary() * (1 + this.getSeniority() * 0.03));
    }
}
