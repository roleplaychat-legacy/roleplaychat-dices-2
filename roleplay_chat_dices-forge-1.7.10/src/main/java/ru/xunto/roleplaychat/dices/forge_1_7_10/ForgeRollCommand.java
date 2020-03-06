package ru.xunto.roleplaychat.dices.forge_1_7_10;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import org.jparsec.error.ParserException;
import ru.xunto.roleplaychat.dices.RollCommand;
import ru.xunto.roleplaychat.forge_1_7_10.ForgeSpeaker;
import ru.xunto.roleplaychat.forge_1_7_10.ForgeWorld;

public class ForgeRollCommand extends CommandBase {
    private static final RollCommand command = new RollCommand();

    @Override
    public String getCommandName() {
        return command.getName();
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (!(sender instanceof EntityPlayerMP)) return;

        EntityPlayerMP player = (EntityPlayerMP) sender;

        String arg = String.join("", args);
        ForgeSpeaker speaker = new ForgeSpeaker(player);
        ForgeWorld world = new ForgeWorld(player.getServerForPlayer());

        try {
            command.execute(speaker, world, arg);
        } catch (ParserException e) {
            throw new CommandException("Невозможно бросить такой дайс.");
        }
    }
}
