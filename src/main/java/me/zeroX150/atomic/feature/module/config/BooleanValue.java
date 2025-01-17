/*
 * This file is part of the atomic client distribution.
 * Copyright (c) 2021-2021 0x150.
 */

package me.zeroX150.atomic.feature.module.config;

public class BooleanValue extends DynamicValue<Boolean> {
    public BooleanValue(String key, boolean value) {
        super(key, value);
    }

    @Override
    public void setValue(Object value) {
        if (!(value instanceof Boolean)) return;
        this.value = (Boolean) value;
        onValueChanged();
    }
}
