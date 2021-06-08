package nl.trydev07.harmkeys2.database;

import nl.trydev07.core.database.Database;
import nl.trydev07.core.database.mysql.SQLDatabase;
import nl.trydev07.harmkeys2.database.executions.ExistUser;
import nl.trydev07.harmkeys2.database.executions.LoadUser;
import nl.trydev07.harmkeys2.database.executions.UpdateUser;
import nl.trydev07.harmkeys2.packages.PackageUser;
import nl.trydev07.harmkeys2.settings.Settings;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DatabaseMethods {

    private static Database database;

    public static boolean existUser(UUID uuid) {
        return new ExistUser(uuid).exists(database);
    }

    public static List<PackageUser> loadUser(UUID uuid) {
        if (!existUser(uuid)) {
            return new ArrayList<>();
        }
        return new LoadUser(uuid).getObject(database);
    }

    public static void updateUser(UUID uuid, List<PackageUser> packaged) {
        if (existUser(uuid)) {
            new UpdateUser(uuid, packaged).executeAsync(database);
        }
    }

    public static void connect() {
        database = new SQLDatabase(Settings.DATABASE_HOSTNAME.getString(), Settings.DATABASE_PORT.getInt(), Settings.DATABASE_USERNAME.getString(), Settings.DATABASE_PASSWORD.getString(), Settings.DATABASE_DATABASE.getString());
    }

}
