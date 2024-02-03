package unibo.exiled.model.item;

/**
 * Represents an item that can't be used by the player, such as crystals.
 */
public class UnUsableItem extends ItemBase {

    /**
     * Constructs an UnUsableItem with the specified name and description.
     *
     * @param name        The name of the un-usable item.
     * @param description The description of the un-usable item.
     */
    public UnUsableItem(final String name, final String description) {
        super(name, description, ItemType.RESOURCE);
    }
}
