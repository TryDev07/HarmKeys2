package nl.trydev07.harmkeys2.commands;

import com.google.inject.Inject;
import nl.trydev07.core.acf.BaseCommand;
import nl.trydev07.core.acf.annotation.CommandAlias;
import nl.trydev07.core.acf.annotation.CommandCompletion;
import nl.trydev07.core.acf.annotation.CommandPermission;
import nl.trydev07.core.acf.annotation.Default;
import nl.trydev07.core.utils.UUIDFetcher;
import nl.trydev07.harmkeys2.menus.ClaimKeyMenu;
import nl.trydev07.harmkeys2.packages.PackageUser;
import nl.trydev07.harmkeys2.settings.Messages;
import nl.trydev07.harmkeys2.settings.Settings;
import nl.trydev07.harmkeys2.user.UserCache;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@CommandAlias("claimkeys|ck")
public class ClaimKeysCommand extends BaseCommand {

    @Inject private UserCache userCache;
    @Inject private ClaimKeyMenu claimKeyMenu;

    @Default
    public void execute(Player sender) {
        try {
            List<PackageUser> user = this.userCache.getUserCache().get(sender.getUniqueId());

            if (user == null || user.isEmpty() || user.stream().noneMatch(p -> p.getAPackage().serverBind().equalsIgnoreCase(Settings.SERVER.getString()))) {
                sender.sendMessage(Messages.NO_KEYS.getTranslated());
                return;
            }

            this.claimKeyMenu.getInventory(sender).open(sender);
        } catch (ExecutionException exception) {
            exception.printStackTrace();
        }
    }

    @Default
    @CommandPermission("claimkeys.see.other")
    @CommandCompletion("@players")
    public void checkOtherPlayer(Player sender, String args1) {
        UUID offlinePlayer = (!Bukkit.getOfflinePlayer(args1).hasPlayedBefore()) ? (UUIDFetcher.getUUID(args1) == null) ? null : Bukkit.getOfflinePlayer(args1).getUniqueId() : UUIDFetcher.getUUID(args1);

        if (offlinePlayer == null) {
            sender.sendMessage(String.format(Messages.UNABLE_TO_FIND_PLAYER.getTranslated(), args1));
            return;
        }

        this.claimKeyMenu.getInventory(Bukkit.getOfflinePlayer(offlinePlayer)).open(sender);
    }

}
