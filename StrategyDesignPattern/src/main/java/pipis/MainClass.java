package pipis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class MainClass {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();

    }

    public static void mainMenu() {
        System.out.println("=============================================");
        System.out.println("Welcome user how you want to proceed?");
        System.out.println("1. Create your shopping list from scratch?");
        System.out.println("2. Create a random shopping list?");
        System.out.println("3. Exit.");
        System.out.println("=============================================");
        System.out.println("Write here: ");
        String input = sc.next();
        switch (input) {
            case ("1"):
                cartCheckout(sList(), choosePayment());
                break;
            case ("2"):
                cartCheckout(randomList(), choosePayment());
                break;
            case ("3"):
                System.out.println("See you next time!");
                System.exit(0);
                break;
            default:
                System.out.println("Wrong input. Returning to home page...");
                mainMenu();

        }
        sc.close();
    }

    public static void cartCheckout(List<TShirt> shoppingList, PaymentStrategy payment) {
        System.out.println("Your shopping list contains:");
        int bill = 0;
        for (TShirt ts : shoppingList) {
            System.out.println(ts.toString());
            bill += ts.getPrice();
        }
        
        
        Cart cart = new Cart(bill, payment, shoppingList);

        cart.toString();
        payment.pay(bill);
    }
    

    public static PaymentStrategy choosePayment() {
        System.out.println("Please choose way of payment");
        System.out.println("1. By cash");
        System.out.println("2. By credit card.");
        System.out.println("3. By wire transfer.");
        String input = sc.next();
        PaymentStrategy payment = null;
        switch (input) {
            case ("1"):
                payment = new CashStrategy();
                break;
            case ("2"):
                payment = createCard();
                break;
            case ("3"):
                payment = new BankTransferStrategy();
                break;
            default:
                System.out.println("Something went wrong please try again");
                choosePayment();
        }
        return (payment);
    }

    public static CreditCardStrategy createCard() {
        String number = null;
        String name = null;
        int dateExp = 0;
        try {
            System.out.println("Please insert your name.");
            name = sc.next();
            name += sc.nextLine();
            System.out.println("Please insert Card nummber.");
            number = sc.next();
            System.out.println("Please expiration year of expiration.");
            dateExp = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Something went wrong please try again!");
            createCard();
        }
        
        return (new CreditCardStrategy(number, name, dateExp));
    }

    //==========================MANUAL VALUES==========================
    public static List<TShirt> sList() {
        List<TShirt> sList = new ArrayList();
        String input;
        try {
            do {
                sList.add(createTshirt());
                System.out.println("Do you want another T-Shirt? (Yes/No)");
                input = sc.next();
            } while (input.toLowerCase().equals("yes"));
        } catch (Exception e) {
            System.out.println("Something went wrong please try again");
            sList();
        }
        return (sList);

    }

    public static TShirt createTshirt() {
        System.out.println("Personalize your tshirt and give it a name.");
        String name = sc.next();
        TShirt t = new TShirt(chooseColor(), chooseFabric(), chooseSize(), name);
        return t;
    }

    public static Color chooseColor() {
        System.out.println("Please choose your color");
        Color[] clist = Color.values();
        int i = 1;
        for (Color c : clist) {

            System.out.println(i + ". " + c);
            i++;
        }

        int c = sc.nextInt() - 1;
        return (clist[c]);

    }

    public static Fabric chooseFabric() {
        System.out.println("Please choose your fabric");
        Fabric[] flist = Fabric.values();
        int i = 1;
        for (Fabric f : flist) {

            System.out.println(i + ". " + f);
            i++;
        }

        int f = sc.nextInt() - 1;
        return (flist[f]);

    }

    public static Size chooseSize() {
        System.out.println("Please create your color");
        Size[] slist = Size.values();
        int i = 1;

        for (Size s : slist) {
            System.out.println(i + ". " + s);
            i++;
        }

        int s = sc.nextInt() - 1;
        return (slist[s]);

    }

    //==========================RANDOM VALUES==========================
    public static List<TShirt> randomList() {
        List<TShirt> rList = new ArrayList();
        System.out.println("How many t-shirts you want to create");
        int r = sc.nextInt();
        for (int i = 0; i < r; i++) {
            String name = "Random name " + i;
            TShirt t = new TShirt(randomColor(), randomFabric(), randomSize(), name);
            rList.add(t);
        }
        return (rList);

    }

    public static Color randomColor() {
        Color[] clist = Color.values();
        Random r = new Random();
        int c = r.nextInt(Color.values().length);
        return (clist[c]);
    }

    public static Size randomSize() {
        Size[] slist = Size.values();
        Random r = new Random();
        int c = r.nextInt(Size.values().length);
        return (slist[c]);
    }

    public static Fabric randomFabric() {
        Fabric[] flist = Fabric.values();
        Random r = new Random();
        int c = r.nextInt(Fabric.values().length);
        return (flist[c]);
    }

}
