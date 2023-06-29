package org.example;

import javax.swing.*;
import java.awt.*;



public class CustomFrame extends JFrame implements Runnable {
    String message = "";

    JTextArea textArea = new JTextArea("Welcome user! \n");


    Thread th;
    public CustomFrame() throws HeadlessException {

        this.th = new Thread(this);
        this.th.start();
        this.textArea.setEditable(false);
        this.add(textArea);
    }

    public void paint(Graphics g) {
        super.paint(g); // always call this first - BUT MAY flicker.. on repaint..
    }



    public void updateMessage(String msg) {
        this.message = msg;
        this.textArea.append(this.message);
    }



    @Override
    public void run() {
        while (true) {
            this.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}