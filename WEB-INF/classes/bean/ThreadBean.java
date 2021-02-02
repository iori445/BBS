package bean;

public class ThreadBean {
    private int genre_id;
    private int user_id;
    private int th_id;
    private String th_title;
    private String th_date;
    private String th_description; 

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }
    public int getGenre_id() {
        return genre_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getUser_id() {
        return user_id;
    }

    public void setTh_id(int th_id) {
        this.th_id = th_id;
    }
    public int getTh_id() {
        return th_id;
    }

    public void setTh_title(String th_title) {
        this.th_title = th_title;
    }
    public String getTh_title() {
        return th_title;
    }

    public void setTh_date(String th_date) {
        this.th_date = th_date;
    }
    public String getTh_date() {
        return th_date;
    }

    public void setTh_description(String th_description) {
        this.th_description = th_description;
    }
    public String getTh_description() {
        return th_description;
    }
}