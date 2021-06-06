package nl.trydev07.harmkeys2.packages;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import nl.trydev07.core.utils.Pair;

import java.util.Arrays;

@Getter
public enum PackageTypes {

    MAAT_MAAND("Maat Maand", new Pair<>("CommonKey", 1), new Pair<>("RareKey", 1)),
    MAAT_LIFETIME("Maat Lifetime", new Pair<>("CommonKey", 10), new Pair<>("RareKey", 3)),

    GOZER_MAAND("Gozer Maand", new Pair<>("CommonKey", 2), new Pair<>("RareKey", 1)),
    GOZER_LIFETIME("Gozer Lifetime", new Pair<>("CommonKey", 15), new Pair<>("RareKey", 3)),

    KNAAP_MAAND("Knaap Maand", new Pair<>("CommonKey", 3), new Pair<>("RareKey", 1)),
    KNAAP_LIFETIME("Knaap Lifetime", new Pair<>("CommonKey", 15), new Pair<>("RareKey", 6)),

    MAKKER_MAAND("Makker Maand", new Pair<>("CommonKey", 4), new Pair<>("RareKey", 2)),
    MAKKER_LIFETIME("Makker Lifetime", new Pair<>("CommonKey", 20), new Pair<>("RareKey", 10)),

    COMMONKEY_1("Maat Maand", new Pair<>("CommonKey", 1)),
    COMMONKEY_3("Maat Maand", new Pair<>("CommonKey", 3)),

    RARECRATE_1("Maat Maand", new Pair<>("RareKey", 1)),
    RARECRATE_3("Maat Maand", new Pair<>("RareKey", 3));


    private final String packageName;
    private final Pair<String, Integer>[] keys;

    @SafeVarargs
    PackageTypes(@NotNull String packageName, @NotNull Pair<String, Integer>... keys) {
        this.packageName = packageName;
        this.keys = keys;
    }

    public static PackageTypes getPackageByName(String name) {
        return Arrays.stream(PackageTypes.values()).filter(packageType -> packageType.name().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
