package ru.xunto.roleplaychat.dices.parser;

import ru.xunto.roleplaychat.framework.state.values.colored_array.ColoredBuilder;

public interface IResult {
    int getFinalResult();

    ColoredBuilder getColoredResult();

    ColoredBuilder getColoredResult(ColoredBuilder builder);
}
