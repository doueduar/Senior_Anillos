package src.personajes.heroes;

import src.personajes.Heroes;

public class Elfos extends Heroes{
    private static int contadorInstancias;

    public Elfos(String nombre) {
        super(250, 45, nombre);
        Elfos.contadorInstancias++;      
    }   
    

    public static int getInstancias(){
        return Elfos.contadorInstancias;
    }
    @Override
    public void saludar(){
        System.out.println("hola soy un Elfo y me llamo"+ this.nombre);
    }
    
}
