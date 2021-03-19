package org.example.worked;

/**
 * Created by Evgeniy Skiba on 17.03.21
 */
public interface PaymentIdentifiable<T> extends  AccountIdentifiable<Long> {
    T getPaymentCurrency();
}
