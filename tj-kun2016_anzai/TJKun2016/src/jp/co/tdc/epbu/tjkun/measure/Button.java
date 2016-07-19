package jp.co.tdc.epbu.tjkun.measure;


private static boolean Button() {
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


