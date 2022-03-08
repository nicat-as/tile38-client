package com.tile38.client.keys;

import io.lettuce.core.protocol.CommandArgs;

public class Circle implements Param<String, String> {
    private Point center;
    private int radius;

    public Circle center(Point center) {
        this.center = center;
        return this;
    }

    public Circle radius(int radius) {
        this.radius = radius;
        return this;
    }

    @Override
    public CommandArgs<String, String> out(CommandArgs<String, String> args) {
        center.out(args);
        return args.add(radius);
    }
}
