package employee.designer;

public class UIUXDesigner extends Designer{

    protected String mainPrototypeTool;

    public UIUXDesigner(String name, int age, String email, String designTool, String prototypeTool) {
        super(name, age, email, designTool);
        this.mainPrototypeTool = prototypeTool;
        salary += 250;
    }

    @Override
    public void showInfo() {
        System.out.println("========================================");
        System.out.println("              [UI/UX디자이너 정보]        ");
        System.out.println("========================================");
        System.out.printf(" • 사원 번호(ID) : %d%n", id);
        System.out.printf(" • 성함 / 나이   : %s (%d세)%n", name, age);
        System.out.printf(" • 이메일 주소   : %s%n", email);
        System.out.printf(" • 급여     : %,.0f만원 %n", salary);
        System.out.println("----------------------------------------");
        System.out.printf(" • 메인 디자인 툴 : %s%n", mainDesignTool);
        System.out.printf(" • 메인 프로토타입 툴 : %s%n", mainPrototypeTool);
        System.out.println("========================================");
    }
    @Override
    public String startWork() {
        return "UI/UX 디자이너[" + name + "]이(가) UI/UX를 디자인합니다";
    }

    @Override
    public String endWork() {
        return "UI/UX 디자이너[" + name + "]이(가) UI/UX 디자인을 마무리 합니다";
    }
}
