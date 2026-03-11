package utility;

import java.util.Map;
import java.util.TreeMap;

public class GetDiscountPercent {
    private static TreeMap<Double, Integer> bulkDiscountRules = new TreeMap<>();

    public static void addDiscountPercent() {
        bulkDiscountRules.put(2000.0,5);
        bulkDiscountRules.put(5000.0,10);
        bulkDiscountRules.put(10000.0,15);
    }

    public static int getDiscountPercent(double amount) {
        Map.Entry<Double, Integer> entry =
                bulkDiscountRules.floorEntry(amount);

        if (entry == null) {
            return 0;
        }

        return entry.getValue();
    }
}
