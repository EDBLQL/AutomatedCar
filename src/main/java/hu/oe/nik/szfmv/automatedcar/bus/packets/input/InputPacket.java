package hu.oe.nik.szfmv.automatedcar.bus.packets.input;
import hu.oe.nik.szfmv.automatedcar.input.enums.GearEnum;

public class InputPacket implements ReadOnlyInputPacket {

    private static InputPacket instance = null;

    public static InputPacket getInstance(){
        if (instance == null){
            instance = new InputPacket();
        }

        return instance;
    }

    private double steeringWheelPosition;


    private int gaspedalposition;

    private int brakepedalvalue;

    private GearEnum gearEnum;

    private  boolean leftIndexOn;

    private  boolean rightIndexOn;


    private boolean LaneKeepingOn;

    private boolean ParkingPilote;


    @Override
    public int getGasPedalPosition() {
        return gaspedalposition;
    }

    @Override
    public int getBreakPedalPosition() {
        return brakepedalvalue;
    }

    @Override
    public double getSteeringWheelPosition()
    {
        return steeringWheelPosition;
    }

    public void setSteeringWheelPosition(double steeringWheelPosition)
    {
        this.steeringWheelPosition = steeringWheelPosition;
    }

    public void setGaspeadalposition(int value)
    {
        this.gaspedalposition = value;
    }

    public void setBrakepedalvalue(int brakepedalvalue)
    {
        this.brakepedalvalue = brakepedalvalue;
    }

    public void setParkingPiloteStatus(boolean value)
    {
        ParkingPilote = value;
    }

    @Override
    public int getACCTargetSpeed() {
        return 0;
    }

    @Override
    public double getACCTargetDistance() {
        return 0;
    }

    @Override
    public boolean getLaneKeepingStatus() {
        return LaneKeepingOn;
    }

    public void setLaneKeepingStatus(boolean value){this.LaneKeepingOn = value;}

    @Override
    public boolean getParkingPilotStatus() {
        return ParkingPilote;
    }

    @Override
    public GearEnum getGearState() {
        return gearEnum;
    }

    public  void setGearSate(GearEnum gearEnum)
    {
        this.gearEnum = gearEnum;

    }

    @Override
    public boolean getLeftTurnSignalStatus() {
        return leftIndexOn;
    }

    @Override
    public boolean getRightTurnSignalStatus() {
        return rightIndexOn;
    }

    public void setLeftTurnSignalStatus(boolean leftIndexOn) {
        this.leftIndexOn = leftIndexOn;
    }

    public void setRightTurnSignalStatus(boolean rightIndexOn) {
        this.rightIndexOn = rightIndexOn;
    }
}