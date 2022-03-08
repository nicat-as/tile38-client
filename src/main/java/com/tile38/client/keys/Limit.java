package com.tile38.client.keys;

import io.lettuce.core.protocol.CommandArgs;

public class Limit implements Param<String, String> {
    private int limit;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Limit limit(int limit) {
        this.limit = limit;
        return this;
    }

    public CommandArgs<String, String> out(CommandArgs<String, String> args) {
        return args.add("LIMIT").add(limit);
    }
}
