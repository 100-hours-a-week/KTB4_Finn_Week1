package enumType.menu;

public enum DesignerTypeMenu {
    UIUX_DESIGNER("1", "UI/UX 디자이너"),
    GRAPHIC_DESIGNER("2", "그래픽 디자이너"),
    BACK("3", "뒤로 가기");

    private final String key;
    private final String label;
    DesignerTypeMenu(String key, String label){
        this.key = key;
        this.label = label;
    }
    public static DesignerTypeMenu from(String input){
        for(DesignerTypeMenu d : values()){
            if(d.key.equals(input)) return d;
        }
        return null;
    }

}
