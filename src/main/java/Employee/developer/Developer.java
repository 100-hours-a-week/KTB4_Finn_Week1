package Employee.developer;

import Employee.Employee;
import enumType.SalaryRule;

public abstract class Developer extends Employee {
    protected String mainLanguage;

    public Developer(String name, int age, String email, String language) {
        super(name, age, email);
        this.mainLanguage = language;
        salary = SalaryRule.DEVELOPER.calculateSalary(salary);
    }

    @Override
    public void showInfo() {
        System.out.printf(" • 사원 번호(ID) : %d%n", id);
        System.out.printf(" • 성함 / 나이   : %s (%d세)%n", name, age);
        System.out.printf(" • 이메일 주소   : %s%n", email);
        System.out.printf(" • 급여     : %,.0f만원 %n", salary);
        System.out.println("----------------------------------------");
        System.out.printf(" • 메인 언어 : %s%n", mainLanguage);

    }

    @Override
    public String startWork() {
        isWorking = true;
        return "개발자가 일을 합니다.";
    }

    @Override
    public String endWork() {
        isWorking = false;
        return "개발자가 일을 마무리 합니다.";
    }
}
