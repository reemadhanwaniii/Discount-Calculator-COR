package utility;


import java.util.HashMap;
import java.util.Map;

public class GetCouponDiscountPercent {


    private static Map<String, Integer> couponDiscounts = new HashMap<>();

    public static void addDiscountCoupons() {
        couponDiscounts.put("WELCOME10", 10);
        couponDiscounts.put("FESTIVE20", 20);
        couponDiscounts.put("NEWUSER15", 15);
    }

    public static int getCouponDiscount(String couponCode) {
        return couponDiscounts.getOrDefault(couponCode,0);
    }

}
