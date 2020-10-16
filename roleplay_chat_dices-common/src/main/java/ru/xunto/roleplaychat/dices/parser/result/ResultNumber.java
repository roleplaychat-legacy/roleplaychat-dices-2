package ru.xunto.roleplaychat.dices.parser.result;

import ru.xunto.roleplaychat.dices.parser.IResult;
import ru.xunto.roleplaychat.framework.state.values.colored_array.ColoredBuilder;

public class ResultNumber implements IResult {
    private int result;

    public ResultNumber(int result) {
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
        return builder.add(Integer.toString(result));
    }
}
