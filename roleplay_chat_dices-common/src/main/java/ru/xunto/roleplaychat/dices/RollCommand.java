package ru.xunto.roleplaychat.dices;

import org.jparsec.error.ParserException;
import ru.xunto.roleplaychat.RoleplayChatCore;
import ru.xunto.roleplaychat.api.ISpeaker;
import ru.xunto.roleplaychat.api.IWorld;
import ru.xunto.roleplaychat.dices.parser.DiceParser;
import ru.xunto.roleplaychat.dices.parser.IResult;
import ru.xunto.roleplaychat.dices.parser.IRoll;
import ru.xunto.roleplaychat.dices.parser.colored.TextPart;
import ru.xunto.roleplaychat.framework.api.Environment;
import ru.xunto.roleplaychat.framework.api.Request;
import ru.xunto.roleplaychat.framework.jtwig.JTwigState;
import ru.xunto.roleplaychat.framework.jtwig.JTwigTemplate;
import ru.xunto.roleplaychat.framework.renderer.text.TextColor;
import ru.xunto.roleplaychat.framework.state.IProperty;
import ru.xunto.roleplaychat.framework.state.Property;

import java.util.List;

public class RollCommand {
    public static IProperty<IRoll> roll = new Property<>("roll");
    public static IProperty<List<TextPart>> result = new Property<>("result");
    public static IProperty<Integer> finalResult = new Property<>("final_result");
    private static JTwigTemplate template = new JTwigTemplate("assets/roleplaychatdices/templates/dices.twig");

    public void sendDiceResult(ISpeaker speaker, IWorld world, IRoll roll, IResult result) {
        Request request = new Request("", speaker, world);
        Environment environment = new Environment(speaker.getName(), "");
        JTwigState state = environment.getState();
        environment.setProcessed(true);

        environment.setTemplate(template);
        environment.getColors().put("default", TextColor.GOLD);
        environment.getColors().put("critical_success", TextColor.GREEN);
        environment.getColors().put("critical_failure", TextColor.RED);

        state.setValue(RollCommand.roll, roll);
        state.setValue(RollCommand.result, result.getColoredResult().build());
        state.setValue(RollCommand.finalResult, result.getFinalResult());

        RoleplayChatCore.instance.process(request, environment);
    }

    public void execute(ISpeaker speaker, IWorld world, String arg) throws ParserException {
        IRoll roll = DiceParser.parser().parse(arg);
        IResult result = roll.roll();

        this.sendDiceResult(speaker, world, roll, result);
    }

    public String getName() {
        return "roll";
    }
}
