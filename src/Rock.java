public class Rock implements ItemInterface {

    String name;
    String description;
    double value;
    int expiry;
    
    public Rock(String name, String description, double value, int expiry) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.expiry = expiry;
    }

    @Override
    public InventoryTableRow getInventoryTableRow() {
        return new InventoryTableRow(name, description, String.valueOf(value), expiry + "");
    }

    @Override
    public CartTableRow getCartRow(String column3) {
        return new CartTableRow(name, String.valueOf(value), column3);
    }
}
