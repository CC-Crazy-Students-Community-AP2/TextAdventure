package de.comcave.textadventure.data;

import de.comcave.textadventure.enums.Interaction;
import de.comcave.textadventure.enums.InteractionType;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Methods {

    protected static void emptyLines(int lines) {
        for (int i = 0; i < lines; i++) {
            System.out.println();
        }
    }

    protected static void getMessage(int count) {
        if (count > 0) {
            System.out.println("Nach der letzten Begegnung, gehst Du weiter, als dir wieder plötzlich etwas begegnet.");
            System.out.println("Du hast keine Ahnung, wer oder was das ist.");

        } else {
            System.out.println("Du bist in einem Wald und hast einen Wanderstab sowie einen Rucksack voll mit Eier-Tomaten-Gurken-Sandwiches.");
            System.out.println("Es ist sehr dunkel, und du kannst kaum die Hand vor Augen sehen, als dir plötzlich etwas begegnet.");
            System.out.println("Du hast keine Ahnung, wer oder was das ist.");
        }
        System.out.println();
        System.out.println("Möchtest du es:");
        System.out.println("\t1) füttern?");
        System.out.println("\t2) streicheln?");
        System.out.println("\t3) mit dem Stock schlagen?");
        System.out.println();
    }

    protected static List<Interaction> generateRandomInteractions() {
        List<Interaction> allInteractions = new ArrayList<>(List.of(Interaction.values()));
        Collections.shuffle(allInteractions);

        return allInteractions.subList(0, 10);
    }

    protected static int getUserChoice(BufferedReader reader, int counter) {
        getMessage(counter);

        int userChoice = 0;
        while (true) {
            try {
                System.out.print("Deine Wahl: ");
                userChoice = Integer.parseInt(reader.readLine());

                if (userChoice == 0) {
                    emptyLines(50);
                    System.out.println("Programm wurde abgebrochen. Vielen Dank!");
                    System.exit(0);
                } else if (userChoice < 1 || userChoice > 3) {
                    System.out.println("Ungültige Eingabe. Bitte wähle 1, 2 oder 3.");
                } else {
                    break;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte wähle 1, 2 oder 3.");
            }
        }

        return userChoice;
    }

    protected static int handleInteraction(Interaction currentInteraction, int userChoice) {
        InteractionType userChoise = InteractionType.getByUserChoice(userChoice);
        boolean isCorrectDesicion = (currentInteraction.getInteractionType() == userChoise);

        System.out.println("\t" + currentInteraction.getActionText(userChoise));
        System.out.println(isCorrectDesicion ? "\tDiese Aktion kostet kein Leben." : "\tDiese Aktion kostet Leben: -" + currentInteraction.getDamage() + " Leben.");

        return isCorrectDesicion ? 0 : currentInteraction.getDamage();
    }

    protected static String getCurrentLive(int playerLives) {
        return (playerLives < 3 ? "\t\tDu hast noch " : "\t\tDu hast nur noch ") + playerLives + " Leben.";
    }
}
