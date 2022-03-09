package com.tile38.client;

import com.tile38.client.command.CommandFSET;
import com.tile38.client.command.CommandSET;
import com.tile38.client.command.Del;
import com.tile38.client.command.Get;

public class QueryBuilder<S extends CommandSET, U extends CommandFSET> {
    S commandSave;
    U commandUpdate;

    public QueryBuilder() {
    }

    public QueryBuilder(S commandSave, U commandUpdate) {
        this.commandSave = commandSave;
        this.commandUpdate = commandUpdate;
    }

    public S track() {
        return commandSave;
    }

    public U fieldSet() {
        return commandUpdate;
    }

    public Get get() {
        return new Get();
    }

    public Del del() {
        return new Del();
    }
}
