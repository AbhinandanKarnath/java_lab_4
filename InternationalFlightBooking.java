package com.airline.bookings;

public class InternationalFlightBooking extends FlightBooking {
    public InternationalFlightBooking(FlightDetails flightDetails) {
        super(flightDetails);
    }

    @Override
    public void bookFlight() {
        System.out.println("International flight booked for: " + getFlightDetails().passengerName());
    }
}
