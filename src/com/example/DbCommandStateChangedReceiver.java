package com.example;

public interface DbCommandStateChangedReceiver {
    void changedStateAction(DbCommandState newState);
}
