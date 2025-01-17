/*
 * This file is part of the atomic client distribution.
 * Copyright (c) 2021-2021 0x150.
 */

package me.zeroX150.atomic.feature.gui.clickgui;

import java.awt.Color;

public class Themes {
    public static Themes.Palette currentActiveTheme = Themes.Theme.ATOMIC.getPalette();
    public enum Theme {
        ATOMIC(
                new Palette(
                        new Color(17, 17, 17, 220),
                        new Color(40, 40, 40, 220),
                        new Color(0, 194, 111, 220),
                        new Color(38, 38, 38, 255),
                        new Color(49, 49, 49, 255),
                        Color.WHITE, Color.WHITE, 4, 2, true, 9)),
        SIGMA(
                new Palette(
                        new Color(0xfafafa),
                        new Color(0x28a6fc),
                        new Color(0x28a6fc),
                        new Color(0xf2f2f2),
                        new Color(0xf2f2f2),
                        new Color(10, 10, 10),
                        new Color(0x7d7d7d),
                        4, 0, false, 14)),
        DARK(
                new Palette(
                        new Color(10, 10, 10, 220),
                        new Color(30, 30, 30, 220),
                        new Color(255, 255, 255, 220),
                        new Color(20, 20, 20, 255),
                        new Color(25, 25, 25, 255),
                        Color.WHITE, Color.WHITE, 4, 1, true, 9)
        );
        final Palette p;

        Theme(Palette palette) {
            this.p = palette;
        }

        public Palette getPalette() {
            return p;
        }
    }

    public static record Palette(Color inactive, Color active, Color l_highlight, Color h_ret, Color h_exp,
                                 Color fontColor, Color titleColor, double h_margin, double h_paddingX,
                                 boolean centerText, double titleHeight) {

    }
}
