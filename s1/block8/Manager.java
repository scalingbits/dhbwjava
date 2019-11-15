package s1.block8;

public class Manager extends Employee {
    public int budget;

    public Manager(String ln, String fn, String EmpId, int a, int b) {
        super(ln, fn,EmpId,a);
        budget = b;
    }
    public String printAll()
    { return (
            fullName() + " " +
                    getEmployeeId() + " " +
                    age + " " +
                    budget);
    }

    public static void main(String[] args) {
        Employee ceo = new Employee("Doe","Jane", "1", 25);
        Employee cto = new Employee("Miller","John","2", 30);
        Employee man1 = new Manager("Johnson","Susan","3", 29, 30000);

        cto.age++;
        System.out.println(ceo.printAll());
        System.out.println(cto.printAll());
        System.out.println(man1.printAll());
    }
}
