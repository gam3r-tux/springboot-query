package com.walmart.query;

public class DatabaseInfo {

    public String databaseName;

    public String tableName;

    public int rows;

    public DatabaseInfo (String dbName, String tabName, int num) {
        this.databaseName = dbName;
        this.tableName = tabName;
        this.rows = num;
    }

    public void setDatabaseName(String name) {
        this.databaseName = name;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setTableName(String name) {
        this.tableName = name;
    }

    public String getTableName() {
        return tableName;
    }

    public void setRows(int num) {
        this.rows = num;
    }

    public int getRows() {
        return rows;
    }
}
