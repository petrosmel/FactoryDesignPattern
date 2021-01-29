package pipis;

public class CreditCardStrategy implements PaymentStrategy {

    private final String CARDNUMBER;
    private final String OWNER;
    private final int EXPIRATION;

    public CreditCardStrategy(String number, String owner, int dateExp) {
        this.CARDNUMBER = number;
        this.OWNER = owner;
        this.EXPIRATION = dateExp;
    }

    @Override
    public void pay(int bill) {
        System.out.println("You will pay € " + bill + " using your Credit Card.");

        try {
            String hideName = OWNER.substring(0, 3);
            for (int i = 0; i < OWNER.length() - 3; i++) {
                hideName += "*";
            }
            
            String hideNumber = "";
            for (int i = 0; i < CARDNUMBER.length() - 3; i++) {
                hideNumber += "*";
            }
            hideNumber += CARDNUMBER.substring(CARDNUMBER.length() - 3);
            System.out.println("You used Card belonging to " + hideName + " with card number " + hideNumber + " expiring on " + EXPIRATION + ".");
        } catch (Exception e) {
               System.out.println("Your Card is not accepted please try again ");
              
            
        }

     

    }

}
