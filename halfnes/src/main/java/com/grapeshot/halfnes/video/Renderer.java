/*
 * HalfNES by Andrew Hoffman
 * Licensed under the GNU GPL Version 3. See LICENSE file
 */
package com.grapeshot.halfnes.video;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/**
 *
 * @author Andrew
 */
public abstract class Renderer {

    int frame_width;
    /*
    there's stuff involving this variable that's much uglier
    than it needs to be because of me not really remembering
    how abstract classes work
     */
    int clip = 8;
    int height = 240 - 2 * clip;
    Bitmap[] imgs = {null, null, null, null};
    int imgctr = 0;

    protected final void init_images() {
        for (int i = 0; i < imgs.length; ++i) {
            imgs[i] = Bitmap.createBitmap(frame_width, height, Config.ARGB_8888);
        }
    }

    public abstract Bitmap render(int[] nespixels, int[] bgcolors, boolean dotcrawl);

    public void setClip(int i) {
        //how many lines to clip from top + bottom
        clip = i;
        height = 240 - 2 * clip;
    }

    public Bitmap getBufferedImage(int[] frame) {
        final Bitmap image = imgs[++imgctr % imgs.length];
        int[] pixels = new int[image.getWidth() * image.getHeight()];
        image.getPixels(pixels, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
        System.arraycopy(frame, frame_width * clip, pixels, 0, frame_width * height);
        return image;
    }

}
