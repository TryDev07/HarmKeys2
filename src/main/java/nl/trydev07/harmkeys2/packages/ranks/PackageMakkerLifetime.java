package nl.trydev07.harmkeys2.packages.ranks;

import nl.trydev07.harmkeys2.packages.PackageRegistery;
import nl.trydev07.harmkeys2.packages.PackageStructure;
import nl.trydev07.harmkeys2.packages.PackageTypes;

@PackageRegistery(name = "MakkerLifetime", packageStructure = PackageMakkerLifetime.class)
public class PackageMakkerLifetime extends PackageStructure {

    @Override
    public PackageTypes packageType() {
        return PackageTypes.MAKKER_LIFETIME;
    }

    @Override
    public String serverBind() {
        return "skyblock";
    }
}
