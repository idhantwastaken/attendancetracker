package com.attendance;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;

import javax.swing.*;
public class Id {
    
    static File IdFile = new File("C:\\ivaef\\Java\\Attendance\\attendancetracker\\src\\main\\resources\\IDS\\Id.txt");
    static File Password = new File("C:\\ivaef\\Java\\Attendance\\attendancetracker\\src\\main\\resources\\IDS\\Pass.txt");

    //Taking id and password from Id and Password files
    private static String[] ids;
    static {
        if (IdFile.exists()) {
            try (java.util.Scanner scanner = new java.util.Scanner(IdFile)) {
                String line = scanner.nextLine();
                ids = line.replace("\"", "").split(" ");
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    private static String[] password;
    static {
        if (Password.exists()) {
            try (java.util.Scanner scanner = new java.util.Scanner(Password)) {
                String line = scanner.nextLine();
                password = line.replace("\"", "").split(" ");
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    static String file = "", name = "", id = "";
    static int index;
    static boolean gotId = false;
    
    void getId() {
        JFrame Get = new JFrame("Enter ID");
        Get.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Get.getContentPane().setBackground(Menu.backgroundColor);
        Get.setSize(375, 250);
        Get.setLocationRelativeTo(null);
        Get.setLayout(null);
        Get.setResizable(false);
        
        JButton signup = new JButton("Sign Up");
        signup.setBorder(new RBorder(40));
        signup.setFocusable(false);
        signup.setOpaque(false);
        signup.setBounds(20, 50, 150, 50);
        signup.setBackground(java.awt.Color.decode("#0882fcff"));
        signup.setForeground(java.awt.Color.decode("#1b25afff"));
        signup.setFont(new java.awt.Font("", java.awt.Font.PLAIN, 14));
        signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signup.setBackground(java.awt.Color.decode("#00bfffff"));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signup.setBackground(java.awt.Color.decode("#1e90ffff"));
            }
        });

        signup.addActionListener(e -> {
            id = javax.swing.JOptionPane.showInputDialog(Get, "Enter your Id");
            if(Arrays.asList(ids).contains(id)) {
                javax.swing.JOptionPane.showMessageDialog(Get, "Id already exists.");
                return;
            }
            String pass = javax.swing.JOptionPane.showInputDialog(Get, "Enter your Password");
            if(id.isEmpty() || pass.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(Get, "Id or Password cannot be empty.");
                return;
            }
            if(pass.length() < 6) {
                javax.swing.JOptionPane.showMessageDialog(Get, "Password must be at least 6 characters long.");
                return;
            }
            if(pass.length() > 32) {
                javax.swing.JOptionPane.showMessageDialog(Get, "Password must not exceed 32 characters.");
                return;
            }
            String[] newIds = Arrays.copyOf(ids, ids.length + 1);
            String[] newPassword = Arrays.copyOf(password, password.length + 1);
            newIds[newIds.length - 1] = id;
            newPassword[newPassword.length - 1] = Cryption.encrypt(pass);
            ids = newIds;
            password = newPassword;
            javax.swing.JOptionPane.showMessageDialog(Get, "Sign Up Successful!");
            try (java.io.PrintWriter idWriter = new java.io.PrintWriter(IdFile)) {
                idWriter.println(String.join(" ", ids));
            } catch (java.io.FileNotFoundException ex) {
                ex.printStackTrace();
            }
            try (java.io.PrintWriter passWriter = new java.io.PrintWriter(Password)) {
                passWriter.println(String.join(" ", password));
            } catch (java.io.FileNotFoundException ex) {
                ex.printStackTrace();
            }
            Get.setVisible(false);
            Get.dispose();
            gotId = true;
            name = id;
            file = "C:\\ivaef\\Java\\Attendance\\attendancetracker\\src\\main\\resources\\Logs\\" + (ids.length) + ".txt";

            File logFile = new File(file);
            if (!logFile.exists()) {
                try {
                    logFile.createNewFile();
                    FileWriter writer = new FileWriter(logFile, true);
                    writer.write((att.date() + " Total: " + 1 + " |Present" + " |Total Present: " + 1 + " Percentage: " + 100 + "%\n"));
                    writer.close();
                    AttendanceTracker.getlast6records();
                    AttendanceTracker.output();
                } catch (java.io.IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Get.add(signup);

        JButton enter = new JButton("Login");
        enter.setBorder(new RBorder(40));
        enter.setFocusable(false);
        enter.setOpaque(false);
        enter.setBounds(190, 50, 150, 50);
        enter.setBackground(java.awt.Color.decode("#0882fcff"));
        enter.setForeground(java.awt.Color.decode("#1b25afff"));
        enter.setFont(new java.awt.Font("", java.awt.Font.PLAIN, 14));
        enter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enter.setBackground(java.awt.Color.decode("#00bfffff"));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                enter.setBackground(java.awt.Color.decode("#1e90ffff"));
            }
        });
        
        enter.addActionListener(e -> {
            id = javax.swing.JOptionPane.showInputDialog(Get, "Enter your Id");
            if(Arrays.asList(ids).contains(id)) {
                String pass = javax.swing.JOptionPane.showInputDialog(Get, "Enter your Password");
                index = Arrays.asList(ids).indexOf(id);
                if(!password[index].equals(Cryption.encrypt(pass))) {
                    javax.swing.JOptionPane.showMessageDialog(Get, "Incorrect Password.");
                    return;
                }
                gotId = true;
                name = id;
                file = "C:\\ivaef\\Java\\Attendance\\attendancetracker\\src\\main\\resources\\Logs\\" + (index + 1) + ".txt";
                Get.setVisible(false);
                Get.dispose();
                Menu.menu();
            }
            else {
                javax.swing.JOptionPane.showMessageDialog(Get, "Incorrect Id.");
                return;
            }
        });
        
        JButton done = new JButton("Exit");
        done.setFocusable(false);
        done.setBorder(new RBorder(40));
        done.setOpaque(false);
        done.setBounds(105, 120, 150, 50);
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

        done.addActionListener(e -> {
            Get.dispose();
            System.exit(0);
        });

        Get.add(enter); Get.add(done);
        Get.setVisible(true);
    }
}