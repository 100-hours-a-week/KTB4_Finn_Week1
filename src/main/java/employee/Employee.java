package employee;

public class Employee {
    protected Long id;
    protected String name;
    protected int age;
    protected String email;
    protected double salary = 3000;

    public Employee(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void showInfo(){
        System.out.print("[직원] ID: " + id + " | 성함: " + name);
    };



    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
