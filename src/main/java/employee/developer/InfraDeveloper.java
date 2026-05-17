package employee.developer;

public class InfraEngineer extends Developer {

    protected String mainFramework;

    public InfraEngineer(String name, int age, String email, String language, String framework) {
        super(name, age, email, language);
        this.mainFramework = framework;
        salary += 250;
    }

    @Override
    public void showInfo() {
        System.out.println("========================================");
        System.out.println("       [인프라 엔지니어 정보 소속]        ");
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
        System.out.println("인프라 개발자가 서버 개발을 합니다.");
    }

}
