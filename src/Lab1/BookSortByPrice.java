package Lab1;

import java.util.Comparator;

public class BookSortByPrice implements Comparator<Merchandise> {

    @Override
    public int compare(Merchandise o1, Merchandise o2) {
        float o1Price = o1.getQuantity() * o1.getUnitPrice();
        float o2Price = o2.getQuantity() * o2.getUnitPrice();
        return Float.compare(o2Price, o1Price);
    }
}
