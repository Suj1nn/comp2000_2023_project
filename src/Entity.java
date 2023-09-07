import java.util.Optional;

public abstract class Entity {
    
    private String name;
    private Inventory inventory;
     
    public Entity(String name, Inventory inventory) {
        this.name = name;
        this.inventory = inventory;
    }

    public abstract Optional<ItemInterface> sell(String itemName);
    public abstract void buy(ItemInterface item);

    /**
     * Adds an item to hte held Inventory
     * @param item
     */
    public void addItem(ItemInterface item) {
        inventory.addOne(item);
    }

    /**
     * Removes and returns an item from the held Inventory that matches
     * the `itemName` parameter.
     * @param itemName
     */
    public Optional<ItemInterface> removeItem(String itenName) {
        return inventory.removeOne(itenName);
    }

    public String getName() {
        return name;
    }
    public Inventory getInventory() {
        return inventory;
    }

    
}
