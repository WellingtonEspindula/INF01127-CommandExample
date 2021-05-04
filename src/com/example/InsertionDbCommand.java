package com.example;

import java.util.Map;

public class InsertionDbCommand extends DbCommandImpl {
    private static final String INSERTION_SQL = "INSERT INTO table_name VALUES insert_values";

    private final String table;
    private final Map<String, String> values;

    public InsertionDbCommand(String table, Map<String, String> values) {
        this.table = table;
        this.values = values;
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
