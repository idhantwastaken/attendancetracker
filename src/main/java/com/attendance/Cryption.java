package com.attendance;
public class Cryption {
    public static String encrypt(String text){
        String encryptedtext = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int asciiValue = (int) c;
            int keyValue = (int) Id.id.charAt(i % Id.id.length());
            int encryptedValue = asciiValue + keyValue;
            encryptedtext += (char) encryptedValue;
        }
        return encryptedtext;
    }
}
