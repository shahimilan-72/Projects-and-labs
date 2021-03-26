import java.util.*;
public class random{
    public static void main(String[] args) {
        double[][] priceList = {{17.99,15.99,12.99},            //defining the prices for all types of food
                {18.99,18.99,10.99},
                {21.99,22.99,26.99}};

        int[][] feedList = {{5,7,4},            //defining the feeds list so that we can get feeding of particular food item
                {7,7,5},
                {8,5,10}};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter How many people Want Food : ");               //taking the input of the people
        int people = Integer.parseInt(sc.nextLine());
        if(people>=10 && people<=100){            // if the no of people are not satisfying the condition then exit
            int countryChoice,foodOption,nOfTrays,leftOvers,feeds;          //varibles to store the values
            double subTotal,tax,tip,price,grandTotal,perPerson;             // some local variable to store the results

            while (true) {          //loop untill the user chooses a right choice
                displayMainMenu();
                countryChoice = Integer.parseInt(sc.nextLine());
                if(countryChoice>=1 && countryChoice<=3){
                    break;          // breaking after the correct input
                }
            }

            while (true) {          // based on the country choice display the food items list
                switch(countryChoice){
                    case 1:
                        displayItalianFoodMenu();
                        break;
                    case 2:
                        displayChineseFoodMenu();
                        break;
                    case 3:
                        displayAmericanFoodMenu();
                        break;
                }
                foodOption = Integer.parseInt(sc.nextLine());           //choose the food item
                if (foodOption>=1 && foodOption<=3) {
                    break;          // if the food item is the correct choice then exit the loop
                }
            }
            feeds = feedList[countryChoice-1][foodOption-1];                //based on country choice and food choice get the details of the feeding no
            price = priceList[countryChoice-1][foodOption-1];               //based on country choice and food choice get the details of the price
            nOfTrays = determineTrays(people,feeds);                // calling the no of trays function
            subTotal = getSubtotal(price,nOfTrays);         //calculating the subtotal
            tip = getTip(subTotal,0.15);            //calculate the tip
            tax = getTax(subTotal,0.07);            //calculate the tax
            grandTotal = getGrandTotal(subTotal,tip,tax);           // now calculate the grand total by passing the subtotal,tax and tip
            leftOvers = determineLeftOvers(feeds,nOfTrays,people); //calculate the leftovers
            perPerson = pricePerPerson(grandTotal,people);          // calculate the price per person
            System.out.println("You Need "+" "+nOfTrays+" trays");          //printing all the details
            System.out.println("Feeds :"+" "+feeds);
            System.out.println("Price for "+" "+people+" people ("+nOfTrays+" trays)"+":"+subTotal);
            System.out.println("Tax : "+(String.format("%.2f",tax)));
            System.out.println("Tip : "+(String.format("%.2f",tip)));
            System.out.println("Total(Food,Tax,Tip): "+String.format("%.2f",grandTotal));
            System.out.println("Price per Person :"+String.format("%.2f",perPerson));
            System.out.println("LeftOver servings for the delivery Person :"+leftOvers);
        }else{
            System.out.println("We can't make Order for LessThan 10 people.");
        }
    }

    public static void displayMainMenu(){           //function that displays the country choice options
        System.out.println("CHOOSE TYPE OF MEAL _ _ _ _");
        System.out.println("1. Italian\n2. Chinese\n3. American");
    }

    public static void displayItalianFoodMenu(){ //function that displays the italian food details
        System.out.println("CHOOSE ONE ---");
        System.out.println("1. Lasangna - Feeds 5 - 17.99");
        System.out.println("2. Pizza Pack - Feeds 7 - 15.99");
        System.out.println("3. Gazpacho Soup,salad and bread sticks pack - Feeds 4 - 12.99");
    }

    public static void displayChineseFoodMenu(){//function that displays the chinese food details
        System.out.println("CHOOSE ONE ---");
        System.out.println("1. Chicken and Braccoli Tray(includes 7 wonton soups,7 egg rolls) - Feeds 7 - 18.99");
        System.out.println("2. Sweet and Sour Fork Tray(includes 7 hot and sour soups,7 egg rolls) - Feeds 7 - 18.99");
        System.out.println("3. Shrip Fried Rice Tray(includes 10 egg rolls)- Feeds 5 - 10.99");
    }

    public static void displayAmericanFoodMenu(){ //function that displays the american food details
        System.out.println("CHOOSE ONE ---");
        System.out.println("1. Hamberger and Hot Dog Tray - includes buns and condiments - Feeds 8 - 21.99");
        System.out.println("2. Grilled Chicken Sandwich and Mozzarella Sticks Tray-includes dipping sauces - Feeds 5 - 22.99");
        System.out.println("3. Barbeque Tray-includes buns and peach clobber - Feeds 10 - 26.99");
    }

    public static int determineTrays(int people, int feeds){                //determining the no of trays
        int nTrays = people/feeds;              // taking the division of people by feeds
        if(people%feeds>0){
            nTrays+=1;              // if there is a remainder then we have to add another tray
        }
        return nTrays;
    }

    public static double getSubtotal(double price,int trays){               //calculate the subtotal
        return price*trays;
    }

    public static double getTax(double subtotal, double taxrate){           //calculate the tax
        return subtotal*taxrate;
    }

    public static double getTip(double subtotal, double tipRate){           //calculating the tip
        return subtotal*tipRate;
    }

    public static double getGrandTotal(double subtotal,double tax,double tip){              //calculating the grand total
        return subtotal+tax+tip;
    }

    public static double pricePerPerson(double grandTotal,int people){              //calculating the price per person
        return grandTotal/people;
    }

    public static int determineLeftOvers(int feeds,int trays,int people){           //determining the left overs
        return (trays*feeds)-people;
    }
}