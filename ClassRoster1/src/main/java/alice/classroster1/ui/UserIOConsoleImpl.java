/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alice.classroster1.ui;

import java.util.Scanner;

/**
 *
 * @author ankang150
 */
public class UserIOConsoleImpl implements UserIO {

    Scanner s = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        boolean isValid = false;
        double num = 0;
        while (!isValid) {
            String input = s.nextLine();
            num = Double.parseDouble(input);
            isValid = true;
        }
        return num;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        boolean isValid = false;
        boolean inRange = false;
        double num = 0;
        while (!inRange) {
            while (!isValid) {
                try {
                    String input = s.nextLine();
                    num = Double.parseDouble(input);
                    isValid = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input, please try again.");
                }
            }
            if (num >= min && num <= max) {
                inRange = true;
            } else {
                System.out.println("Whoops please enter a number in given range");
                isValid = false;
            }
        }
        return num;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        boolean isValid = false;
        float num = 0;
        while (!isValid) {
            try {
                String input = s.nextLine();
                num = Float.parseFloat(input);
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input, please try again.");
            }
        }
        return num;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        boolean isValid = false;
        boolean inRange = false;
        float num = 0;
        while (!inRange) {
            while (!isValid) {
                try {
                    String input = s.nextLine();
                    num = Float.parseFloat(input);
                    isValid = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input, please try again.");
                }
            }
            if (num >= min && num <= max) {
                inRange = true;
            } else {
                System.out.println("Enter a number in given range");
                isValid = false;
            }
        }
        return num;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        boolean isValid = false;
        int num = 0;
        while (!isValid) {
            try {
                String input = s.nextLine();
                num = Integer.parseInt(input);
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input, please try again.");
            }
        }
        return num;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        boolean isValid = false;
        boolean inRange = false;
        int num = 0;
        while (!inRange) {
            while (!isValid) {
                try {
                    String input = s.nextLine();
                    num = Integer.parseInt(input);
                    isValid = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input, please try again.");
                }
            }
            if (num >= min && num <= max) {
                inRange = true;
            } else {
                System.out.println("Whoops please enter a number in given range");
                isValid = false;
            }
        }
        return num;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        boolean isValid = false;
        long num = 0;
        while (!isValid) {
            try {
                String input = s.nextLine();
                num = Long.parseLong(input);
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input, please try again.");
            }
        }
        return num;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        boolean isValid = false;
        boolean inRange = false;
        long num = 0;
        while (!inRange) {
            while (!isValid) {
                try {
                    String input = s.nextLine();
                    num = Long.parseLong(input);
                    isValid = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input, please try again.");
                }
            }
            if (num >= min && num <= max) {
                inRange = true;
            } else {
                System.out.println("Whoops please enter a number in given range");
                isValid = false;
            }
        }
        return num;
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        return s.nextLine();
    }

    @Override
    public String readAnswer(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
