package src;
import src.personajes.bestias.*;
import src.personajes.heroes.*;
import src.personajes.Bestias;
import src.personajes.Heroes;
import src.personajes.Personajes;

public class Juego {
    //inicializar los arreglos de los personajes de la batalla.
    private Bestias ejercitoBestias[];
    private Heroes ejercitoHeroes[];

    private final int CANTIDAD = 5;

    public Juego() {
        // inicializar la cantidad de personajes 
        ejercitoBestias = new Bestias[CANTIDAD];
        ejercitoHeroes = new Heroes[CANTIDAD];

    }
    public void jugar(){
        System.out.println("Bienvenido al juego del señor de los anillos: \n\n"); 
        // inicializando a bestias con el metodo interno 
        this.inicializarBestias();
        this.presentarPersonajes(ejercitoBestias);
        //inicializando a heroes
        this.inicializarHeroes();
        this.presentarPersonajes(ejercitoHeroes);

        System.out.println("\n\n Iniciando pelea de bestias y heroes: \n\n");
        this.pelea();
   
    }
    // Metodo para ataque y defensa
    public void peliadores(int posicion){
        while ( ( 0 < ejercitoBestias[posicion].getVida() ) && ( 0 < ejercitoHeroes[posicion].getVida() ) ) {
            if (0 < ejercitoHeroes[posicion].getVida()) {
                ejercitoBestias[posicion].recibirAtaque(ejercitoHeroes[posicion]);
            }
            //evaluar si el elfo mato a la bestia si no la bestia sigue atacando
            if (0<ejercitoBestias[posicion].getVida()) {
                ejercitoHeroes[posicion].recibirAtaque(ejercitoBestias[posicion]);
            }
        } 
    }

    int ronda = 1;
    public void rondas(){
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>Ronda "+ronda+"<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        for (int i = 0; i < ejercitoBestias.length; i++) {
            if ((ejercitoBestias[i] !=null) && (ejercitoHeroes[i] !=null) ) {
                this.peliadores(i);
                if (0 < ejercitoBestias[i].getVida()) {
                    System.out.println("ganador: "+ ejercitoBestias[i].getNombre()+"\n\n");
                    ejercitoHeroes[i].setVida(0);
                }
                if (0 < ejercitoHeroes[i].getVida()){
                    System.out.println("ganador: "+ ejercitoHeroes[i].getNombre()+"\n\n");
                    ejercitoBestias[i].setVida(0);
                }
            }
        }
        for (int i = 0; i < ejercitoBestias.length; i++) {
            if (ejercitoBestias[i] != null) {
                if (ejercitoBestias[i].getVida() <= 0) {
                    ejercitoBestias[i] = null;
                }
            }
            if (ejercitoHeroes[i] !=null) {
                if (ejercitoHeroes[i].getVida() <= 0) {
                    ejercitoHeroes[i] =null;
                }
            }
        }
        ronda++;
    }
    public void pelea(){
        while ((existe(ejercitoBestias))&&(existe(ejercitoHeroes))) {
            this.rondas();
            this.ordenar(ejercitoBestias);
            this.ordenar(ejercitoHeroes);
            System.out.println("Peliadores restantes: \n");
            this.presentarPersonajes(ejercitoBestias);
            this.presentarPersonajes(ejercitoHeroes);
        }
        if (existe(ejercitoHeroes)){
            System.out.println("\n\n-------------------------Ganador Heroes----------------------------\n\n");
        }
        if (existe(ejercitoBestias)){
            System.out.println("\n\n-------------------------Ganador Bestias----------------------------\n\n");
        }
    }

    public void inicializarBestias(){
        int random = 0;
        // utiliza el for para calcular la cantidad del ejercito que se tiene 
        //con el length 
        for (int i = 0; i < ejercitoHeroes.length; i++) {
            random = Dado.tirarDado(0, 1, 1, false);
            switch (random) {
                case 0:
                    ejercitoBestias[i] = new Trasgos("Trasgo "+Trasgos.getInstancias());
                    break;
                case 1:
                    ejercitoBestias[i] = new Orcos("Orco "+Orcos.getInstancias());
                    break;
                default:
                    ejercitoBestias[i] = new Orcos("Orco "+Orcos.getInstancias());
                    break;
            }
        }
    }

    public void inicializarHeroes(){
        int random = 0;
        for (int i = 0; i < ejercitoHeroes.length; i++) {
            random = Dado.tirarDado(0, 2, 1, false);
            switch (random) {
                case 0:
                    ejercitoHeroes[i] = new Humanos("Humano "+Humanos.getInstancias());
                    break;
                case 1:
                    ejercitoHeroes[i] = new Elfos("Elfo "+Elfos.getInstancias());
                    break;
                case 2:
                    ejercitoHeroes[i] = new Hobbits("Hobbit "+Hobbits.getInstancias());
                    break;
                default:
                    ejercitoHeroes[i] = new Elfos("Elfo "+Elfos.getInstancias());
                    break;
            }
        }
    }
    public boolean existe(Personajes ejercito[]){
        for (int i = 0; i < ejercito.length; i++) {
            if (ejercito[i]!=null) {
                return true;
            }
        }
        return false;
    }
    public void ordenar(Personajes ejercito[]){
        for (int i = 0; i < ejercito.length-2; i++) {
            for (int j = 0; j < ejercito.length-1; j++) {
                if ((ejercito[j]==null)&&(ejercito[j+1]!=null)) {
                        ejercito[j] = ejercito[j+1];
                        ejercito[j+1] = null;
                }
            }
        }
    }
    public void presentarPersonajes( Personajes ejercito[]){

        if (ejercito.length> 0 ){
           
            for (int i = 0; i < ejercito.length; i++) {
                //ejemplo con operador ternario
                if (ejercito[i] !=null) {
                    System.out.println("\nPresentando ejercito de "+ (ejercito[i] instanceof Bestias?"Bestias":"Herores")+"\n");
                        for (int j = 0; j < ejercito.length; j++) {
                            if (ejercito[j] !=null) {
                                ejercito[j].saludar();
                            }
                        }
                    break;  
                }else{
                    System.out.print("No hay ejercito");
                    break;
                }

            }
        }
        else {
            System.out.println("No hay un ejercito ");
        }
    }

}
