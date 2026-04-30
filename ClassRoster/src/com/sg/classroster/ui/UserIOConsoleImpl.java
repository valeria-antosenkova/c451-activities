package com.sg.classroster.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readString(prompt));
            } catch (NumberFormatException e) {
                print("That was not a valid number. Try again.");
            }
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) return value;
            print("Please enter a number between " + min + " and " + max + ".");
        }
    }

    @Override
    public double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readString(prompt));
            } catch (NumberFormatException e) {
                print("That was not a valid number. Try again.");
            }
        }
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        while (true) {
            double value = readDouble(prompt);
            if (value >= min && value <= max) return value;
            print("Please enter a number between " + min + " and " + max + ".");
        }
    }

    @Override
    public float readFloat(String prompt) {
        while (true) {
            try {
                return Float.parseFloat(readString(prompt));
            } catch (NumberFormatException e) {
                print("That was not a valid number. Try again.");
            }
        }
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        while (true) {
            float value = readFloat(prompt);
            if (value >= min && value <= max) return value;
            print("Please enter a number between " + min + " and " + max + ".");
        }
    }

    @Override
    public long readLong(String prompt) {
        while (true) {
            try {
                return Long.parseLong(readString(prompt));
            } catch (NumberFormatException e) {
                print("That was not a valid number. Try again.");
            }
        }
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        while (true) {
            long value = readLong(prompt);
            if (value >= min && value <= max) return value;
            print("Please enter a number between " + min + " and " + max + ".");
        }
    }
}
