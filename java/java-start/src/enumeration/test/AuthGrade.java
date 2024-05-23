package enumeration.test;

public enum AuthGrade {
    GUEST(1, "손님"), LOGIN(2, "로그인 회원"), ADMIN(3, "관리자");

    int level;
    String description;

    AuthGrade(int level, String description) {
        this.level = level;
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }

    public void getMenu() {
        System.out.printf("당신의 등급은 %s입니다.\n", this.description);
        switch (this) {
            case GUEST:
                System.out.println("-메인 화면");
            case LOGIN:
                System.out.println("-이메일 관리 화면");
            case ADMIN:
                System.out.println("-관리자 화면");
        }
    }
}
