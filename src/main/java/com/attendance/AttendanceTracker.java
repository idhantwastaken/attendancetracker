package com.attendance;
import javax.swing.*;
public class AttendanceTracker{

    static void output() {
        JFrame frame1 = new JFrame("Attendance Tracker Output");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.getContentPane().setBackground(Menu.backgroundColor);
        frame1.setSize(800, 500);
        frame1.setLocationRelativeTo(null);
        frame1.setLayout(null); 
        frame1.setResizable(false);
        
        javax.swing.JLabel outputLabel = new javax.swing.JLabel("<html>" + Menu.msg.replace("\n", "<br>") + "</html>");
        outputLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 16));
        outputLabel.setForeground(java.awt.Color.lightGray);
        outputLabel.setBounds(100, 50, 700, 200);
        frame1.add(outputLabel);
        
        Menu.msg = "";
        
        JButton open = new JButton("Open Log");
        open.setFocusable(false);
        open.setBorder(new RBorder(40));
        open.setOpaque(false);
        open.setBounds(100, 275, 150, 50);
        open.addActionListener(e -> {
            try {
                java.io.File file = new java.io.File(Id.file);
                if (file.exists()) {
                    java.awt.Desktop.getDesktop().open(file);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Log file not found.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(null, "Error opening log file.");
            }
        });
        open.setBackground(Menu.buttonColor);
        open.setForeground(Menu.foregroundColor);
        open.setFont(new java.awt.Font("", java.awt.Font.PLAIN, 14));
        open.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                open.setBackground(Menu.hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                open.setBackground(Menu.buttonColor);
            }
        });
        frame1.add(open);
        
        
        JButton Redo = new JButton("Go Back");
        Redo.setFocusable(false);
        Redo.setBorder(new RBorder(40));
        Redo.setOpaque(false);
        Redo.setBounds(300, 275, 150, 50);
        Redo.addActionListener(e -> {
            frame1.dispose();
            Menu.menu();
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
        frame1.add(Redo);
        
        JButton del = new JButton("Delete Last Entry");
        del.setFocusable(false);
        del.setOpaque(false);
        del.setBorder(new RBorder(40));
        del.setBounds(500, 275, 200, 50);
        del.addActionListener(e -> {
            try {
                java.io.File file = new java.io.File(Id.file);
                java.util.List<String> lines = java.nio.file.Files.readAllLines(file.toPath());
                lines.remove(lines.size() - 1); // Remove the last entry
                java.nio.file.Files.write(file.toPath(), lines);
            } catch (Exception ex) {
                ex.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(null, "Error deleting last entry.");
            }
            Menu.msg = getlast6records() + "> ";
            output();
            frame1.dispose();
        });
        del.setBackground(Menu.buttonColor);
        del.setForeground(Menu.foregroundColor);
        del.setFont(new java.awt.Font("", java.awt.Font.PLAIN, 14));
        del.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                del.setBackground(Menu.hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                del.setBackground(Menu.buttonColor);
            }
        });
        frame1.add(del);
        
        JButton done = new JButton("Exit");
        done.setFocusable(false);
        done.setBorder(new RBorder(40));
        done.setOpaque(false);
        done.setBounds(300, 350, 150, 50);
        done.addActionListener(e -> {
            frame1.dispose();
            System.exit(0);
        });
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
        frame1.add(done);
        frame1.setVisible(true);
    }
    
    static String getlast6records() {
        try {
            java.io.File file = new java.io.File(Id.file);
            java.util.List<String> lines = java.nio.file.Files.readAllLines(file.toPath());
            int start = Math.max(0, lines.size() - 6);
            for (int i = start; i < lines.size(); i++) {
                Menu.msg += (lines.get(i)) + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
            Menu.msg = ("Error reading log file.");
        }
        return Menu.msg;   
    }
}