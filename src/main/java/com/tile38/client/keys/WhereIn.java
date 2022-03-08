package com.tile38.client.keys;

import io.lettuce.core.protocol.CommandArgs;

import java.util.ArrayList;
import java.util.List;

public class WhereIn implements Param<String, String> {
    private List<WhereInQueryField> fields = new ArrayList<>();

    public WhereIn field(WhereInQueryField field) {
        fields.add(field);
        return this;
    }

    @Override
    public CommandArgs<String, String> out(CommandArgs<String, String> args) {

        if (!fields.isEmpty()) {
            fields.forEach(field -> {
                args.add("WHEREIN");
                field.out(args);
            });
        }
        return args;
    }
}
