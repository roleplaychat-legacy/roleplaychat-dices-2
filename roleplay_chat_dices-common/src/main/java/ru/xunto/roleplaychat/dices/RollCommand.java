package ru.xunto.roleplaychat.dices;

import org.jparsec.error.ParserException;
import org.jtwig.environment.EnvironmentConfiguration;
import org.jtwig.resource.loader.ClasspathResourceLoader;
import org.jtwig.resource.loader.TypedResourceLoader;
import org.jtwig.resource.reference.ResourceReference;
import ru.xunto.roleplaychat.RoleplayChatCore;
import ru.xunto.roleplaychat.api.ICommand;
import ru.xunto.roleplaychat.api.ISpeaker;
import ru.xunto.roleplaychat.dices.parser.DiceParser;
import ru.xunto.roleplaychat.dices.parser.IResult;
import ru.xunto.roleplaychat.dices.parser.IRoll;
import ru.xunto.roleplaychat.dices.parser.colored.TextPart;
import ru.xunto.roleplaychat.features.middleware.distance.Distance;
import ru.xunto.roleplaychat.features.middleware.distance.DistanceMiddleware;
import ru.xunto.roleplaychat.framework.api.Environment;
import ru.xunto.roleplaychat.framework.api.Request;
import ru.xunto.roleplaychat.framework.commands.CommandException;
import ru.xunto.roleplaychat.framework.jtwig.JTwigState;
import ru.xunto.roleplaychat.framework.jtwig.JTwigTemplate;
import ru.xunto.roleplaychat.framework.renderer.text.TextColor;
import ru.xunto.roleplaychat.framework.state.IProperty;
import ru.xunto.roleplaychat.framework.state.Property;

import java.util.Collections;
import java.util.List;

public class RollCommand implements ICommand {
    public static IProperty<IRoll> roll = new Property<>("roll");
    public static IProperty<List<TextPart>> result = new Property<>("result");
    public static IProperty<Integer> finalResult = new Property<>("final_result");
    private static EnvironmentConfiguration CONF = JTwigTemplate.CONF_BUILDER
            .resources()
            .resourceLoaders().set(
                    Collections.singletonList(new TypedResourceLoader(
                            ResourceReference.CLASSPATH,
                            new ClasspathResourceLoader(RollCommand.class.getClassLoader())
                    ))
            ).and()
            .and()
            .build();


    private static JTwigTemplate template = new JTwigTemplate("assets/roleplaychatdices/templates/dices.twig", CONF);

    public void sendDiceResult(ISpeaker speaker, IRoll roll, IResult result) {
        Request request = new Request("", speaker);
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
        state.setValue(DistanceMiddleware.FORCE_ENVIRONMENT, true);
        state.setValue(DistanceMiddleware.DISTANCE, Distance.NORMAL);

        RoleplayChatCore.instance.process(request, environment);
    }

    @Override
    public String getCommandName() {
        return "roll";
    }

    @Override
    public String[] getTabCompletion(ISpeaker iSpeaker, String[] strings) {
        return new String[0];
    }

    @Override
    public boolean canExecute(ISpeaker iSpeaker) {
        return true;
    }

    @Override
    public void execute(ISpeaker speaker, String[] args) throws CommandException {
        String arg = String.join("", args);

        IRoll roll;
        try {
            roll = DiceParser.parser().parse(arg);
            IResult result = roll.roll();
            this.sendDiceResult(speaker, roll, result);
        } catch (ParserException e) {
            throw new CommandException("Невозможно бросить такой дайс.");
        }
    }
}
