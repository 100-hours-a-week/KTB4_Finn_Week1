package Employee;

import enumType.SalaryRule;

import java.util.concurrent.atomic.AtomicBoolean;

public class Employee {
    protected Long id;
    protected String name;
    protected int age;
    protected String email;
    protected double salary;

    protected AtomicBoolean isWorking = new AtomicBoolean(false);

    public Employee(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.salary = SalaryRule.GENERAL.initSalary();
    }

    public void showInfo(){
        System.out.print("[직원] ID: " + id + " | 성함: " + name);
    }

    public String showStartWork(){
        startWork();
        return "직원이 일을 합니다.";
    }
    public String showEndWork(){
        endWork();
        return "직원이 일을 마무리합니다.";
    }

    public void startWork(){
        isWorking.set(true);
    }
    public void endWork(){
        isWorking.set(false);
    }

    public String getName() {
        return name;
    }

    public boolean isWorking() {
        return isWorking.get();
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
