package com.airline.bookings;

public class BookingThread extends Thread {
    private final FlightBooking booking;

    public BookingThread(FlightBooking booking) {
        this.booking = booking;
    }

    @Override
    public void run() {
        booking.bookFlight();
        booking.displayInfo();
    }
}
