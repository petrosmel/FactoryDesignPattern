package pipis;

public class CashStrategy implements PaymentStrategy {


   

    @Override
    public void pay(int bill) {
        System.out.println("You will pay € " + bill + " by cash.");
    }

}
