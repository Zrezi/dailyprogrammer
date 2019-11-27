package easy;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Challenge366Test {

    private Challenge366 challenge366;
    private List<TestData> standardList;

    @Before
    public void setUp() throws Exception {
        challenge366 = new Challenge366();

        setUpStandardList();
    }

    private void setUpStandardList() {
        standardList = new ArrayList<>();
        standardList.add(new TestData("leave", "eave", true));
        standardList.add(new TestData("reset", "rest", true));
        standardList.add(new TestData("dragoon", "dragon", true));
        standardList.add(new TestData("eave", "leave", false));
        standardList.add(new TestData("sleet", "lets", false));
        standardList.add(new TestData("skiff", "ski", false));
    }

    @Test
    public void testStandard() {
        standardList.forEach(testData -> {
            assertEquals(testData.getResult(), challenge366.funnel(testData.getContainer(), testData.getSearch()));
        });
    }

    private class TestData {

        private String container;
        private String search;
        private Boolean result;

        TestData(String container, String search, Boolean result) {
            this.container = container;
            this.search = search;
            this.result = result;
        }

        String getContainer() {
            return container;
        }

        String getSearch() {
            return search;
        }

        Boolean getResult() {
            return result;
        }

    }

}
