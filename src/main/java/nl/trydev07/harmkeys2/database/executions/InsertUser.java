package nl.trydev07.harmkeys2.database.executions;

import lombok.AllArgsConstructor;
import nl.trydev07.core.database.query.insert.Insert;
import nl.trydev07.harmkeys2.database.queries.InsertQuery;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class InsertUser extends InsertQuery implements Insert {

    private final UUID uuid;
    private final String playerName;
    private final String packages;

    @Override
    public String getQuery() {
        return String.format(getRawQuery(), "harmkey_users", "uuid, player_name, packages", "?, ?, ?");
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(this.uuid.toString(), this.playerName, this.packages);
    }
}
