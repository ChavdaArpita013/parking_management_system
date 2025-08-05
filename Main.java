import manager.SlotManager;
import model.ParkingTicket;
import model.Vehicle;
import model.VehicleType;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SlotManager slotManager = new SlotManager(new HashMap<>() , new HashMap<>());
        boolean running = true;
        while(running){
            System.out.println("\n========= Parking Management System =========");
            System.out.println("1. Vehicle Entry");
            System.out.println("2. Vehicle Exit");
            System.out.println("3. Exit App");
            System.out.print("Enter your choice Number: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    sc.nextLine();
                    System.out.println("Enter Vehicle Number: ");
                    String number = sc.nextLine();

                    System.out.println("Enter VehicleType(CAR/BIKE/OTHER): ");
                    String type = sc.nextLine().toUpperCase();

                    try {
                        VehicleType vehicleType = VehicleType.valueOf(type);
                        Vehicle vehicle = new Vehicle(number , vehicleType);
                        ParkingTicket ticket = slotManager.assignSlot(vehicle);
                        if(ticket != null){
                            System.out.println("Vehicle Parked with ticket Number " + ticket.getTicketId());
                        }else{
                            System.out.println("No Slot available");
                        }
                    }catch (IllegalArgumentException e) {
                        System.out.println("❌ Invalid vehicle type.");
                    }
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter vehicle number for exit: ");
                    String exitNumber = sc.nextLine();
                    slotManager.freeSlot(exitNumber);
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
