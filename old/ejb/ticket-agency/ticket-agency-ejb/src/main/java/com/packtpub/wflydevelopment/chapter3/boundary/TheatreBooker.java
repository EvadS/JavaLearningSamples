package com.packtpub.wflydevelopment.chapter3.boundary;


import com.packtpub.wflydevelopment.chapter3.control.TheatreBox;
import com.packtpub.wflydevelopment.chapter3.exception.NotEnoughMoneyException;
import com.packtpub.wflydevelopment.chapter3.exception.NoSuchSeatException;
import com.packtpub.wflydevelopment.chapter3.exception.SeatBookedException;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Stateful
@Remote(TheatreBookerRemote.class)
@AccessTimeout(value = 5, unit = TimeUnit.MINUTES)
public class TheatreBooker implements TheatreBookerRemote {

    private static final Logger logger = Logger.getLogger(TheatreBooker.class);

    @EJB
    private TheatreBox box;

    private int money;

    @PostConstruct
    public void createCustomer() {
        this.money = 100;
    }

    @Override
    public int getAccountBalance() {
        return money;
    }

    @Override
    public String bookSeat(int seatId) throws NoSuchSeatException, NotEnoughMoneyException, SeatBookedException {
        final int seatPrice = box.getSeatPrice(seatId);
        if (seatPrice > money) {
            throw new NotEnoughMoneyException("You don't have enough money to buy this " + seatId + " seat!");
        }

        box.buyTicket(seatId);
        money = money - seatPrice;
        logger.infov("Seat {0} booked", seatId);

        return "Seat booked.";
    }

    @Override
    @Asynchronous
    public Future<String> bookSeatAsync(int seatId) throws NotEnoughMoneyException {
        try {
            Thread.sleep(10000);
            bookSeat(seatId);

            return new AsyncResult<>("Booked seat: " + seatId + ". Money left: " + money);
        } catch (InterruptedException | NoSuchSeatException | SeatBookedException e) {
            return new AsyncResult<>(e.getMessage());
        }
    }
}