package employee.developer;

public class AIEngineer extends Developer {

    protected String mainFramework;

    public AIEngineer(String name, int age, String email, String language, String framework) {
        super(name, age, email, language);
        salary += 300;
        this.mainFramework = framework;
    }

    @Override
    public void showInfo() {
        System.out.println("========================================");
        System.out.println("       [AI엔지니어 정보 소속]        ");
        System.out.println("========================================");
        System.out.printf(" • 사원 번호(ID) : %d%n", id);
        System.out.printf(" • 성함 / 나이   : %s (%d세)%n", name, age);
        System.out.printf(" • 이메일 주소   : %s%n", email);
        System.out.printf(" • 급여     : %,.0f만원 %n", salary);
        System.out.println("----------------------------------------");
        System.out.printf(" • 메인 언어 : %s%n", mainLanguage);
        System.out.printf(" • 메인 프레임워크  : %s%n", mainFramework);
        System.out.println("========================================");
    }

    @Override
    public void toWork() {
        System.out.println("AI개발자가 AI 기반 서비스 게발을 합니다.");
    }
}
