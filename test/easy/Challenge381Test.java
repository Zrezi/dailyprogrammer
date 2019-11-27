package easy;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Challenge381Test {

    private Challenge381 challenge381;
    private List<Integer> list1;
    private List<Integer> list2;
    private List<Integer> list3;
    private int[] array1;
    private int[] array2;
    private int[] array3;

    @Before
    public void setUp() {
        challenge381 = new Challenge381();

        setUpLists();
        setUpArrays();
    }

    private void setUpLists() {
        list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(5);
        list1.add(6);

        list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(4);

        list3 = new ArrayList<>();
        list3.add(6);
        list3.add(6);
        list3.add(6);
        list3.add(6);
        list3.add(6);
    }

    private void setUpArrays() {
        array1 = new int[]{2, 3, 5, 5, 6};
        array2 = new int[]{1, 1, 1, 1, 4};
        array3 = new int[]{6, 6, 6, 6, 6};
    }

    @Test
    public void testScoreList() {
        assertEquals(new Integer(10), challenge381.scoreList(list1));
        assertEquals(new Integer(4), challenge381.scoreList(list2));
        assertEquals(new Integer(30), challenge381.scoreList(list3));
    }

    @Test
    public void testScoreArray() {
        assertEquals(10, challenge381.scoreArray(array1));
        assertEquals(4, challenge381.scoreArray(array2));
        assertEquals(30, challenge381.scoreArray(array3));
    }

}
