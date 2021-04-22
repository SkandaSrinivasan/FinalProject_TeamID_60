/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JxMaps.main;

import Business.EcoSystem;
import JxMaps.main.AppConfig;
import JxMaps.main.Modal.LatLong;
import JxMaps.main.Modal.UsZipCode;
import JxMaps.main.Utils.ZipCodeResolver;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.Component;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Skanda
 */
public class MapMarker {

    private static final int MIN_ZOOM = 0;
    private static final int MAX_ZOOM = 21;
    private static String setMarkerScript = "";
    private static int zoomValue = 4;
    private LatLong currentLatLong;
    JFrame mf;
    EcoSystem business;

    public static String setMarkerOnMap(String lat, String longitude) {
        return "var myLatlng = new google.maps.LatLng(" + lat + "," + longitude + ");\n"
                + "var marker = new google.maps.Marker({\n"
                + "    position: myLatlng,\n"
                + "    map: map,\n"
                + "    title: 'Hello World!'\n"
                + "});";
    }

    public MapMarker(EcoSystem business) {
        Browser browser = createBrowser();

        SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);
//            ZipCodeResolver zipCodeResolver = new ZipCodeResolver();
//            UsZipCode zipDetails = zipCodeResolver.getDetailsForUsZipCode(zipCode);
//            System.out.println(zipDetails);
//            setMarkerScript = setMarkerOnMap(zipDetails.getLatitude(), zipDetails.getLongitude());
//            ################################################

            JButton setMarkerButton = new JButton("Set Marker");
            JButton setAddressButton = new JButton("Save Place");
            setMarkerButton.addActionListener(e
                    -> browser.mainFrame().ifPresent(frame
                            -> frame.executeJavaScript(setMarkerScript)));
            setAddressButton
                    .addActionListener(e -> browser.mainFrame()
                    .ifPresent(frame -> {
                        this.currentLatLong = getLatLngFromGoogleMapsUrl(browser.url());

                        // CALL THIS FUNCTION TO GET LAT LNG
                        business.setTempLocation(getCurrentBrowserLatLng());
                        System.out.println(getCurrentBrowserLatLng());
                    }
                    ));
            JPanel toolBar = createToolBar(Arrays.asList(setMarkerButton, setAddressButton));

            createFrame(toolBar, view);
            browser.navigation().loadUrl("https://www.google.com/maps");
//            browser
//            browser.navigation().loadUrl("file:///" + Paths.get(".").toAbsolutePath().toString()
//                    + "/src/main/java/JxMaps/main/Web/map.html");
        });
        this.business = business;
    }

    public LatLong getCurrentBrowserLatLng() {
        return this.currentLatLong;
    }

    public MapMarker saveMapMarker() {

        Browser browser = createBrowser();

        SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);
//            ZipCodeResolver zipCodeResolver = new ZipCodeResolver();
//            UsZipCode zipDetails = zipCodeResolver.getDetailsForUsZipCode(zipCode);
//            System.out.println(zipDetails);
//            setMarkerScript = setMarkerOnMap(zipDetails.getLatitude(), zipDetails.getLongitude());
//            ################################################

            JButton setMarkerButton = new JButton("Set Marker");
            JButton setAddressButton = new JButton("Save Place");
            setMarkerButton.addActionListener(e
                    -> browser.mainFrame().ifPresent(frame
                            -> frame.executeJavaScript(setMarkerScript)));
            setAddressButton
                    .addActionListener(e -> browser.mainFrame()
                    .ifPresent(frame -> {
                        this.currentLatLong = getLatLngFromGoogleMapsUrl(browser.url());

                        // CALL THIS FUNCTION TO GET LAT LNG
                        business.setTempLocation(getCurrentBrowserLatLng());
                        System.out.println(getCurrentBrowserLatLng());
                        
                    }
                    ));
            JPanel toolBar = createToolBar(Arrays.asList(setMarkerButton, setAddressButton));

            createFrame(toolBar, view);
            browser.navigation().loadUrl("https://www.google.com/maps");

        });
        return this;
    }

    public LatLong getLatLngFromGoogleMapsUrl(String googleMapsUrl) {
        Optional<String> latLongString = Arrays.asList(googleMapsUrl.split("/")).stream().filter(i -> i.startsWith("@")).findFirst();
        if (latLongString.isPresent()) {
            String latLng = latLongString.get().substring(1);
            String[] latLngArr = latLng.split(",");
            return new LatLong(latLngArr[0], latLngArr[1]);
        }
        return new LatLong("40", "40");
    }

    private void createFrame(Component toolBar, Component view) {
        mf = new JFrame("Google Maps");
        mf.add(toolBar, BorderLayout.SOUTH);
        mf.add(view, BorderLayout.CENTER);
        mf.setSize(800, 500);
        mf.setVisible(true);
        mf.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {

            }
        });
    }

    private Browser createBrowser() {
        EngineOptions options
                = EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                        .licenseKey(AppConfig.getInstance().getJXBrowserLicenseKey())
                        .build();
        return Engine.newInstance(options).newBrowser();
    }

    private JPanel createToolBar(List<JButton> buttons) {
        JPanel jpanel = new JPanel();
        buttons.forEach(button -> {
            jpanel.add(button);
        });
        return jpanel;
    }
}
