package easy;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Challenge16Test {

    private Challenge16 challenge16;
    private HashMap<String, String[]> standardMap;

    @Before
    public void setUp() throws Exception {
        challenge16 = new Challenge16();

        setUpStandardMap();
    }

    private void setUpStandardMap() {
        standardMap = new HashMap<>();
        standardMap.put("DlyPrgrmmr", new String[] { "Daily Programmer", "aeiou " });
    }

    @Test
    public void testStandard() {
        for (Map.Entry<String, String[]> entry : standardMap.entrySet()) {
            String[] inputs = entry.getValue();
            assertEquals(entry.getKey(), challenge16.removeSecondCharactersFromFirst(inputs[0], inputs[1]));
        }
    }
}
