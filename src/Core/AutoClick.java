package Core;

import java.awt.*;

public class AutoClick {
    private Robot robot;
    private int delay;
    public AutoClick() {

        try {
            robot = new Robot();
        } catch (Exception e) {
            System.out.println(e);
        }
        delay = 300;
    }

    public void ClickMouse(int button) {
        try {
            robot.mousePress(button);
            robot.delay(10);
            robot.mouseRelease(button);
            robot.delay(delay);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void ClickDoubleMouse(int button) {
        try {

            robot.mousePress(button);
            robot.delay(1);
            robot.mouseRelease(button);
            robot.delay(1);
            robot.mousePress(button);
            robot.delay(1);
            robot.mouseRelease(button);
            robot.delay(1);
            robot.delay(1000);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void setDelay(int ms) {
        this.delay = ms;
    }
}
