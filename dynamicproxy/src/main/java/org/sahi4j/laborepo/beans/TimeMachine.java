package org.sahi4j.laborepo.beans;

public class TimeMachine implements TimeMachineInterface {
    private int currentYear;
    private int fuelLeft;
    private int passengerSeats;

    public TimeMachine(){
        currentYear=2020;
        fuelLeft=100;
        passengerSeats=2;
    }

    @Override
    public int moveInTime(int years){
        currentYear+=years;
        System.out.println("Moved to year "+currentYear);
        return currentYear;
    }

}
