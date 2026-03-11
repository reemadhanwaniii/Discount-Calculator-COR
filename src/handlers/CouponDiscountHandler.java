package handlers;

import models.Order;
import utility.GetCouponDiscountPercent;
import utility.GetDiscountPercent;

public class CouponDiscountHandler implements ApplyDiscountHandler{

    private ApplyDiscountHandler nextHandler;

    public CouponDiscountHandler(ApplyDiscountHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    @Override
    public void applyDiscount(Order order) {
        String couponCode = order.getCouponCode().orElse(null);
        if(couponCode != null) {
            int discountPercent = GetCouponDiscountPercent.getCouponDiscount(couponCode);

            if(discountPercent != 0) {
                double tmp = (order.getPayableAmount()*discountPercent)/100.0;
                order.setDiscountAmount(order.getDiscountAmount() + tmp);
                order.setPayableAmount(order.getPayableAmount() - tmp);
            }
        }

        this.nextHandler.applyDiscount(order);
    }
}
