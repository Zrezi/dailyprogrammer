package hard;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Challenge3Test {

    Challenge3 challenge3;

    @Before
    public void setUp() {
        challenge3 = new Challenge3();
    }

    @Test
    public void test() {
        Map<String, String> expectedResult = new HashMap<>();
        expectedResult.put("nalraoci", "carolina");
        expectedResult.put("amrhat", "martha");
        expectedResult.put("sleewa", "weasel");
        expectedResult.put("iferkna", "frankie");
        expectedResult.put("iragoge", "georgia");
        expectedResult.put("mkeart", "market");
        expectedResult.put("edcudls", "cuddles");
        expectedResult.put("nsdeuto", "notused");
        expectedResult.put("usrlsle", "russell");
        expectedResult.put("inknsy", "skinny");
        
        assertEquals(expectedResult, challenge3.bruteForce());
    }

}