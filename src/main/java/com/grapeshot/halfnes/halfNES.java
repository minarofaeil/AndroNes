/*
 * HalfNES by Andrew Hoffman
 * Licensed under the GNU GPL Version 3. See LICENSE file
 */
package com.grapeshot.halfnes;

import com.grapeshot.halfnes.ui.SwingUI;

import java.io.*;
import javax.swing.*;

public class halfNES {

    private halfNES() {}

    public static void main(String[] args) throws IOException {
        JInputHelper.setupJInput();
        new SwingUI(args);
    }

}
