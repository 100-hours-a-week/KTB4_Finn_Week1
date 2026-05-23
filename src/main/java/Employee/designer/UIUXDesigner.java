package Employee.designer;

import enumType.SalaryRule;

public class UIUXDesigner extends Designer{

    protected String mainPrototypeTool;

    public UIUXDesigner(String name, int age, String email, String designTool, String prototypeTool) {
        super(name, age, email, designTool);
        this.mainPrototypeTool = prototypeTool;
        salary = SalaryRule.UIUX_DESIGNER.calculateSalary(salary);
    }

    @Override
    public void showInfo() {

        System.out.println("========================================");
        System.out.println("           [UI/UX디자이너 정보]        ");
        System.out.println("========================================");

        super.showInfo();

        System.out.printf(" • 메인 프로토타입 툴 : %s%n", mainPrototypeTool);
        System.out.println("========================================\n");
    }
    @Override
    public String startWork() {
        isWorking = true;
        return "UI/UX 디자이너[" + name + "]이(가) UI/UX를 디자인합니다";
    }

    @Override
    public String endWork() {
        isWorking = false;
        return "UI/UX 디자이너[" + name + "]이(가) UI/UX를 디자인을 마무리 합니다";
    }
}
