/*
 * Lab03.java
 * Nicolas DeTroia
 * September 19, 2023
 * To implement a doodlepad.jar program using java
 */

import doodlepad.*;
import java.util.Random; 


public class Lab03 {

    public static Rectangle r1, r2, r3;
    
    public static void main(String[] args) 
    { 
        r1 = new Rectangle();
        r2 = new Rectangle();
        r3 = new Rectangle();
    

        r1.setMousePressedHandler(Lab03::onMousePressed);
        r2.setMousePressedHandler(Lab03::onMousePressed);
        r3.setMousePressedHandler(Lab03::onMousePressed);
    }

    public static void onMousePressed(Shape s, double x, double y, int button)
    {

        Random rnd = new Random();
        int r = rnd.nextInt(0, 256);

        int randLoc1 = rnd.nextInt(0, 256);
        int randLoc2 = rnd.nextInt(0, 256);
        int randLoc3 = rnd.nextInt(0, 256);


        int num = rnd.nextInt(0, 10);
        int num1 = rnd.nextInt(0, 10);
        int num2 = rnd.nextInt(0, 10);

        r1.setFillColor(r, 0, 0);
        r2.setFillColor(0, r, 0);
        r3.setFillColor(0, 0, r);

        r1.setLocation(randLoc1, randLoc1);
        r2.setLocation(randLoc2, randLoc2);
        r3.setLocation(randLoc3, randLoc3);

        // change the bounds to 1-10 so the shape changes 
        r1.setText("1");
        r2.setText("2");
        r3.setText("3");

    }
}


