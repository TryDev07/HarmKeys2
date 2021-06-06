package nl.trydev07.harmkeys2.database.queries;

import nl.trydev07.harmkeys2.database.Query;

public class ExistQuery implements Query {
    @Override
    public String getRawQuery() {
        return "SELECT %s FROM %s WHERE %s";
    }
}
