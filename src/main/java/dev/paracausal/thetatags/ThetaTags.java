package dev.paracausal.thetatags;

import dev.paracausal.thetatags.configuration.Config;
import dev.paracausal.thetatags.tags.TagBlacklist;
import dev.paracausal.thetatags.utils.logger.ThetaLog;
import org.bukkit.plugin.java.JavaPlugin;

public class ThetaTags extends JavaPlugin {

    private Config configYml;
    private Config bracketsYml;
    private Config blacklistYml;

    private ThetaLog log;
    private TagBlacklist tagBlacklist;

    @Override
    public void onLoad() {
        this.configYml = new Config(this, "config");
        this.log = new ThetaLog(this);
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

    public Config getConfigYml() { return configYml; }
    public Config getBracketsYml() { return bracketsYml; }
    public Config getBlacklistYml() { return blacklistYml; }

    public ThetaLog getLog() { return log; }
    public TagBlacklist getTagBlacklist() { return tagBlacklist; }

}
