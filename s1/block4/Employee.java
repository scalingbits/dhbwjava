package s1.block4;
public class Employee {
    private String surName;
    private String firstName;
    private int employeeId;
    private double salary;
    /**
     * Der Konstruktor initialisert die Attribute für Employee
     * @param ln Nachname
     * @param fn Vorname
     * @param id Mitarbeiternummer
     * @param sal Gehalt. Gehalt wird im Konstruktor auf 100000 begranzt
     */
    public Employee (String ln, String fn, int id, double sal) {
        surName = ln;
        firstName = fn;
        employeeId = id;
        if (sal > 100000) salary = 100000;
        else salary= sal;
     }
    public void printRecord() {
        System.out.print(employeeId + ", " + surName + " " + firstName);
        System.out.println(",Salary :" + salary);
    }
    /**
     * Teste die Konstruktoren
     * @param args werden nicht benutzt
     */
    public static void main(String[] args) {
        Employee ceo = new Employee("Doe","John",1,80000.0);
        Employee cio = new Employee("Doe","Jane",1,70000.0);
        ceo.printRecord();
        cio.printRecord();
    }
}
