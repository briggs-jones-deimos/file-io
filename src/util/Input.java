package util;

import java.util.Scanner;

public class Input {
    private Scanner scan = new Scanner(System.in);

    //! Get String
    public String getString(){
        return scan.nextLine();
    }

    //! YES OR NO
    public boolean yesNo(){
        String input = getString();
        if(input.equalsIgnoreCase("yes")) return true;
        else return false;
    }

    //! GET INT
    public int getInt(double min, double max){
        int num;
        while (true){
            num = Integer.parseInt(getString());
            if(num >= min && num <= max) break;
            System.out.printf("Please enter a number between %d and %d", min, max);
        }
        return num;
    }

    public int getInt(){
        // positive numbers
        return getInt(0, Integer.MAX_VALUE);
    }

    //! DOUBLE
    public double getDouble(double min, double max){
        min = Double.parseDouble(String.valueOf(min));
        max = Double.parseDouble(String.valueOf(max));
        double input;
        while (true){
            input = Double.parseDouble(getString());
            if(input >= min && input <= max) break;
            System.out.printf("Please enter a number between %s and %s: ", min, max);
        }
        return input;
    }

    public double getDouble(){
        return getDouble(0, Double.MAX_VALUE);
    }
// end
}