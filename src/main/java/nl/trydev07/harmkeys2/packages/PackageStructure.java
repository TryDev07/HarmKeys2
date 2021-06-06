package nl.trydev07.harmkeys2.packages;

import nl.trydev07.core.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public abstract class PackageStructure {

    public abstract PackageTypes packageType();

    public abstract String serverBind();

    public final void giveContents(Player player) {
        Optional<PackageTypes> packageTypes = Optional.of(packageType());

        if (Arrays.stream(player.getInventory().getStorageContents()).filter(Objects::isNull).count() < packageTypes.get().getKeys().length) {
            player.sendMessage(ColorUtils.translate("&cJe hebt niet voldoende plek in je inventory vrij"));
            return;
        }

        Arrays.stream(packageTypes.get().getKeys()).forEachOrdered(keys -> Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), String.format("cr give to %s %s %s", player.getName(), keys.getKey(), keys.getValue())));
    }

}
