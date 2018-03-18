package hu.oe.nik.szfmv.automatedcar.systemcomponents;

import hu.oe.nik.szfmv.automatedcar.bus.VirtualFunctionBus;
import hu.oe.nik.szfmv.automatedcar.bus.packets.input.InputPacket;
import hu.oe.nik.szfmv.automatedcar.input.InputHandler;

public class SteeringWheel extends SystemComponent {

    private static final double MINPOSITION = -100;

    private static final double MAXPOSITION = 100;

    private static final double step = 5;

    private final InputPacket inputPacket;

    private InputHandler inputHandler;

    public SteeringWheel(VirtualFunctionBus virtualFunctionBus) {
        super(virtualFunctionBus);
        inputPacket = InputPacket.getInstance();
        virtualFunctionBus.inputPacket = inputPacket;

        inputHandler = InputHandler.getInstance();
    }

    @Override
    public void loop() {

        if (inputHandler.isSteeringLeftPressed() && inputHandler.isSteeringRightPressed()) {
            return;
        }

        double newPosition = 0.0;

        if (inputHandler.isSteeringLeftPressed()) {
            newPosition = calculateNewSteeringWheelPosition(inputPacket.getSteeringWheelPosition() - step);
        } else if (inputHandler.isSteeringRightPressed()) {
            newPosition = calculateNewSteeringWheelPosition(inputPacket.getSteeringWheelPosition() + step);
        } else if (inputPacket.getSteeringWheelPosition() != 0) {
            // Ha nincs lenyomva egyik irány sem, és nem középen áll a kormány, a 0 felé közelítjük az állást.
            int sign = inputPacket.getSteeringWheelPosition() > 0 ? -1 : 1;
            newPosition = calculateNewSteeringWheelPosition(inputPacket.getSteeringWheelPosition() + (sign * step));
        }

        inputPacket.setSteeringWheelPosition(newPosition);
    }

    private double calculateNewSteeringWheelPosition(double newPos) {

        if (newPos > MAXPOSITION) {
            return MAXPOSITION;
        }

        if (newPos < MINPOSITION) {
            return MINPOSITION;
        }

        // Ha már egy lépésnyinél kevesebbel térünk el 0-tól, akkor beállítjuk 0-ra
        // hogy ne ugráljon magától ide oda a kormányállás.
        if (Math.abs(newPos) < step) {
            return 0;
        }

        return newPos;
    }
}
