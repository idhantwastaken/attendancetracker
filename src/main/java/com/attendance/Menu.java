package com.attendance;
import javax.swing.*;
public class Menu {
    
    static JFrame menumain;
    
    static java.awt.Color buttonColor = new java.awt.Color(0x44444444);
    static java.awt.Color hoverColor = new java.awt.Color(0x000000);
    static java.awt.Color backgroundColor = new java.awt.Color(0x000000);
    static java.awt.Color foregroundColor = new java.awt.Color(0xFFFFFF);
    static String msg = "";
    
    public static void holiday() {
        JFrame holiday = new JFrame("Attendance Tracker");
        holiday.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        holiday.getContentPane().setBackground(backgroundColor);
        holiday.setSize(500, 350);
        holiday.setLocationRelativeTo(null);
        holiday.setLayout(null);
        holiday.setResizable(false);

        JLabel label = new JLabel("Holiday!!");
        label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        label.setForeground(java.awt.Color.lightGray);
        label.setBounds(200, 10, 200, 120);

        holiday.add(label);
        
        JButton custom = new JButton("Custom");
        custom.setBorder(new RBorder(40));
        custom.setFocusable(false);
        custom.setOpaque(false);
        custom.setBounds(75, 125, 150, 50);
        custom.setBackground(buttonColor);
        custom.setForeground(foregroundColor);
        custom.setFont(new java.awt.Font("", java.awt.Font.PLAIN, 14));
        custom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                custom.setBackground(hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                custom.setBackground(buttonColor);
            }
        });
        
        custom.addActionListener(e -> {
            String customMessage = javax.swing.JOptionPane.showInputDialog(holiday, "Enter your custom message:");
            if(customMessage == null || customMessage.trim().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(holiday, "Custom message cannot be empty.");
                return;
            }
            msg = AttendanceTracker.getlast6records() + "> " + att.output('C', customMessage);
            holiday.setVisible(false);
            menumain.setVisible(false);
            menumain.removeAll();
            holiday.removeAll();
            AttendanceTracker.output();
        });
        
        JButton sunday = new JButton("Sunday");
        sunday.setBorder(new RBorder(40));
        sunday.setFocusable(false);
        sunday.setOpaque(false);
        sunday.setBounds(250, 125, 150, 50);
        sunday.setBackground(buttonColor);
        sunday.setForeground(foregroundColor);
        sunday.setFont(new java.awt.Font("", java.awt.Font.PLAIN, 14));
        sunday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sunday.setBackground(hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sunday.setBackground(buttonColor);
            }
        });
        
        sunday.addActionListener(e -> {
            msg = AttendanceTracker.getlast6records() + "> " + att.output('S', "");
            holiday.setVisible(false);
            menumain.setVisible(false);
            menumain.removeAll();
            holiday.removeAll();
            AttendanceTracker.output();
        });
        
        JButton Redo = new JButton("Go Back");
        Redo.setFocusable(false);
        Redo.setBorder(new RBorder(40));
        Redo.setOpaque(false);
        Redo.setBounds(162, 200, 150, 50);
        Redo.addActionListener(e -> {
            holiday.dispose();
            menumain.setVisible(false);
            menumain.removeAll();
            menu();
        });
        Redo.setBackground(Menu.buttonColor);
        Redo.setForeground(Menu.foregroundColor);
        Redo.setFont(new java.awt.Font("", java.awt.Font.PLAIN, 14));
        Redo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Redo.setBackground(Menu.hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Redo.setBackground(Menu.buttonColor);
            }
        });
        holiday.add(Redo);
        
        holiday.add(custom);
        holiday.add(sunday);
        holiday.setVisible(true);
        
    }
     
    public static void menu() {
        menumain = new JFrame("Attendance Tracker");
        menumain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menumain.getContentPane().setBackground(backgroundColor);
        menumain.setSize(800, 500);
        menumain.setLocationRelativeTo(null);
        menumain.setLayout(null);
        menumain.setResizable(false);
        
        javax.swing.JLabel label = new javax.swing.JLabel("Attendance Tracker: " + Id.name);
        label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
        label.setForeground(java.awt.Color.lightGray);
        label.setBounds(225, 50, 700, 50);
        
        JButton present = new JButton("Present");
        present.setFocusable(false);
        present.setOpaque(false);
        present.setBorder(new RBorder(40));
        present.setBounds(125, 175, 150, 50);
        present.setBackground(buttonColor);
        present.setForeground(foregroundColor);
        present.setFont(new java.awt.Font("", java.awt.Font.PLAIN, 14));
        present.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                present.setBackground(hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                present.setBackground(buttonColor);
            }
        });
        
        JButton absent = new JButton("Absent");
        absent.setBorder(new RBorder(40));
        absent.setFocusable(false);
        absent.setOpaque(false);
        absent.setBounds(300, 175, 150, 50);
        absent.setBackground(buttonColor);
        absent.setForeground(foregroundColor);
        absent.setFont(new java.awt.Font("", java.awt.Font.PLAIN, 14));
        absent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                absent.setBackground(hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                absent.setBackground(buttonColor);
            }
        });
        
        JButton custom = new JButton("Holiday");
        custom.setBorder(new RBorder(40));
        custom.setFocusable(false);
        custom.setOpaque(false);
        custom.setBounds(475, 175, 150, 50);
        custom.setBackground(buttonColor);
        custom.setForeground(foregroundColor);
        custom.setFont(new java.awt.Font("", java.awt.Font.PLAIN, 14));
        custom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                custom.setBackground(hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                custom.setBackground(buttonColor);
            }
        });
        
        JButton logout = new JButton("Logout");
        logout.setBorder(new RBorder(40));
        logout.setFocusable(false);
        logout.setOpaque(false);
        logout.setBounds(300, 275, 150, 50);
        logout.setBackground(java.awt.Color.decode("#0882fcff"));
        logout.setForeground(java.awt.Color.decode("#1b25afff"));
        logout.setFont(new java.awt.Font("", java.awt.Font.PLAIN, 14));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logout.setBackground(java.awt.Color.decode("#00bfffff"));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logout.setBackground(java.awt.Color.decode("#1e90ffff"));
            }
        });
        menumain.add(logout);
        
        JButton done = new JButton("Exit");
        done.setFocusable(false);
        done.setBorder(new RBorder(40));
        done.setOpaque(false);
        done.setBounds(475, 275, 150, 50);
        done.setBackground(java.awt.Color.red);
        done.setForeground(java.awt.Color.red);
        done.setFont(new java.awt.Font("", java.awt.Font.PLAIN, 14));
        done.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                done.setBackground(java.awt.Color.red.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                done.setBackground(java.awt.Color.red);
            }
        });
        
        JButton total = new JButton("Total");
        total.setFocusable(false);
        total.setBorder(new RBorder(40));
        total.setOpaque(false);
        total.setBounds(125, 275, 150, 50);
        total.setBackground(buttonColor);
        total.setForeground(foregroundColor);
        total.setFont(new java.awt.Font("", java.awt.Font.PLAIN, 14));
        total.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                total.setBackground(hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                total.setBackground(buttonColor);
            }
        });
        
        menumain.add(done);
        menumain.add(label); menumain.add(present); menumain.add(absent); menumain.add(custom); menumain.add(total); 
        menumain.setVisible(true);
        
        present.addActionListener(e -> {
            msg = AttendanceTracker.getlast6records() + "> " + att.output('P', "");
            menumain.setVisible(false);
            menumain.removeAll();
            AttendanceTracker.output();
        });
        
        absent.addActionListener(e -> {
            msg = AttendanceTracker.getlast6records() + "> " + att.output('A', "");
            menumain.setVisible(false);
            menumain.removeAll();
            AttendanceTracker.output();
        });
        
        custom.addActionListener(e -> {
            holiday();
        });
        
        total.addActionListener(e -> {
            menumain.setVisible(false);
            menumain.removeAll();
            msg = att.output('T',"");
            AttendanceTracker.output();
        });
        
        done.addActionListener(e -> {
            menumain.dispose();
            System.exit(0);
        });

        logout.addActionListener(e -> {
            menumain.setVisible(false);
            menumain.dispose();
            Id.gotId = false;
            Id.name = "";
            Id.index = 0;
            Id.file = "";
            javax.swing.JOptionPane.showMessageDialog(null, "You have been logged out.");
            Id id = new Id();
            id.getId();
        });
    }
    
    public static void main(String[] args) {
        Id id = new Id();
        id.getId();
        if(Id.gotId)
            menu();
    }
}