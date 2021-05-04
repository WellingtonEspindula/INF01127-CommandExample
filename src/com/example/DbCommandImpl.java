package com.example;

public abstract class DbCommandImpl implements DbCommand {
    private final DbConnection connection;
    private DbCommandStateChangedReceiver receiver;
    private DbCommandState state;

    public DbCommandImpl() {
        this.state = DbCommandState.NOT_STARTED;
        this.connection = DbConnection.getInstance();
    }

    protected void changeState(DbCommandState newState) {
        this.state = newState;
        receiver.changedStateAction(newState);
    }

    public void setReceiver(DbCommandStateChangedReceiver receiver) {
        this.receiver = receiver;
    }

}
