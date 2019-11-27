package intermediate;

import java.util.HashMap;
import java.util.Map;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * You're a regional manager for an office beverage sales company, and right
 * now you're in charge of paying your sales team their monthly commissions.
 * <p>
 * Sales people get paid using the following formula for the total
 * commissions: commission is 6.2% of profit, with no commission for any
 * product to total less than zero.
 */
class Challenge365 {

    static class EmployeeInfo {

        private static final double COMMISSION_RATE = 0.062;

        private Map<String, Integer> revenue;
        private Map<String, Integer> expenses;

        EmployeeInfo() {
            this.revenue = new HashMap<>();
            this.expenses = new HashMap<>();
        }

        EmployeeInfo addRevenue(String name, Integer cost) {
            revenue.put(name, cost);
            return this;
        }

        EmployeeInfo addExpense(String name, Integer cost) {
            expenses.put(name, cost);
            return this;
        }

        int calculateCommission() {
            int totalProfit = 0;
            for (String item : revenue.keySet()) {
                int itemProfit = revenue.get(item) - expenses.get(item);
                totalProfit += Math.max(itemProfit, 0);
            }
            return (int) (totalProfit * COMMISSION_RATE);
        }

    }

}
