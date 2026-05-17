package employee.designer;

import employee.Employee;

public abstract class Designer extends Employee {
    protected String mainDesignTool;

    public Designer(String name, int age, String email, String designTool) {
        super(name, age, email);
        this.mainDesignTool = designTool;
        salary += 800;
    }

    public Designer() {
    }

    @Override
    public void showInfo() {
        System.out.println("========================================");
        System.out.println("              [디자이너 정보]        ");
        System.out.println("========================================");
        System.out.printf(" • 사원 번호(ID) : %d%n", id);
        System.out.printf(" • 성함 / 나이   : %s (%d세)%n", name, age);
        System.out.printf(" • 이메일 주소   : %s%n", email);
        System.out.printf(" • 급여     : %,.0f만원 %n", salary);
        System.out.println("----------------------------------------");
        System.out.printf(" • 메인 디자인 툴 : %s%n", mainDesignTool);
    }
    @Override
    public String startWork() {
        return "디자이너가 디자인을 합니다.";
    }

    @Override
    public String endWork() {
        return "디자이너가 디자인을 마무리 합니다.";
    }
}
