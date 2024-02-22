package de.comcave.textadventure.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum InteractionType {
    FEED(1),
    PET(2),
    ATTACK(3);

    private final int userChoice;

    InteractionType(int userChoice) {
        this.userChoice = userChoice;
    }

    public static InteractionType getByUserChoice(int choice) {
        return Arrays
                .stream(values())
                .filter(type -> type.getUserChoice() == choice)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Ungültige Benutzerwahl: " + choice));
    }
}