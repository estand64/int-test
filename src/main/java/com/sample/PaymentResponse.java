package com.sample;

public class PaymentResponse {
    private final Long orderId;
    private final String creditCardNumber;

    public PaymentResponse(Long orderId, String creditCardNumber) {
        this.orderId = orderId;
        this.creditCardNumber = creditCardNumber;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public String getCreditCardNumber() {
        return this.creditCardNumber;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PaymentResponse)) return false;
        final PaymentResponse other = (PaymentResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$orderId = this.getOrderId();
        final Object other$orderId = other.getOrderId();
        if (this$orderId == null ? other$orderId != null : !this$orderId.equals(other$orderId)) return false;
        final Object this$creditCardNumber = this.getCreditCardNumber();
        final Object other$creditCardNumber = other.getCreditCardNumber();
        if (this$creditCardNumber == null ? other$creditCardNumber != null : !this$creditCardNumber.equals(other$creditCardNumber))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PaymentResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $orderId = this.getOrderId();
        result = result * PRIME + ($orderId == null ? 43 : $orderId.hashCode());
        final Object $creditCardNumber = this.getCreditCardNumber();
        result = result * PRIME + ($creditCardNumber == null ? 43 : $creditCardNumber.hashCode());
        return result;
    }

    public String toString() {
        return "PaymentResponse(orderId=" + this.getOrderId() + ", creditCardNumber=" + this.getCreditCardNumber() + ")";
    }
}
