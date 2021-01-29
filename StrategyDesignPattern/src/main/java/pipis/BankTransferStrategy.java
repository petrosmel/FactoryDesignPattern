package pipis;

import java.util.Objects;

public class BankTransferStrategy implements PaymentStrategy {

    private final String BANKNAME ="Greek Bank";
    private final String ACCOUNTNUMBER= "GR124554554445544665441357788";

    public BankTransferStrategy() {
    }

    public String getBANKNAME() {
        return BANKNAME;
    }

    public String getACCOUNTNUMBER() {
        return ACCOUNTNUMBER;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.BANKNAME);
        hash = 47 * hash + Objects.hashCode(this.ACCOUNTNUMBER);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankTransferStrategy other = (BankTransferStrategy) obj;
        if (!Objects.equals(this.BANKNAME, other.BANKNAME)) {
            return false;
        }
        if (!Objects.equals(this.ACCOUNTNUMBER, other.ACCOUNTNUMBER)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "BankTransferStrategy{" + "BANKNAME=" + BANKNAME + ", ACCOUNTNUMBER=" + ACCOUNTNUMBER + '}';
    }

   

    @Override
    public void pay(int bill) {
        System.out.println("You will pay € " + bill + " via Bank wire transfer.");
        System.out.println("Please use bank account: " +this.ACCOUNTNUMBER+ " provided by "+ this.BANKNAME + ".");
    }
}
