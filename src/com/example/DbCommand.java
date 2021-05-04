package com.example;

public interface DbCommand {
    void execute();
    void rollback();
    void setReceiver(DbCommandStateChangedReceiver receiver);
}
