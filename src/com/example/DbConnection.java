package com.example;

public class DbConnection {
    private static DbConnection instance;

    private String schema;
    private String dbName;
    private String user;
    private String password;

    public static DbConnection getInstance() {
        if (instance == null){
            instance = new DbConnection();
        }

        return instance;
    }


    public void open(){
        //TODO
    }

    public void close() {
        //TODO
    }

    public boolean isOpen() {
        // TODO
        return false;
    }


}
