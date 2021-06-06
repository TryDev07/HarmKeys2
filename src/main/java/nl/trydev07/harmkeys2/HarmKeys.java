package nl.trydev07.harmkeys2;

import nl.trydev07.core.WolfCore;
import nl.trydev07.core.WolfPlugin;
import nl.trydev07.core.compatibility.CompatibleMaterial;

public class HarmKeys extends WolfPlugin {


    @Override
    public void onPluginLoad() {
        WolfCore.registerPlugin(this, 2, CompatibleMaterial.TRIPWIRE.name(), "1.0.0");
    }

    @Override
    public void onPluginEnable() {

    }
}
