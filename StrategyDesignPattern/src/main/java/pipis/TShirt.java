package pipis;

import java.util.Objects;

public class TShirt {

    private Color color;
    private Fabric fabric;
    private Size size;
    private String name;
    private int price;

    public TShirt() {
    }
    
    public TShirt(Color color, Fabric fabric, Size size, String name) {
        this.color = color;
        this.fabric = fabric;
        this.size = size;
        this.name = name;
        this.price=generatePrice();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.color);
        hash = 97 * hash + Objects.hashCode(this.fabric);
        hash = 97 * hash + Objects.hashCode(this.size);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Float.floatToIntBits(this.price);
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
        final TShirt other = (TShirt) obj;
        if (Float.floatToIntBits(this.price) != Float.floatToIntBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        if (this.fabric != other.fabric) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "T-Shirt with name: "+ name +" size "+ size +", is made out of "+ fabric + " colored " + color + " and costs € " + price;
    }

    private int generatePrice() {
        int price;
        price = this.getColor().ordinal()+1;
        price += this.getFabric().ordinal()+1;
        price += this.getSize().ordinal()+1;
        return (price);
    }

}
//================= enums ============================
enum Fabric {
    WOOL, COTTON, POLYESTER, RAYON, LINEN, CASHMERE, SILK
}

enum Size {
    XS, S, M, L, XL, XXL, XXXL
}

enum Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}
