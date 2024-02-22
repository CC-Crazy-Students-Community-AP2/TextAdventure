package de.comcave.textadventure;

import de.comcave.textadventure.data.Methods;
import de.comcave.textadventure.enums.Interaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Slf4j
@SpringBootApplication
public class TextAdventureApplication extends Methods {

    public static void main(String[] args) {
        int playerLives = 6;
        int userChoice = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Interaction> interactions = generateRandomInteractions();

        for (int i = 0; i < 10; i++) {
            emptyLines(2);
//            userChoice = getUserChoice(reader, i);
            Interaction currentInteraction = interactions.get(i);
            emptyLines(30);

            // Debug
            System.out.println("Begegnung " + (i + 1) + ": " + currentInteraction.getName() + " (" + currentInteraction.getInteractionType().getUserChoice() + ")");
            userChoice = getUserChoice(reader, i);

//            System.out.println("Begegnung " + (i + 1) + ": " + currentInteraction.getName());
            playerLives -= handleInteraction(currentInteraction, userChoice);
            System.out.println(getCurrentLive(playerLives));

            if (playerLives <= 0) {
                emptyLines(50);
                System.out.println("Du hast alle Leben verloren. Das Spiel ist vorbei.\n");
                break;
            }
        }

        if (playerLives > 0) {
            emptyLines(50);
            System.out.println("Herzlichen Glückwunsch!\nDu hast den Wald überlebt und bist beim McDonald's angekommen.\nGuten Appetit :-)\n");
        }
    }
}