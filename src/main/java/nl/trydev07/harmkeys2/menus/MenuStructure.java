package nl.trydev07.harmkeys2.menus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nl.trydev07.core.gui.ClickableItem;
import nl.trydev07.core.gui.SmartInventory;
import nl.trydev07.core.gui.content.InventoryContents;
import nl.trydev07.core.gui.content.InventoryProvider;
import nl.trydev07.core.gui.content.Pagination;
import nl.trydev07.core.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public abstract class MenuStructure implements InventoryProvider {

    private final OfflinePlayer offlinePlayer;

    protected MenuStructure(Player player) {
        this.offlinePlayer = player;
    }

    protected MenuStructure() {
        this.offlinePlayer = null;
    }

    public abstract SmartInventory getInventory(OfflinePlayer player);

    public abstract void simpleInit(InventoryContents inventoryContents);

    @Getter private InventoryContents inventoryContents;
    @Getter private Pagination pagination;

    public Player getPlayer() {
        return (this.offlinePlayer != null && this.offlinePlayer.isOnline() && this.offlinePlayer.getPlayer() != null) ? offlinePlayer.getPlayer() : null;
    }

    public OfflinePlayer getOfflinePlayer() {
        return this.offlinePlayer;
    }

    public List<ClickableItem> getItems() {
        return new ArrayList<>();
    }

    public boolean isPagination() {
        return false;
    }

    @Override
    public void init(Player p, InventoryContents inventoryContents) {
        this.inventoryContents = inventoryContents;
        OfflinePlayer player = (getPlayer() == null) ? (getOfflinePlayer() == null) ? null : getOfflinePlayer() : getPlayer();

        simpleInit(inventoryContents);

        if (getItems() != null && !getItems().isEmpty()) {
            Arrays.stream(getItems().toArray(new ClickableItem[0])).forEach(inventoryContents::add);
        }

        if (isPagination() && player != null) {
            Pagination pagination = inventoryContents.pagination();

            if (!getItems().isEmpty()) {
                pagination.setItems(getItems().toArray(new ClickableItem[0]));
            }

            if (!pagination.isFirst()) {
                inventoryContents.set(2, 3, ClickableItem.of(new ItemBuilder(Material.ARROW).name("&bVorige pagina").lore(Arrays.asList("&7Ga naar de", "&7vorige pagina.")).build(),
                        e -> getInventory(p).open(p, pagination.previous().getPage())));
            }
            if (!pagination.isLast()) {
                inventoryContents.set(2, 5, ClickableItem.of(new ItemBuilder(Material.ARROW).name("&bVolgende pagina").lore(Arrays.asList("&7Ga naar de", "&7volgende pagina.")).build(),
                        e -> getInventory(p).open(p, pagination.next().getPage())));
            }
        }

    }
}
