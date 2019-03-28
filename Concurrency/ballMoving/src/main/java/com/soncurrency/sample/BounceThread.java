package com.soncurrency.sample;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class BounceThread
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setTitle("BounceThread");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
