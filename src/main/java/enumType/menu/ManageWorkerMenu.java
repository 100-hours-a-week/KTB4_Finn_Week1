package enumType.menu;

public enum ManageWorkerMenu {
    ASSIGN("1", "작업 할당"),
    RELEASE("2", "작업 해제"),
    OUTSIDE("3", "외근 관리"),
    BACK("4", "뒤로가기");

    private final String key;
    private final String label;

    ManageWorkerMenu(String key, String label){
        this.key = key;
        this.label = label;
    }
    public static ManageWorkerMenu from(String input){
        for(ManageWorkerMenu m : values()){
            if(m.key.equals(input)) return m;
        }
        return null;
    }
}
