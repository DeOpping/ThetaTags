package dev.paracausal.thetatags.brackets;

import dev.paracausal.thetatags.ThetaTags;
import dev.paracausal.thetatags.configuration.Config;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;

public final class Brackets {

    private final ThetaTags plugin;
    private final LinkedHashMap<String, Bracket> brackets = new LinkedHashMap<>();

    public Brackets(@NotNull final ThetaTags plugin) {
        this.plugin = plugin;
        reload();
    }

    public void reload() {
        brackets.clear();

        final Config config = plugin.getBracketsYml();
        final ConfigurationSection section = config.options().getConfigurationSection("brackets");
        if (section == null) return;

        section.getKeys(false).forEach(id ->
            brackets.put(id, new Bracket(id, config))
        );
    }

}
