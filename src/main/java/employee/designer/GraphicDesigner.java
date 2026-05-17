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
        System.out.println("========================================");
        System.out.println("       [그래픽 디자이너 정보]        ");
        System.out.println("========================================");
        System.out.printf(" • 사원 번호(ID) : %d%n", id);
        System.out.printf(" • 성함 / 나이   : %s (%d세)%n", name, age);
        System.out.printf(" • 이메일 주소   : %s%n", email);
        System.out.printf(" • 급여     : %,.0f만원 %n", salary);
        System.out.println("----------------------------------------");
        System.out.printf(" • 메인 언어 : %s%n", mainDesignTool);
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
