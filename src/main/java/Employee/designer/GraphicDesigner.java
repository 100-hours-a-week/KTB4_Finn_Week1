package Employee.designer;

import enumType.SalaryRule;

public class GraphicDesigner extends Designer{

    protected String mainGraphicAssertType;

    public GraphicDesigner(String name, int age, String email, String designTool, String graphicAssertType) {
        super(name, age, email, designTool);
        this.mainGraphicAssertType = graphicAssertType;
        salary = SalaryRule.GRAPHIC_DESIGNER.calculateSalary(salary);
    }

    @Override
    public void showInfo() {
        System.out.println("========================================");
        System.out.println("           [그래픽 디자이너 정보]        ");
        System.out.println("========================================");

        super.showInfo();

        System.out.printf(" • 메인 그래픽 작업 종류 : %s%n", mainGraphicAssertType);
        System.out.println("========================================\n");
    }

    @Override
    public String startWork() {
        isWorking = true;
        return "그래픽 디자이너[" + name + "]이(가) 그래픽 디자인을 합니다.";
    }
    @Override
    public String endWork() {
        isWorking = false;
        return "그래픽 디자이너[" + name + "]이(가) 그래픽 디자인을 마무리 합니다.";
    }
}
