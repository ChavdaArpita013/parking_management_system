package model;

public class Slot {
    private VehicleType supportedType;
    private String slotId;
    private boolean isOccupied;
    private Vehicle currentVehicle;

    public Slot(String slotId , VehicleType supportedType){
        this.slotId = slotId;
        this.isOccupied = false;
        this.supportedType = supportedType;
    }

    public String getSlotId() {
        return slotId;
    }

    public VehicleType getSupportedType() {
        return supportedType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public void setCurrentVehicle(Vehicle currentVehicle) {
        this.currentVehicle = currentVehicle;
    }
}
