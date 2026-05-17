package employee.developer;

import employee.Employee;

public class Developer extends Employee {
    protected String mainLanguage;

    public Developer(String name, int age, String email, String language) {
        super(name, age, email);
        this.mainLanguage = language;
        salary += 1000;
    }

    @Override
    public void showInfo() {
        System.out.println("========================================");
        System.out.println("       [풀스택 엔지니어 정보 소속]        ");
        System.out.println("========================================");
        System.out.printf(" • 사원 번호(ID) : %d%n", id);
        System.out.printf(" • 성함 / 나이   : %s (%d세)%n", name, age);
        System.out.printf(" • 이메일 주소   : %s%n", email);
        System.out.printf(" • 급여     : %,.0f만원 %n", salary);
        System.out.println("----------------------------------------");
        System.out.printf(" • 메인 언어 : %s%n", mainLanguage);
        System.out.println("========================================");
    }
}
