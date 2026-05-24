package Employee.developer;

import enumType.SalaryRule;

public class InfraDeveloper extends Developer {

    protected String mainCloudPlatform;

    public InfraDeveloper(String name, int age, String email, String language, String cloudPlatform) {
        super(name, age, email, language);
        this.mainCloudPlatform = cloudPlatform;
        salary = SalaryRule.INFRA_DEVELOPER.calculateSalary(salary);
    }

    @Override
    public void showInfo() {
        System.out.println("========================================");
        System.out.println("           [인프라 개발자 정보]            ");
        System.out.println("========================================");

        super.showInfo();

        System.out.printf(" • 메인 클라우드 플랫폼  : %s%n", mainCloudPlatform);
        System.out.println("========================================\n");
    }

    @Override
    public String showStartWork() {
        isWorking.set(true);
        return "인프라 개발자[" + name + "]이(가) " + mainCloudPlatform + "을(를) 사용해 서버 개발을 합니다.";
    }

    @Override
    public String showEndWork() {
        isWorking.set(false);
        return "인프라 개발자[" + name + "]이(가) " + mainCloudPlatform + "을(를) 사용해 서버 개발을 마무리 합니다.";
    }
}
