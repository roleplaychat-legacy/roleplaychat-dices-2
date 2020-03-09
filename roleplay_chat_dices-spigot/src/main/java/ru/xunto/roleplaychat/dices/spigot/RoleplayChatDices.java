package ru.xunto.roleplaychat.dices.spigot;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ru.xunto.roleplaychat.RoleplayChatCore;
import ru.xunto.roleplaychat.dices.RollCommand;

public final class RoleplayChatDices extends JavaPlugin implements Listener {
    @Override
    public void onLoad() {
        RoleplayChatCore.instance.register(new RollCommand());
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }
}
