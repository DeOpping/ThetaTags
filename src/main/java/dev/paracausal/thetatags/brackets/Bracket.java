package dev.paracausal.thetatags.brackets;

import dev.paracausal.thetatags.configuration.Config;
import org.jetbrains.annotations.NotNull;

public class Bracket {

    private final String id;
    private final String open;
    private final String close;

    public Bracket(@NotNull final String id, @NotNull final String open, @NotNull final String close) {
        this.id = id;
        this.open = open;
        this.close = close;
    }

    public Bracket(@NotNull final String id, @NotNull final Config config) {
        this.id = id;
        open = config.options().getString("brackets." + id + ".open", "");
        close = config.options().getString("brackets." + id + ".close", "");
    }

    public String getID() { return id; }
    public String getOpen() { return open; }
    public String getClose() { return close; }

}
