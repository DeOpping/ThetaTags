package dev.paracausal.thetatags.tags;

import dev.paracausal.thetatags.ThetaTags;
import dev.paracausal.thetatags.configuration.Config;
import dev.paracausal.thetatags.utils.ListUtils;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TagBlacklist {

    private final ThetaTags plugin;
    private static final Set<String> words = new HashSet<>();
    private static final Set<String> regex = new HashSet<>();

    public TagBlacklist(@NotNull final ThetaTags plugin) {
        this.plugin = plugin;
        reload();
    }

    public void reload() {
        words.clear();
        regex.clear();

        final Config config = plugin.getBlacklistYml();
        words.addAll(ListUtils.fromConfig(config, "words"));
        regex.addAll(ListUtils.fromConfig(config, "regex"));
    }

    public static boolean checkWord(@NotNull final String input) {
        return words.contains(input.toLowerCase());
    }

    public static boolean checkPattern(@NotNull final String input) {
        for (final String patternString : regex) {
            final Pattern pattern;
            try { pattern = Pattern.compile(patternString); }
            catch (PatternSyntaxException e) { continue; }

            final Matcher matcher = pattern.matcher(input);
            if (matcher.find()) return false;
        }

        return true;
    }

}
