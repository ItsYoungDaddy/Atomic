/*
 * This file is part of the atomic client distribution.
 * Copyright (c) 2021. 0x150 and contributors
 */

package me.zeroX150.atomic.feature.command.impl;

import me.zeroX150.atomic.feature.command.Command;

public class Test extends Command {
    public Test() {
        super("Test", "amogus sus", "among", "sus", "test");
    }

    @Override
    public void onExecute(String[] args) {
    }
}
