package nl.trydev07.harmkeys2.user;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import lombok.Getter;
import nl.trydev07.harmkeys2.packages.PackageUser;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class UserCache {

    @Getter
    private final LoadingCache<UUID, List<PackageUser>> userCache;

    public UserCache() {
        this.userCache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(5L, TimeUnit.MINUTES)
                .refreshAfterWrite(6L, TimeUnit.MINUTES)
                .removalListener(removalListener)
                .build(cacheLoader);
    }


    RemovalListener<UUID, List<PackageUser>> removalListener = removalNotification -> {
       /* if (removalNotification.getValue().isChanged()) {
            try {
               // DatabaseMethods.updateUser(HarmKeys.getInstance().getDatabase(), removalNotification.getKey(), Serializer.serialize(removalNotification.getValue()));
            } catch (Exception exception) {
                Logger.warning("Error while upating the user " + removalNotification.getKey() + " error: " + exception.getMessage());
            }
        }*/
    };

    CacheLoader<UUID, List<PackageUser>> cacheLoader = new CacheLoader<UUID, List<PackageUser>>() {
        @Override
        public List<PackageUser> load(UUID uuid) {
            //TODO: Load user
            return null;
        }
    };
}
