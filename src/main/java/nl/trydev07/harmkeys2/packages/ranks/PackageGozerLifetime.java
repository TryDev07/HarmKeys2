package nl.trydev07.harmkeys2.packages.ranks;

import nl.trydev07.harmkeys2.packages.PackageRegistery;
import nl.trydev07.harmkeys2.packages.PackageStructure;
import nl.trydev07.harmkeys2.packages.PackageTypes;

@PackageRegistery(name = "GozerLifetime", packageStructure = PackageGozerLifetime.class)
public class PackageGozerLifetime extends PackageStructure {

    @Override
    public PackageTypes packageType() {
        return PackageTypes.GOZER_LIFETIME;
    }

    @Override
    public String serverBind() {
        return "skyblock";
    }
}
