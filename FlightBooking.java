package com.airline.bookings;

public abstract class FlightBooking implements Bookable {
    private final FlightDetails flightDetails;

    public FlightBooking(FlightDetails flightDetails) {
        this.flightDetails = flightDetails;
    }

    public FlightDetails getFlightDetails() {
        return flightDetails;
    }

    @Override
    public void displayInfo() {
        // Using StringBuilder for string concatenation
        StringBuilder sb = new StringBuilder();
        sb.append("Booking ID: ").append(flightDetails.bookingID())
          .append("\nPassenger Name: ").append(flightDetails.passengerName())
          .append("\nFlight Type: ").append(flightDetails.flightType())
          .append("\nSource: ").append(flightDetails.source())
          .append("\nDestination: ").append(flightDetails.destination());
        System.out.println(sb.toString());
    }
}
