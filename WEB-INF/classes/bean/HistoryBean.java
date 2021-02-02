package bean;

public class HistoryBean {
    private int user_id;
    private int res_id;
    private String history_browsing;

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }


    public void setHistory_browsing(String history_browsing) {
        this.history_browsing = history_browsing;
    }


    public int getUser_id() {
        return user_id;
    }


    public int getRes_id() {
        return res_id;
    }


    public String getHistory_browsing() {
        return history_browsing;
    }
}
