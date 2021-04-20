/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JxMaps.main;

import JxMaps.main.AppConfig;
import JxMaps.main.Modal.UsZipCode;
import JxMaps.main.Utils.ZipCodeResolver;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.BorderLayout;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Skanda
 */
public class MapMarker {

    private static final int MIN_ZOOM = 0;
    private static final int MAX_ZOOM = 21;
    private static String setMarkerScript
            = "var myLatlng = new google.maps.LatLng(48.4431727,23.0488126);\n"
            + "var marker = new google.maps.Marker({\n"
            + "    position: myLatlng,\n"
            + "    map: map,\n"
            + "    title: 'Hello World!'\n"
            + "});";

    private static int zoomValue = 4;

    public static String setMarkerOnMap(String lat, String longitude) {
        return "var myLatlng = new google.maps.LatLng(" + lat + "," + longitude + ");\n"
                + "var marker = new google.maps.Marker({\n"
                + "    position: myLatlng,\n"
                + "    map: map,\n"
                + "    title: 'Hello World!'\n"
                + "});";
    }

    public MapMarker(String zipCode) {
            EngineOptions options
                = EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                        .licenseKey(AppConfig.getInstance().getJXBrowserLicenseKey())
                        .build();
            System.out.println(AppConfig.getInstance().getJXBrowserLicenseKey());
        Engine engine = Engine.newInstance(options);
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);

            JButton zoomInButton = new JButton("Zoom In");
//            ############## USAGE  ##########################
            ZipCodeResolver zipCodeResolver = new ZipCodeResolver();
            UsZipCode zipDetails = zipCodeResolver.getDetailsForUsZipCode(zipCode);
            System.out.println(zipDetails);
            setMarkerScript = setMarkerOnMap(zipDetails.getLatitude(), zipDetails.getLongitude());
//            ################################################

            JButton setMarkerButton = new JButton("Set Marker");
            setMarkerButton.addActionListener(e
                    -> browser.mainFrame().ifPresent(frame
                            -> frame.executeJavaScript(setMarkerScript)));

            JPanel toolBar = new JPanel();
            toolBar.add(setMarkerButton);

            JFrame frame = new JFrame("Google Maps");
            frame.add(toolBar, BorderLayout.SOUTH);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(800, 500);
            frame.setVisible(true);

            browser.navigation().loadUrl("file:///" + Paths.get(".").toAbsolutePath().toString()
                    + "/src/main/java/JxMaps/main/Web/map.html");
        });

    }
}
