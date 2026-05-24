package enumType.menu;

public enum EmployeeTypeMenu {
    DEVELOPER("1", "개발자"),
    DESIGNER("2", "디자이너"),
    BACK("3", "뒤로가기");

    private final String key;
    private final String label;
    EmployeeTypeMenu(String key, String label){
        this.key = key;
        this.label = label;
    }

    public static EmployeeTypeMenu from(String input){
        for(EmployeeTypeMenu e : values()){
            if(e.key.equals(input)) return e;
        }
        return null;
    }
}
