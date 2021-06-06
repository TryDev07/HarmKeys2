package nl.trydev07.harmkeys2.database.executions;


import lombok.AllArgsConstructor;
import nl.trydev07.core.database.query.update.Update;
import nl.trydev07.harmkeys2.database.queries.UpdateQuery;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class UpdateUser extends UpdateQuery implements Update {

    private final UUID uuid;
    private final String playerName;
    private final String packages;

    @Override
    public String getQuery() {
        return String.format(getRawQuery(), "harmkey_users", "player_name=?, packages=?", "uuid=?");
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(this.playerName, this.packages, this.uuid.toString());
    }
}
