package com.springheaven.ing.ingapp.endpoints;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class InvestmentDepositService {
//
//    private final ProductDefinitionPort productDefinitionPort;
//    private final InvestmentOrderService investmentOrderService;
//    private final InvestmentOrderDepositPort investmentOrderDepositPort;
//    private final InstrumentPort   instrumentPort;
//    private final PartiesPort partiesPort;
//
//
//    public InvestmentOrderDepositData getOrderDepositData(final User user,final AgreementId agreementId,final TransactionType transactionType){
//
//        val transactionSettings = productDefinitionPort.getProductDefinition(agreementId.getProductType())
//                .getTransactionSettings();
//        val fiscalSetting = investmentOrderDepositPort.getFiscalsettings(user,agreementId);
//
//        val minimumAmount= Money.builder().amount(transactionSettings.getPeriodicDepositSettings().getMinimumAmount))
//        .build();
//
//
//        val MaximumAmount= Money.builder().amount(transactionSettings.getPeriodicDepositSettings().getMinimumAmount))
//        .build();
//
//       val hasPendingOrders= hasPendingOrders(user,AgreementId);
//
//       val periodicOrder=investmentOrderDepositPort.getPeriodicOrder(user,agreementId).stream().findAny().orElseThrow();
//
//       val mayBeInstrumentId= Optional.ofNullable(periodicOrder.getInstrumentUUID()).map(InstrumentID::fromUid);
//
//       val instrument = getInstrument(user,mayBeInstrumentId);
//
//       val hasPeriodicOrder = Objects.nonNull(periodicOrder.getFrequency) && !Frequency.UNKNOWN.Equals(periodicOrder.getFrequency));
//
//      val currentYearTotalInvestedAmount = getCurrentYearTotalInvestedAmount(user,agreementId);
//
//      val periodicDeposit=calculateCurrentYearPeriodicDepositAmount(periodicOrder,currentYearTotalInvestedAmount);
//
//      val updatePeriodicOrder= PeriodicOrder.toBuilder()
//              .remainingDeposit(BigDecimal.valueOf(remainingDeposit))
//              .periodicDeposit(BigDecimal.valueOf(Money.builder.amount(periodicDeposit).build()))
//              .build();
//    }
//
//    val individualUid= UUID.fromString(user.getCustomer()).getIdentifier(UserIdentifier.Party_UUID);
//    Val dateOfBirt= partiesPort.getDateofBirth();
//    val customerAgeBelowThreshold=transactionSettings.getPeriodicDepositSettings().getCustomerAgeBelowThreshold();
//    boolean isCustomerAgeBelowThreshold=isCustomerAgeBelowThreshold(dateOfBirt,customerAgeBelowThreshold);
//
//    return InvestmentOrderDepositData.builder()
//            .fiscalSettings(fiscalSetting)
//    .minimumAmount(minimumAmount)
//    .maximumAmount(maximumAmount)
//    .customerAgeBelowThresold(isCustomerAgeBelowThreshold)
//    .taxPaid(fiscalSettings.getTaxPaid())
//    .haspendingOrders(hasPendingOrders)
//    .hasPeriodicOrder(hasPeriodicOrder)
//    .currentYearTotalInvestedAmount(currentYearTotalInvestedAmount)
//    .periodicOrder(updatePeriodicOrder)
//    .instrument(instrument)
//    .build()
//
//
//}

}