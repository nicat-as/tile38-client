package com.tile38.client.command;

import com.tile38.client.keys.*;
import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.protocol.CommandArgs;

import java.util.List;

public class Nearby implements BaseCommand<String, String> {
    private List<Detect> detect;
    private Fence fence;
    private Param<String, String> shape;
    private Limit limit;
    private WhereIn whereIn;
    private Where where;
    private Match match;

    public Nearby detect(List<Detect> detect) {
        this.detect = detect;
        return this;
    }

    public Nearby fence(Fence fence) {
        this.fence = fence;
        return this;
    }

    public Nearby limit(Limit limit) {
        this.limit = limit;
        return this;
    }

    public Nearby shape(Param<String, String> shape) {
        this.shape = shape;
        return this;
    }

    public Nearby whereIn(WhereIn whereIn) {
        this.whereIn = whereIn;
        return this;
    }

    public Nearby where(Where where) {
        this.where = where;
        return this;
    }

    public Nearby match(Match match) {
        this.match = match;
        return this;
    }

    @Override
    public CommandArgs<String, String> build(RedisCodec<String, String> codec) {
        CommandArgs<String, String> args = new CommandArgs<>(codec)
                .add("fleet");

        if (match != null) {
            match.out(args);
        }

        if (whereIn != null) {
            whereIn.out(args);
        }

        if (where != null) {
            where.out(args);
        }

        if (fence != null) {
            fence.out(args);
        }

        if (shape != null) {
            shape.out(args);
        }

        if (limit != null) {
            limit.out(args);
        }

        return args;
    }
}
