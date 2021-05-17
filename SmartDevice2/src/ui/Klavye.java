package ui;

import java.util.Scanner;

public class Klavye implements IKlavye {

    @Override
    public String getString() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    @Override
    public int getInt() {
        Scanner input = new Scanner(System.in);
        return Integer.parseInt(input.next());
    }
}
