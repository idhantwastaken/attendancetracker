package com.attendance;
import java.io.*;
import java.util.*;

public class att {
    
    static String date() {      // To get the current date
        Date d = new Date();
        String str = d.toString();
        String[] arr = str.split(" ");
        return arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[5];
    }
    
    public static String output(char ch, String msg) {
        int total = 0;
        int present = 0;
        
        String res = "";
        
        try {
            FileWriter fw = new FileWriter(Id.file,true);
            File File = new File(Id.file);
            Scanner scan = new Scanner(File);
            String line;
            
            while (scan.hasNextLine()) {        // To get the last valid line
                line = scan.nextLine();
                if (!scan.hasNextLine()) {
                    String[] words = line.split(" "); 
                    if (line.contains("Total:")) {
                        total = Integer.parseInt(words[5]) + 1;
                        present = Integer.parseInt(words[9]);
                    } else {
                        // If the last line is invalid, continue searching backward
                        List<String> lines = new ArrayList<>();
                        try (BufferedReader br = new BufferedReader(new FileReader(File))) {
                            String currentLine;
                            while ((currentLine = br.readLine()) != null) {
                                lines.add(currentLine);
                            }
                        }
                        for (int i = lines.size() - 1; i >= 0; i--) {
                            String previousLine = lines.get(i);
                            if (previousLine.contains("Total:")) {
                                words = previousLine.split(" ");
                                total = Integer.parseInt(words[5]) + 1;
                                present = Integer.parseInt(words[9]);
                                break;
                            }
                        }
                    }
                }
            } 
            
            double percentage = Math.round((present * 1000000.0 / total)) / 10000.0;

            if (ch == 'P') {
                present++;
                percentage = Math.round((present * 1000000.0 / total)) / 10000.0;
                res = (date() + " Total: " + total + " |Present" + " |Total Present: " + present + " Percentage: " + percentage + "%\n");
            } else if (ch == 'A') {
                res = (date() + " Total: " + total + " |Absent" + " |Total Present: " + present + " Percentage: " + percentage+ "%\n");
            } else if (ch == 'C') {
                res = (date() + " " + msg + "\n");
            } else if(ch == 'T') {
                total -= 1;
                percentage = Math.round((present * 1000000.0 / total)) / 10000.0;
                scan.close();
                fw.close();
                return ("Total : " + total + " Days. Present: " + present + " Days. Absent: " + (total - present) + " Days. Percentage: " + percentage + "%");
            } else if(ch == 'S')
            res = (date() + " Sunday." + "\n");

            fw.write(res);
            
            fw.close();
            scan.close();

        } catch (Exception e) {
            res += "Error: " + e.getMessage();
        }

        return res;
    }
}