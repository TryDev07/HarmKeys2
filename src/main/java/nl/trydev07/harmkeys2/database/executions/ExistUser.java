package nl.trydev07.harmkeys2.database.executions;

import lombok.AllArgsConstructor;
import nl.trydev07.core.database.query.exist.Exist;
import nl.trydev07.harmkeys2.database.queries.ExistQuery;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class ExistUser extends ExistQuery implements Exist {

    private final UUID uuid;

    @Override
    public String getQuery() {
        return String.format(getRawQuery(), "uuid", "harmkey_users", "uuid=?");
    }

    @Override
    public List<Object> getParams() {
        return Collections.singletonList(uuid.toString());
    }
}
