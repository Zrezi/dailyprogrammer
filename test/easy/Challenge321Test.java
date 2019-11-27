package easy;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Challenge321Test {

    private Challenge321 challenge321;
    private HashMap<String, String> standardMap;

    @Before
    public void setUp() throws Exception {
        challenge321 = new Challenge321();

        setUpStandardMap();
    }

    private void setUpStandardMap() {
        standardMap = new HashMap<>();
        standardMap.put("00:00", "It's twelve am");
        standardMap.put("01:30", "It's one thirty am");
        standardMap.put("12:05", "It's twelve oh five pm");
        standardMap.put("14:01", "It's two oh one pm");
        standardMap.put("20:29", "It's eight twenty nine pm");
        standardMap.put("21:00", "It's nine pm");
    }

    @Test
    public void testStandard() {
        for (Map.Entry<String, String> entry : standardMap.entrySet()) {
            assertEquals(entry.getValue(), challenge321.convertTimeIntoWords(entry.getKey()));
        }
    }
}
