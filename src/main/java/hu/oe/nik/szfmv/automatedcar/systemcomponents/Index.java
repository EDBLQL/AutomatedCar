package hu.oe.nik.szfmv.automatedcar.systemcomponents;

import hu.oe.nik.szfmv.automatedcar.bus.VirtualFunctionBus;
import hu.oe.nik.szfmv.automatedcar.bus.packets.input.InputPacket;
import hu.oe.nik.szfmv.automatedcar.input.InputHandler;

public class Index extends SystemComponent {

    private InputHandler inputHandler;

    private final InputPacket inputPacket;

    private boolean rightTurnSingalOn;

    private boolean leftTurnSignalOn;

    protected Index(VirtualFunctionBus virtualFunctionBus) {
        super(virtualFunctionBus);

        rightTurnSingalOn = false;
        leftTurnSignalOn = false;

        inputPacket = InputPacket.getInstance();
        virtualFunctionBus.inputPacket = inputPacket;
        inputHandler = InputHandler.getInstance();
    }

    @Override
    public void loop() {

        if (inputHandler.isLeftIndexPressed() && inputHandler.isRightIndexPressed()) {
            return;
        }
        if (inputHandler.isRightIndexPressed()) {
            if (!rightTurnSingalOn) {
                rightTurnSingalOn = true;
            } else {
                rightTurnSingalOn = false;
            }

            inputPacket.setRightTurnSignalStatus(rightTurnSingalOn);
        }
        if (inputHandler.isLeftIndexPressed()) {
            if (!leftTurnSignalOn) {
                leftTurnSignalOn = true;
            } else {
                leftTurnSignalOn = false;
            }

            inputPacket.setLeftTurnSignalStatus(leftTurnSignalOn);
        }

    }
}