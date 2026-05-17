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
        super.showInfo();
        System.out.printf(" • 메인 프로토타입 툴 : %s%n", mainPrototypeTool);
        System.out.println("========================================");
    }
    @Override
    public String startWork() {
        return "UI/UX 디자이너[" + name + "]이(가) UI/UX를 디자인합니다";
    }

    @Override
    public String endWork() {
        return "UI/UX 디자이너[" + name + "]이(가) UI/UX를 디자인을 마무리 합니다";
    }
}
