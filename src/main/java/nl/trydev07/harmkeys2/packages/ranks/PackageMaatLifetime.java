package nl.trydev07.harmkeys2.packages.ranks;

import nl.trydev07.harmkeys2.packages.PackageRegistery;
import nl.trydev07.harmkeys2.packages.PackageStructure;
import nl.trydev07.harmkeys2.packages.PackageTypes;

@PackageRegistery(name = "MaatLifetime", packageStructure = PackageMaatLifetime.class)
public class PackageMaatLifetime extends PackageStructure {

    @Override
    public PackageTypes packageType() {
        return PackageTypes.MAAT_LIFETIME;
    }

    @Override
    public String serverBind() {
        return "skyblock";
    }
}
