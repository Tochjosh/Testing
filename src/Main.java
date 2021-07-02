import java.util.Scanner;

import java.util.*;
public class Main {


        public static void main(String[] args) {
            int option;
            int chosenRow;
            int chosenSeat;
            double count = 0;

            //The admin enters the available rows and seats, and fixes this as the available seats the user can see.
            System.out.println("Good morning. Welcome to the admin ticket portal." +
                    "\n Kindly enter the available rows and seats");

            //the user enters their choice rows and seats here.
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of rows: ");
            int rows = sc.nextInt();

            System.out.println("Enter the number of seats per row: ");
            int seats = sc.nextInt();


            //the details entered by the user is used to create an array of all the total seats
            int totalSeat = rows * seats;

            String[][] allSeats = new String[rows][seats];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < seats; j++) {
                    allSeats[i][j] = "A";
                }
            }


            do {
                //the menu page that the user sees starts here.
                System.out.println("\t\tMENU\nChoose what you'd like to do by entering " +
                        "the options 1, 2 and 3 or enter 0 to exit." +
                        "\n1. show the seats\n2. Buy a ticket\n3. See ticket statistics\n0. Exit");

                System.out.println("Enter your option: ");
                option = sc.nextInt();


                //the total seat is displayed by printing out the array generated from the roe and seat that the user enters.
                if (option == 1) {
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < seats; j++) {
                            System.out.print(allSeats[i][j] + " ");
                        }
                        System.out.println();
                    }
                }

                if (option == 2) {
                    //the system prompts the user for details and uses this to check for seat availability
                    System.out.println("Please enter the row you'd like to purchase from: ");
                    chosenRow = sc.nextInt();

                    while (chosenRow > rows) {
                        System.out.println("Kindly enter a number between 1 and " + rows);
                        chosenRow = sc.nextInt();
                    }

                    System.out.println("Enter the seat you'd like: ");
                    chosenSeat = sc.nextInt();

                    while (chosenSeat > seats) {
                        System.out.println("Kindly enter a number between 1 and " + seats);
                        chosenSeat = sc.nextInt();
                    }

                    if (allSeats[chosenRow - 1][chosenSeat - 1] == "B") {
                        System.out.println("This seat has been purchased");

                    }

                    if (allSeats[chosenRow - 1][chosenSeat - 1] != "B"){
                        allSeats[chosenRow -1][chosenSeat - 1] = "B";
                        count++;
                        System.out.println("Ticket purchased successfully");

                    }
                }

                //some basic calculations is used to generate the statistics of sold tickets and and incomes.
                if (option == 3){
                    System.out.println("Percentage of tickets sold = "+ ((count/totalSeat)*100)+"%");
                    System.out.println("Current income = "+ (count*10)+"$");
                    System.out.println("Total income = "+totalSeat*10+"$");
                    System.out.println("Total Seat Bought = "+ count);
                }



            }
            //when the option is entered the program is exited.
            while (option != 0);
            System.out.println("Thank you, and have a good day");

        }

    }


