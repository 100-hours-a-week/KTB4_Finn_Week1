package enumType;

public enum SalaryRule {
    GENERAL(0),
    DEVELOPER(1000),
    DESIGNER(800),

    //개발자
    AI_DEVELOPER(350),
    FULLSTACK_DEVELOPER(300),
    INFRA_DEVELOPER(250),

    //디자이지
    UIUX_DESIGNER(200),
    GRAPHIC_DESIGNER(250);


    private static final double BASE_SALARY = 3000;
    private final double allowance;


    SalaryRule(int allowance) {
        this.allowance = allowance;
    }

    public double initSalary() {
        return BASE_SALARY;
    }

    public double calculateSalary(double salary) {
        return salary + this.allowance;
    }
}
