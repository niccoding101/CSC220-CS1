/*
 * Nicolas DeTroia
 * Fri October 27, 2023
 * Project2.java
 * This codes purpose is to randomize 3 squares and turn the lights off in a random order 
 */

import doodlepad.*;
import java.util.Random;

public class Project2 {

    public static Pad pad;
    public static Rectangle[][] rects = new Rectangle[5][5];

    public static void main(String[] args) {
        pad = new Pad("Lights out", 500, 500);
        
        // creates 5x5 rectangle array 
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int x = j * 100;
                int y = i * 100;
                rects[i][j] = new Rectangle(x, y, 100, 100);
                rects[i][j].setFillColor(255, 255, 255);  // RGB for grey color 
                rects[i][j].setMousePressedHandler(Project2::onMousePressed);
            }
        }
        
        newGame();
    }

    public static void turnOff(int r, int c) {
        rects[r][c].setFillColor(0, 0, 0);  // TURNS BLOCK TO DARK COLOR
    }

    public static void turnOn(int r, int c) {
        rects[r][c].setFillColor(255, 255, 255);  // TURNS BLOCK TO LIGHT COLOR
    }

    public static boolean isOn(int r, int c) { // filled with chosen light color 
        Rectangle rect = rects[r][c];
        return rect.getFillColor().getRed() == 255.0 && rect.getFillColor().getGreen() == 255.0 && rect.getFillColor().getBlue() == 255.0;
    }

    public static void toggle(int r, int c) {
        if (isOn(r, c)) { // initialzies the variables from the game constructor 
            turnOff(r, c); 
        } else {
            turnOn(r, c);
        }
    }

    public static void clear() {
        for (int r = 0; r < 5; r++) { // turns off all rectangles by generating all array indexes r and c 
            for (int c = 0; c < 5; c++) {
                turnOff(r, c);
            }
        }
    }

    public static void play(int r, int c) {
        toggle(r, c); // plays game light at indexes [r][c]
        if (r - 1 >= 0) toggle(r - 1, c);
        if (r + 1 < 5) toggle(r + 1, c);
        if (c - 1 >= 0) toggle(r, c - 1);
        if (c + 1 < 5) toggle(r, c + 1);
    }

    public static void onMousePressed(Shape shp, double x, double y, int button) {
        int r = (int) Math.floor(y / 100.0);
        int c = (int) Math.floor(x / 100.0);
        play(r, c); 
    }

    public static void newGame() {
        clear(); // sets up new game 
        Random rand = new Random();
        
        // Randomly toggle at least 3 rectangles
        for (int i = 0; i < 3; i++) { // loop repeats three times 
            int r = rand.nextInt(5);
            int c = rand.nextInt(5);
            play(r, c);
            System.out.println("Toggled: " + r + ", " + c);  // prints indexes r and c to terminal
        }
    }
}
