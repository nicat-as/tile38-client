package com.tile38.client.keys;

import io.lettuce.core.protocol.CommandArgs;

public abstract class Field<K, V> {
    protected Double value;

    public abstract String getName();

    public Field<K, V> value(Double value) {
        this.value = value;
        return this;
    }

    public CommandArgs<K, V> out(CommandArgs<K, V> args) {
        return args
                .add("FIELD")
                .add(this.getName())
                .add(value);
    }
}
