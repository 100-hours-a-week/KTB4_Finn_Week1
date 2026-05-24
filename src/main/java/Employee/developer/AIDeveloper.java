package Employee.developer;

import enumType.SalaryRule;

public class AIDeveloper extends Developer {

    protected String mainField;

    public AIDeveloper(String name, int age, String email, String language, String field) {
        super(name, age, email, language);
        this.mainField = field;
        salary = SalaryRule.AI_DEVELOPER.calculateSalary(salary);
    }

    @Override
    public void showInfo() {
        System.out.println("========================================");
        System.out.println("             [AI개발자 정보]        ");
        System.out.println("========================================");

        super.showInfo();

        System.out.printf(" • 메인 필드  : %s%n", mainField);
        System.out.println("========================================\n");
    }

    @Override
    public String showStartWork() {
        isWorking.set(true);
        return "AI개발자 [" + name + "]이(가) " + mainField + " 기반 AI 서비스 개발을 합니다.";
    }

    @Override
    public String showEndWork() {
        isWorking.set(false);
        return "AI개발자 [" + name + "]이(가) " + mainField + " 기반 AI 서비스 개발을 마무리 합니다.";
    }
}
