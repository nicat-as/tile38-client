package com.tile38.client.keys;

import io.lettuce.core.protocol.CommandArgs;

public interface Param<K, V> {
    CommandArgs<K, V> out(CommandArgs<K, V> args);
}
