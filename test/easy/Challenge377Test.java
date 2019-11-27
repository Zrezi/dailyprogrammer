package easy;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Challenge377Test {

    private Challenge377 challenge377;
    private HashMap<Integer, List<Integer>> fit1Map;
    private HashMap<Integer, List<Integer>> fit2Map;
    private HashMap<Integer, List<Integer>> fit3Map;
    private HashMap<Integer, List<int[]>> fitNMap;

    @Before
    public void setUp() throws Exception {
        challenge377 = new Challenge377();

        setUpMaps();
    }

    private void setUpMaps() {
        fit1Map = new HashMap<>();
        fit1Map.put(12, Arrays.asList(25, 18, 6, 5));
        fit1Map.put(100, Arrays.asList(10, 10, 1, 1));
        fit1Map.put(10, Arrays.asList(12, 34, 5, 6));
        fit1Map.put(5676, Arrays.asList(12345, 678910, 1112, 1314));
        fit1Map.put(0, Arrays.asList(5, 100, 6, 1));

        fit2Map = new HashMap<>();
        fit2Map.put(15, Arrays.asList(25, 18, 6, 5));
        fit2Map.put(12, Arrays.asList(12, 34, 5, 6));
        fit2Map.put(5676, Arrays.asList(12345, 678910, 1112, 1314));
        fit2Map.put(2, Arrays.asList(5, 5, 3, 2));
        fit2Map.put(80, Arrays.asList(5, 100, 6, 1));
        fit2Map.put(0, Arrays.asList(5, 5, 6, 1));

        fit3Map = new HashMap<>();
        fit3Map.put(1000, Arrays.asList(10, 10, 10, 1, 1, 1));
        fit3Map.put(32, Arrays.asList(12, 34, 56, 7, 8, 9));
        fit3Map.put(32604, Arrays.asList(123, 456, 789, 10, 11, 12));
        fit3Map.put(174648, Arrays.asList(1234567, 89101112, 13141516, 171819, 202122, 232425));

        fitNMap = new HashMap<>();
        fitNMap.put(6, Arrays.asList(new int[] { 3, 4 }, new int[] { 1, 2 }));
        fitNMap.put(32604, Arrays.asList(new int[] { 123, 456, 789 }, new int[] { 10, 11, 12 }));
        fitNMap.put(1883443968, Arrays.asList(new int[]{ 123, 456, 789, 1011, 1213, 1415 }, new int[]{ 16, 17, 18, 19, 20, 21 }));
    }

    @Test
    public void testFit1() {
        for (Map.Entry<Integer, List<Integer>> entry : fit1Map.entrySet()) {
            List<Integer> list = entry.getValue();
            assertEquals((int) entry.getKey(), challenge377.fit1(list.get(0), list.get(1), list.get(2), list.get(3)));
        }
    }

    @Test
    public void testFit2() {
        for (Map.Entry<Integer, List<Integer>> entry : fit2Map.entrySet()) {
            List<Integer> list = entry.getValue();
            assertEquals((int) entry.getKey(), challenge377.fit2(list.get(0), list.get(1), list.get(2), list.get(3)));
        }
    }

    @Test
    public void testFit3() {
        for (Map.Entry<Integer, List<Integer>> entry : fit3Map.entrySet()) {
            List<Integer> list = entry.getValue();
            assertEquals((int) entry.getKey(), challenge377.fit3(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)));
        }
    }

    @Test
    public void testFitN() {
        for (Map.Entry<Integer, List<int[]>> entry : fitNMap.entrySet()) {
            List<int[]> list = entry.getValue();
            assertEquals((int) entry.getKey(), challenge377.fitN(list.get(0), list.get(1)));
        }
    }

}
