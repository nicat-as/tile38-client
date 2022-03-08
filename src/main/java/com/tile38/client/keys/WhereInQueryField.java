package com.tile38.client.keys;

import io.lettuce.core.protocol.CommandArgs;

import java.util.Collection;

public class WhereInQueryField implements Param<String, String> {
    private String name;
    private Collection<Double> values;

    public WhereInQueryField name(String name) {
        this.name = name;
        return this;
    }

    public WhereInQueryField values(Collection<Double> values) {
        this.values = values;
        return this;
    }

    @Override
    public CommandArgs<String, String> out(CommandArgs<String, String> args) {
        args.add(name).add(values.size());
        values.forEach(args::add);
        return args;
    }
}
