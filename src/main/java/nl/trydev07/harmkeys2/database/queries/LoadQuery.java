package nl.trydev07.harmkeys2.database.queries;

import nl.trydev07.harmkeys2.database.Query;

public class LoadQuery implements Query {

    @Override
    public String getRawQuery() {
        return "SELECT * FROM %s WHERE %s";
    }
}
