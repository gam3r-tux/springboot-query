package com.walmart.query;

import java.sql.*;

import org.springframework.stereotype.Service;   

@Service
public class QueryServiceDB2 implements IQueryServiceDB2 {
    public static String url = "jdbc:db2://localhost:50000/testdb";
    public static String user = "db2inst1";
    public static String password = "db2inst1";
    public static String tableName = "testtable";
    public static String sql = "select count(1) c from " + tableName;

    @Override
    public DatabaseInfo getInfo() {
        int c = 0;
        Connection con;
        Statement stmt;
        ResultSet rs;
                
        try 
        {                                                                        
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            con = DriverManager.getConnection (url, user, password);
            stmt = con.createStatement();

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
            c = rs.getInt(1);
            }
            rs.close();
            stmt.close();
            con.close();    
        } catch (ClassNotFoundException e) {
            System.err.println("Could not load JDBC driver");
            System.out.println("Exception: " + e);
            e.printStackTrace();
        } catch(SQLException ex) {
            System.err.println("SQLException information");
            while(ex!=null) {
            System.err.println ("Error msg: " + ex.getMessage());
            System.err.println ("SQLSTATE: " + ex.getSQLState());
            System.err.println ("Error code: " + ex.getErrorCode());
            ex.printStackTrace();
            ex = ex.getNextException();
            }
        }

        return new DatabaseInfo("DB2", tableName, c);
    }
}