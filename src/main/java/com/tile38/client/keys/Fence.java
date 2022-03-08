package com.tile38.client.keys;

import io.lettuce.core.protocol.CommandArgs;

public class Fence implements Param<String, String> {
    public CommandArgs<String, String> out(CommandArgs<String, String> args) {
        return args.add("FENCE");
    }
}
