package model;

import java.time.LocalDateTime;

public class ParkingTicket {
    private String ticketId;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private LocalDateTime entryTime;
    private Slot slot;

    public ParkingTicket(String ticketId, String vehicleNumber, VehicleType type, LocalDateTime entryTime, Slot slot) {
        this.ticketId = ticketId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = type;
        this.entryTime = entryTime;
        this.slot = slot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Slot getSlot() {
        return slot;
    }
}
