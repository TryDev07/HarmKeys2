package nl.trydev07.harmkeys2;

import lombok.Getter;
import nl.trydev07.core.WolfCore;
import nl.trydev07.core.WolfPlugin;
import nl.trydev07.core.compatibility.CompatibleMaterial;
import nl.trydev07.harmkeys2.database.DatabaseMethods;

public class HarmKeys extends WolfPlugin {

    @Getter private static HarmKeys instance;

    @Override
    public void onPluginLoad() {
        instance = this;
        WolfCore.registerPlugin(this, 2, CompatibleMaterial.TRIPWIRE.name(), "1.0.0");
    }

    @Override
    public void onPluginEnable() {
        DatabaseMethods.connect();
    }
}
