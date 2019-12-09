package util;

import java.security.spec.ECField;
import java.util.Scanner;

public class Input {
    private Scanner scan = new Scanner(System.in);

    //! Get String
    public String getString(){
        return scan.nextLine();
    }

    //! YES OR NO
    public boolean getBoolean(int count) throws Exception {
        try{
            if(count == 3) throw new Exception();
        }catch (Exception e){
            System.out.println("Function Cancled. Value False");
            return false;
        }
        String response = scan.nextLine();
        if(response.equals("yes") || response.equals("y")) return true;
        else if(response.equals("no") || response.equals("n")) return false;
        else {
            System.out.println("incorrect input, try again: ");
            return getBoolean(count+1);
        }
    }
    public boolean getBoolean() throws Exception {
        return getBoolean(0);
    }

    //! GET INT
    public int getInt(int min, int max, int count){
        try{
            if(count == 3) throw new Exception();
        } catch (Exception e) {
            System.out.printf("Function Cancled. Value %n", min);
            return min;
        }
        int num = Integer.parseInt(scan.nextLine());
        if(num >= min && num <= max) return num;
        else return getInt(min, max, count+1);
    }

    public int getInt(){
        // positive numbers
        return getInt(0, Integer.MAX_VALUE,0);
    }

    //! DOUBLE
    public double getDouble(String min, String max, int count){
        Double minimum = Double.parseDouble(String.valueOf(min));
        Double maximum = Double.parseDouble(String.valueOf(max));
        try{
            if(count == 3) throw new Exception();
        } catch (Exception e) {
            System.out.printf("Function cancled. Value %d", min);
            return maximum;
        }
        Double answer = Double.parseDouble(scan.nextLine());
        if(answer >= minimum && answer <= maximum) return answer;
        else return getDouble(min, max, count+1);
    }

    public double getDouble(){
        return getDouble("0", String.valueOf(Double.MAX_VALUE), 0);
    }
// end
}