public class Main {

    public static void main(String[] args) {

        Scientist emp1 = new Junior_Scientist(15000, 2);
        Scientist emp2 = new Junior_Scientist(15000, 2);
        Scientist emp3 = new Senior_Scientist(90000, 10);
        Scientist emp4 = new Senior_Scientist(95000, 12);
        Scientist emp5 = new Junior_Scientist(35000, 5);
        Scientist emp6 = new Junior_Scientist(20000, 3);
        Scientist emp7 = new Senior_Scientist(60000, 3);
        Scientist emp8 = new Engineer(55000, 3);
        Scientist emp9 = new Engineer(55000, 1);
        Scientist emp10 = new Engineer(75000, 10);

        Scientist[] scientists = {emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10};
        for (Scientist elem : scientists) {
            System.out.println("Ставка: " + elem.getSalary() + " С учётом надбавки: " + elem.countSalary());
        }

    }
}
