package nl.trydev07.harmkeys2.database.queries;

import nl.trydev07.harmkeys2.database.Query;
import nl.trydev07.harmkeys2.packages.PackageUser;
import nl.trydev07.harmkeys2.packages.PackageUserSerializer;
import nl.trydev07.harmkeys2.utils.NameFetcher;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UpdateQuery implements Query {

    @Override
    public String getRawQuery() {
        return "UPDATE %s SET %s WHERE %s";
    }

    public String getRawQuery(List<PackageUser> packages, UUID uuid) {
        StringBuilder query = new StringBuilder();
        String playerName = NameFetcher.getName(uuid);

        List<PackageUser> filteredPackageUser = packages.stream().filter(PackageUser::isChanged).collect(Collectors.toList());

        if (!filteredPackageUser.isEmpty()) {
            for (PackageUser packageUser : filteredPackageUser) {
                if (packageUser.isChanged()) {
                    if (packageUser.isClaimed()) {
                        query.append(String.format(getRawQuery(), "harmkey_users", "player_name='" + playerName +
                                "', packages=REPLACE(packages,'" + packageUser.getOldValue() + "','" + PackageUserSerializer.serialize(packageUser) + "')", uuid + ";"));
                    } else {
                        query.append(String.format(getRawQuery(), "harmkey_users", "player_name='" + playerName +
                                "', packages=CONCAT(packages,'" + PackageUserSerializer.serialize(packageUser) + "'", uuid + ";"));
                    }
                }
            }
        }
        return query.toString();
    }
}
