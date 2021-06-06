package nl.trydev07.harmkeys2.packages.ranks;

import nl.trydev07.harmkeys2.packages.PackageRegistery;
import nl.trydev07.harmkeys2.packages.PackageStructure;
import nl.trydev07.harmkeys2.packages.PackageTypes;

@PackageRegistery(name = "KnaapLifetime", packageStructure = PackageKnaapLifetime.class)
public class PackageKnaapLifetime extends PackageStructure {

    @Override
    public PackageTypes packageType() {
        return PackageTypes.KNAAP_LIFETIME;
    }

    @Override
    public String serverBind() {
        return "skyblock";
    }
}
