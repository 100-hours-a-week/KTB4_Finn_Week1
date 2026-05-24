package enumType.menu;

public enum FindEmployeeMenu {
    FIND_ALL("1", "전체 직원 조회"),
    FIND_BY_ID("2", "직원ID로 조회"),
    BACK("3", "뒤로 가기");

    private final String key;
    private final String label;

    FindEmployeeMenu(String key, String label){
        this.key = key;
        this.label = label;
    }

    public static FindEmployeeMenu from(String input){
        for(FindEmployeeMenu f : values()){
            if(f.key.equals(input)) return f;
        }
        return null;
    }
}
