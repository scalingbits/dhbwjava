package s1.block8;
public class Employee extends Person {
    private String employeeId;
    public Employee(String ln, String fn, String EmpId, int a) {
        super(ln,fn); // Java ruft hier den Konstruktor der Oberklasse auf
        employeeId = EmpId;
        age = a;
    }
    public String getEmployeeId() {return employeeId;}
    public String printAll() {
        return (
                fullName() + " " +
                        employeeId + " " +
                        age);
    }

    public static void main(String[] args) {
        Employee ceo = new Employee("Doe","Jane", "1", 25);
        Employee cto = new Employee("Miller","John","2", 30);

        cto.age++;
        System.out.println(ceo.printAll());
        System.out.println(cto.printAll());
    }
}
