package employee;

public class Employee {
    protected Long id;
    protected String name;
    protected int age;
    protected String email;
    protected double salary = 3000;

    protected boolean isWorking = false;

    public Employee(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Employee() {
    }

    public void showInfo(){
        System.out.print("[직원] ID: " + id + " | 성함: " + name);
    };

    public String startWork(){
        return "직원이 일을 합니다.";
    }
    public String endWork(){
        return "직원이 일을 마무리합니다.";
    }


    public String getName() {
        return name;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
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
