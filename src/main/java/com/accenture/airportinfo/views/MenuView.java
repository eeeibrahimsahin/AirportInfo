package com.accenture.airportinfo.views;

import java.util.Scanner;

import static com.accenture.airportinfo.constants.Constant.*;

public class MenuView {
    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(SELECTION_MENU);
        System.out.print(ENTER_SELECTION);
        int userSelection = 0;
        try {
            userSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ignored) {
            System.out.println(ENTER_A_NUMBER);
        }
        while (true) {
            if (userSelection <= 4)
                return userSelection;
        }
    }

    public static String takeCountryCodeFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(ENTER_COUNTRY_CODE);
        return scanner.nextLine();
    }

    public static String takeCountryNameFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(ENTER_COUNTRY_NAME);
        return scanner.nextLine();
    }

    private MenuView() {
    }
}
