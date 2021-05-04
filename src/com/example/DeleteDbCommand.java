package com.example;

public class DeleteDbCommand extends DbCommandImpl {
    private static final String DELETE_SQL = "DELETE FROM table_name WHERE id=key";

    private final String table;
    private final String key;

    public DeleteDbCommand(String table, String key) {
        this.table = table;
        this.key = key;
    }


    @Override
    public void execute() {
        changeState(DbCommandState.EXECUTING);
        // TODO Thread to execute query

        changeState(DbCommandState.FINISHED);
    }

    @Override
    public void rollback() {
        changeState(DbCommandState.EXECUTING);
        // TODO Thread to rollback query

        changeState(DbCommandState.FINISHED);
    }
}
