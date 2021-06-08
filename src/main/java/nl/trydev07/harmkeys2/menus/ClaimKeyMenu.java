package nl.trydev07.harmkeys2.menus;

import com.google.inject.Inject;
import nl.trydev07.core.gui.ClickableItem;
import nl.trydev07.core.gui.SmartInventory;
import nl.trydev07.core.gui.content.InventoryContents;
import nl.trydev07.core.gui.content.SlotIterator;
import nl.trydev07.core.utils.ItemBuilder;
import nl.trydev07.harmkeys2.packages.PackageUser;
import nl.trydev07.harmkeys2.user.UserCache;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ClaimKeyMenu extends MenuStructure {

    @Inject UserCache userCache;

    public ClaimKeyMenu(Player player) {
        super(player);
    }

    @Override
    public SmartInventory getInventory(OfflinePlayer player) {
        return SmartInventory.builder().id("claim_key_menu").provider(new ClaimKeyMenu(player.getPlayer())).size(3, 9).title("Claim keys").build();
    }

    @Override
    public boolean isPagination() {
        return true;
    }

    @Override
    public List<ClickableItem> getItems() {
        List<ClickableItem> clickableItems = new ArrayList<>();
        try {
            List<PackageUser> user = this.userCache.getUserCache().get(getPlayer().getUniqueId());

            for (PackageUser packageUser : user) {
                clickableItems.add(ClickableItem.of(new ItemBuilder(Material.PAPER).build(), (a) -> {
                    packageUser.getAPackage().giveContents(getPlayer());
                }));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return clickableItems;
    }

    @Override
    public void simpleInit(InventoryContents inventoryContents) {
        inventoryContents.fillBorders(ClickableItem.empty(new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build()));

        getPagination().setItemsPerPage(7);
        getPagination().addToIterator(inventoryContents.newIterator("keysMenu", SlotIterator.Type.HORIZONTAL, 1, 1));
    }
}
