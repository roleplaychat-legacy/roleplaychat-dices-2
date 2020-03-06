package ru.xunto.roleplaychat.dices.forge_1_7_10.parser;

import ru.xunto.roleplaychat.dices.forge_1_7_10.parser.colored.ColoredBuilder;

public interface IResult {
    int getFinalResult();

    ColoredBuilder getColoredResult();

    ColoredBuilder getColoredResult(ColoredBuilder builder);
}
