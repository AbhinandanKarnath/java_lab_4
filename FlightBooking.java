package com.airline.bookings;

public abstract class FlightBooking {
    private final FlightDetails flightDetails;

    public FlightBooking(FlightDetails flightDetails) {
        this.flightDetails = flightDetails;
    }

    public abstract void bookFlight();

    public FlightDetails getFlightDetails() {
        return flightDetails;
    }

    public void displayInfo() {
        System.out.println("Booking ID: " + flightDetails.bookingID() +
                "\nPassenger Name: " + flightDetails.passengerName() +
                "\nFlight Type: " + flightDetails.flightType() +
                "\nSource: " + flightDetails.source() +
                "\nDestination: " + flightDetails.destination());
    }
}
