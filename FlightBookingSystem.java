package com.airline.application;

import com.airline.bookings.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FlightBookingSystem {
    private static final String[] names = {"Alice", "Bob", "Charlie", "David", "Emma", "Fiona", "George", "Hannah"};
    private static final String[] sources = {"Chicago", "Los Angeles", "Toronto", "Berlin", "Dubai", "Mumbai", "Tokyo", "Seoul"};
    private static final String[] destinations = {"New York", "Paris", "Tokyo", "Mumbai", "Dubai", "Sydney", "London"};
    private static final Random random = new Random();
    private static final List<FlightBooking> bookings = new ArrayList<>();

    private static FlightBooking createBooking(String flightType) {
        String bookingID = "B" + (random.nextInt(900) + 100);
        String passengerName = names[random.nextInt(names.length)];
        String source = sources[random.nextInt(sources.length)];
        String destination = destinations[random.nextInt(destinations.length)];

        FlightDetails flightDetails = new FlightDetails(bookingID, passengerName, flightType, source, destination);

        if ("Domestic".equals(flightType)) {
            return new DomesticFlightBooking(flightDetails);
        } else {
            return new InternationalFlightBooking(flightDetails);
        }
    }

    private static void displayAllBookings() {
        System.out.println("\nAll Bookings:");
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (FlightBooking booking : bookings) {
                booking.displayInfo();
                System.out.println("------------------------");
            }
        }
    }

    private static void displayBookingsByType(String flightType) {
        System.out.println("\nBookings for " + flightType + " flights:");
        boolean found = false;
        for (FlightBooking booking : bookings) {
            if (booking.getFlightDetails().flightType().equalsIgnoreCase(flightType)) {
                booking.displayInfo();
                System.out.println("------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No bookings found for " + flightType + " flights.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nFlight Booking System Menu:");
            System.out.println("1. Book a Domestic Flight");
            System.out.println("2. Book an International Flight");
            System.out.println("3. Display All Bookings");
            System.out.println("4. Display Bookings by Flight Type");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    FlightBooking domesticBooking = createBooking("Domestic");
                    new BookingThread(domesticBooking).start();
                    bookings.add(domesticBooking);
                }
                case 2 -> {
                    FlightBooking internationalBooking = createBooking("International");
                    new BookingThread(internationalBooking).start();
                    bookings.add(internationalBooking);
                }
                case 3 -> displayAllBookings();
                case 4 -> {
                    System.out.print("Enter flight type (Domestic/International): ");
                    String type = scanner.nextLine();
                    displayBookingsByType(type);
                }
                case 5 -> {
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
