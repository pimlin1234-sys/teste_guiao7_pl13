package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Cozinhar comida congelada. */
@StateSet({"congelada", "descongelada", "aCozinhar", "cozinhada", "desperdicada"})
public class RefeicaoCongelada {

    @StateRefinement(to="congelada()")
    public RefeicaoCongelada() {}

    /** Volta a congelar a refeição (só se ainda não começou a ser cozinhada). */
    @StateRefinement(from="descongelada()", to="congelar()")
    public void voltarACongelar() {}

    /** Deita a refeição fora. */
    @StateRefinement(from="cozinhada()", to="desperdicada()")
    public void deitarFora() {}

    /** Descongela a refeição. */
    @StateRefinement(from="congelada()", to="descongelada()")
    public void descongelar() {}

    /** Põe a refeição a cozinhar. */
    @StateRefinement(from="congelada()", to="aCozinhar()")
    public void iniciarCozedura() {}

    /** Termina a cozedura. */
    @StateRefinement(from="aCozinhar()", to="cozinhada()")
    public void terminarCozedura() {}
}
