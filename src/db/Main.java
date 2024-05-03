package db;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DB20 db20 = null;
        try {
            db20 = new DB20();
//            db20.addMember("aaa", "bbb", "ccc", "ddd", "M", "N");
//            db20.searchMember("ddd");
//            db20.updateMember("aaa", "xxx", "vvv", "nnn", "F", "Y");
//            db20.searchMember("aaa");
//            db20.deleteMember("aaa");
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (db20 != null)
                    db20.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

