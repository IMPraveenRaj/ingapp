package com.springheaven.ing.ingapp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InvestmentOrderDepositData {
    // Settings
    private final FiscalSettings fiscalSettings;
    private final LocalDate minStartDate;
    private final LocalDate maxStartDate;
    private final Money minimumAmount;
    private final Money maximumAmount;
    private final Boolean customerAgeBelowThreshold;

    // Current Situation
    private final BigDecimal currentYearTotalInvestedAmount;
    private final Order currentOrder;
    private final Boolean hasPendingOrders;
    private final Boolean hasPeriodicOrder;
    private final Boolean taxPaid;

    // Private constructor accessible only through the builder
    private InvestmentOrderDepositData(InvestmentOrderDepositDataBuilder builder) {
        this.fiscalSettings = builder.fiscalSettings;
        this.minStartDate = builder.minStartDate;
        this.maxStartDate = builder.maxStartDate;
        this.minimumAmount = builder.minimumAmount;
        this.maximumAmount = builder.maximumAmount;
        this.customerAgeBelowThreshold = builder.customerAgeBelowThreshold;

        this.currentYearTotalInvestedAmount = builder.currentYearTotalInvestedAmount;
        this.currentOrder = builder.currentOrder;
        this.hasPendingOrders = builder.hasPendingOrders;
        this.hasPeriodicOrder = builder.hasPeriodicOrder;
        this.taxPaid = builder.taxPaid;
    }

    // Static method to get a new Builder instance
    public static InvestmentOrderDepositDataBuilder builder() {
        return new InvestmentOrderDepositDataBuilder();
    }

    @Override
    public String toString() {
        return "InvestmentOrderDepositData{" +
                "fiscalSettings=" + fiscalSettings +
                ", minStartDate=" + minStartDate +
                ", maxStartDate=" + maxStartDate +
                ", minimumAmount=" + minimumAmount +
                ", maximumAmount=" + maximumAmount +
                ", customerAgeBelowThreshold=" + customerAgeBelowThreshold +
                ", currentYearTotalInvestedAmount=" + currentYearTotalInvestedAmount +
                ", currentOrder=" + currentOrder +
                ", hasPendingOrders=" + hasPendingOrders +
                ", hasPeriodicOrder=" + hasPeriodicOrder +
                ", taxPaid=" + taxPaid +
                '}';
    }

    // Static nested Builder class
    public static class InvestmentOrderDepositDataBuilder {
        // Settings
        private FiscalSettings fiscalSettings;
        private LocalDate minStartDate;
        private LocalDate maxStartDate;
        private Money minimumAmount;
        private Money maximumAmount;
        private Boolean customerAgeBelowThreshold;

        // Current Situation
        private BigDecimal currentYearTotalInvestedAmount;
        private Order currentOrder;
        private Boolean hasPendingOrders;
        private Boolean hasPeriodicOrder;
        private Boolean taxPaid;

        // Methods for required and optional attributes
        public InvestmentOrderDepositDataBuilder fiscalSettings(FiscalSettings fiscalSettings) {
            this.fiscalSettings = fiscalSettings;
            return this;
        }

        public InvestmentOrderDepositDataBuilder minStartDate(LocalDate minStartDate) {
            this.minStartDate = minStartDate;
            return this;
        }

        public InvestmentOrderDepositDataBuilder maxStartDate(LocalDate maxStartDate) {
            this.maxStartDate = maxStartDate;
            return this;
        }

        public InvestmentOrderDepositDataBuilder minimumAmount(Money minimumAmount) {
            this.minimumAmount = minimumAmount;
            return this;
        }

        public InvestmentOrderDepositDataBuilder maximumAmount(Money maximumAmount) {
            this.maximumAmount = maximumAmount;
            return this;
        }

        public InvestmentOrderDepositDataBuilder customerAgeBelowThreshold(Boolean customerAgeBelowThreshold) {
            this.customerAgeBelowThreshold = customerAgeBelowThreshold;
            return this;
        }

        public InvestmentOrderDepositDataBuilder currentYearTotalInvestedAmount(BigDecimal currentYearTotalInvestedAmount) {
            this.currentYearTotalInvestedAmount = currentYearTotalInvestedAmount;
            return this;
        }

        public InvestmentOrderDepositDataBuilder currentOrder(Order currentOrder) {
            this.currentOrder = currentOrder;
            return this;
        }

        public InvestmentOrderDepositDataBuilder hasPendingOrders(Boolean hasPendingOrders) {
            this.hasPendingOrders = hasPendingOrders;
            return this;
        }

        public InvestmentOrderDepositDataBuilder hasPeriodicOrder(Boolean hasPeriodicOrder) {
            this.hasPeriodicOrder = hasPeriodicOrder;
            return this;
        }

        public InvestmentOrderDepositDataBuilder taxPaid(Boolean taxPaid) {
            this.taxPaid = taxPaid;
            return this;
        }

        // Build method to create the final object
        public InvestmentOrderDepositData build() {
            return new InvestmentOrderDepositData(this);
        }
    }
}
