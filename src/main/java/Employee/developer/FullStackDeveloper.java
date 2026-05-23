package Employee.developer;

import enumType.SalaryRule;

public class FullStackDeveloper extends Developer {

    protected String mainFrontendFramework;
    protected String mainBackendFramework;

    public FullStackDeveloper(String name, int age, String email, String language, String frontendFramework, String backendFramework) {
        super(name, age, email, language);
        this.mainFrontendFramework = frontendFramework;
        this.mainBackendFramework = backendFramework;
        salary = SalaryRule.FULLSTACK_DEVELOPER.calculateSalary(salary);
    }

    @Override
    public void showInfo() {
        System.out.println("========================================");
        System.out.println("             [풀스택 개발자 정보]        ");
        System.out.println("========================================");

        super.showInfo();

        System.out.printf(" • 메인 프론트엔드 프레임워크  : %s%n", mainFrontendFramework);
        System.out.printf(" • 메인 백엔드 프레임워크  : %s%n", mainBackendFramework);
        System.out.println("========================================\n");
    }

    @Override
    public String startWork() {
        isWorking = true;
        return "풀스택 개발자 [" + name + "]이(가) " + mainFrontendFramework + "와 " + mainBackendFramework+ " 을(를) 사용해 백엔드와 프론트엔드 개발을 합니다.";
    }
    @Override
    public String endWork() {
        isWorking = false;
        return "풀스택 개발자 [" + name + "]이(가) " + mainFrontendFramework + "와 " + mainBackendFramework+ " 을(를) 사용해 백엔드와 프론트엔드 개발을 마무리 합니다.";
    }
}
