package intermediate;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Challenge365Test {

    private static final String TEA = "tea";
    private static final String COFFEE = "coffee";
    private static final String WATER = "water";
    private static final String MILK = "milk";

    private Map<Integer, Challenge365.EmployeeInfo> employeeInfoMap;

    @Before
    public void setUp() throws Exception {
        employeeInfoMap = new HashMap<>();

        Challenge365.EmployeeInfo johnver = new Challenge365.EmployeeInfo();
        johnver.addRevenue(TEA, 190).addExpense(TEA, 120)
                .addRevenue(COFFEE, 325).addExpense(COFFEE, 300)
                .addRevenue(WATER, 682).addExpense(WATER, 50)
                .addRevenue(MILK, 829).addExpense(MILK, 67);
        employeeInfoMap.put(92, johnver);

        Challenge365.EmployeeInfo vanston = new Challenge365.EmployeeInfo();
        vanston.addRevenue(TEA, 140).addExpense(TEA, 65)
                .addRevenue(COFFEE, 19).addExpense(COFFEE, 10)
                .addRevenue(WATER, 14).addExpense(WATER, 299)
                .addRevenue(MILK, 140).addExpense(MILK, 254);
        employeeInfoMap.put(5, vanston);

        Challenge365.EmployeeInfo danbree = new Challenge365.EmployeeInfo();
        danbree.addRevenue(TEA, 1926).addExpense(TEA, 890)
                .addRevenue(COFFEE, 293).addExpense(COFFEE, 23)
                .addRevenue(WATER, 852).addExpense(WATER, 1290)
                .addRevenue(MILK, 609).addExpense(MILK, 89);
        employeeInfoMap.put(113, danbree);

        Challenge365.EmployeeInfo vansey = new Challenge365.EmployeeInfo();
        vansey.addRevenue(TEA, 14).addExpense(TEA, 54)
                .addRevenue(COFFEE, 1491).addExpense(COFFEE, 802)
                .addRevenue(WATER, 56).addExpense(WATER, 12)
                .addRevenue(MILK, 120).addExpense(MILK, 129);
        employeeInfoMap.put(45, vansey);

        Challenge365.EmployeeInfo mundyke = new Challenge365.EmployeeInfo();
        mundyke.addRevenue(TEA, 143).addExpense(TEA, 430)
                .addRevenue(COFFEE, 162).addExpense(COFFEE, 235)
                .addRevenue(WATER, 659).addExpense(WATER, 145)
                .addRevenue(MILK, 87).addExpense(MILK, 76);
        employeeInfoMap.put(32, mundyke);
    }

    @Test
    public void testCommission() {
        for (Map.Entry<Integer, Challenge365.EmployeeInfo> entry : employeeInfoMap.entrySet()) {
            assertEquals((int) entry.getKey(), entry.getValue().calculateCommission());
        }
    }
}
