package ru.xunto.roleplaychat.dices.forge_1_7_10;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import ru.xunto.roleplaychat.RoleplayChatCore;
import ru.xunto.roleplaychat.dices.forge_1_7_10.parser.IResult;
import ru.xunto.roleplaychat.dices.forge_1_7_10.parser.IRoll;
import ru.xunto.roleplaychat.dices.forge_1_7_10.parser.colored.TextPart;
import ru.xunto.roleplaychat.dices.forge_1_7_10.parser.roll.RollDice;
import ru.xunto.roleplaychat.dices.forge_1_7_10.parser.roll.RollNumber;
import ru.xunto.roleplaychat.dices.forge_1_7_10.parser.roll.RollSum;
import ru.xunto.roleplaychat.forge_1_7_10.ForgeSpeaker;
import ru.xunto.roleplaychat.forge_1_7_10.ForgeWorld;
import ru.xunto.roleplaychat.framework.api.Environment;
import ru.xunto.roleplaychat.framework.api.Request;
import ru.xunto.roleplaychat.framework.jtwig.JTwigState;
import ru.xunto.roleplaychat.framework.jtwig.JTwigTemplate;
import ru.xunto.roleplaychat.framework.renderer.text.TextColor;
import ru.xunto.roleplaychat.framework.state.IProperty;
import ru.xunto.roleplaychat.framework.state.Property;

import java.util.List;

public class DiceCommand extends CommandBase {
    public static IProperty<IRoll> roll = new Property<>("roll");
    public static IProperty<List<TextPart>> result = new Property<>("result");
    public static IProperty<Integer> finalResult = new Property<>("final_result");
    private static JTwigTemplate template = new JTwigTemplate("assets/roleplaychatdices/templates/dices.twig");

    @Override
    public String getCommandName() {
        return "roll";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return null;
    }

    public void sendDiceResult(EntityPlayerMP player, IRoll roll, IResult result) {
        ForgeSpeaker speaker = new ForgeSpeaker(player);
        ForgeWorld world = new ForgeWorld(player.getServerForPlayer());

        Request request = new Request("", speaker, world);
        Environment environment = new Environment(speaker.getName(), "");
        JTwigState state = environment.getState();
        environment.setProcessed(true);

        environment.setTemplate(template);
        environment.getColors().put("default", TextColor.GOLD);
        environment.getColors().put("critical_success", TextColor.GREEN);
        environment.getColors().put("critical_failure", TextColor.RED);

        state.setValue(DiceCommand.roll, roll);
        state.setValue(DiceCommand.result, result.getColoredResult().build());
        state.setValue(DiceCommand.finalResult, result.getFinalResult());

        RoleplayChatCore.instance.process(request, environment);
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        EntityPlayerMP player = (EntityPlayerMP) sender;

        IRoll roll = new RollSum(new RollDice(5, 20), new RollNumber(5));
        IResult result = roll.roll();

        this.sendDiceResult(player, roll, result);
    }
}
