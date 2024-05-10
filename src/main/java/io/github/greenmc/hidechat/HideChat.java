package io.github.greenmc.hidechat;

import io.github.greenmc.hidechat.hook.HideChatHook;
import io.github.greenmc.hidechat.hook.impl.EssentialsHook;
import io.github.greenmc.hidechat.hook.impl.LibertyBansHook;
import io.github.greenmc.hidechat.hook.impl.LiteBansHook;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HideChat extends JavaPlugin {

    private HideChatHook hook;

    @Override
    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();
        if (pluginManager.isPluginEnabled("LiteBans")) {
            hook = new LiteBansHook(this);
        }

        else if (pluginManager.isPluginEnabled("LibertyBans")) {
            hook = new LibertyBansHook(this);
        }

        else if (pluginManager.isPluginEnabled("EssentialsX")) {
            hook = new EssentialsHook(this);
        }

        getLogger().info(hook.getClass().getName() + " initialized!");
        getLogger().info("HideChat v" + getDescription().getVersion() + " now enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}