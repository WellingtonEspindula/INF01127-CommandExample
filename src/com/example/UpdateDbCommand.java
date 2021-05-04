package com.example;

import java.util.Map;

public class UpdateDbCommand extends DbCommandImpl {
    private static final String UPDATE_SQL = "UPDATE table_name\n" +
            "SET values\n" +
            "WHERE id=key";

    private final String table;
    private final String key;
    private final Map<String, String> values;

    public UpdateDbCommand(String table, String key, Map<String, String> values) {
        this.table = table;
        this.key = key;
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
