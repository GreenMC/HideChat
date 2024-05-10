package io.github.greenmc.hidechat;

import io.github.greenmc.hidechat.hook.HookManager;
import io.github.greenmc.hidechat.user.UserManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class HideChat extends JavaPlugin {

    private UserManager userManager;
    private HookManager hookManager;

    @Override
    public void onEnable() {
        this.userManager = new UserManager(this);
        this.hookManager = new HookManager(this);

        //        getLogger().info(hook.getClass().getName() + " initialized!");
        getLogger().info("HideChat v" + getDescription().getVersion() + " now enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @NotNull
    public UserManager getUserManager() {
        return userManager;
    }

    @NotNull
    public HookManager getHookManager() {
        return hookManager;
    }
}