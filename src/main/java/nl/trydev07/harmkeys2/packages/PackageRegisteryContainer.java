package nl.trydev07.harmkeys2.packages;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PackageRegisteryContainer {

    Map<String, PackageStructure> registryPackages = new HashMap<>();

    public PackageStructure getPackage(String name) {
        if (!registryPackages.containsKey(name)) return null;
        return registryPackages.get(name);
    }

    public void init() {
        Reflections reflections = new Reflections("nl.trydev07.harmkeys2.packages");
        Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);

        try {
            for (Class<?> clazz : allClasses) {
                if (clazz.isAnnotationPresent(PackageRegistery.class)) {
                    PackageRegistery packageRegistery = clazz.getAnnotation(PackageRegistery.class);
                    PackageStructure packageStructure = (PackageStructure) clazz.newInstance();
                    registryPackages.put(packageRegistery.name(), packageStructure);

                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
