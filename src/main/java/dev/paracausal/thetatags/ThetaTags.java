package dev.paracausal.thetatags;

import dev.paracausal.thetatags.configuration.Config;
import dev.paracausal.thetatags.tags.TagBlacklist;
import org.bukkit.plugin.java.JavaPlugin;

public class ThetaTags extends JavaPlugin {

    private Config bracketsYml;
    private Config blacklistYml;
    private TagBlacklist tagBlacklist;

    @Override
    public void onLoad() {
        this.bracketsYml = new Config(this, "brackets");
        this.blacklistYml = new Config(this, "blacklist");
        this.tagBlacklist = new TagBlacklist(this);
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public Config getBracketsYml() { return bracketsYml; }
    public Config getBlacklistYml() { return blacklistYml; }

    public TagBlacklist getTagBlacklist() { return tagBlacklist; }

}
