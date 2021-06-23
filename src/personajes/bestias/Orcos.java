package src.personajes.bestias;

import src.personajes.Bestias;

public class Orcos extends Bestias{

    private static int contadorInstancias;

    public Orcos(String nombre) {
        super(300, 45, nombre);
        Orcos.contadorInstancias++;      
    }   
    

    public static int getInstancias(){
        return Orcos.contadorInstancias;
    }
    @Override
    public void saludar(){
        System.out.println("hola soy un orco y me llamo"+ this.nombre);
    }
}
