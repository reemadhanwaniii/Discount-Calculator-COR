import enums.UserType;
import factories.CreateDiscountHandler;
import handlers.ApplyDiscountHandler;
import models.Order;
import utility.GetCouponDiscountPercent;
import utility.GetDiscountPercent;

public class Main {
    static void main(String[] args) {
        GetCouponDiscountPercent.addDiscountCoupons();
        GetDiscountPercent.addDiscountPercent();

        Order o1 = new Order(1000, UserType.REGULAR);
        Order o2 = new Order(10000,UserType.PREMIUM);
        Order o3 = new Order(5000,UserType.REGULAR,"WELCOME10");

        ApplyDiscountHandler handler = CreateDiscountHandler.createDiscountHandler();
        handler.applyDiscount(o1);
        handler.applyDiscount(o2);
        handler.applyDiscount(o3);

    }
}