package de.comcave.textadventure.enums;

import lombok.Getter;

@Getter
public enum Interaction {

    FOERSTER("Förster",
            InteractionType.FEED,
            "Der Jäger freut sich über das Essen und bedankt sich!",
            "Der Jäger schaut dich irritiert an, als du versuchst, ihn zu streicheln und schießt auf dich.",
            "Der Jäger ist empört! Er zieht seinen Revolver und schießt auf dich.",
            1),
    FOERSTER_JEEP("Jeep des Försters",
            InteractionType.PET,
            "Der Jäger findet es gar nicht gut, dass Du seinen Jeep mit Essen bewirfst, er wirft Dich in den See.",
            "Der Jeep bleibt regungslos, als Du ihn streichelst. Der Jäger schaut nur komisch.",
            "Der Jäger findet es gar nicht gut, dass Du seinen Jeep mit einem Stock vermöbelst, jetzt vermöbelt er Dich.",
            1),
    KROKODIL("Krokodil",
            InteractionType.FEED,
            "schnappt nach dem Essen und verschwindet im Wasser.",
            "faucht dich an, schnappt nach Dir und zieht sich zurück.",
            "Das Krokodil ist wütend! Es verfolgt dich.",
            2),
    LOEWE("Löwe",
            InteractionType.FEED,
            "Der Löwe brüllt vor Freude über das Essen und rennt damit weg.",
            "Der Löwe brummt zufrieden, wenn du ihn streichelst und spielt mit Dir.",
            "Der Löwe ist verärgert! Er springt dich an.",
            2),
    HE_MAN("He-Man",
            InteractionType.PET,
            "He-Man nimmt das Essen und bedankt sich mit einem kräftigen 'Ich habe die Macht!' une einem zu kräftigen Schulterschlag.",
            "He-Man zeigt dir seine beeindruckende Muskulatur, als du versuchst, ihn zu streicheln.",
            "He-Man ist beleidigt! Er schleudert dich durch die Luft.",
            3),
    REH("Reh",
            InteractionType.PET,
            "Das Reh verschwindet scheu mit dem Essen im Wald.",
            "Das Reh genießt die Streicheleinheiten und schaut dich dankbar an.",
            "Das Reh erschrickt und tritt aus.",
            1),
    DR_SNUGGLES("Dr. Snuggles",
            InteractionType.PET,
            "Dr. Snuggles hüpft vor Freude umher und trampelt aus Versehen über Dich drüber.",
            "Dr. Snuggles kuschelt sich an dich, während du ihn streichelst.",
            "Dr. Snuggles ist traurig! Er weint und nimmt dir das Essen weg.",
            2),
    TELETUBBIES("Teletubbies",
            InteractionType.ATTACK,
            "Die Teletubbies sehen das Essen, klauen es Dir und tanzen vor Glück.",
            "Die Teletubbies fangen an Dich zu streicheln und zu drücken, als Du sie streicheln willst.",
            "Die Teletubbies haben Angst! Sie laufen weg, Du hast gewonnen",
            2),
    HULK("Hulk",
            InteractionType.FEED,
            "Hulk verschlingt das Essen und grunzt vor Zufriedenheit.",
            "Hulk knurrt Dich an und schubst Dich, als du versuchst, ihn zu streicheln.",
            "Hulk ist rasend vor Wut! Er zerstört alles um sich herum.",
            3),
    GUMMIBAERENBANDE("Gummibärenbande",
            InteractionType.PET,
            "Du hast leider keine Gummibären, das macht die Bande sauer.",
            "Die Bande kichert vergnügt, wenn du sie streichelst.",
            "Die Gummibärenbande ist verspielt! Sie schnappen nach dir.",
            1);

    private final String name;
    private final InteractionType interactionType;
    private final String feedText;
    private final String petText;
    private final String attackText;
    private final int damage;

    Interaction(String name, InteractionType interactionType, String feedText, String petText, String attackText, int damage) {
        this.name = name;
        this.interactionType = interactionType;
        this.feedText = feedText;
        this.petText = petText;
        this.attackText = attackText;
        this.damage = damage;
    }

    public String getActionText(InteractionType interactionType) {
        return switch (interactionType) {
            case FEED -> feedText;
            case PET -> petText;
            case ATTACK -> attackText;
        };
    }
}