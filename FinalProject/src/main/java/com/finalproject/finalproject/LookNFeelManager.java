/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalproject.finalproject;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceAutumnLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceBusinessBlueSteelLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceBusinessLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceCeruleanLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceDustCoffeeLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGeminiLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteElectricLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteSiennaLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceGreenMagicLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceMistAquaLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceModerateLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceNightShadeLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceSaharaLookAndFeel;

/**
 *
 * @author Skanda
 */
public class LookNFeelManager {

    private static LookNFeelManager instance;

    public LookNFeelManager() {

    }

    public static LookNFeelManager getInstance() {
        if (instance == null) {
            instance = new LookNFeelManager();
        }
        return instance;
    }

    public void setNightShadeLF() {
        try {
            UIManager.setLookAndFeel(new SubstanceNightShadeLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDefaultLF() {
        try {
            UIManager.setLookAndFeel(new SubstanceNightShadeLookAndFeel());
        } catch (Exception ex) {
            Logger.getLogger(LookNFeelManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
