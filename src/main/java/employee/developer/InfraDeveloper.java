package employee.developer;

public class InfraDeveloper extends Developer {

    protected String mainCloudPlatform;

    public InfraDeveloper(String name, int age, String email, String language, String cloudPlatform) {
        super(name, age, email, language);
        this.mainCloudPlatform = cloudPlatform;
        salary += 250;
    }

    @Override
    public void showInfo() {
        System.out.println("========================================");
        System.out.println("            [인프라개발자 정보]        ");
        System.out.println("========================================");
        System.out.printf(" • 사원 번호(ID) : %d%n", id);
        System.out.printf(" • 성함 / 나이   : %s (%d세)%n", name, age);
        System.out.printf(" • 이메일 주소   : %s%n", email);
        System.out.printf(" • 급여     : %,.0f만원 %n", salary);
        System.out.println("----------------------------------------");
        System.out.printf(" • 메인 언어 : %s%n", mainLanguage);
        System.out.printf(" • 메인 클라우드 플랫폼  : %s%n", mainCloudPlatform);
        System.out.println("========================================");
    }

    @Override
    public String startWork() {
        return "인프라 개발자[" + name + "]이(가) " + mainCloudPlatform + "을(를) 사용해 서버 개발을 합니다.";
    }

    @Override
    public String endWork() {
        return "인프라 개발자[" + name + "]이(가) " + mainCloudPlatform + "을(를) 사용해 서버 개발을 마무리 합니다.";
    }
}
