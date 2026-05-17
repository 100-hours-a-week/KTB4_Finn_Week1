package employee.developer;

public class AIDeveloper extends Developer {

    protected String mainField;

    public AIDeveloper(String name, int age, String email, String language, String field) {
        super(name, age, email, language);
        this.mainField = field;
        salary += 300;
    }

    @Override
    public void showInfo() {
        System.out.println("========================================");
        System.out.println("              [AI개발자 정보]        ");
        System.out.println("========================================");
        System.out.printf(" • 사원 번호(ID) : %d%n", id);
        System.out.printf(" • 성함 / 나이   : %s (%d세)%n", name, age);
        System.out.printf(" • 이메일 주소   : %s%n", email);
        System.out.printf(" • 급여     : %,.0f만원 %n", salary);
        System.out.println("----------------------------------------");
        System.out.printf(" • 메인 언어 : %s%n", mainLanguage);
        System.out.printf(" • 메인 필드  : %s%n", mainField);
        System.out.println("========================================");
    }

    @Override
    public String startWork() {
        return "AI개발자 [" + name + "]이(가) " + mainField + " 기반 AI 서비스 개발을 합니다.";
    }

    @Override
    public String endWork() {
        return "AI개발자 [" + name + "]이(가) " + mainField + " 기반 AI 서비스 게발을 마무리 합니다.";
    }
}
