import java.awt.*;
import java.util.Scanner;

import javax.swing.*;

class CircleDDA extends JPanel {
    
    int xc = 250; 
    int yc = 250; 
    int r = 100;  
    String style = "solid"; 

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter 1 forr DDACircle Algorithm and 2 for Bresanhams Algorithm ");
        int choice = sc.nextInt();
        if(choice==1){
            drawCircleDDA(g, xc, yc, r, style);
        }
        else if (choice==2){
            drawCircleBresenham(g, xc, yc, r, style);
        }
        else{
            System.out.println("invalid input");
        }
    }

    
    void drawCircleDDA(Graphics g, int xc, int yc, int r, String style) {
        double x = 0;
        double y = r;
        double p = 3 - 2 * r; 
        int count = 0; 

        while (x <= y) {
            
            plot(g, xc + (int)x, yc + (int)y, style, count);
            plot(g, xc - (int)x, yc + (int)y, style, count);
            plot(g, xc + (int)x, yc - (int)y, style, count);
            plot(g, xc - (int)x, yc - (int)y, style, count);
            plot(g, xc + (int)y, yc + (int)x, style, count);
            plot(g, xc - (int)y, yc + (int)x, style, count);
            plot(g, xc + (int)y, yc - (int)x, style, count);
            plot(g, xc - (int)y, yc - (int)x, style, count);

            x++;
            if (p < 0) {
                p = p + 4 * x + 6;
            } else {
                y--;
                p = p + 4 * (x - y) + 10;
            }
            count++;
        }
    }
    void drawCircleBresenham(Graphics g, int xc, int yc, int r, String style) {
    int x = 0;
    int y = r;
    int d = 3 - 2 * r;
    int count = 0; // For dotted style

    while (x <= y) {
        // Plot all 8 octants
        plot(g, xc + x, yc + y, style, count);
        plot(g, xc - x, yc + y, style, count);
        plot(g, xc + x, yc - y, style, count);
        plot(g, xc - x, yc - y, style, count);
        plot(g, xc + y, yc + x, style, count);
        plot(g, xc - y, yc + x, style, count);
        plot(g, xc + y, yc - x, style, count);
        plot(g, xc - y, yc - x, style, count);

        if (d < 0) {
            d = d + 4 * x + 6;
        } else {
            d = d + 4 * (x - y) + 10;
            y--;
        }
        x++;
        count++;
    }
}

    void plot(Graphics g, int x, int y, String style, int count) {
        if (style.equals("solid")) {
            g.fillRect(x, y, 1, 1);
        } else if (style.equals("dotted")) {
            if (count % 4 == 0) { 
                g.fillRect(x, y, 1, 1);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DDA Circle Drawing");
        CircleDDA panel = new CircleDDA();
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}