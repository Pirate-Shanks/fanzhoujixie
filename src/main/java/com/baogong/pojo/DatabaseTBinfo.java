package com.baogong.pojo;

public class DatabaseTBinfo {
    private int id;
    private String tableName;
    private int tableInfo;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getTableInfo() {
        return tableInfo;
    }

    public void setTableInfo(int tableInfo) {
        this.tableInfo = tableInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
