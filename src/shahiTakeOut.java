
import java.util.Scanner;

public class shahiTakeOut {


    public static void main(String[] args){
        System.out.println("--------Food menu and bill calculator---------");
        Scanner input = new Scanner(System.in);
        System.out.println("How many people are making order?  ");
        int numberPeople = input.nextInt();

        if (numberPeople >= 10 && numberPeople <= 100) {
            int leftOvers,trays;
            double subTotal,  pricePerPerson, GrandTotal, tax, tip;
            double taxrate = 0.07;
            double tipRate = 0.15;
            displaymenu();
            displayItalianFoodMenu ();
            displayChineseFoodMenu ();
            displayAmericanFoodMenu ();
            trays = determineTrays(feeds,numberPeople);
            subTotal = getSubtotal(price, trays);
            tax = getTax (subTotal, taxrate);
            tip = getTip(subTotal,tipRate);
            GrandTotal = getGrandTotal (subTotal,tax, tip);
            pricePerPerson = pricePerPerson( GrandTotal,numberPeople);
            leftOvers = determineLeftOvers (feeds, trays, numberPeople);


           System.out.println("You need " +trays+ " trays");
           System.out.println("Feeds " +feeds);
           System.out.println("The price for " + numberPeople + " people is " + subTotal);
           System.out.println("Tax amount: " + tax);
           System.out.println("Tip amount " + tip);
           System.out.println("Total(food,tax, tip): " + GrandTotal);
           System.out.println("Price per person " + pricePerPerson);
           System.out.println("Leftover servings for delivery person " + leftOvers);

        } else
            {
            System.out.println("Invalid input!!");
        }
    }
    public static void displaymenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("--------Menu------------");
        System.out.println("Choose type of meal?");
        System.out.println("\n 1. Italian \n 2. Chinese \n 3. American");
        String foodType = input.nextLine();
        switch (foodType) {
                case "1":
                displayItalianFoodMenu();
                break;
                case "2":
                    displayChineseFoodMenu();
                    break;
                case "3":
                    displayAmericanFoodMenu();
                    break;
                default:
                    break;

            }
        }

        public static void displayItalianFoodMenu () {
            Scanner input = new Scanner(System.in);
            System.out.println("\n1. Lasagna Tray - Feeds 5 - 17.99 \n2. Pizza Pack - Feeds 7 - 15.99 \n3. Gazpacho Soup, salad and bread sticks pack - Feeds 4 - 12.99");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    String food = "Lasagna Tray";
                    int feeds = 5;
                    double price = 17.99;
                    break;

                case 2:
                    food = "Pizza Pack";
                    feeds = 7;
                    price = 15.99;
                    break;

                case 3:
                    food = "Gazpacho Soup, salad and bread sticks pack";
                    feeds = 4;
                    price = 12.99;
                    break;

                default:
                    break;
            }
        }

        public static void displayChineseFoodMenu () {
            Scanner input = new Scanner(System.in);
            System.out.println("\n1. Chicken and Broccoli Tray (includes 7 wonton soups, 7 egg rolls) - feeds 7 - 18.99  \n2.Sweet and Sour Pork Tray (includes 7 hot and sour soups, 7 egg rolls) - feeds 7 - 18.99. \n3.Shrimp Fried Rice Tray (includes 10 egg rolls) - Feeds 5 - 10.99");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    String food = "Chicken and Broccoli Tray (includes 7 wonton soups, 7 egg rolls)";
                    int feeds = 7;
                    double price = 18.99;
                    break;

                case 2:
                    food = "Sweet and Sour Pork Tray (includes 7 hot and sour soups, 7 egg rolls)";
                    feeds = 7;
                    price = 18.99;
                    break;

                case 3:
                    food = "Shrimp Fried Rice Tray (includes 10 egg rolls)";
                    feeds = 5;
                    price = 10.99;
                    break;

                default:
                    break;

            }

        }

        public static void displayAmericanFoodMenu () {
            Scanner input = new Scanner(System.in);
            System.out.println("\n1. Hamburger and Hot Dog Tray - includes buns and condiments - feeds 8 - 21.99\n2. Grilled Chicken Sandwich and Mozzarella Sticks Tray - includes dipping sauces -Feeds 5 - 22.99\n3. Barbeque Tray - includes buns and peach cobbler - Feeds 10 - 26.99");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    String food = "Hamburger and Hot Dog Tray - (includes buns and condiments)";
                    int feeds = 8;
                    double price = 21.99;
                    break;

                case 2:
                    food = " Grilled Chicken Sandwich and Mozzarella Sticks Tray - includes dipping sauces";
                    feeds = 5;
                    price = 22.99;
                    break;

                case 3:
                    food = "3. Barbeque Tray - includes buns and peach cobbler ";
                    feeds = 10;
                    price = 26.99;
                    break;

                default:
                    break;

            }
        }

        public static int determineTrays(int numberPeople , int feeds, double price, String food) {
            int trays = numberPeople / feeds;
            if (trays % feeds > 0)
            {
               trays = +trays;
             }return trays;
        }
        public static double getSubtotal (double price, int trays)
        {
            return  trays * price;

        }
        public static double getTax ( double subtotal, double taxrate)
        {
            return  taxrate * subtotal;

        }
        public static double getTip ( double subtotal, double tipRate)
        {
            return tipRate * subtotal;

        }
        public static double getGrandTotal ( double subtotal, double tax, double tip)
        {
           return  subtotal + tax + tip;

        }
        public static double pricePerPerson ( double grandTotal, int people)
        {
            return grandTotal / people;

        }
        public static int determineLeftOvers (int feeds, int trays, int numberPeople)
        {
            return  numberPeople - feeds * trays;

        }

    }

