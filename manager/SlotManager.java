package manager;

import model.ParkingTicket;
import model.Slot;
import model.Vehicle;
import model.VehicleType;

import java.time.LocalDateTime;
import java.util.*;

public class SlotManager {
    Map<String , ParkingTicket> activeTickets;
    Map<VehicleType , Queue<Slot>> freeSlots;

    public SlotManager(Map<String , ParkingTicket> activeTickets , Map<VehicleType , Queue<Slot>> freeSlots) {
        this.freeSlots = new HashMap<>();
        this.activeTickets = new HashMap<>();
        initSlot();
    }

    private void initSlot(){
        for(VehicleType type : VehicleType.values()){
            Queue<Slot> slots= new LinkedList<>();

            for(int i = 0 ; i < 10 ; i++){
                slots.offer(new Slot(UUID.randomUUID().toString() ,type));
            }
            freeSlots.put(type , slots);
        }
    }

     public ParkingTicket assignSlot(Vehicle vehicle){
         VehicleType type = vehicle.getVehicleType();
         Queue<Slot> queue = freeSlots.get(type);

         if(queue == null || queue.isEmpty()){
             return null; // no slot
         }

         Slot slot = queue.poll();
         slot.setOccupied(true);
         slot.setCurrentVehicle(vehicle);

        ParkingTicket parkingTicket = new ParkingTicket(
                UUID.randomUUID().toString(),
                vehicle.getVehicleNumber(),
                type,
                LocalDateTime.now(),
                slot
        );
        activeTickets.put(vehicle.getVehicleNumber() , parkingTicket);

        return parkingTicket;
     }
     public void freeSlot(String vehicleNumber){
         ParkingTicket ticket = activeTickets.get(vehicleNumber);

         if(ticket == null){
             System.out.println("No active ticket found for this vehicle Number " + vehicleNumber);
             return;
         }

         Slot slot = ticket.getSlot();
         slot.setOccupied(false);
         slot.setCurrentVehicle(null);
         freeSlots.get(slot.getSupportedType()).offer(slot); // available to park for supported type

         activeTickets.remove(vehicleNumber);

         System.out.println("Slot freed and available to Park");
     }

     public ParkingTicket getTicket(String vehicleNumber){
        return activeTickets.get(vehicleNumber);
     }
}
