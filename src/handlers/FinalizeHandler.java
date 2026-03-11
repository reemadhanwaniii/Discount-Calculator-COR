package handlers;

import models.Order;

public class FinalizeHandler implements ApplyDiscountHandler {


    @Override
    public void applyDiscount(Order order) {
        System.out.println("Total Amount : "+order.getTotalAmount() +
                " Discount : "+order.getDiscountAmount() +
                " payable amount : "+ order.getPayableAmount());
    }
}
