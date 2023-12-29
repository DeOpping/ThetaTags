package dev.paracausal.thetatags.utils;

import dev.paracausal.thetatags.configuration.Config;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtils {

    public static @NotNull List<String> fromConfig(@NotNull final Config config, @NotNull final String path) {
        final Object o = config.options().get(path, null);
        if (o == null) return new ArrayList<>();
        if (o instanceof List<?>) return config.options().getStringList(path);
        return new ArrayList<>(Collections.singletonList(o.toString()));
    }

    public static @NotNull List<String> fromConfig(
            @NotNull final Config config,
            @NotNull final String path,
            @NotNull final List<String> def
    ) {
        final Object o = config.options().get(path, null);
        if (o == null) return def;
        if (o instanceof List<?>) return config.options().getStringList(path);
        return new ArrayList<>(Collections.singletonList(o.toString()));
    }

    public static @NotNull List<String> replace(@NotNull final List<String> input, @NotNull final String... replacements) {
        if (input.isEmpty()) return input;
        int length = replacements.length;
        if (length % 2 != 0) length -= 1;
        if (length == 0) return input;

        final List<String> parsed = new ArrayList<>();
        final int l = length;

        input.forEach(string -> {
            for (int i = 0; i <= l; i++) {
                string = string.replace(replacements[i], replacements[i+1]);
                i++;
            }

            parsed.add(string);
        });

        return parsed;
    }

    public static @NotNull String replace(@NotNull String input, @NotNull final String... replacements) {
        if (input.length() < 1) return input;
        int length = replacements.length;
        if (length % 2 != 0) length -= 1;
        if (length == 0) return input;

        for (int i = 0; i <= length; i++) {
            input = input.replace(replacements[i], replacements[i+1]);
            i++;
        }

        return input;
    }

}
