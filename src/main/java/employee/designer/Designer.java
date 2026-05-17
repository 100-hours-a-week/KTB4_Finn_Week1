package employee.designer;

import employee.Employee;

public class Designer extends Employee {
    protected String mainDesignTool;

    public Designer(String name, int age, String email, String designTool) {
        super(name, age, email);
        this.mainDesignTool = designTool;
        salary += 800;
    }
}
