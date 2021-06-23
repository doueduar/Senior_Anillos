package src.personajes.heroes;

import src.personajes.Heroes;

public class Hobbits extends Heroes {
    
    private static int contadorInstancias;

    public Hobbits(String nombre) {
        super(200, 45, nombre);
        Hobbits.contadorInstancias++;      
    }   
    

    public static int getInstancias(){
        return Hobbits.contadorInstancias;
    }
    @Override
    public void saludar(){
        System.out.println("hola soy un Hobbit y me llamo"+ this.nombre);
    }
    
}
