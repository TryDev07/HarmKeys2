package nl.trydev07.harmkeys2.packages.ranks;

import nl.trydev07.harmkeys2.packages.PackageRegistery;
import nl.trydev07.harmkeys2.packages.PackageStructure;
import nl.trydev07.harmkeys2.packages.PackageTypes;

@PackageRegistery(name = "GozerMaand", packageStructure = PackageGozerMaand.class)
public class PackageGozerMaand extends PackageStructure {

    @Override
    public PackageTypes packageType() {
        return PackageTypes.GOZER_MAAND;
    }

    @Override
    public String serverBind() {
        return "skyblock";
    }
}
