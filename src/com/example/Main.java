package com.example;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	    DatabaseAdministrator dbAdmin = new DatabaseAdministrator();
	    dbAdmin.enqueue(new InsertionDbCommand("mTable", new HashMap<>(){{
            put("id", "001");
	        put("name", "Wellington Espindula");
	        put("telephone", "+5551000000000");
        }}));

	    dbAdmin.start();

	    dbAdmin.enqueue(new InsertionDbCommand("mTable", new HashMap<>(){{
	        put("id", "002");
	        put("name", "Fulano Espindula");
	        put("telephone", "+5551000000000");
        }}));

	    dbAdmin.enqueue(new InsertionDbCommand("mTable", new HashMap<>(){{
            put("id", "003");
	        put("name", "Fulano Ciclano");
	        put("telephone", "+5551000000000");
        }}));

	    dbAdmin.enqueue(new UpdateDbCommand("mTable", "003", new HashMap<>(){{
	        put("name", "Fulano Ciclano da Silva");
	        put("telephone", "+55510000000012");
        }}));
    }
}
