public abstract class Scientist {
    private int salary, seniority;

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public int getSeniority() {
        return seniority;
    }

    public Scientist(int salary, int seniority) {
        this.salary = salary;
        this.seniority = seniority;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object instanceof Scientist) {
            Scientist emp = (Scientist)object;
            if (salary == emp.salary && seniority == emp.seniority)
                result = true;
        }
        return result;
    }

    public String toString() {
        return "Научный сотрудник, зарплата: " + this.salary + ", стаж: " + this.seniority;
    }

    abstract double countSalary();

    public String hire() {
        return "Принят на должность";
    }

    public String fire() {
        return "Уволен с должности";
    }

    public String replace() {
        return "Переведён на должность";
    }

    public double calculate_salary() {
        return this.countSalary();
    }


}
