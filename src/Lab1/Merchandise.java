package Lab1;

public class Merchandise implements Comparable<Merchandise> {
    private String itemCode;
    private int quantity;
    private float unitPrice;

    public Merchandise(String itemCode, int quantity, float unitPrice) {
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append(itemCode)
                .append(" - ")
                .append(quantity)
                .append(" - ")
                .append(unitPrice);

        return sb.toString();
    }

    @Override
    public int compareTo(Merchandise o) {
        return this.getItemCode().compareTo(o.getItemCode());
    }
}
