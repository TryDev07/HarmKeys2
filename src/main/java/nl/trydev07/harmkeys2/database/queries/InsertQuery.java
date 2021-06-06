package nl.trydev07.harmkeys2.database.queries;

import nl.trydev07.harmkeys2.database.Query;

public class InsertQuery implements Query {

    @Override
    public String getRawQuery() {
        return "INSERT INTO %s (%s) VALUES (%s)";
    }
}
