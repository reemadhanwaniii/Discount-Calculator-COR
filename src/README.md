 ### Goal: 
Build a discount processing pipeline where each discount rule is an independent handler. The system should calculate the final price of an order by passing it through a chain of handlers, each applying a specific discount if the order meets the criteria



### Core Requirements

Order Class: A class containing totalAmount, userType (e.g., Regular, Premium), and couponCode.

Handler Interface (DiscountHandler): Must include methods to setNext(DiscountHandler next) and apply(Order order).

Abstract Base Handler: To handle the boilerplate logic of storing the next handler and forwarding the request


### Specific Handlers to Implement
MemberDiscountHandler: Applies a 10% discount if the user type is PREMIUM.

CouponDiscountHandler: Applies a flat $20 discount if the coupon code is SAVE20.

BulkDiscountHandler: Applies a 5% discount if the total order amount is greater than $500.

### Execution Logic
Each handler performs its specific check.

If the criteria are met, the handler modifies the order's price.

The handler must then pass the (potentially modified) order to the next handler in the chain until the end is reached.

### Non Functional Requirements

#### Extensibility

System should allow adding new discounts easily:

Examples:

FestivalDiscount

FirstTimeUserDiscount

PaymentMethodDiscount

Without modifying existing code.

#### Modularity

Each discount rule should be implemented in separate classes.

#### Maintainability

Discount logic should not be tightly coupled