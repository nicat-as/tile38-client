package com.tile38.client.keys;

import io.lettuce.core.protocol.CommandArgs;

public class Point implements Param<String, String> {
    private Double x;
    private Double y;
    private Double z;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public Point x(Double x) {
        this.x = x;
        return this;
    }

    public Point y(Double y) {
        this.y = y;
        return this;
    }

    public Point z(Double z) {
        this.z = z;
        return this;
    }

    @Override
    public CommandArgs<String, String> out(CommandArgs<String, String> args) {
        return args
                .add("POINT")
                .add(x)
                .add(y);
    }
}
