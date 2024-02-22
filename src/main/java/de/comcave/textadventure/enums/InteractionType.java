package de.comcave.textadventure.enums;

import lombok.Getter;

@Getter
public enum InteractionType {
    FEED(1), PET(2), ATTACK(3);

    private final int userChoice;

    InteractionType(int userChoice) {
        this.userChoice = userChoice;
    }

    public static InteractionType getByUserChoice(int choice) {
        for (InteractionType type : values()) {
            if (type.getUserChoice() == choice) {
                return type;
            }
        }
        throw new IllegalArgumentException("Ungültige Benutzerwahl: " + choice);
    }
}