package com.airline.bookings;

public class DomesticFlightBooking extends FlightBooking {
    public DomesticFlightBooking(FlightDetails flightDetails) {
        super(flightDetails);
    }

    @Override
    public void bookFlight() {
        System.out.println("Domestic flight booked for: " + getFlightDetails().passengerName());
    }
}
