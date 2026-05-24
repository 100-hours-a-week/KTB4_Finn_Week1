package enumType.menu;

public enum MainMenu {
    ADD_EMPLOYEE("1", "직원등록"),
    FIND_EMPLOYEE("2", "직원조회"),
    DELETE_EMPLOYEE("3", "직원삭제"),
    MANAGE_WORK("4", "작업 현황"),
    EXIT("5", "종료");

    private final String key;
    private final String label;

    MainMenu(String key, String label) {
        this.key = key;
        this.label = label;
    }

    public static MainMenu from(String input) {
        for (MainMenu m : values()) {
            if (m.key.equals(input)) return m;
        }
        return null;
    }
}