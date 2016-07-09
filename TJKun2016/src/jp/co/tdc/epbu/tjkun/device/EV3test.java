package jp.co.tdc.epbu.tjkun.device;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class EV3test {

	private static EV3 ev3;
    private static boolean        touchPressed;    // タッチセンサーが押されたかの状態

	public static void main(String[] args) {

		ev3 = EV3.getInstance();

        LCD.drawString("Please Wait...  ", 0, 4);
        ev3.start();
        // スタート待ち
        LCD.drawString("Touch to START", 0, 4);
        while (waitForStart()) {
            Delay.msDelay(100);
        }

        LCD.drawString("Running       ", 0, 4);

        while (waitForStop()) {
            ev3.controlBalance(0,0,EV3.TAIL_ANGLE_DRIVE);
            Delay.msDelay(10);
        }
        ev3.stop();
        ev3.close();


	}


	private static boolean waitForStart() {
        boolean res = true;
        ev3.controlBalance(0,0,EV3.TAIL_ANGLE_STAND_UP);
        if (ev3.touchSensorIsPressed()) {
            touchPressed = true;          // タッチセンサーが押された
        } else {
            if (touchPressed) {
                res = false;
                touchPressed = false;     // タッチセンサーが押された後に放した
            }
        }

        return res;
    }

	private static boolean waitForStop() {
    	boolean res = true;
        if (ev3.touchSensorIsPressed()) {
            touchPressed = true;          // タッチセンサーが押された
        } else {
            if (touchPressed) {
                res = false;
                touchPressed = false;     // タッチセンサーが押された後に放した
            }
        }

        return res;
    }

}
