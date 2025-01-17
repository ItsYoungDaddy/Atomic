/*
 * This file is part of the atomic client distribution.
 * Copyright (c) 2021-2021 0x150.
 */

package me.zeroX150.atomic.feature.module.impl.world;

import com.google.common.collect.Lists;
import me.zeroX150.atomic.Atomic;
import me.zeroX150.atomic.feature.module.Module;
import me.zeroX150.atomic.feature.module.ModuleType;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class XRAY extends Module {
    public static final List<Block> blocks = Lists.newArrayList();

    public XRAY() {
        super("XRAY", "\"yea hold on im going mining rq\"", ModuleType.WORLD);
        Registry.BLOCK.forEach(block -> {
            if (blockApplicable(block)) blocks.add(block);
        });
    }

    boolean blockApplicable(Block block) {
        boolean c1 = block == Blocks.CHEST || block == Blocks.FURNACE || block == Blocks.END_GATEWAY || block == Blocks.COMMAND_BLOCK || block == Blocks.ANCIENT_DEBRIS;
        boolean c2 = block instanceof OreBlock || block instanceof RedstoneOreBlock;
        return c1 || c2;
    }

    @Override
    public void tick() {

    }

    @Override
    public void enable() {
        Atomic.client.worldRenderer.reload();
    }

    @Override
    public void disable() {
        Atomic.client.worldRenderer.reload();
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

