import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FlightBookingSystem {
    public static void main(String[] args) {
        
        Flight flight = new Flight("ABC123", "New York", "Los Angeles", "2024-04-18 08:00", 250.0, 100);

        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter seat number: ");
        String seatNumber = scanner.nextLine();

        
        boolean isBooked = flight.bookSeat(seatNumber);

        if (isBooked) {
            // Payment processing
            PaymentProcessor.processPayment(flight.getPrice());
            // Additional actions like sending confirmation email, etc.
            System.out.println("Seat " + seatNumber + " booked successfully!");
        } else {
            System.out.println("Seat " + seatNumber + " is not available.");
        }

        
        scanner.close();
    }
}

class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private double price;
    private int totalSeats;
    private int availableSeats;
    private Map<String, Boolean> seatMap;

    public Flight(String flightNumber, String origin, String destination, String departureTime, double price, int totalSeats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.price = price;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.seatMap = new HashMap<>();
        initializeSeatMap();
    }

    private void initializeSeatMap() {
        for (int i = 1; i <= totalSeats; i++) {
            seatMap.put(String.valueOf(i), true); // true means seat is available
        }
    }

    public boolean bookSeat(String seatNumber) {
        if (seatMap.containsKey(seatNumber) && seatMap.get(seatNumber)) {
            seatMap.put(seatNumber, false); // Booked seat
            availableSeats--;
            return true;
        }
        return false;
    }

    
    public double getPrice() {
        return price;
    }
}

class PaymentProcessor {
    public static void processPayment(double amount) {
        // Logic for processing payment
        System.out.println("Payment processed successfully! Amount: $" + amount);
    }
}