package com.example;

import java.util.List;

public class Transaction extends DbCommandImpl {

    List<DbCommand> commands;

    public Transaction(DbCommandStateChangedReceiver receiver, List<DbCommand> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        changeState(DbCommandState.EXECUTING);
        for (DbCommand c : commands) {
            c.execute();
        }
        changeState(DbCommandState.FINISHED);

    }

    @Override
    public void rollback() {
        changeState(DbCommandState.EXECUTING);
        for (DbCommand c : commands) {
            c.rollback();
        }
        changeState(DbCommandState.FINISHED);
    }
}
