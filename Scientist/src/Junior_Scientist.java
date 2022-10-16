public class Junior_Scientist extends Scientist{

    public Junior_Scientist(int salary, int seniority) {
        super(salary, seniority);
    }

    public String toString() {
        return "Младший НС, зарплата: " + this.getSalary() + ", стаж: " + this.getSeniority();
    }

    @Override
    public double countSalary() {
        return Math.round(this.getSalary() * (1 + this.getSeniority() * 0.02));
    }
}
