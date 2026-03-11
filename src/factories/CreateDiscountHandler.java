package factories;

import handlers.*;

public class CreateDiscountHandler {
    public static ApplyDiscountHandler createDiscountHandler() {
        return new MemberDiscountHandler(
                new BulkDiscountHandler(
                        new CouponDiscountHandler(
                                new FinalizeHandler()
                        )
                )
        );
    }
}
