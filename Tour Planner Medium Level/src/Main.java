import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void trip_plan(LinkedList<String> destinations) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your Trip Plan:\n " + destinations);
        System.out.println("Press 9 when you are ready to start the trip");
        int approve = scanner.nextInt();
        if (approve == 9) {
            System.out.println("Starting the trip...");
            if (destinations.size() <= 0) {
                System.out.println("Your trip list is empty");
            } else {
                for (int a = 0; a < destinations.size(); a++) {
                    System.out.println("Next Destination: " + destinations.get(a));
                    System.out.println("Press 2 when you have finished visiting this place");
                    int completed = scanner.nextInt();
                    if (completed == 2) {
                        System.out.println("Moving to the next destination...");
                    }
                }
                System.out.println("You have completed the trip. Congratulations!");
            }
        } else {
            trip_plan(destinations);
        }
    }

    public static void show_options() {
        System.out.println("1- View Options\n"
                + "2- Start Trip");
    }

    public static void touring_dest(LinkedList<String> destinations) {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            show_options();
            option = scanner.nextInt();
            scanner.nextLine(); // To capture the newline character

            if (option == 2) {
                System.out.println("Starting the trip...");
                break;
            } else if (option == 1) {
                while (true) {
                    System.out.println("Options: (1) Add New Place | (2) Remove Place | (3) Change Order of Places | (4) Return to Main Menu");
                    int option_ = scanner.nextInt();
                    scanner.nextLine();
                    if (option_ == 1) {
                        System.out.println("Enter the place you want to add");
                        String addition = scanner.nextLine();
                        destinations.add(addition);
                    } else if (option_ == 2) {
                        System.out.println("Enter the place you want to remove");
                        String substruct = scanner.nextLine();
                        if (destinations.contains(substruct)) {
                            destinations.remove(substruct);
                            System.out.println("Successfully removed from the list");
                            System.out.println("Updated List: " + destinations);
                        } else {
                            System.out.println("The place you entered is not in the list or there was a typo");
                        }
                    } else if (option_ == 3) {
                        if (destinations.size() < 2) {
                            System.out.println("Not enough places to reorder. At least two places are required.");
                        } else {
                            System.out.println("Enter the place whose order you want to change");
                            String itemToMove = scanner.nextLine();

                            if (destinations.contains(itemToMove)) {
                                int currentIndex = destinations.indexOf(itemToMove);

                                System.out.println("Enter the new position (a number between 0 and " + (destinations.size() - 1) + "):");
                                int newPosition = scanner.nextInt();
                                scanner.nextLine();

                                if (newPosition < 0 || newPosition >= destinations.size()) {
                                    System.out.println("Invalid position.");
                                } else {
                                    destinations.remove(currentIndex);
                                    destinations.add(newPosition, itemToMove);
                                    System.out.println("List updated: " + destinations);
                                }
                            } else {
                                System.out.println("The specified place is not in the list.");
                            }
                        }
                    } else if (option_ == 4) {
                        System.out.println("Returning to Main Menu...");
                        break;
                    } else {
                        System.out.println("Invalid Input");
                    }
                }
            } else {
                System.out.println("Invalid Menu Option.");
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<String> destinations = new LinkedList<>();

        System.out.println("Select the city you want to visit:");
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();

        touring_dest(destinations);
        trip_plan(destinations);
    }
}
