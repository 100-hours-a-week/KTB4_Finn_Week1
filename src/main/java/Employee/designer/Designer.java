package Employee.designer;

import Employee.Employee;
import enumType.SalaryRule;

public abstract class Designer extends Employee {
    protected String mainDesignTool;

    public Designer(String name, int age, String email, String designTool) {
        super(name, age, email);
        this.mainDesignTool = designTool;
        salary = SalaryRule.DESIGNER.calculateSalary(salary);
    }

    @Override
    public void showInfo() {
        System.out.printf(" • 사원 번호(ID) : %d%n", id);
        System.out.printf(" • 성함 / 나이   : %s (%d세)%n", name, age);
        System.out.printf(" • 이메일 주소   : %s%n", email);
        System.out.printf(" • 급여     : %,.0f만원 %n", salary);
        System.out.println("----------------------------------------");
        System.out.printf(" • 메인 디자인 툴 : %s%n", mainDesignTool);
    }
    @Override
    public String startWork() {
        isWorking = true;
        return "디자이너가 디자인을 합니다.";
    }

    @Override
    public String endWork() {
        isWorking = false;
        return "디자이너가 디자인을 마무리 합니다.";
    }
}
