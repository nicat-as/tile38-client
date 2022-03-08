package com.tile38.client.keys;

import io.lettuce.core.protocol.CommandArgs;

public class Match implements Param<String, String> {
    private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Match query(String query) {
        this.query = query;
        return this;
    }

    public CommandArgs<String, String> out(CommandArgs<String, String> args) {
        return query == null ? args : args.add("MATCH").add(query);
    }
}
