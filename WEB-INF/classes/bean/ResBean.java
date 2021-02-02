package bean;

public class ResBean {
    private int th_id;
    private int user_id;
    private int res_id;
    private int res_count;
    private String res_date;
    private String res_text;

    public void setTh_id(int th_id) {
        this.th_id = th_id;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }


    public void setRes_date(String res_date) {
        this.res_date = res_date;
    }


    public void setRes_text(String res_text) {
        this.res_text = res_text;
    }


    public void setRes_count(int res_count) {
        this.res_count = res_count;
    }


    public int getTh_id() {
        return th_id;
    }


    public int getUser_id() {
        return user_id;
    }


    public int getRes_id() {
        return res_id;
    }


    public String getRes_date() {
        return res_date;
    }


    public String getRes_text() {
        return res_text;
    }


    public int getRes_count() {
        return res_count;
    }
}
