package dev.paracausal.thetatags;

import dev.paracausal.thetatags.configuration.Config;
import org.bukkit.plugin.java.JavaPlugin;

public class ThetaTags extends JavaPlugin {

    private Config bracketsYml;

    @Override
    public void onLoad() {
        this.bracketsYml = new Config(this, "brackets");
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public Config getBracketsYml() { return bracketsYml; }

}
