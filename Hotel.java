import java.util.Scanner;

public class Hotel {
    static final int FLOORS = 5;
    static final int ROOMS = 10;
    static char[][] hotelRooms = new char[FLOORS][ROOMS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeRooms();

        while (true) {
            System.out.println("\n=== Hotel Booking System ===");
            System.out.println("1. View Room Status");
            System.out.println("2. Book a Room");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayRooms();
                    break;
                case 2:
                    bookRoom(scanner);
                    break;
                case 3:
                    System.out.println("Thank You!");
                    return; // exit the program
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void initializeRooms() {
        for (int i = 0; i < FLOORS; i++) {
            for (int j = 0; j < ROOMS; j++) {
                hotelRooms[i][j] = 'A';
            }
        }
    }

    static void displayRooms() {
        System.out.println("\nRoom status (A = Available, B = Booked):");
        for (int i = 0; i < FLOORS; i++) {
            System.out.print("Floor " + (i + 1) + ": ");
            for (int j = 0; j < ROOMS; j++) {
                System.out.print(hotelRooms[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bookRoom(Scanner scanner) {
        System.out.print("Enter floor number (1-" + FLOORS + "): ");
        int floor = scanner.nextInt();

        System.out.print("Enter room number (1-" + ROOMS + "): ");
        int room = scanner.nextInt();

        // Check if input is valid
        if (floor < 1 || floor > FLOORS || room < 1 || room > ROOMS) {
            System.out.println("Invalid floor or room number.");
            return;
        }

        // Adjust for 0-based array
        if (hotelRooms[floor - 1][room - 1] == 'B') {
            System.out.println("Room is already Booked.");
        } else {
            hotelRooms[floor - 1][room - 1] = 'B';
            System.out.println("Room Booked Successfully!");
        }
    }
}
