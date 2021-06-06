package nl.trydev07.harmkeys2.database.executions;

import lombok.AllArgsConstructor;
import nl.trydev07.core.database.Database;
import nl.trydev07.core.database.query.select.Select;
import nl.trydev07.harmkeys2.database.queries.LoadQuery;
import nl.trydev07.harmkeys2.packages.PackageUser;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class LoadUser extends LoadQuery implements Select<List<PackageUser>> {

    private final UUID uuid;

    @Override
    public String getQuery() {
        return String.format(getRawQuery(), "harmkey_users", "uuid=?");
    }

    @Override
    public List<Object> getParams() {
        return Collections.singletonList(this.uuid.toString());
    }

    @Override
    public List<PackageUser> getObject(Database database) {
        CachedRowSet result = this.execute(database);
        if (result == null) return null;
        try {
            if (result.next()) {
                /*user.setPlayerName(result.getString("player_name"));
                if (HarmKeys.getInstance().getPackageHandler().deserializedPackages(result.getString("data")) != null) {
                    user.setPackages(HarmKeys.getInstance().getPackageHandler().deserializedPackages(result.getString("data")));
                }
                user.setReceived(HarmKeys.getInstance().getPackageHandler().deserializedPackages(result.getString("received")));
*/
                return null;
            }
            return null;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }

    }
}
