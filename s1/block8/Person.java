package s1.block8;

public class Person {
    private String name;
    private String firstName;
    public int age;

    public Person(String ln, String fn) {
        name = ln; firstName = fn; }

    public Person() { this("Doe","John");}

    public void setName(String ln, String fn) {
        name = ln; firstName = fn; }
    public String fullName() {return (name + " " + firstName);}
}
