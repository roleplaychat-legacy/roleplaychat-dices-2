package ru.xunto.roleplaychat.dices.forge_1_7_10.parser.result;

import ru.xunto.roleplaychat.dices.forge_1_7_10.parser.IResult;
import ru.xunto.roleplaychat.dices.forge_1_7_10.parser.colored.ColoredBuilder;
import ru.xunto.roleplaychat.dices.forge_1_7_10.parser.roll.RollDice;

public class ResultDice implements IResult {
    private RollDice dice;
    private int result;

    public ResultDice(RollDice dice, int result) {
        this.dice = dice;
        this.result = result;
    }

    @Override
    public int getFinalResult() {
        return this.result;
    }

    @Override
    public ColoredBuilder getColoredResult() {
        ColoredBuilder coloredBuilder = new ColoredBuilder();
        return this.getColoredResult(coloredBuilder);
    }

    @Override
    public ColoredBuilder getColoredResult(ColoredBuilder builder) {
        String str = Integer.toString(this.result);

        if (dice.getSides() == this.result) builder.add(str, "critical_success");
        else if (this.result == 1) builder.add(str, "critical_failure");
        else builder.add(str);

        return builder;
    }
}
