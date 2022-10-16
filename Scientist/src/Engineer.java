public class Engineer extends Scientist {

    public Engineer(int salary, int seniority) {
        super(salary, seniority);
    }

    public String toString() {
        return "Инженер, зарплата: " + this.getSalary() + ", стаж: " + this.getSeniority();
    }

    @Override
    public double countSalary() {
        return Math.round(this.getSalary() * (1 + this.getSeniority() * 0.01));
    }
}
