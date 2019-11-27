package easy;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Challenge217Test {

    private Challenge217 challenge217;
    private HashMap<int[][], TestData> standardMap;

    @Before
    public void setUp() throws Exception {
        challenge217 = new Challenge217();

        setUpStandardMap();
    }

    private void setUpStandardMap() {
        standardMap = new HashMap<>();
        standardMap.put(new int[][] { { 3, 2, 2 }, { 2, 2, 3 }, { 2, 4, 2 } }, new TestData(7, new int[][] { { 1, 1, 1 }, { 2, 1, 3 }, { 1, 4, 1 } }));
    }

    @Test
    public void testStandard() {
        for (Map.Entry<int[][], TestData> entry : standardMap.entrySet()) {
            int[][] expected = entry.getKey();
            TestData testData = entry.getValue();
            int[][] actual = challenge217.logs(testData.getLogsToPlace(), testData.getGrid());
            for (int i = 0; i < expected.length; i++) {
                for (int j = 0; j < expected.length; j++) {
                    assertEquals(expected[i][j], actual[i][j]);
                }
            }
        }
    }

    private class TestData {

        private int logsToPlace;
        private int[][] grid;

        TestData(int logsToPlace, int[][] grid) {
            this.logsToPlace = logsToPlace;
            this.grid = grid;
        }

        int getLogsToPlace() {
            return logsToPlace;
        }

        int[][] getGrid() {
            return grid;
        }

    }
}
