package com.tile38.client.command;

import com.tile38.client.keys.Point;
import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.protocol.CommandArgs;

public class CommandSET extends CommandBaseFSET<String, String, CommandSET> {
    private Point point;

    public CommandSET point(Point point) {
        this.point = point;
        return this;
    }

    @Override
    public CommandArgs<String, String> build(RedisCodec<String, String> codec) {
        CommandArgs<String, String> args = super.build(codec);

        if (point != null) {
            point.out(args);
        }

        return args;
    }
}
