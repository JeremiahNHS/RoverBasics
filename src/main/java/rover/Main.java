package rover;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Locale;

/**
 * CSCI-121 · Week 5 · RoverBasics
 *
 * There are no tests in this project. You run the program and read what it
 * prints:
 *
 *     ./mvnw compile exec:java          (Windows:  mvnw.cmd compile exec:java)
 *
 * PART 1 of this lab is a FOLLOW-ALONG. Every line you need is printed in the
 * README, in order, with an explanation. You type it in, you run it, you check
 * what it printed against the README. Nothing is left for you to invent.
 *
 * PART 2 is six stretch goals. Those give you the rules and the output, and
 * you write the code yourself.
 *
 * HOW TO WORK PART 1
 *
 *   1. Open the README at Step 1.
 *   2. Type the code it gives you into the matching method below. TYPE it, do
 *      not paste it - the typing is most of the point.
 *   3. Write down what you think it will print. The README has a box.
 *   4. Run it. Compare against the README.
 *   5. Come back here and delete the // in front of the next step in main().
 *
 * One step at a time. Do not switch on three steps and then try to work out
 * which one is broken.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== RoverBasics ===");

        // ── MONDAY ──────────────────────────────────────────────────────────

        step1Variables();
        step2Battery();
        step3Strings();
        step4Input();

        // ── TUESDAY ─────────────────────────────────────────────────────────
        step5FirstClass();
        step6TwoConstructors();
        step7Composition();
        step8ArrayOfObjects();
        step9Methods();

        // ── PART 2 · STRETCH ────────────────────────────────────────────────
        stretch();
    }


    // ════════════════════════════════════════════════════════════════════════
    // STEP 1 · Variables have types, and you have to say which
    // ════════════════════════════════════════════════════════════════════════

    private static void step1Variables() {
        System.out.println();
        System.out.println("--- Step 1: what a rover is made of ---");
        // ▼ README · Step 1. Type it below this line.
        String name = "Sparky";
        int wheels = 6;
        double topSpeed = 0.75;
        boolean headlightsOn = false;
        char missionCode = 'B';

        System.out.println("name         = " + name);
        System.out.println("wheels       = " + wheels);
        System.out.println("topSpeed     = " + topSpeed);
        System.out.println("headlightsOn = " + headlightsOn);
        System.out.println("missionCode  = " + missionCode);

        System.out.println("missionCode + 1       = " + (missionCode + 1));
        System.out.println("(char)(missionCode+1) = " + (char) (missionCode + 1));
    }


    // ════════════════════════════════════════════════════════════════════════
    // STEP 2 · Integer division, and the bug it causes
    // ════════════════════════════════════════════════════════════════════════

    private static void step2Battery() {
        System.out.println();
        System.out.println("--- Step 2: how full is the battery? ---");

        // ▼ README · Step 2.
        int capacity = 300;
        int charge = 150;

        int wrong = charge / capacity * 100;
        int right = charge * 100 / capacity;
        double exact = (double) charge * 100 / capacity;

        System.out.println("capacity = " + capacity + ", charge = " + charge);
        System.out.println("wrong = " + wrong + "%");
        System.out.println("right = " + right + "%");
        System.out.println("exact = " + exact + "%");

        int smallCapacity = 3;
        int smallCharge = 2;

        int twoThirds = smallCharge * 100 / smallCapacity;
        double twoThirdsExact = (double) smallCharge * 100 / smallCapacity;

        System.out.println("2 of 3 as an int    = " + twoThirds + "%");
        System.out.println("2 of 3 as a double  = " + twoThirdsExact + "%");
        System.out.println("Java did not round. It chopped.");
    }


    // ════════════════════════════════════════════════════════════════════════
    // STEP 3 · Strings are objects, and they never change
    // ════════════════════════════════════════════════════════════════════════

    private static void step3Strings() {
        System.out.println();
        System.out.println("--- Step 3: strings ---");

        // ▼ README · Step 3.
        String label = "Rover Sparky";

        System.out.println("label            = " + label);
        System.out.println("label.length()   = " + label.length());
        System.out.println("label.charAt(6)  = " + label.charAt(6));
        System.out.println("label.substring(6) = " + label.substring(6));

        label.toUpperCase();

        System.out.println("after toUpperCase(), label = " + label);

        String shouty = label.toUpperCase();

        System.out.println("shouty = " + shouty);

        String typedByHand = new String("Rover Sparky");

        boolean sameObject = label == typedByHand;
        boolean sameText = label.equals(typedByHand);

        System.out.println("label == typedByHand      -> " + sameObject);
        System.out.println("label.equals(typedByHand) -> " + sameText);


    }


    // ════════════════════════════════════════════════════════════════════════
    // STEP 4 · Reading what somebody types
    //
    // This step needs an import. The README says where it goes.
    // ════════════════════════════════════════════════════════════════════════

    private static void step4Input() {
        System.out.println();
        System.out.println("--- Step 4: ask the operator ---");

        // ▼ README · Step 4.
        Scanner in = new Scanner(System.in);

        System.out.print("Name your rover: ");
        String roverName = in.nextLine();

        System.out.print("How many wheels? ");
        int wheelCount = in.nextInt();

        System.out.println(roverName + " reporting for duty on " + wheelCount + " wheels.");

    }


    // ════════════════════════════════════════════════════════════════════════
    // STEP 5 · Your first class
    //
    // Write Servo.java FIRST. This method will not compile until it exists.
    // ════════════════════════════════════════════════════════════════════════

    private static void step5FirstClass() {
        System.out.println();
        System.out.println("--- Step 5: one servo ---");

        // ▼ README · Step 5.
        Servo mast =new Servo("Mast");

        System.out.println("name         = " + mast.getName());
        System.out.println("starts at    = " + mast.getAngle());
        System.out.println("isCentered() = " + mast.isCentered());

        mast.turnTo(45);
        System.out.println("after turnTo(45)  = " + mast.getAngle());

        mast.turnTo(240);
        System.out.println("after turnTo(240) = " + mast.getAngle());

        mast.turnTo(-40);
        System.out.println("after turnTo(-40) = " + mast.getAngle());



    }


    // ════════════════════════════════════════════════════════════════════════
    // STEP 6 · Two constructors, one class
    // ════════════════════════════════════════════════════════════════════════

    private static void step6TwoConstructors() {
        System.out.println();
        System.out.println("--- Step 6: a second constructor ---");

        // ▼ README · Step 6.
        Servo a = new Servo("Arm");
        Servo b = new Servo("Boom", 30);

        System.out.println(a.getName() + " starts at " + a.getAngle());
        System.out.println(b.getName() + " starts at " + b.getAngle());

        Servo c = new Servo("Cheat", 500);
        System.out.println(c.getName() + " starts at " + c.getAngle());

    }


    // ════════════════════════════════════════════════════════════════════════
    // STEP 7 · One object owning another, and two names for one object
    //
    // Write Rover.java FIRST.
    // ════════════════════════════════════════════════════════════════════════

    private static void step7Composition() {
        System.out.println();
        System.out.println("--- Step 7: a rover owns two servos ---");

        // ▼ README · Step 7.
        Rover sparky = new Rover("Sparky");

        System.out.println("left  starts at " + sparky.getLeftServo().getAngle());
        System.out.println("right starts at " + sparky.getRightServo().getAngle());

        sparky.steerLeft(30);
        System.out.println("after steerLeft(30):  left = "
                + sparky.getLeftServo().getAngle()
                + ", right = " + sparky.getRightServo().getAngle());

        Servo borrowed = sparky.getLeftServo();
        borrowed.turnTo(120);

        System.out.println("borrowed.getAngle()            = " + borrowed.getAngle());
        System.out.println("sparky.getLeftServo().getAngle = "
                + sparky.getLeftServo().getAngle());
        System.out.println("Same object? " + (borrowed == sparky.getLeftServo()));

        Rover other = new Rover("Bolt");
        System.out.println("Bolt's left servo is still at " + other.getLeftServo().getAngle());

    }


    // ════════════════════════════════════════════════════════════════════════
    // STEP 8 · An array of objects
    // ════════════════════════════════════════════════════════════════════════

    private static void step8ArrayOfObjects() {
        System.out.println();
        System.out.println("--- Step 8: four servos in an array ---");

        // ▼ README · Step 8.
        Servo[] servos = new Servo[4];

        System.out.println("servos.length = " + servos.length);
        System.out.println("servos[0]     = " + servos[0]);

        for (int i = 0; i < servos.length; i++){
            servos[i] = new Servo("S" + i);
        }

        for (int i = 0; i < servos.length; i++){
            System.out.println(servos[i]);
        }
    }


    // ════════════════════════════════════════════════════════════════════════
    // STEP 9 · Methods of your own
    //
    // You have been writing methods all lab without being told. Every
    // stepNSomething() below is a method, and so is every getAngle() on Servo.
    // This step makes four of your own on purpose.
    //
    // Watch #26 first. #27 and #28 if you have time.
    // ════════════════════════════════════════════════════════════════════════

    private static void step9Methods() {
        System.out.println();
        System.out.println("--- Step 9: methods of your own ---");

        // ▼ README · Step 9, part 1.
        System.out.println("percent(150, 300) = " + percent(150, 300));
        System.out.println("percent(2, 3)     = " + percent(2, 3));
        System.out.println("percent(150)      = " + percent(150));

        Servo mast = new Servo("Mast");
        mast.turnTo(20);
        System.out.println("before centerIt   = " + mast.getAngle());
        centerIt(mast);
        System.out.println("after  centerIt   = " + mast.getAngle());

        Servo boom = new Servo("Boom");
        boom.turnTo(20);
        System.out.println("before replaceIt  = " + boom);
        replaceIt(boom);
        System.out.println("after  replaceIt  = " + boom);

        // System.out.println(runningTotal);




    }

    // ▼ README · Step 9, part 2 — the four methods go below this line, INSIDE
    //   the class but OUTSIDE step9Methods(). A method never goes inside
    //   another method.
    private static int percent(int part, int whole){
        int runningTotal = part * 100;
        return runningTotal / whole;
    }

    private static int percent(int part){
        return percent(part, 300);
    }

    private static void centerIt(Servo s){
        s.turnTo(90);
    }

    private static void replaceIt(Servo s){
        s = new Servo("Replacement");
        s.turnTo(90);
    }


    // ════════════════════════════════════════════════════════════════════════
    // PART 2 · STRETCH  —  six goals, A to F
    //
    // The README gives you the RULES and the OUTPUT. It does not give you the
    // code. That is the difference between part 1 and part 2.
    //
    // The printing below is given, so your output lines up with the README.
    // Everything it calls is yours to write, in Servo.java and Rover.java.
    //
    // Do them in order. Each one is a few lines. If you get through A, B and C
    // you are in good shape.
    // ════════════════════════════════════════════════════════════════════════

    private static void stretch() {
        System.out.println();
        System.out.println("--- Stretch ---");

        // ▼ README · Stretch. Uncomment a block once you have written its goal.

        // ── A · Servo.turnBy(int) ───────────────────────────────────────────
         Servo s = new Servo("Mast");
         s.turnBy(30);
         System.out.println("A · after turnBy(30) from 90 = " + s.getAngle());
         s.turnBy(200);
         System.out.println("A · after turnBy(200)        = " + s.getAngle());

        // ── B · Rover.centerAll() ───────────────────────────────────────────
         Rover r = new Rover("Sparky", 800);
         r.steerLeft(10);
         r.steerRight(170);
         r.centerAll();
         System.out.println("B · after centerAll: " + r.getLeftServo().getAngle()
                 + " and " + r.getRightServo().getAngle());

        // ── C · the battery ─────────────────────────────────────────────────
         System.out.println("C · starts at        " + r.batteryPercent() + "%");
         r.drain(150);
         System.out.println("C · after drain(150) " + r.batteryPercent() + "%");
         r.drain(649);
         System.out.println("C · after drain(999) " + r.getCharge() + " mAh, "
                 + r.batteryPercent() + "%");


        // ── D · Rover.hasName(String) ───────────────────────────────────────
        // System.out.println("D · hasName(new String(\"Sparky\")) = "
        //         + r.hasName(new String("Sparky")));
        // System.out.println("D · hasName(\"Bolt\")              = " + r.hasName("Bolt"));

        // ── E · Rover.toString() ────────────────────────────────────────────
        // r.steerLeft(45);
        // System.out.println("E · " + r);

        // ── F · two methods over an array ───────────────────────────────────
        // Servo[] servos = {
        //         new Servo("S0"),
        //         new Servo("S1", 30),
        //         new Servo("S2"),
        //         new Servo("S3", 175)
        // };
        // System.out.println("F · centered count = " + countCentered(servos));
        // System.out.println("F · widest         = " + widest(servos));
    }

    // ── F · write these two yourself ────────────────────────────────────────
    //
    // countCentered(Servo[]) -> how many of them are at exactly 90
    // widest(Servo[])        -> the one Servo with the largest angle
    //
    // Both loop over the array. Neither one prints anything - they RETURN.

}
