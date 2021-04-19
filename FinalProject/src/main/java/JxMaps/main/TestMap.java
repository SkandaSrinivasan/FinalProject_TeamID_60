/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JxMaps.main;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.engine.RenderingMode;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Paths;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author Skanda
 */
public class TestMap {

    // Right click + run file to run this. not part of usual flow
    public static void main(String[] args) {
        System.out.println(AppConfig.getInstance().getGMapsApiKey());
        System.setProperty("jxbrowser.license.key", AppConfig.getInstance().getJXBrowserLicenseKey());
        System.out.println("license done");
        Engine engine = Engine.newInstance(EngineOptions.newBuilder(RenderingMode.HARDWARE_ACCELERATED)
                .googleApiKey(AppConfig.getInstance().getGMapsApiKey())
                .remoteDebuggingPort(9222)
                .build());
        Browser browser = engine.newBrowser();
        // load web page to browser
//        browser.navigation().loadUrl("https://google.com");

        SwingUtilities.invokeLater(() -> {
            // Creating Swing component for rendering web content
            // loaded in the given Browser instance
            BrowserView view = BrowserView.newInstance(browser);

            // Creating and displaying Swing app frame
            JFrame frame = new JFrame("JxBrowser AWT/Swing");
            // Closing the engine when app frame is about to close
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    engine.close();
                }
            });
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(800, 600);
            frame.setVisible(true);

            browser.navigation().loadUrl("file:///"+Paths.get(".").toAbsolutePath().toString()
                    + "/src/main/java/JxMaps/main/map.html");
        });

    }
}
