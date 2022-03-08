package com.tile38.client.keys;

import com.tile38.client.enumeration.OperationEnum;
import io.lettuce.core.protocol.CommandArgs;

import static com.tile38.client.enumeration.OperationEnum.GREATER;

public class WhereQueryField implements Param<String, String> {
    private String name;
    private Double value;
    private OperationEnum op;

    public WhereQueryField name(String name) {
        this.name = name;
        return this;
    }

    public WhereQueryField value(Double value) {
        this.value = value;
        return this;
    }

    public WhereQueryField op(OperationEnum op) {
        this.op = op;
        return this;
    }

    @Override
    public CommandArgs<String, String> out(CommandArgs<String, String> args) {
        if (op == GREATER) {
            args.add(name).add(value).add(op.getValue());
        } else {
            args.add(name).add(op.getValue()).add(value);
        }
        return args;
    }
}
