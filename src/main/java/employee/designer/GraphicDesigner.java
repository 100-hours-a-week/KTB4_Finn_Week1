package employee.designer;

public class GraphicDesigner extends Designer{

    protected String mainGraphicAssertType;

    public GraphicDesigner(String name, int age, String email, String designTool, String graphicAssertType) {
        super(name, age, email, designTool);
        this.mainGraphicAssertType = graphicAssertType;
        salary += 200;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.printf(" • 메인 그래픽 작업 종류 : %s%n", mainGraphicAssertType);
        System.out.println("========================================");
    }

    @Override
    public String startWork() {
        return "그래픽 디자이너[" + name + "]이(가) 그래픽 디자인을 합니다.";
    }
    @Override
    public String endWork() {
        return "그래픽 디자이너[" + name + "]이(가) 그래픽 디자인을 마무리 합니다.";
    }
}
