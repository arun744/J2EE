package com.ajayaraj.olympicshop;

public class Main {
    
    /**
     * Gets a substring from a string.
     */
    public void getSubstring() {
        

        String str = "ajayaraj0001";
        
        String sub = str.substring(0, 8);
        int number = Integer.parseInt(str.substring(8, str.length()));
        
        int increment = number + 10;
        String formatValue = String.format("%04d", increment);
        System.out.println(sub);
        
        String complete = sub.concat(String.valueOf(formatValue));
        sub = str.substring(10);
        
        System.out.println(complete);
    }
    
    /**
     * Starts the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().getSubstring();
    }
}