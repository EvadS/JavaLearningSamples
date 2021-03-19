package org.example.worked;

/**
 * Created by Evgeniy Skiba on 17.03.21
 */
public class BlockingWalletResourceId <T> extends BlockingAccountIdResource<T> implements PaymentIdentifiable<PaymentCurrency>   {

    private PaymentCurrency paymentCurrency;
    private T id;

    public BlockingWalletResourceId(T id) {
        super(id);
    }


    @Override
    public PaymentCurrency getPaymentCurrency() {
        return paymentCurrency;
    }
}
