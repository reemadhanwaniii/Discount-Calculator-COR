package enums;

public enum UserType {



    REGULAR(5),
    PREMIUM(10),
    PLATINUM(15);


    private final int discountPercent;

    UserType(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return this.discountPercent;
    }

}
