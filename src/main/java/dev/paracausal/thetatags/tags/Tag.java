package dev.paracausal.thetatags.tags;

import dev.paracausal.thetatags.configuration.Config;
import org.jetbrains.annotations.NotNull;

public class Tag {

    private final String id;
    private final String displayName;
    private final String display;
    private boolean locked = true;

    public Tag(@NotNull final String id, @NotNull final Config config) {
        this.id = id;

        final String path = "tags." + id + ".";
        this.displayName = config.options().getString(path + "display-name", id);
        this.display = config.options().getString(path + "display", "");
    }

    public @NotNull String getID() { return id; }
    public @NotNull String getDisplayName() { return displayName; }
    public @NotNull String getDisplay() { return display; }

    public void setLocked(final boolean locked) { this.locked = locked; }
    public boolean isLocked() { return locked; }

}
