package com.tile38.client.keys;

import io.lettuce.core.protocol.CommandArgs;

import java.util.ArrayList;
import java.util.List;

public class Where implements Param<String, String> {
    private List<WhereQueryField> fields = new ArrayList<>();

    public Where field(WhereQueryField field) {
        fields.add(field);
        return this;
    }

    @Override
    public CommandArgs<String, String> out(CommandArgs<String, String> args) {

        if (!fields.isEmpty()) {
            fields.forEach(field -> {
                args.add("WHERE");
                field.out(args);
            });
        }
        return args;
    }
}
