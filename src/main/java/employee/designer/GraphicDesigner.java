package employee.designer;

public class GraphicDesigner extends Designer{
    public GraphicDesigner(String name, int age, String email, String designTool) {
        super(name, age, email, designTool);
        salary += 200;
    }
}
