package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ItemToShulkerConverter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean runProgram = true;
        while (runProgram) {
            int itemAmount;

            try {
                System.out.print("enter the number of items: ");
                itemAmount = input.nextInt();

                if (itemAmount < 0) {
                    System.out.println("Error: you cant enter a negative number\n");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: enter a valid number\n");
                input.nextLine();
                continue;
            }

            int itemsPerBox = 1728; // number of items that can fit in a shulker box
            int boxesNeeded = itemAmount / itemsPerBox; // number of full boxes needed
            int itemsRemaining = itemAmount % itemsPerBox; // remaining items after filling boxes
            int itemsInLastStack = itemsRemaining % 64; // number of items in the last stack
            int stacksForRemainingItems = itemsRemaining / 64; // number of stacks needed for remaining items
            int remainingBoxesNeeded = (stacksForRemainingItems == 1) ? 1 : ((stacksForRemainingItems - 1) / 64) + 1; // number of boxes needed for remaining items
            String remainingAmount = remainingBoxesNeeded + " shulker box with " + stacksForRemainingItems + " stacks and " + itemsInLastStack;

            if (itemAmount <= 1728) {
                remainingAmount = "none";
            }


            System.out.println("For " + itemAmount + " items, you will need:\n" + boxesNeeded + " full shulker box(es) " + "| remaining amount: "  + remainingAmount);
            runProgram = false;
        }
    }
}
