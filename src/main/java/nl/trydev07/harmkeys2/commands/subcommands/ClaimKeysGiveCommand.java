package nl.trydev07.harmkeys2.commands.subcommands;

import com.google.inject.Inject;
import nl.trydev07.core.acf.BaseCommand;
import nl.trydev07.core.acf.annotation.CommandAlias;
import nl.trydev07.core.acf.annotation.CommandPermission;
import nl.trydev07.core.acf.annotation.Subcommand;
import nl.trydev07.core.utils.UUIDFetcher;
import nl.trydev07.harmkeys2.packages.PackageRegisteryContainer;
import nl.trydev07.harmkeys2.packages.PackageUser;
import nl.trydev07.harmkeys2.settings.Messages;
import nl.trydev07.harmkeys2.user.UserCache;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@CommandAlias("claimkeys|ck")
public class ClaimKeysGiveCommand extends BaseCommand {

    @Inject
    UserCache userCache;

    @Inject PackageRegisteryContainer packageRegisteryContainer;

    @Subcommand("give")
    @CommandPermission("claimkeys.give")
    public void execute(CommandSender sender, String args1, String args2) {
        if (args1.matches("[a-f0-9]{8}-[a-f0-9]{4}-4[0-9]{3}-[89ab][a-f0-9]{3}-[0-9a-f]{12}")) {
            try {
                this.userCache.getUserCache().get(UUID.fromString(args1)).add(new PackageUser.Builder().setDateReceived(System.nanoTime()).setPackage(packageRegisteryContainer.getPackage(args2)).setChanged(true).build());
                sender.sendMessage(String.format(Messages.GIVE_KEY_CONFIRM.getTranslated(), args2, args1));
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        } else {
            UUID offlinePlayer = (!Bukkit.getOfflinePlayer(args1).hasPlayedBefore()) ? (UUIDFetcher.getUUID(args1) == null) ? null : Bukkit.getOfflinePlayer(args1).getUniqueId() : UUIDFetcher.getUUID(args1);

            if (offlinePlayer == null) {
                sender.sendMessage(String.format(Messages.UNABLE_TO_FIND_PLAYER.getTranslated(), args1));
                return;
            }

            try {
                this.userCache.getUserCache().get(UUID.fromString(args1)).add(new PackageUser.Builder().setDateReceived(System.nanoTime()).setPackage(packageRegisteryContainer.getPackage(args2)).setChanged(true).build());
                sender.sendMessage(String.format(Messages.GIVE_KEY_CONFIRM.getTranslated(), args2, args1));
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
