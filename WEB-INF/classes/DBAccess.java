import bean.ThreadBean;
import bean.ResBean;
import bean.GenreBean;
import bean.UserBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;

public class DBAccess{
    private static final String DB_CLASS = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_LOGIN = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String DB_USER = "isaka";
    private static final String DB_PASS = "shoji";

    private static Connection getOracleConnection()throws Exception{
        Class.forName(DB_CLASS);
        Connection connection = DriverManager.getConnection(DB_LOGIN, DB_USER, DB_PASS);
        return connection;
    }

    public static void UserInsert(String name, String pass){

        try{
            Connection connection = getOracleConnection();
            String sql = "insert into account values(user_id.nextval, '"+name+"', '"+pass+"')";

            Statement statement = connection.createStatement();
            statement.executeQuery(sql);
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void ResInsert(String text, int th_id, int user_id){

        try{
            Connection connection = getOracleConnection();
            String sql = "insert into res values(res_id.nextval, sysdate, '"+text+"', res_count.nextval, "+th_id+", "+user_id+")";

            Statement statement = connection.createStatement();

            statement.executeQuery(sql);
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void ThreadInsert(String th_title, String th_des, int genre_id, int user_id){
        try{
            Connection connection = getOracleConnection();
            String sql = "insert into thread values(th_id.nextval, '"+th_title+"', sysdate, '"+th_des+"', "+genre_id+", "+user_id+")";

            Statement statement = connection.createStatement();

            statement.executeQuery(sql);
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void GenreInsert(int genre_id, String genre_name){
        try{
            Connection connection = getOracleConnection();

            String sql = "insert into genre values("+genre_id+", '"+genre_name+"')";

            Statement statement = connection.createStatement();

            statement.executeQuery(sql);
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<UserBean> UsersSelect(){
        ArrayList<UserBean> user_tb = new ArrayList<UserBean>();
        try{
            Connection connection = getOracleConnection();

            String sql = "select user_id, user_name, user_pass from account order by user_id asc";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                UserBean user = new UserBean();

                user.setUser_id(Integer.parseInt(resultSet.getString(1)));
                user.setUser_name(resultSet.getString(2));
                user.setUser_pass(resultSet.getString(3));

                user_tb.add(user);
            }
            connection.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return user_tb;
    }

    public static ArrayList<UserBean> UserIdSelect(String user_name, String user_pass){
        ArrayList<UserBean> user_tb = new ArrayList<UserBean>();

        try{
            Connection connection = getOracleConnection();

            String sql = "select user_id, user_name, user_pass from account where user_name = '"+user_name+"' and user_pass = '"+user_pass+"'";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                UserBean user = new UserBean();

                user.setUser_id(Integer.parseInt(resultSet.getString(1)));

                user.setUser_name(resultSet.getString(2));

                user.setUser_pass(resultSet.getString(3));

                user_tb.add(user);
            }
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return user_tb;
    }

    public static ArrayList<UserBean> UserSelect(int user_id){
        ArrayList<UserBean> user_tb = new ArrayList<UserBean>();
        try{
            Connection connection = getOracleConnection();

            String sql = "select user_id, user_name, user_pass from account where user_id = "+user_id+"";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                UserBean user = new UserBean();

                user.setUser_id(Integer.parseInt(resultSet.getString(1)));
                user.setUser_name(resultSet.getString(2));
                user.setUser_pass(resultSet.getString(3));

                user_tb.add(user);
            }
            connection.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return user_tb;
    }

    public static ArrayList<ThreadBean> ThreadsSelect(){
        ArrayList<ThreadBean> thread_tb = new ArrayList<ThreadBean>();

        try{
            Connection connection = getOracleConnection();

            String sql = "select th_id, th_title, th_date, th_description, genre_id, user_id from thread order by th_id desc";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                ThreadBean thre = new ThreadBean();

                thre.setTh_id(Integer.parseInt(resultSet.getString(1)));

                thre.setTh_title(resultSet.getString(2));

                thre.setTh_date(resultSet.getString(3));

                thre.setTh_description(resultSet.getString(4));

                thre.setGenre_id(Integer.parseInt(resultSet.getString(5)));

                thre.setUser_id(Integer.parseInt(resultSet.getString(6)));

                thread_tb.add(thre);
            }
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return thread_tb;

    }

    public static ArrayList<ThreadBean> ThreadSelect(int th_id){
        ArrayList<ThreadBean> thread_tb = new ArrayList<ThreadBean>();

        try{
            Connection connection = getOracleConnection();

            String sql = "select th_id, th_title, th_date, th_description, genre_id, user_id from thread where th_id = "+th_id+"";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                ThreadBean thre = new ThreadBean();

                thre.setTh_id(Integer.parseInt(resultSet.getString(1)));

                thre.setTh_title(resultSet.getString(2));

                thre.setTh_date(resultSet.getString(3));

                thre.setTh_description(resultSet.getString(4));

                thre.setGenre_id(Integer.parseInt(resultSet.getString(5)));

                thre.setUser_id(Integer.parseInt(resultSet.getString(6)));

                thread_tb.add(thre);
            }
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return thread_tb;

    }

    public static ArrayList<ResBean> ResSelect(int th_id){
        ArrayList<ResBean> res_tb = new ArrayList<ResBean>();

        try{
            Connection connection = getOracleConnection();

            String sql = "select res_id, res_date, res_text, res_count, th_id, user_id from res where th_id = "+th_id+" order by res_id desc";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                ResBean resb = new ResBean();

                resb.setRes_id(Integer.parseInt(resultSet.getString(1)));

                resb.setRes_date(resultSet.getString(2));

                resb.setRes_text(resultSet.getString(3));

                resb.setRes_count(Integer.parseInt(resultSet.getString(4)));

                resb.setTh_id(Integer.parseInt(resultSet.getString(5)));

                resb.setUser_id(Integer.parseInt(resultSet.getString(6)));

                res_tb.add(resb);

            }
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return res_tb;

    }

    public static ArrayList<ResBean> ResSearch(int th_id, int res_id){
        ArrayList<ResBean> res_tb = new ArrayList<ResBean>();

        try{
            Connection connection = getOracleConnection();

            String sql = "select res_id, res_date, res_text, res_count, th_id, user_id from res where th_id = "+th_id+" and res_id = "+res_id+"";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                ResBean resb = new ResBean();

                resb.setRes_id(Integer.parseInt(resultSet.getString(1)));

                resb.setRes_date(resultSet.getString(2));

                resb.setRes_text(resultSet.getString(3));

                resb.setRes_count(Integer.parseInt(resultSet.getString(4)));

                resb.setTh_id(Integer.parseInt(resultSet.getString(5)));

                resb.setUser_id(Integer.parseInt(resultSet.getString(6)));

                res_tb.add(resb);

            }
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return res_tb;

    }

    public static ArrayList<GenreBean> GenresSelect(){
        ArrayList<GenreBean> genre_tb = new ArrayList<GenreBean>();
        try{
            Connection connection = getOracleConnection();

            String sql = "select genre_id, genre_name from genre order by genre_id asc";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                GenreBean genreb = new GenreBean();

                genreb.setGenre_id(Integer.parseInt(resultSet.getString(1)));

                genreb.setGenre_name(resultSet.getString(2));


                genre_tb.add(genreb);
            }
            connection.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return genre_tb;
    }

    public static ArrayList<GenreBean> GenresSelect(int genre_id){
        ArrayList<GenreBean> genre_tb = new ArrayList<GenreBean>();
        try{
            Connection connection = getOracleConnection();

            String sql = "select genre_id, genre_name from genre where genre_id = "+genre_id+"";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                GenreBean genreb = new GenreBean();

                genreb.setGenre_id(Integer.parseInt(resultSet.getString(1)));

                genreb.setGenre_name(resultSet.getString(2));


                genre_tb.add(genreb);
            }
            connection.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return genre_tb;
    }








}