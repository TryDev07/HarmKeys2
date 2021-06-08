package nl.trydev07.harmkeys2.database.executions;


import lombok.AllArgsConstructor;
import nl.trydev07.core.database.query.update.Update;
import nl.trydev07.harmkeys2.database.queries.UpdateQuery;
import nl.trydev07.harmkeys2.packages.PackageUser;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class UpdateUser extends UpdateQuery implements Update {

    private final UUID uuid;
    private final List<PackageUser> packages;

    @Override
    public String getQuery() {
        return getRawQuery(packages, uuid);
    }

    @Override
    public List<Object> getParams() {
        return Collections.emptyList();
    }


}
