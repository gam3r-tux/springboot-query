package com.walmart.query;

import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class QueryServiceSQL implements IQueryServiceSQL {
    // Azure SQL
    //public static String connectionUrl = "jdbc:sqlserver://srvone.database.windows.net:1433;database=demoDB;user=webusr@srvone;password=m4rd0.CaLa;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    // SQLExpress
    public static String connectionUrl = "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;encrypt=false;databaseName=demoDB;user=sa;password=m4rd0.CaLa";

    public static String tableName = "batchTest";
    public static String sql = "select count(1) c from " + tableName ;

    @Override
    public DatabaseInfo getInfo() {

        int c = 0;

        try (Connection con = DriverManager.getConnection(connectionUrl);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
        ) {            
            while (rs.next()) {
                c = rs.getInt("c");              
             }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return new DatabaseInfo("Azure SQL", tableName, c);
    }
}
