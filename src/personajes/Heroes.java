package src.personajes;
import src.*;

public class Heroes extends Personajes {
    //private static int instanciasHeroes;
    private static int ataqueMaximo = 100;

    public Heroes (int vida, int armadura, String nombre){
        super(vida, armadura, ataqueMaximo, nombre, true);
        //Heroes.instanciasHeroes++;

    }
    //public static int getInstancias(){
      //  return Heroes.instanciasHeroes;
    //}
    @Override
    public int getAtaque(){
        return Dado.tirarDado(0, Heroes.ataqueMaximo, 2, true);
    }
    
}
