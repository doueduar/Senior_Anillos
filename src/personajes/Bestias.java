package src.personajes;
import src.*;

public class Bestias extends Personajes {
    private static int ataqueMaximo = 90;
    //private static int instanciasBestias;

    public Bestias(int vida, int armadura, String nombre){
        super(vida, armadura, ataqueMaximo, nombre, false);
    }
    @Override
    public int getAtaque(){
        return Dado.tirarDado(0, Bestias.ataqueMaximo , 1, true);
    }
}
