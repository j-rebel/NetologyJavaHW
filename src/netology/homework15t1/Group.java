package netology.homework15t1;

public enum Group {

    WORK("Работа"),
    FRIENDS("Друзья"),
    FAMILY("Семья");

    private String title;

    Group(String title){
        this.title = title;
    }

    public String getTitle(){ return title;}
}
