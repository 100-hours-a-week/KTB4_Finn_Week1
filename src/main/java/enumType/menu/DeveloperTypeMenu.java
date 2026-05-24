package enumType.menu;

public enum DeveloperTypeMenu {
    FULLSTACK("1", "풀스택 개발자"),
    AI("2", "AI 개발자"),
    INFRA("3", "인프라 개발자"),
    BACK("4", "뒤로가기");

    private final String key;
    private final String label;

    DeveloperTypeMenu(String key, String label){
        this.key = key;
        this.label = label;
    }
    public static DeveloperTypeMenu from(String input){
        for(DeveloperTypeMenu d : values()){
            if(d.key.equals(input)) return d;
        }
        return null;
    }
}
