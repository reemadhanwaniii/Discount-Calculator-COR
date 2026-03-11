package handlers;

import enums.DiscountType;
import models.Order;
import utility.GetDiscountPercent;

public class BulkDiscountHandler implements ApplyDiscountHandler{

    private ApplyDiscountHandler nextHandler;

    public BulkDiscountHandler(ApplyDiscountHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void applyDiscount(Order order) {
        int discountPercent = GetDiscountPercent.getDiscountPercent(order.getPayableAmount());
        if(discountPercent != 0){
            order.getAppliedDiscounts().add(DiscountType.BULK);
            double tmp = (order.getPayableAmount() * discountPercent)/100.0;
            order.setPayableAmount(order.getPayableAmount() - tmp);
            order.setDiscountAmount(order.getDiscountAmount() + tmp);
        }
        this.nextHandler.applyDiscount(order);
    }
}
