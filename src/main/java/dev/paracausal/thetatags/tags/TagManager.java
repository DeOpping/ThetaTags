package dev.paracausal.thetatags.tags;

import dev.paracausal.thetatags.ThetaTags;
import dev.paracausal.thetatags.configuration.Config;
import dev.paracausal.thetatags.utils.logger.ThetaLog;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class TagManager {

    private final ThetaTags plugin;
    private final LinkedHashMap<String, Tag> tags = new LinkedHashMap<>();

    public TagManager(@NotNull final ThetaTags plugin) {
        this.plugin = plugin;
        reload();
    }

    public void reload() {
        tags.clear();
        final File folder = new File(plugin.getDataFolder(), "tags");
        if (!folder.exists()) new Config(plugin, "tags" + File.separator + "example");

        final File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            ThetaLog.log(
                    "No tag files found!",
                    "Add tag files to the tags folder or delete the folder and reload to generate the example.yml!"
            );
            return;
        }

        for (final File file : files) {
            final String fileName = file.getName();
            if (fileName.startsWith("_") || !fileName.endsWith(".yml")) continue;

            final String fileId = fileName.substring(0, fileName.length()-4);
            final Config config = new Config(plugin, "tags" + File.separator + fileId);

            final ConfigurationSection tagSection = config.options().getConfigurationSection("tags");
            if (tagSection == null) continue;

            tagSection.getKeys(false).forEach(tagId ->
                tags.putIfAbsent(tagId, new Tag(tagId, config))
            );
        }
    }

    public @NotNull List<String> getTagIDs() {
        return new ArrayList<>(tags.keySet());
    }

    public @NotNull List<Tag> getTags() {
        return new ArrayList<>(tags.values());
    }

    public boolean exists(@NotNull final String id) {
        return tags.containsKey(id);
    }

    public @Nullable Tag getTag(@NotNull final String id) {
        return tags.getOrDefault(id, null);
    }

}
