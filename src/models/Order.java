package models;

import enums.DiscountType;
import enums.UserType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Order {
    private final double totalAmount;
    private final UserType userType;
    private final String couponCode;

    private double discountAmount;
    private double payableAmount;
    private List<DiscountType> appliedDiscounts;

    public Order(double totalAmount,UserType userType) {
        this(totalAmount,userType,null);
    }

    public double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public Order(double totalAmount, UserType userType, String couponCode) {
        this.totalAmount = totalAmount;
        this.userType = userType;
        this.couponCode = couponCode;
        this.discountAmount = 0;
        this.payableAmount = totalAmount;
        this.appliedDiscounts = new ArrayList<>();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public UserType getUserType() {
        return userType;
    }

    public Optional<String> getCouponCode() {
        return Optional.ofNullable(couponCode);
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public List<DiscountType> getAppliedDiscounts() {
        return appliedDiscounts;
    }

    public void setAppliedDiscounts(DiscountType discountType) {
        this.appliedDiscounts.add(discountType);
    }
}
