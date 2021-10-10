/*
 * This file is part of the atomic client distribution.
 * Copyright (c) 2021. 0x150 and contributors
 */

package me.zeroX150.atomic.feature.module.impl.movement;

import me.zeroX150.atomic.feature.module.Module;
import me.zeroX150.atomic.feature.module.ModuleType;
import net.minecraft.client.util.math.MatrixStack;

public class NoLevitation extends Module {
    public NoLevitation() {
        super("No Levitation", "Dont care, keep malding", ModuleType.MOVEMENT);
    }

    @Override
    public void tick() {

    }

    @Override
    public void enable() {

    }

    @Override
    public void disable() {

    }

    @Override
    public String getContext() {
        return null;
    }

    @Override
    public void onWorldRender(MatrixStack matrices) {

    }

    @Override
    public void onHudRender() {

    }
}

