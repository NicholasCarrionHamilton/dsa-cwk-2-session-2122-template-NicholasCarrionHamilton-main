//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputHelper {
    private final Scanner reader;

    public InputHelper() {
        this.reader = new Scanner(System.in);
    }

    public char readCharacter(String prompt) {
        System.out.println(prompt + ": ");
        char inputText = this.reader.nextLine().charAt(0);
        return inputText;
    }

    public char readCharacter(String prompt, String validCharacters) {
        char inputText;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");
            inputText = this.reader.nextLine().toUpperCase().charAt(0);
            if (validCharacters.indexOf(inputText) == -1) {
                inputError = true;
                System.out.println("Character out of range: please re-enter: ");
            }
        } while(inputError);

        return inputText;
    }

    public String readString(String prompt) {
        System.out.println(prompt + ": ");
        String inputText = this.reader.nextLine();
        return inputText;
    }

    public int readInt(String prompt, int max, int min) {
        int inputNumber = 0;

        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(this.reader.nextLine());
                if (inputNumber < min || inputNumber > max) {
                    inputError = true;
                    System.out.println("Number out of range: please re-enter\n");
                }
            } catch (NumberFormatException var7) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while(inputError);

        return inputNumber;
    }

    public int readInt(String prompt) {
        int inputNumber = 0;

        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(this.reader.nextLine());
            } catch (NumberFormatException var5) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while(inputError);

        return inputNumber;
    }

    public double readDouble(String prompt) {
        double inputNumber = 0.0D;

        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Double.parseDouble(this.reader.nextLine());
            } catch (NumberFormatException var6) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while(inputError);

        return inputNumber;
    }

    public Calendar readDate(String prompt, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = this.readString("Enter date yyyy-MM-dd");
        Date date = null;

        try {
            date = sdf.parse(dateInString);
        } catch (ParseException var7) {
            Logger.getLogger(InputHelper.class.getName()).log(Level.SEVERE, (String)null, var7);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
