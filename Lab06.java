/*
 * Nicolas DeTroia
 * October 18, 2023 
 * Lab06.java
 * This code implements multidimensional arrays as well as 2D arrays
 */

import doodlepad.*;

public class Lab06 { 

    public static Pad pad; 
    public static Rectangle[][] rects = new Rectangle[5][5];

    public static void main(String[] args) { 
        pad = new Pad("Lights out", 500, 500);

        for (int i = 0; i < 5; i++) { 
            for(int j = 0; j < 5; j++) {
                int x = j * 100; 
                int y = i * 100;
                rects[i][j] = new Rectangle(x, y, 100, 100);
                rects[i][j].setFillColor(1, 1, 1);
                rects[i][j].setMousePressedHandler(Lab06::onMousePressed);
            }
        }
    }

    public static void onMousePressed(Shape shp, double x, double y, int button) {
        int r = (int)Math.floor(y/100);
        int c = (int)Math.floor(x/100);

        Rectangle rect = rects[r][c];
        toggle(r, c);

        if(r-1 >= 0) toggle(r-1, c);
        if(r+1 < 5) toggle(r+1, c);
        if(c-1 >= 0) toggle(r, c-1);
        if(c+1 < 5) toggle(r, c+1);
    }

    // Check if the Rectangle (light) is on by inspecting its fill color elements.
    public static void toggle(int r, int c) {
        Rectangle rect = rects[r][c];
        if (rect.getFillColor().getRed() == 1.0 && rect.getFillColor().getGreen() == 1.0 && rect.getFillColor().getBlue() == 1.0) {  // If color is white
            rect.setFillColor(0, 0, 0);  // Change to black
        } else {
            rect.setFillColor(1, 1, 1);  // Change to white
        }
    }
}
