import java.util.ArrayList;
import java.util.Optional;

public class Player extends Entity{

    private double money;
    private Basket shoppingBasket;
    private Inventory viewOfStoreInventory;

    public Player(String name, double startingMoney, Inventory startingInventory) {
        super(name, startingInventory);
        money = startingMoney;
        shoppingBasket = new Basket();
    }

    /**
     * Attempts to perform a purchase of the parameter item.
     * If the player has enough money for the item, their money is reduced,
     * and the item is purchased. Otherwise, no changes are made.
     * @param item
     */
    public void buy(ItemInterface item) {
        if (Double.valueOf(item.getInventoryTableRow().getColumnThree().trim()) > money) {
            return;
        }
        getInventory().addOne(item);
        money -= Double.valueOf(item.getInventoryTableRow().getColumnThree().trim());
    }

    /**
     * Attempt to sell an item by name. If an item with a matching name is
     * found, the players money is increased by the value of the item, and
     * the item is removed and returned.
     * @param itemName
     */
    public Optional<ItemInterface> sell(String itemName) {
        Optional<ItemInterface> i = removeItem(itemName);
        if (i.isPresent()) {
            money += Double.valueOf(i.get().getInventoryTableRow().getColumnThree().trim());
            return i;
        }
        return Optional.empty();
    }

    public Basket getShoppingBasket() {
        return shoppingBasket;
    }

    public void addToShoppingBasket(ItemInterface itemDataRow) {
        shoppingBasket.add(itemDataRow);
    }

    public void removeFromShoppingBasket(String itemName) {
        shoppingBasket.remove(itemName);
    }

    public ArrayList<ItemInterface> getStoreInventoryView() {
        return viewOfStoreInventory.getStock();
    }

    public Inventory getStoreView() {
        return viewOfStoreInventory;
    }

    public void setStoreView(Inventory storeInventory) {
        viewOfStoreInventory = storeInventory;
    }

    public double getMoney() {
        return money;
    }
    
}
