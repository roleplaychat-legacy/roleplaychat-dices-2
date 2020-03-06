package ru.xunto.roleplaychat.dices.parser;

import ru.xunto.roleplaychat.dices.parser.colored.ColoredBuilder;

public interface IResult {
    int getFinalResult();

    ColoredBuilder getColoredResult();

    ColoredBuilder getColoredResult(ColoredBuilder builder);
}
