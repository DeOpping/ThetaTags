package dev.paracausal.thetatags.utils.logger;

import dev.paracausal.thetatags.ThetaTags;
import dev.paracausal.thetatags.configuration.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public class ThetaLog {

    public enum Level {
        INFO, SUCCESS("&a"), ERROR("&c");
        private final String color;
        Level(@NotNull final String color) { this.color = color; }
        Level() { this.color = ""; }
    }

    private static final String PREFIX = "[ThetaTags] ";
    private static final String DEBUG = "[&ei&r] ";
    private static final String DIVIDER = "------------------------------";

    private static boolean format = true;
    private static boolean debugMode = false;

    private final ThetaTags plugin;

    public ThetaLog(@NotNull final ThetaTags plugin) {
        this.plugin = plugin;
        reload();
    }

    public void reload() {
        final Config config = plugin.getConfigYml();
        format = config.options().getBoolean("logging.format", true);
        debugMode = config.options().getBoolean("logging.debug", false);
    }

    private static void send(@NotNull final Level level, final boolean debug, @NotNull final String... input) {
        if (debug && !debugMode) return;

        for (final String string : input) {
            final StringBuilder builder = new StringBuilder(PREFIX);
            if (debugMode && debug) builder.append(DEBUG);
            builder.append(level.color).append(string);

            String message = ChatColor.translateAlternateColorCodes('&', builder.toString());
            if (!format) message = ChatColor.stripColor(message);

            Bukkit.getConsoleSender().sendMessage(message);
        }
    }

    public static void log(@NotNull final String... input) {
        send(Level.INFO, false, input);
    }

    public static void log(@NotNull final Level level, @NotNull final String... input) {
        send(level, false, input);
    }

    public static void debug(@NotNull final String... input) {
        send(Level.INFO, true, input);
    }

    public static void debug(@NotNull final Level level, @NotNull final String... input) {
        send(level, true, input);
    }

    public static void divider(final boolean debug) {
        send(Level.INFO, debug, DIVIDER);
    }

    public static void divider() {
        send(Level.INFO, false, DIVIDER);
    }

}
