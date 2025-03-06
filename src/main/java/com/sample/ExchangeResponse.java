package com.sample;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.math.BigDecimal;

public class ExchangeResponse {
    @JsonAlias("conversion_rate")
    private BigDecimal conversionRate;
    private String result;
    @JsonAlias("error-type")
    private String errorType;

    public ExchangeResponse() {
    }

    public BigDecimal getConversionRate() {
        return this.conversionRate;
    }

    public String getResult() {
        return this.result;
    }

    public String getErrorType() {
        return this.errorType;
    }

    @JsonAlias("conversion_rate")
    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @JsonAlias("error-type")
    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ExchangeResponse)) return false;
        final ExchangeResponse other = (ExchangeResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$conversionRate = this.getConversionRate();
        final Object other$conversionRate = other.getConversionRate();
        if (this$conversionRate == null ? other$conversionRate != null : !this$conversionRate.equals(other$conversionRate))
            return false;
        final Object this$result = this.getResult();
        final Object other$result = other.getResult();
        if (this$result == null ? other$result != null : !this$result.equals(other$result)) return false;
        final Object this$errorType = this.getErrorType();
        final Object other$errorType = other.getErrorType();
        if (this$errorType == null ? other$errorType != null : !this$errorType.equals(other$errorType)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ExchangeResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $conversionRate = this.getConversionRate();
        result = result * PRIME + ($conversionRate == null ? 43 : $conversionRate.hashCode());
        final Object $result = this.getResult();
        result = result * PRIME + ($result == null ? 43 : $result.hashCode());
        final Object $errorType = this.getErrorType();
        result = result * PRIME + ($errorType == null ? 43 : $errorType.hashCode());
        return result;
    }

    public String toString() {
        return "ExchangeResponse(conversionRate=" + this.getConversionRate() + ", result=" + this.getResult() + ", errorType=" + this.getErrorType() + ")";
    }
}
