/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JxMaps.main.Utils;

import JxMaps.main.Modal.LatLong;
import JxMaps.main.Modal.UsZipCode;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author Skanda
 */
public class ZipCodeResolver {

    private static final String ZIP_CODE_FILENAME = "us-zip-code-latitude-and-longitude.csv";
    private static List<UsZipCode> beans = new LinkedList();
    private static Map<String, UsZipCode> zipCodeToDetailsMap = new HashMap();

    static {
        Reader reader = new InputStreamReader(ZipCodeResolver.class.getClassLoader().getResourceAsStream(ZIP_CODE_FILENAME));
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();

        beans = new CsvToBeanBuilder(reader)
                .withSeparator(';')
                .withSkipLines(1)
                .withType(UsZipCode.class)
                .build()
                .parse();

        zipCodeToDetailsMap = beans.stream().collect(
                Collectors.toMap(UsZipCode::getZipCode, Function.identity()));
        beans.clear();

    }

    public Map<String, UsZipCode> getZipCodeToDetailsMap() {
        return zipCodeToDetailsMap;
    }

    public UsZipCode getDetailsForUsZipCode(String zipCode) {
        if (!zipCodeToDetailsMap.containsKey(zipCode)) {
            return null;
        }

        return zipCodeToDetailsMap.get(zipCode);
    }

    public LatLong getLatitudeLongitudeForZipCode(String zipCode) {
        UsZipCode usZip = getDetailsForUsZipCode(zipCode);
        if (usZip == null) {
            return null;
        }
        return new LatLong(usZip.getLatitude(), usZip.getLongitude());
    }

}
