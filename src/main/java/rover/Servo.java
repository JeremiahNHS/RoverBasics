package rover;

/**
 * STEP 5 and STEP 6 · A servo is a motor that holds an angle.
 *
 *      ┌──────────────────────────┐
 *      │          Servo           │
 *      ├──────────────────────────┤
 *      │ - name: String           │
 *      │ - angle: int             │
 *      ├──────────────────────────┤
 *      │ + getName(): String      │
 *      │ + getAngle(): int        │
 *      │ + turnTo(int): void      │
 *      │ + isCentered(): boolean  │
 *      └──────────────────────────┘
 *
 * The four rules this class obeys:
 *
 *   1. A brand new servo sits at 90.
 *   2. turnTo can never leave it above 180.
 *   3. turnTo can never leave it below 0.
 *   4. It is "centered" when it is at exactly 90.
 *
 * README Step 5 gives you the whole class. Type it in below. README Step 6
 * adds one more constructor to it.
 */
public class Servo {

    // ▼ README · Step 5, then Step 6.
    private final String name;
    private int angle;

    public Servo(String name){
        this.name = name;
        this.angle = 90;
    }
    public Servo(String name, int startingAngle){
        this.name = name;
        turnTo(startingAngle);
    }

    public String getName(){
        return name;
    }

    public int getAngle(){
        return angle;
    }

    public void turnTo(int degrees){
        if (degrees > 180) {
            angle = 180;
        } else if (degrees < 0) {
            angle = 0;
        } else {
            angle = degrees;
        }
    }

    public void turnBy(int value){
        turnTo(90 + value);
    }


    public boolean isCentered(){
        return angle == 90;
    }

    @Override
    public String toString(){
        return getName() + " @ " + getAngle();
    }
}
