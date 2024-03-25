package com.montaury.pokebagarre.metier;

import com.montaury.pokebagarre.erreurs.ErreurMemePokemon;
import com.montaury.pokebagarre.erreurs.ErreurPokemonNonRenseigne;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BagarreTest {

    @Test
    void devrait_lever_une_erreur_si_le_premier_pokemon_est_null() {
        // GIVEN
        Bagarre bagarre = new Bagarre();

        Throwable erreur = Assertions.catchThrowable(()->bagarre.demarrer(null,"pikachu"));

        // THEN
        assertThat(erreur).isInstanceOf(ErreurPokemonNonRenseigne.class)
                .hasMessage("Le premier pokemon n'est pas renseigne");
    }

    @Test
    void devrait_lever_une_erreur_si_le_deuxieme_pokemon_est_null() {
        // GIVEN
        Bagarre bagarre = new Bagarre();

        Throwable erreur = Assertions.catchThrowable(()->bagarre.demarrer("pikachu",null));

        // THEN
        assertThat(erreur).isInstanceOf(ErreurPokemonNonRenseigne.class)
                .hasMessage("Le second pokemon n'est pas renseigne");
    }

    @Test
    void devrait_lever_une_erreur_si_le_premier_pokemon_est_vide() {
        // GIVEN
        Bagarre bagarre = new Bagarre();

        Throwable erreur = Assertions.catchThrowable(()->bagarre.demarrer("","pikachu"));

        // THEN
        assertThat(erreur).isInstanceOf(ErreurPokemonNonRenseigne.class)
                .hasMessage("Le premier pokemon n'est pas renseigne");
    }

    @Test
    void devrait_lever_une_erreur_si_le_deuxieme_pokemon_est_vide() {
        // GIVEN
        Bagarre bagarre = new Bagarre();

        Throwable erreur = Assertions.catchThrowable(()->bagarre.demarrer("pikachu",""));

        // THEN
        assertThat(erreur).isInstanceOf(ErreurPokemonNonRenseigne.class)
                .hasMessage("Le second pokemon n'est pas renseigne");
    }
    @Test
    void devrait_lever_une_erreur_si_les_deux_pokemons_ont_le_meme_nom() {
        // GIVEN
        Bagarre bagarre = new Bagarre();

        Throwable erreur = Assertions.catchThrowable(()->bagarre.demarrer("pikachu","pikachu"));

        // THEN
        assertThat(erreur).isInstanceOf(ErreurMemePokemon.class)
                .hasMessage("Impossible de faire se bagarrer un pokemon avec lui-meme");
    }
}