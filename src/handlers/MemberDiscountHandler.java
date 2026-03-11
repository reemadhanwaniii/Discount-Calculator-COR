package handlers;

import enums.DiscountType;
import models.Order;

public class MemberDiscountHandler implements ApplyDiscountHandler{

    private ApplyDiscountHandler nextHandler;

    public MemberDiscountHandler(ApplyDiscountHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void applyDiscount(Order order) {
        order.getAppliedDiscounts().add(DiscountType.MEMBERSHIP);
        double tem = (order.getPayableAmount() * order.getUserType().getDiscountPercent())/100.0;
        order.setPayableAmount(order.getPayableAmount() - tem);
        order.setDiscountAmount(order.getDiscountAmount() + tem);
        this.nextHandler.applyDiscount(order);
    }
}
