/*
 * This file is part of the atomic client distribution.
 * Copyright (c) 2021-2021 0x150.
 */

package me.zeroX150.atomic.mixin.game.screen;

import me.zeroX150.atomic.Atomic;
import me.zeroX150.atomic.feature.gui.screen.AltManagerScreen;
import me.zeroX150.atomic.feature.gui.screen.HomeScreen;
import me.zeroX150.atomic.feature.module.impl.client.ClientConfig;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
    public TitleScreenMixin() {
        super(Text.of(""));
    }

    @Inject(method = "init", at = @At("TAIL"))
    public void init(CallbackInfo ci) {
        ButtonWidget alts = new ButtonWidget(1, 22, 130, 20, Text.of("Alt manager"), button -> Atomic.client.setScreen(new AltManagerScreen()));
        ButtonWidget customScreen = new ButtonWidget(1, 1, 130, 20, Text.of("Custom home screen"), button -> {
            ClientConfig.customMainMenu.setValue(true);
            Atomic.client.setScreen(null);
        });
        this.addDrawableChild(alts);
        this.addDrawableChild(customScreen);
    }

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (ClientConfig.customMainMenu.getValue()) {
            ci.cancel();
            Atomic.client.setScreen(new HomeScreen());
        }
    }
}
