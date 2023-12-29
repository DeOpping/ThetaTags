package dev.paracausal.thetatags;

import dev.paracausal.thetatags.configuration.Config;
import dev.paracausal.thetatags.tags.TagManager;
import dev.paracausal.thetatags.tags.TagBlacklist;
import dev.paracausal.thetatags.utils.logger.ThetaLog;
import org.bukkit.plugin.java.JavaPlugin;

public class ThetaTags extends JavaPlugin {

    private Config configYml;
    private Config bracketsYml;
    private Config blacklistYml;

    private ThetaLog log;
    private TagBlacklist tagBlacklist;

    private TagManager tagManager;

    @Override
    public void onLoad() {
        final long start = System.currentTimeMillis();

        this.configYml = new Config(this, "config");
        this.log = new ThetaLog(this);

        this.bracketsYml = new Config(this, "brackets");

        this.blacklistYml = new Config(this, "blacklist");
        this.tagBlacklist = new TagBlacklist(this);

        final long end = System.currentTimeMillis() - start;
        ThetaLog.debug(ThetaLog.Level.SUCCESS, "Loaded in " + end + "ms!");
    }

    @Override
    public void onEnable() {
        final long start = System.currentTimeMillis();

        this.tagManager = new TagManager(this);

        final long end = System.currentTimeMillis() - start;
        ThetaLog.divider();
        ThetaLog.log(
                "ThetaTags v" + getDescription().getVersion(),
                "Developed by Mantice"
        );
        ThetaLog.debug("Enabled in " + end + "ms!");
        ThetaLog.divider();
    }

    @Override
    public void onDisable() {
        final long start = System.currentTimeMillis();

        final long end = System.currentTimeMillis() - start;
        ThetaLog.debug("Disabled in " + end + "ms!");
    }

    public Config getConfigYml() { return configYml; }
    public Config getBracketsYml() { return bracketsYml; }
    public Config getBlacklistYml() { return blacklistYml; }

    public ThetaLog getLog() { return log; }
    public TagBlacklist getTagBlacklist() { return tagBlacklist; }

    public TagManager getTagManager() { return tagManager; }

}
