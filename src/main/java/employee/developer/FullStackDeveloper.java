package employee.developer;

public class FullStackDeveloper extends Developer {

    protected String mainFrontendFramework;
    protected String mainBackendFramework;

    public FullStackDeveloper(String name, int age, String email, String language, String frontendFramework, String backendFramework) {
        super(name, age, email, language);
        this.mainFrontendFramework = frontendFramework;
        this.mainBackendFramework = backendFramework;
        salary += 300;
    }

    @Override
    public void showInfo() {
        System.out.println("========================================");
        System.out.println("            [풀스택 개발자 정보]        ");
        System.out.println("========================================");
        System.out.printf(" • 사원 번호(ID) : %d%n", id);
        System.out.printf(" • 성함 / 나이   : %s (%d세)%n", name, age);
        System.out.printf(" • 이메일 주소   : %s%n", email);
        System.out.printf(" • 급여     : %,.0f만원%n", salary);
        System.out.println("----------------------------------------");
        System.out.printf(" • 메인 언어 : %s%n", mainLanguage);
        System.out.printf(" • 메인 프론트엔드 프레임워크  : %s%n", mainFrontendFramework);
        System.out.printf(" • 메인 백엔드 프레임워크  : %s%n", mainBackendFramework);
        System.out.println("========================================");
    }

    @Override
    public String startWork() {
        return "풀스택 개발자 [" + name + "]이(가) " + mainFrontendFramework + "와 " + mainBackendFramework+ " 을(를) 사용해 백엔드와 프론트엔드 개발을 합니다.";
    }
    @Override
    public String endWork() {
        return "풀스택 개발자 [" + name + "]이(가) " + mainFrontendFramework + "와 " + mainBackendFramework+ " 을(를) 사용해 백엔드와 프론트엔드 개발을 마무리 합니다.";
    }
}
