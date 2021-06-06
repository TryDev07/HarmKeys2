package nl.trydev07.harmkeys2.packages;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface PackageRegistery {

    String name() default "";
    Class<? extends PackageStructure> packageStructure();
}
