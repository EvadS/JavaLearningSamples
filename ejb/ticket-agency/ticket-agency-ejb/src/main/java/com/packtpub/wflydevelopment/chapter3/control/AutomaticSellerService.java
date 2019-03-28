package com.packtpub.wflydevelopment.chapter3.control;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import org.jboss.logging.Logger;

import com.packtpub.wflydevelopment.chapter3.entity.Seat;
import com.packtpub.wflydevelopment.chapter3.exception.NoSuchSeatException;
import com.packtpub.wflydevelopment.chapter3.exception.SeatBookedException;

@Stateless
public class AutomaticSellerService {

	private static final Logger logger = Logger.getLogger(AutomaticSellerService.class);

	@EJB
	private TheatreBox theatreBox;

	@Resource
	private TimerService timerService;

	@Schedule(hour = "*", minute = "*/1", persistent = false)
	public void automaticCustomer() throws NoSuchSeatException {
		final Optional<Seat> seatOptional = findFreeSeat();

		if (!seatOptional.isPresent()) {
			cancelTimers();
			logger.info("Scheduler gone!");
			return;
		}

		final Seat seat = seatOptional.get();

		try {
			theatreBox.buyTicket(seat.getId());
		} catch (SeatBookedException e) {
			// do nothing
		}

		logger.info("Somebody just booked seat number" + seat.getId());
	}

	private void cancelTimers() {
		for (Timer timer : timerService.getTimers()) {
			timer.cancel();
		}
	}

	private Optional<Seat> findFreeSeat() {
		final Collection<Seat> list = theatreBox.getSeats();
		
		return list.stream()
				.filter(seat -> !seat.isBooked())
				.findFirst();
	}

}