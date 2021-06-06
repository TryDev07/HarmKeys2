package nl.trydev07.harmkeys2.database.queries;

import nl.trydev07.harmkeys2.database.Query;

public class UpdateQuery implements Query {

    @Override
    public String getRawQuery() {
        return "UPDATE %s SET %s WHERE %s";
    }
}
