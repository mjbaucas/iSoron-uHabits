/*
 * Copyright (C) 2016 Álinson Santos Xavier <isoron@gmail.com>
 *
 * This file is part of Loop Habit Tracker.
 *
 * Loop Habit Tracker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Loop Habit Tracker is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.isoron.uhabits.utils;

import android.content.*;
import android.content.res.*;
import android.graphics.Color;
import android.graphics.drawable.*;
import android.support.annotation.*;

import org.isoron.uhabits.*;


public class StyledResources
{
    private static Integer fixedTheme;

    private final Context context;

    public StyledResources(@NonNull Context context)
    {
        this.context = context;
    }

    public static void setFixedTheme(Integer theme)
    {
        fixedTheme = theme;
    }

    public boolean getBoolean(@AttrRes int attrId)
    {
        TypedArray ta = getTypedArray(attrId);
        boolean bool = ta.getBoolean(0, false);
        ta.recycle();

        return bool;
    }

    public int getColor(@AttrRes int attrId)
    {
        TypedArray ta = getTypedArray(attrId);
        int color = ta.getColor(0, 0);
        ta.recycle();

        return color;
    }

    public Drawable getDrawable(@AttrRes int attrId)
    {
        TypedArray ta = getTypedArray(attrId);
        Drawable drawable = ta.getDrawable(0);
        ta.recycle();

        return drawable;
    }

    public float getFloat(@AttrRes int attrId)
    {
        TypedArray ta = getTypedArray(attrId);
        float f = ta.getFloat(0, 0);
        ta.recycle();

        return f;
    }

    public int[] getPalette()
    {

        int [] color = {
                Color.parseColor("#D32F2F"), //  0 red
                Color.parseColor("#E64A19"), //  1 orange
                Color.parseColor("#F9A825"), //  2 yellow
                Color.parseColor("#AFB42B"), //  3 light green
                Color.parseColor("#388E3C"), //  4 dark green
                Color.parseColor("#00897B"), //  5 teal
                Color.parseColor("#00ACC1"), //  6 cyan
                Color.parseColor("#039BE5"), //  7 blue
                Color.parseColor("#5E35B1"), //  8 deep purple
                Color.parseColor("#8E24AA"), //  9 purple
                Color.parseColor("#D81B60"), // 10 pink
                Color.parseColor("#303030"), // 11 dark grey
                Color.parseColor("#aaaaaa"), // 12 light grey
                Color.parseColor("#ffd3f9"), // 13 pink
                Color.parseColor("#c0feff"), // 14 light blue
                Color.parseColor("#3b271e"), // 15 brown
                Color.parseColor("#14e9c3"), // 16 weird green
                Color.parseColor("#4f0e0e"), // 17 dark dark red
                Color.parseColor("#ce8d8d"), // 18 light pink
                Color.parseColor("#ce8d8e") // 19 other pink

        };

        return color;
    }

    int getStyleResource(@AttrRes int attrId)
    {
        TypedArray ta = getTypedArray(attrId);

        int resourceId = ta.getResourceId(0, -1);
        ta.recycle();

        return resourceId;
    }

    private TypedArray getTypedArray(@AttrRes int attrId)
    {
        int[] attrs = new int[]{ attrId };

        if (fixedTheme != null)
            return context.getTheme().obtainStyledAttributes(fixedTheme, attrs);

        return context.obtainStyledAttributes(attrs);
    }
}
