package src.personajes.bestias;

import src.personajes.Bestias;

public class Trasgos extends Bestias{
    
    private static int contadorInstancias;

    public Trasgos(String nombre){
        super(325, 45, nombre);
        Trasgos.contadorInstancias++;
    }
    
    public static int getInstancias(){
        return Trasgos.contadorInstancias;
    }
    @Override
    public void saludar(){
        System.out.println("hola soy un trasgo y me llamo"+ this.nombre);
    }
}
