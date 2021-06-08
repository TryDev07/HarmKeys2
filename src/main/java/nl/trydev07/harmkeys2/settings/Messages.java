package nl.trydev07.harmkeys2.settings;

import lombok.AllArgsConstructor;
import nl.trydev07.core.utils.ColorUtils;

@AllArgsConstructor
public enum Messages {

    NO_KEYS("&cJe hebt helaas geen keys om te claimen."),
    UNABLE_TO_FIND_PLAYER("&cEr bestaat geen speler met de naam %s."),
    GIVE_KEY_CONFIRM("&aJe hebt de &7%s package geven aan &7%s.");


    String message;

    public String getTranslated() {
        return ColorUtils.translate(message);
    }
}
