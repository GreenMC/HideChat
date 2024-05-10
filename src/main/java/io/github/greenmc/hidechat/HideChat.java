package io.github.greenmc.hidechat;

import io.github.greenmc.hidechat.events.Events;
import io.github.greenmc.hidechat.hook.HookManager;
import io.github.greenmc.hidechat.user.UserManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class HideChat extends JavaPlugin {

    private static HideChat instance;

    private UserManager userManager;
    private HookManager hookManager;

    @Override
    public void onEnable() {
        instance = this;

        this.userManager = new UserManager(this);
        this.hookManager = new HookManager(this);

        new Events(this);

        getLogger().info("Initialization finished, hooked into %s.".formatted(hookManager.getHook().getName()));
    }

    @NotNull
    public UserManager getUserManager() {
        return userManager;
    }

    @NotNull
    public HookManager getHookManager() {
        return hookManager;
    }

    @NotNull
    public static HideChat getInstance() {
        return instance;
    }
}