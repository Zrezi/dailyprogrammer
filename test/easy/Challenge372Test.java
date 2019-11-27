package easy;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Challenge372Test {

    private Challenge372 challenge372;
    private HashMap<String, Boolean> standardMap;
    private HashMap<String, Boolean> bonusMap;

    @Before
    public void setUp() throws Exception {
        challenge372 = new Challenge372();

        initializeStandardMap();
        initializeBonusMap();
    }

    private void initializeStandardMap() {
        standardMap = new HashMap<>();
        standardMap.put("xxxyyy", true);
        standardMap.put("yyyxxx", true);
        standardMap.put("xxxyyyy", false);
        standardMap.put("yyxyxxyxxyyyyxxxyxyx", true);
        standardMap.put("xyxxxxyyyxyxxyxxyy", false);
        standardMap.put("", true);
        standardMap.put("x", false);
    }

    private void initializeBonusMap() {
        bonusMap = new HashMap<>();
        bonusMap.put("xxxyyyzzz", true);
        bonusMap.put("abccbaabccba", true);
        bonusMap.put("xxxyyyzzzz", false);
        bonusMap.put("abcdefghijklmnopqrstuvwxyz", true);
        bonusMap.put("pqq", false);
        bonusMap.put("fdedfdeffeddefeeeefddf", false);
        bonusMap.put("www", true);
        bonusMap.put("x", true);
        bonusMap.put("", true);
    }

    @Test
    public void testStandard() {
        for (Map.Entry<String, Boolean> entry : standardMap.entrySet()) {
            assertEquals(entry.getValue(), challenge372.isBalancedStandard(entry.getKey()));
        }
    }

    @Test
    public void testBonus() {
        for (Map.Entry<String, Boolean> entry : bonusMap.entrySet()) {
            assertEquals(entry.getValue(), challenge372.isBalancedBonus(entry.getKey()));
        }
    }
}
