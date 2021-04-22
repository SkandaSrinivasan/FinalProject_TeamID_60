/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JxMaps.main;

import JxMaps.main.Modal.LatLong;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.engine.RenderingMode;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Paths;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author Skanda
 */
public class TestMap {

    public static void main(String[] args) {

        MapMarker mapMarker = new MapMarker();
        mapMarker.setMapMarkers(Arrays.asList(
                new LatLong("Bondi Beach", "-33.890542", "151.274856, 4"),
                new LatLong("Coogee Beach", "-34.0282492", "151.157507"),
                new LatLong("Cronulla Beach", "-33.80010128657071", "151.28747820854187")
        ));
    }
}
