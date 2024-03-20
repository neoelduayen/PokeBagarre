package com.montaury.pokebagarre.metier;

import com.montaury.pokebagarre.fixtures.ConstructeurDePokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class PokemonTest {

    @Test
    void premier_pokemon_devrait_gagner_si_meilleure_attaque() {
        // GIVEN
        Pokemon Pokemon1 = new Pokemon("Pikachu","",new Stats(100,50));
        Pokemon Pokemon2 = new Pokemon("Rattata","",new Stats(50, 100));

        // WHEN
        boolean resultat = Pokemon1.estVainqueurContre(Pokemon2);

        // THEN
        // assertEquals(true,resultat);
        assertThat(resultat).isTrue();
    }

    @Test
    void deuxieme_pokemon_devrait_gagner_si_meilleure_attaque() {
        // GIVEN
        Pokemon Pokemon1 = new Pokemon("Pikachu","",new Stats(100,50));
        Pokemon Pokemon2 = new Pokemon("Tortank","",new Stats(150, 100));

        // WHEN
        boolean resultat = Pokemon2.estVainqueurContre(Pokemon1);

        // THEN
        assertEquals(true,resultat);
    }

    @Test
    void premier_pokemon_devrait_gagner_si_attaque_egale_et_meilleure_defense() {
        // GIVEN
        Pokemon Pokemon1 = new Pokemon("Torterra","",new Stats(150,120));
        Pokemon Pokemon2 = new Pokemon("Tortank","",new Stats(150, 100));

        // WHEN
        boolean resultat = Pokemon1.estVainqueurContre(Pokemon2);

        // THEN
        assertEquals(true,resultat);
    }

    @Test
    void deuxieme_pokemon_devrait_gagner_si_attaque_egale_et_meilleure_defense() {
        // GIVEN
        Pokemon Pokemon1 = new Pokemon("Torterra","",new Stats(150,120));
        Pokemon Pokemon2 = new Pokemon("Galeking","",new Stats(150, 150));

        // WHEN
        boolean resultat = Pokemon2.estVainqueurContre(Pokemon1);

        // THEN
        assertEquals(true,resultat);
    }

    @Test
    void premier_pokemon_devrait_gagner_si_attaque_egale_et_defense_egale() {
        // GIVEN
        Pokemon Pokemon1 = new Pokemon("Lougaroc","",new Stats(90,60));
        Pokemon Pokemon2 = new Pokemon("Elecsprint","",new Stats(90, 60));

        // WHEN
        boolean resultat = Pokemon1.estVainqueurContre(Pokemon2);

        // THEN
        assertEquals(true,resultat);
    }

}