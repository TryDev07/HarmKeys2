package nl.trydev07.harmkeys2.settings;

import nl.trydev07.core.configuration.Config;
import nl.trydev07.core.configuration.ConfigSetting;
import nl.trydev07.harmkeys2.HarmKeys;

public class Settings {

    public static final Config config = new Config(HarmKeys.getInstance());

    public static final ConfigSetting DATABASE_HOSTNAME = new ConfigSetting(config, "database.hostname", "localhost");
    public static final ConfigSetting DATABASE_PORT = new ConfigSetting(config, "database.port", 3306);
    public static final ConfigSetting DATABASE_USERNAME = new ConfigSetting(config, "database.username", "root");
    public static final ConfigSetting DATABASE_PASSWORD = new ConfigSetting(config, "database.password", "");
    public static final ConfigSetting DATABASE_DATABASE = new ConfigSetting(config, "database.database", "database");

    public static final ConfigSetting SERVER = new ConfigSetting(config, "server", "skyblock", "Define which type can be claimed.", "Available types: survival, skyblock");

    public static void setupConfig() {
        config.load();
        config.setAutoremove(true).setAutosave(true);
        config.saveChanges();
    }

}
