package src.personajes.heroes;

import src.personajes.Heroes;

public class Humanos extends Heroes{
    private static int contadorInstancias;

    public Humanos(String nombre) {
        super(180, 45, nombre);
        Humanos.contadorInstancias++;      
    }   
    

    public static int getInstancias(){
        return Humanos.contadorInstancias;
    }
    @Override
    public void saludar(){
        System.out.println("hola soy un Humano y me llamo"+ this.nombre);
    }
    
}
