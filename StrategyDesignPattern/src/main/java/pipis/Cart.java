package pipis;

import java.util.List;
import java.util.Objects;


public class Cart {
private  int bill;
private PaymentStrategy strategy;
private List<TShirt> list;

    public Cart() {
    }


    public Cart(int bill, PaymentStrategy strategy, List<TShirt> list) {
        this.bill = bill;
        this.strategy = strategy;
        this.list = list;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public PaymentStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public List<TShirt> getList() {
        return list;
    }

    public void setList(List<TShirt> list) {
        this.list = list;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.bill;
        hash = 89 * hash + Objects.hashCode(this.strategy);
        hash = 89 * hash + Objects.hashCode(this.list);
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
        final Cart other = (Cart) obj;
        if (this.bill != other.bill) {
            return false;
        }
        if (!Objects.equals(this.strategy, other.strategy)) {
            return false;
        }
        if (!Objects.equals(this.list, other.list)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cart{" + "bill=" + bill + ", strategy=" + strategy + ", list=" + list + '}';
    }




}
