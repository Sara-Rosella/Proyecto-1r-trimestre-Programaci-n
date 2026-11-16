import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

//2 y 14 --> minijuegos
//1 --> entrada, -1 --> sala secreta
//3, 4, 7, 12, 26, 16 --> salas vacías
//3, 4, 7, 12, 26, 16, 27, 28, 32, 33, 37 --> salas vacias V2
//5, 10, 13, 25, 19 --> cofre
//8, 17 --> ruletas
//11, 21, 22 --> finales
//6, 15 --> puertas

public class ProyectoV3 {
    static int[][] rooms = {
            {0, 0, 0, 0, 21, 22},
            {0, 11, 0, 0, 18, 0},
            {0, 9, 0, 0, 16, 0},
            {0, 32, 0, 38, 37, 0},
            {0, 31, 0, 35, 36, 0},
            {0, 30, 0, 34, 33, 19},
            {29, 27, 10, 0, 28, 17},
            {0, 7, 8, 0, 15, 0},
            {5, 6, 0, 25, 26, 0},
            {3, 4, 0, 13, 14, 0},
            {0, 2, 0, 12, 0, 0},
            {0, 0,  1, 0, 0, 0},
            {0, 0, -1, 0, 0, 0}
    };
    static int xpos;
    static int ypos;
    static boolean perro = false;
    static boolean llave = false;
    static boolean clave = false;
    static int vidas = 7;
    static boolean anafin = false;
    static boolean palcodfin = false;
    static boolean ahorcfin = false;
    static boolean estuve = false;
    static boolean rulefin = false;
    static boolean abierto = false;
    static boolean cofab = false;
    static boolean cofrerul = false;
    static boolean gema = false;
    static boolean llaveGet = false;
    static boolean stop = false;
    static boolean sombrero = false;
    static boolean invuse = false;
    static boolean gema2 = false;
    static boolean cofab2 = false;
    static boolean pregvid1 = false;
    static boolean pregvid2 = false;
    static boolean piedab = false;
    static boolean abierto2 = false;
    static boolean over = false;
    static boolean fin = false;
    static ArrayList<String> inv = new ArrayList<>();
    static ArrayList<String> notepadQuest = new ArrayList<>();
    static ArrayList<String> notepadAns= new ArrayList<>();
    static String[] objetos = {
            "perro", "llave", "clave de cifrado",
            "salir", "gema", "sombrero",
            "papel", "nota", "vidas", "piedra preciosa"};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String nombre;

        inv.add("vidas");
        inv.add("papel");

        tpw("Bienvenido estimado aventurero al templo del DRAGÓN HERÁLDICO GUIVERNO BLANCO.\nDurante siglos un tesoro ha permanecido oculto en este lugar, centenares de aventureros lo han intentado conseguir sin exito pereciendo en el intento.\n¿Serás el primero en superar todas la pruebas que te deparen tus elecciones durante el camino? Tengo ganas de comprobarlo...\nAhora valiente aventurero,¿Cuál es tu nombre?: ");
        nombre = sc.nextLine();

        tpw("\n" + nombre + "... ese nombre suena a éxito, suerte para tu aventura la vas a necesitar...\n");
        //xpos = 11; ypos = 2;
        xpos = 11;
        ypos = 2;

        tpw("\nTe encuentras en la primera sala, una sala vacía normal y corriente, sin ningún tipo de prueba o reto visible, sin embargo encuentras una nota a tu derecha.\nParece que la nota habla del templo, es mejor guardarla por si acaso.\n(Pones la nota el junto a un papel que trajiste de casa, para usarlo o examinarlo, abra el inventario)");
        inv.add("nota");

        room(rooms[xpos][ypos], nombre);
    }

    public static void tpw (String text) {

        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void room (int curoom, String nombre){

        String[] palabras = {
                "aventura", "tesoro", "heraldico", "escondite",
                "mazmorra", "laberinto", "pasadizo", "antorcha",
                "cripta", "guardian", "hechizo", "pocion",
                "grimorio", "conjuro", "dragon", "guiverno",
                "espectro", "reliquia", "maldicion", "cofre",
                "esmeralda", "diamante", "corona", "armadura",
                "pergamino", "medallon", "espada", "acertijo",
                "enigma", "jeroglifico"
        };

        do {
            switch (curoom){
                case -1 -> curoom = salaSecreta();
                case 1 -> {
                    if (perro){
                        curoom = entradaV2(nombre);
                    } else {
                        curoom = entrada(nombre);
                    }
                }
                case 2 -> {
                    if (anafin) {
                        curoom = anagrama(nombre);
                    } else {
                        curoom = anagrama(palabras, nombre);
                    }
                }
                case 5, 13, 25 ->{
                    if (cofab) {
                        curoom = salCofAb();
                    } else {
                        curoom = salCof();
                    }
                }

                case 19, 10 ->{
                    if (cofrerul){
                        curoom = salCofAb();
                    } else {
                        curoom = salCof();
                    }
                }

                case 36, 29 ->{
                    if (cofab2){
                        curoom = salCofAb();
                    } else {
                        curoom = salCof();
                    }
                }
                case 3, 4, 12, 26, 27, 28, 32, 34, 37 -> curoom = salVac(nombre);

                case 7, 33-> {
                    if (pregvid1) {
                        curoom = salVac(nombre);
                    } else {
                        curoom = salVid(nombre);
                    }
                }
                case 30, 35-> {
                    if (pregvid2) {
                        curoom = salVac(nombre);
                    } else {
                        curoom = salVid(nombre);
                    }
                }

                case 31, 16 -> {
                    if (abierto2){
                        curoom = puertpiedab(nombre);
                    } else {
                        curoom = puertapied(nombre);
                    }
                }

                case 14 -> {
                    if (palcodfin){
                    curoom = palcod(nombre);
                    } else {
                    curoom = palcod(palabras,nombre);
                    }
                }
                case 6, 15 ->{
                    if(abierto){
                        curoom = puertaab(nombre);
                    } else {
                        curoom = puertallav(nombre);
                    }
                }
                case 8 ,17 -> {
                    if (rulefin){
                    curoom = ruletav2();
                    } else {
                        curoom = ruleta();
                    }
                }
                case 9, 18 -> {
                    if (ahorcfin) {
                        curoom = ahorcado(nombre);
                    } else {
                        curoom = ahorcado(palabras);
                    }
                }
                case 38 -> curoom = salMed(nombre);
                case 11, 21, 22 -> termino();
            }
        } while (curoom != 0);

    }

    public static void sigueVivo() { //Funcion para comprobar las vidas al acabar las pruebas
        if (vidas <= 0) {
            tpw("\n\u001B[31mTE HAS QUEDADO SIN VIDAS. FIN DE LA AVENTURA.");
            System.exit(0);
        }
    }

    public static int entrada (String nombre) {
        Scanner sc = new Scanner(System.in);
        String ans;

        tpw("\n\nMiras tu entorno y ves 3 posibles caminos, izquierda, derecha y un pequeño conducto detrás de ti.");

        do {
            tpw("\n" + nombre + ", ¿Qué camino quieres escoger (1-> Izquierda, 2-> Derecha, 3-> Conducto, 4-> Inventario): ");
            ans = sc.next();

            if (op4Check(ans)){
                tpw("Opción no válida, por favor escriba '1' si quieres ir a la izquierda, '2' si quieres ir a la derecha, '3' si quieres ir por el ducto y '4' si quieres abrir el inventario");
            }
        } while (op4Check(ans));

           switch (ans) {
               case "1" -> {
                   xpos--;
                   ypos--;
               }
               case "3" ->{
                   xpos++;
                   return rooms[xpos][ypos];
               }
               case "2" -> {
                   xpos--;
                   ypos++;
               }
               case "4" -> inv();
           }
        return rooms[xpos][ypos];
    }

    public static int entradaV2 (String nombre) {
        Scanner sc = new Scanner(System.in);
        String ans;

        tpw("\nTe encuentras en la entrada de nuevo.\nMiras tu entorno y ves 2 posibles caminos, izquierda y derecha. El conducto detrás de ti parece innacesible.\n");

        do {
            tpw("\n" + nombre + ", ¿Por donde quieres ir? (1->Izquierda, 2->Derecha, 3-> Inventario): ");
            ans = sc.next();

            if (op3Check(ans)){
                tpw("Opción no válida, por favor escriba '1' si quieres ir a la izquierda, '2' si quieres ir a la derecha y '3' si quieres abrir el inventario");
            }
        } while (op3Check(ans));

        switch (ans){
            case "1" ->{
                xpos--;
                ypos--;
            }
            case "2" -> {
                xpos--;
                ypos++;
            }
            case "3" -> inv();
        }
        return rooms[xpos][ypos];
    }

    public static int salaSecreta () { //En esta funcion quiero que pregunte 3 veces si quiero tomar el camino para llegar a la sala secreta
        String n;
        Scanner sc = new Scanner(System.in);

        tpw("\nTe encuentras en un pasillo que no parece tener final, ¿qué quiere hacer? (1-> Seguir hacia adelante, 2-> Darte la vuelta y volver al incio): ");
        n = sc.next();


        while (op2Check(n)){
            tpw("\nOpción no válida, por favor introduzca '1' si quieres seguir o '2' si quieres darte la vuelta: ");
            n = sc.next();
        }


        switch (n) {
            case "1", "y":
                for (int i = 0; i < 3; i++) {
                    tpw("\nTodavía sigues sin ver el final..., ¿quieres seguir recorriendo este pasillo? (Y/N): ");
                    n = sc.next().toLowerCase();
                    char s = n.charAt(0);
                    while (ynCheck(s)) {
                        tpw("\nOpción no válida, por favor introduzca 'Y' si quieres seguir o 'N' si quieres darte la vuelta: ");
                        n = sc.next();
                        s = n.charAt(0);
                    }


                    if (s == 'n') {
                        tpw("\nVuelves a la sala inicial");
                        xpos--;
                        return rooms[xpos][ypos];
                    }
                }
                break;
            case "2", "n":
                tpw("\nVuelves a la sala inicial");
                xpos--;
                return rooms[xpos][ypos];
        }
        tpw("Consigues llegar al final del pasillo donde te encuentras un perro quien te mira con cara de expectación y miedo.\nDespués de unos minutos se acerca a ti amistosamente y parece estar listo para seguirte durante tu aventura.");
        tpw("Vuelves a la entrada, no nada más aquí");
        perro = true;
        inv.add("perro");
        xpos--;
        return rooms[xpos][ypos];
    }

    public static int anagrama(String[] palabras, String nombre) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbNum = new StringBuilder();
        Random rand = new Random();
        String palabra = palabras[rnd.nextInt(palabras.length)];
        String intento;
        cofab = false;

        int r;

        for (int i = 0; i < palabra.length(); i++){
            do {
                r = rand.nextInt(palabra.length());
            }while (sbNum.indexOf(String.valueOf(r)) != -1); //repite tirada en caso de que el número ya esté usado si no simplemente sale y lo mete en el string
            sbNum.append(r);
            sb.append(palabra.charAt(r));
        }

        tpw("\n(Escuchas a un puerta moverse)\n\nBienvenido viajero " + nombre + " a la prueba del anagrama.\nEsta prueba consiste en reordenar las letras de la cadena dada para adivinar la palabra escondida detrás de ese desorden.\nTeniendo en cuenta su dificultad te doy la opción de rendirte, a cambio perderás 3 vidas solo tendrás que introducir 'escapar'.");
        tpw("\nANAGRAMA: " + sb);
        tpw("\nPor favor, " + nombre + ", introduzca su intento: ");
        intento = sc.nextLine().toLowerCase();


        while (!intento.equalsIgnoreCase(palabra) && vidas > 0 && !intento.equalsIgnoreCase("escapar")){
            vidas--;
            tpw("\nIntento fallido, has perdido una vida.\nVidas restantes: " + vidas);
            sigueVivo();
            tpw("\nAnagrama: " + sb);
            tpw("\nPor favor, " + nombre + ", introduzca su nuevo intento: ");
            intento = sc.nextLine();
        }




        if (intento.equalsIgnoreCase(palabra)) {
            tpw("\nPalabra adivinada correctamente, felicidades.\n");
            anafin = true;
            tpw("La entrada por la que entraste empieza a colapsar, bloqueando el camino por donde entraste");
        } else if (intento.equalsIgnoreCase("escapar")) {
            vidas-= 3;
            tpw("\nIntentas escapar de la prueba pero en la sala empieza a temblar y te caen piedras grandes encima, logras esquivar la mayoría pero sales con heridas, quitándote 3 vidas.");
            sigueVivo();
            tpw("\nVidas restantes: " + vidas);
            anafin = true;
        }

        return rooms[xpos][ypos];
    }

    public static int anagrama(String nombre) {
        Scanner sc = new Scanner(System.in);
        String ans;


        tpw("\nHay dos caminos enfrente tuya, izquierda y derecha\n");

        do {
            tpw("\n" + nombre + ", ¿Qué camino quieres escoger?(1-> Izquierda, 2-> Derecha, 3 -> Inventario): ");
            ans = sc.next();

            if (op3Check(ans)) {
                tpw("Opción no válida, por favor escriba '1' si quieres ir a la izquierda, '2' si quieres ir a la derecha y '3' si quieres abrir el inventario");
            }
        } while (op3Check(ans));

        switch (ans){
            case "1" ->{
                xpos--;
                ypos--;
            }
            case "2" -> xpos--;

            case "3" -> inv();
        }
        return rooms[xpos][ypos];
    }

    public static int palcod(String[] palabras, String nombre){
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        String palabra = palabras[rnd.nextInt(palabras.length)];
        StringBuilder sb = new StringBuilder();
        String intento;
        char[] cadena1 = {'a', 'o', 'e', 's', 'c', 'r', 'n'};
        char[] cadena2 = {'q', 'x', 'k', 'w', 'z', 'ñ', 'h'};
        char c;


        for (int i = 0; i < palabra.length(); i++){
            c = palabra.charAt(i);
            sb.append(codifica(cadena1, cadena2, c));
        }


        tpw("\nBienvenido viajero " + nombre + ", esta prueba se llama 'palabra codificada' y como su propio nombre indica, consiste en adivinar la palabra codificada mostrada.\nDurante la aventura has podido encontrar alguna pista para resolverlo pero si no la encontraste solo me queda desearte buena suerte. \nTendrás los mismos intentos que vidas restantes tengas, cada fallo te restará 1 vida piénsalo antes de resolver a lo loco.");
        tpw("\nLa palabra codificada es: ");
        tpw(sb.toString());


        if (clave){
            tpw("\nClave de codificación: a -> q, o -> x, e -> k, s -> w, c -> z, r -> ñ y n -> h");
        }


        tpw("\nIntroduce tu intento, por favor (puedes salir de la prueba escribiendo 'salir'): ");
        intento = sc.next();


        while (!intento.equalsIgnoreCase(palabra) && vidas > 0 && !intento.equalsIgnoreCase("salir")){
            tpw("\nIntento fallido has perdido una vida");
            vidas--;
            sigueVivo();
            tpw("\nVidas restantes: ");
            tpw(String.valueOf(vidas));
            if (clave){
                tpw("\nClave de codificación: a -> q, o -> x, e -> k, s -> w, c -> z, r -> ñ y n -> h");
            }
            tpw("\nLa palabra codficada: ");
            tpw(sb.toString());
            tpw("\nPor favor, introduce un nuevo intento (recordatorio, puedes salir escribiendo 'salir'): ");
            intento = sc.next();

        }


        if (intento.equalsIgnoreCase("salir")){
            tpw("\nSaliste de la sala a salvo\n");
            xpos++;
            ypos--;
        } else {
            sigueVivo();
            tpw("\nPalabra acertada\n");
            tpw("Enhorabuena " + nombre + " por superar la prueba.");
            tpw("\nEscuchas algo moverse por la dirección por donde entraste");
            palcodfin = true;
            cofab = false;
        }

        return rooms[xpos][ypos];
    }

    public static int palcod(String nombre){
        Scanner sc = new Scanner(System.in);
        String ans;
        estuve = false;

        tpw("\nEn la sala se pueden ver dos caminos.\n");

        do {
            tpw(nombre + ", ¿Qué camino quieres escoger?(1-> Izquierda, 2-> Derecha, 3 -> Inventario): ");
            ans = sc.next();

            if (op3Check(ans)) {
                tpw("Opción no válida, por favor escriba '1' si quieres ir a la izquierda, '2' si quieres ir a la derecha y '3' si quieres abrir el inventario");
            }
        } while (op3Check(ans));

        switch (ans){
            case "1" ->{
                xpos--;
                ypos--;
            }
            case "2" -> xpos--;

            case "3" -> inv();
        }
        return rooms[xpos][ypos];
    }

    public static char codifica(char[] conjunto1, char[] conjunto2, char c ){
        for (int i = 0; i < conjunto1.length; i++){
            if (c == conjunto1[i]){
                return conjunto2[i];
            }
        }
        return c;
    }

    public static int ahorcado (String[] ans){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        char[] show;
        String pal = ans[r.nextInt(ans.length)];
        int counter;
        char guess;
        String res;
        String res2;
        boolean correct;
        boolean repeat;
        ArrayList<Character> adiv = new ArrayList<>();

        show = pal.toCharArray();
        counter = pal.length();


        tpw("Te encuentras en la prueba del ahorcado, tu objetivo es adivinar la palabra secreta.\nTendrás la opción de decir una letra y comprobar si está contenida en la palabra, o de adivinarla cuando lo tengas claro.\nCada letra o intento fallado te restará una vida, ahora sí que comience la prueba...");
        for (int i = 0; i < pal.length(); i++) {
            show[i] = '_';
        }



        tpw("\nTienes " + vidas + " intentos para adivinar la palabra\n");


        do{
            for (int i = 0; i < pal.length(); i++) {
                System.out.print(show[i]);
                System.out.print(' ');
            }
            tpw(" ");

            tpw("\nIntentos restantes: " + vidas);
            tpw("\nLetras introducidas: " + adiv);
            tpw("\nIntroduzca una letra o escriba adivinar para resolver la palabra: ");
            res = sc.next().toLowerCase();

            correct = false;
            if (Objects.equals(res,"adivinar")) {
                sc.nextLine();

                tpw("\n¿Cuál es la palabra oculta?");
                res2 = sc.nextLine().toLowerCase();

                if (Objects.equals(res2, pal)){
                    break;
                } else {
                    tpw("\nPalabra incorrecta");
                    vidas--;
                }
            } else {
                guess = res.toLowerCase().charAt(0);
                repeat = false;

                for (Character character : adiv) {
                    if (Objects.equals(guess, character)) {
                        tpw("\nLa letra ya ha sido introducida");
                        repeat = true;
                    }
                }

                if (!repeat) {
                    adiv.add(guess);
                    for (int i = 0; i < pal.length(); i++) {
                        if (guess == pal.charAt(i)) {
                            show[i] = guess;
                            counter--;
                            correct = true;
                        }
                    }

                    if (!correct) {
                        tpw("\nLa letra no está en la palabra");
                        vidas--;
                    } else {
                        tpw("\nLa letra está en la palabra");
                    }

                    sigueVivo();
                    System.out.println(' ');
                }
            }
        }while(counter != 0);

        tpw("Palabra adivinada: " + pal);
        tpw("\nEnhorabuena por superar la prueba del ahorcado." );
        ahorcfin = true;
        return rooms[xpos][ypos];
    }

    public static int ahorcado (String nombre){
        Scanner sc = new Scanner(System.in);
        String ans;


        switch (rooms[xpos][ypos]){
            case 9 -> {
                tpw("\nSolo te queda avanzar a la siguiente sala para reclamar tu deseada reliquia");
                do {
                    tpw("\n" + nombre + ", ¿Qué quieres hacer ahora? (1-> Avanzar, 2-> Volver, 3-> Inventario): ");
                    ans = sc.next();

                    if (op3Check(ans)) {
                        tpw("Opción no válida, por favor escriba '1' si quieres ir a la izquierda, '2' si quieres ir a la derecha y '3' si quieres abrir el inventario");
                    }
                } while (op3Check(ans));

                switch (ans){
                    case "1" -> xpos--;

                    case "2" -> tpw("\nNo hay vuelta atrás");

                    case "3" -> inv();
                }
                return rooms[xpos][ypos];
            }
            case 18 ->{
                tpw("\nDelante tuya hay dos caminos, elige sabiamente");
                do {
                    tpw("\n" + nombre + ", ¿Qué quieres hacer ahora? (1-> Izquierda, 2-> Derecha, 3-> Volver, 4 -> Inventario): ");
                    ans = sc.next();
                    if (op4Check(ans)) {
                        tpw("Opción no válida, por favor escriba '1' si quieres ir a la izquierda, '2' si quieres ir a la derecha, '3' si quieres volver y '4' si queires abrir el inventario");
                    }
                } while (op4Check(ans));

                switch (ans) {
                    case "1" -> xpos--;
                    case "2" -> {
                        xpos--;
                        ypos++;
                    }
                    case "4" -> inv();
                    case "3" -> tpw("\nNo hay vuelta atrás");
                }
            }
        }
        return rooms[xpos][ypos];
    }

    public static int ruleta(){
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int numAleat = rnd.nextInt(20) + 1; //rango del 1 al 20
        int intento;
        String ans;
        char first;

        tpw("\nEsta prueba consiste en intentar adivinar el número oculto. Si lo adivinas la recompensa puede ser muuuy valiosa, mientras que si fallas sufrirás un pequeño castigo.\n EL número se encuentra entre el 1 y el 20\n");

        do {
            tpw("Te gustaría participar en esta prueba? Ten en cuenta que una vez rechazado, no podrás volver ha hacerla (Y/N)");
            ans = sc.next().toLowerCase();
            first = ans.charAt(0);

            if (ynCheck(first)){
                tpw("Opción incorrecta, escriba 'Y' si quieres proceder con la prueba o 'N' si quieres saltártela");
                ans = sc.next().toLowerCase();
                first = ans.charAt(0);
            }
        }while (ynCheck(first));

        if (first == 'y'){
            tpw("\nAhora estimado viajero, introduce tu número elegido: ");
            intento = sc.nextInt();

            while (intento < 1 || intento > 20){
                tpw("\nNúmero no valido, por favor introduzca otro: ");
                intento = sc.nextInt();
            }

            if (intento == numAleat){
                tpw("\nFelicidades, acertaste el número secreto. Se te recompensará con 5 vidas extra para terminar tu aventura, espero que sepas usarlas.");
                vidas+=5;
                tpw("\nEl número de vidas actualmente es: " + vidas);
            } else {
                tpw("\nNúmero incorrecto. Tu castigo: perder 1 vida.\n");
                vidas--;
                sigueVivo();
                tpw("\nTe quedan " + vidas + " vidas");
                tpw("\nLa respuesta correcta era: " + numAleat + ", mala suerte\n");
                tpw("(Vuelves a la sala anterior)");
            }
            xpos++;
            ypos--;
        } else {
            tpw("\nLa prueba ha sido cancelada\n");
        }

        rulefin = true;
        return rooms[xpos][ypos];
    }

    public static int ruletav2(){
        Scanner sc = new Scanner(System.in);
        String ans;

        tpw("\nLa sala está vacía, que te gustaría hacer?");

        do {
            tpw(" \n(1-> Avanzar, 2-> Volver, 3-> Inventario): \n");
            ans = sc.next();

            if (op3Check(ans)) {
                tpw("Opción no válida, por favor escriba '1' si quieres avanzar, '2' si quieres volver y '3' si quieres abrir el inventario");
            }
        } while (op3Check(ans));

        switch (ans){
            case "1" -> xpos--;

            case "2" -> {
                xpos++;
                ypos--;
            }
            case "3" -> inv();
        }
        return rooms[xpos][ypos];
    }

    public static int puertallav (String nombre){
        Scanner sc = new Scanner(System.in);
        String ans;
        String pick;
        char check;

        if (llave){
            if (!stop) {
                tpw("\nDetrás de la puerta te encuentras un pedestal con una gema encima.");

                do {
                    tpw("\nQuieres cogerla? (Y/N): ");
                    pick = sc.next();
                    check = pick.charAt(0);

                    if (ynCheck(check)){
                        tpw("Opción no válida, por favor escriba 'Y' si quieres coger la gema o 'N' si quieres dejarla");
                    }
                } while (ynCheck(check));

                if (check == 'y') {
                    tpw("\nCogiste la gema");
                    inv.add("gema");
                    gema = true;
                } else {
                    tpw("\nSurge un temblor que empuja la gema al suelo y se rompe a pedazos, no parece ser una buena idea coger los pedazos sin guantes");
                }
            }
            stop = true;

            tpw ("\nSe te presenta dos caminos\n");
            do {
                tpw(nombre + ", ¿Qué camino quieres escoger? (1-> Izquierda, 2-> Derecha, 3-> Inventario): ");
                ans = sc.next();

                if (op3Check(ans)) {
                    tpw("Opción no válida, por favor escriba '1' si quieres ir a la izquierda, '2' si quieres ir a la derecha y '3' si quieres abrir el inventario");
                }
            } while (op3Check(ans));

            switch (ans){
                case "1" -> xpos--;
                case "2" -> {
                    xpos--;
                    ypos++;
                }
                case "3" -> {
                    inv();
                    if (llave){
                        return rooms[xpos][ypos];
                    }
                }
            }
            abierto = true;
            return rooms[xpos][ypos];
        } else {
            tpw("\nTe encuentras ante una puerta cerrada. Parece que necesita una llave\n");
            do {
                tpw(nombre + ", ¿Qué te gustaría hacer? (1-> Volver, 2-> Inventario): ");
                ans = sc.nextLine();

                if (op3Check(ans)) {
                    tpw("Opción no válida, por favor escriba '1' si quieres volver y '2' si quieres abrir el inventario");
                }
            } while (op2Check(ans));

            if (Objects.equals(ans, "1")) {
                if (rooms[xpos][ypos] == 6) {
                    xpos++;
                    return rooms[xpos][ypos];
                } else {
                    if (estuve) {
                        xpos++;
                        ypos--;
                        return rooms[xpos][ypos];
                    } else {
                        xpos++;
                        return rooms[xpos][ypos];
                    }
                }
            } else {
                inv();
                if (!llave) {
                    tpw("\nA lo mejor deberías volver sobre tus pasos\n");
                    tpw("\n(Vuelves a la sala anterior)\n");
                    if (rooms[xpos][ypos] == 6) {
                        xpos++;
                        return rooms[xpos][ypos];
                    } else {
                        if (estuve) {
                            xpos++;
                            ypos--;
                            estuve = false;
                        } else {
                            xpos++;
                        }
                    }
                } else {
                    tpw("\nLe das una vuelta a la llave y abres la puerta.");
                }
                return rooms[xpos][ypos];
            }
        }
    }

    public static int puertaab (String nombre){
        Scanner sc = new Scanner(System.in);
        String ans;
        tpw("\nTe encuentras en una sala con una puerta abierta, la cual dirige a dos caminos.\n");

            do {
                tpw(nombre + ", ¿Qué quieres hacer? (1-> Ir a la Izquierda, 2-> Ir a la Derecha, 3 -> Inventario): ");
                ans = sc.next();

                if (op3Check(ans)) {
                    tpw("Opción no válida, por favor escriba '1' si quieres ir a la izquierda, '2' si quieres ir a la derecha y '3' si quieres abrir el inventario");
                }
            } while (op3Check(ans));

            switch (ans) {
                case "1" -> xpos--;
                case "2" -> {
                    xpos--;
                    ypos++;
                }
                case "3" -> inv();
            }
        return rooms[xpos][ypos];
    }

    public static int puertapied (String nombre){
        Scanner sc = new Scanner(System.in);
        String ans;

        if (piedab){
            switch (rooms[xpos][ypos]) {
                case 31 -> {
                    tpw("\nSolo tienes un camino\n");

                    do {
                        tpw(nombre + ", ¿Qué camino quieres escoger? (1-> Avanzar, 2-> Inventario): ");
                        ans = sc.next();

                        if (op2Check(ans)) {
                            tpw("Opción no válida, por favor escriba '1' si quieres ir a la izquierda y '2' si quieres abrir el inventario");
                        }
                    } while (op2Check(ans));

                    switch (ans) {
                        case "1" -> xpos--;
                        case "2" -> {
                            inv();
                            if (piedab) {
                                return rooms[xpos][ypos];
                            }
                        }
                    }
                    abierto2 = true;
                    return rooms[xpos][ypos];
                }
                case 16-> {
                    tpw("\nTienes dos caminos\n");
                    do {
                        tpw(nombre + ", ¿Qué camino quieres escoger? (1-> Avanzar, 2-> Izquierda y 3 -> Inventario): ");
                        ans = sc.next();

                        if (op2Check(ans)) {
                            tpw("Opción no válida, por favor escriba '1' si quieres ir avanzar, '2' si quieres ir a la izquierda y '3' si quieres abrir el inventario");
                        }
                    } while (op2Check(ans));

                    switch (ans) {
                        case "1" -> xpos--;
                        case "2" -> {
                            xpos++;
                            ypos--;
                        }
                        case "3" -> inv();

                    }
                    abierto2 = true;
                    return rooms[xpos][ypos];
                    }
            }
        }
        else {
            tpw("\nTe encuentras ante una puerta cerrada. Parece que necesita un objeto\n");
            do {
                tpw(nombre + ", ¿Qué te gustaría hacer? (1-> Volver, 2-> Inventario): ");
                ans = sc.nextLine();

                if (op3Check(ans)) {
                    tpw("Opción no válida, por favor escriba '1' si quieres volver y '2' si quieres abrir el inventario");
                }
            } while (op2Check(ans));

            if (Objects.equals(ans, "1")) {
                xpos++;
                return rooms[xpos][ypos];
            } else {
                inv();
                if (!piedab) {
                    tpw("\nA lo mejor deberías volver sobre tus pasos\n");
                    tpw("\n(Vuelves a la sala anterior)\n");
                    if (rooms[xpos][ypos] == 16) {
                        xpos++;
                        return rooms[xpos][ypos];
                    } else {
                        xpos++;
                    }
                }
                else {
                    tpw("\nInsertas la piedra en la puerta. La puerta se abre y avanzas, pero al sacar la piedra brillante, la puerta se cierra de nuevo.\nNo parce tener una hueco para la piedra desde este lado.");
                }
            }
        }
        return rooms[xpos][ypos];
    }

    public static int puertpiedab (String nombre){
        Scanner sc = new Scanner(System.in);
        String ans;
        if (rooms[xpos][ypos] == 31){
        tpw("\nTe encuentras en una sala con una puerta cerrada, pero no puede abrirla.\n");

        do {
            tpw(nombre + ", ¿Qué quieres hacer? (1-> Avanzar, 2-> Volver, 3 -> Inventario): ");
            ans = sc.next();

            if (op3Check(ans)) {
                tpw("Opción no válida, por favor escriba '1' si quieres avanzar, '2' si quieres volver y '3' si quieres abrir el inventario");
            }
        } while (op3Check(ans));

        switch (ans) {
            case "1" -> xpos--;
            case "2" -> {
                tpw("No puedes volver");
                return rooms[xpos][ypos];
            }
            case "3" -> inv();
        }
        } else {
            if (!over) {
                tpw("\nTe encuentras en una sala con una puerta cerrada, la cual dirige a dos caminos.\n");

                do {
                    tpw(nombre + ", ¿Qué quieres hacer? (1-> Avanzar, 2-> Izquierda, 3 -> Volver, 4-> inventario): \n");
                    ans = sc.next();

                    if (op4Check(ans)) {
                        tpw("\nOpción no válida, por favor escriba '1' si quieres ir a izquierda, '2' si quieres avanzar, '3' si quieres volver y '4' si quieres abrir el inventario\n");
                    }
                } while (op4Check(ans));

                switch (ans) {
                    case "1" -> xpos--;
                    case "2" -> {
                        xpos++;
                        ypos--;
                    }
                    case "3" -> {
                        tpw("\nNo puedes volver\n");
                        return rooms[xpos][ypos];
                    }
                    case "4" -> inv();
                }
            } else {
                tpw("\nTe encuentras en una sala con una puerta cerrada, solo puedes avanzar, al puerta de la izquierda está bloqueada.\n");

                do {
                    tpw(nombre + ", ¿Qué quieres hacer? (1-> Avanzar, 2 -> Volver, 3-> inventario): \n");
                    ans = sc.next();

                    if (op3Check(ans)) {
                        tpw("\nOpción no válida, por favor escriba '1' si quieres avanzar, '2' si quieres volver y '3' si quieres abrir el inventario\n");
                    }
                } while (op3Check(ans));

                switch (ans) {
                    case "1" -> xpos--;
                    case "2" -> {
                        tpw("\nNo puedes volver\n");
                        return rooms[xpos][ypos];
                    }
                    case "3" -> inv();
                }
            }
        }
        return rooms[xpos][ypos];
    }

    public static int salCof (){
        Scanner sc = new Scanner(System.in);
        String ans;
        char yn;
        int lugar = rooms[xpos][ypos];
        tpw("\nTe encuentras en una sala con un cofre en el medio.");

        do {
            tpw("\n¿Te gustaría abrir el cofre? (Y/N): ");
            ans = sc.next().toLowerCase();
            yn = ans.charAt(0);

            if (ynCheck(yn)){
                tpw("\nOpción no válida, porfavor escriba 'Y' si quieres abrir el cofre y 'N' si no quieres interactuar: ");
            }
        } while(ynCheck(yn));

        if (yn == 'y'){
           String obtain;
            switch (lugar){

               case 5 ->{
                   obtain ="una llave";
                   llaveGet = true;
                   xpos++;
                   cofab = true;
                   inv.add("llave");
               }
               case 25 -> {
                   obtain ="una llave";
                   inv.add("llave");
                   cofab = true;
                   llaveGet = true;
               }
               case 29 ->{
                   obtain = "una rata.\nLa rata se asusta y te araña la cara.\n-1 vida";
                   vidas--;
                   xpos++;
                   ypos++;
                   estuve = true;
                   cofab2 = true;
               }
               case 36 -> {
                   obtain = "una rata.\nLa rata se asusta y te araña la cara.\n-1 vida";
                   estuve = false;
                   vidas--;
                   ypos--;
                   cofab2 = true;
               }
               case 10, 19 -> {
                   obtain = "una piedra preciosa";
                   xpos++;
                   inv.add("piedra preciosa");
                   cofrerul = true;
                   gema2 = true;
               }
               case 13 ->{
                   obtain = "una clave de cifrado, parece ser para una prueba, no lo entiendes pero te lo guardas.";
                   clave = true;
                   xpos++;
                   cofab = true;
                   inv.add("clave de cifrado");
               }
               default ->  obtain = "null";
            }

            tpw("\nAbres el cofre y en el te encuentras " + obtain);

            if (lugar == 25 || lugar == 29 ){
                do{
                    tpw("\n¿Qué desea hacer ahora? 1-> Avanzar, 2-> volver\n");
                    ans = sc.next().toLowerCase();

                    if (op2Check(ans)) {
                        tpw("\nOpción no válida, porfavor escriba '1' si quieres avanzar y '2' si quieres volver");
                    }
                } while (op2Check(ans));

                estuve = true;

                switch (ans) {
                    case "1" -> {
                        xpos--;
                        ypos++;
                    }
                    case "2" -> {
                        xpos++;
                        ypos++;
                    }
                }
            } else {
                tpw("\nNo hay nada más en esta sala, es mejor volver\n");
                tpw(("\n(Vuelves a la sala anterior)\n"));
            }
        } else {
            if (lugar == 25 || lugar == 29 || lugar == 36) {
                do {
                    tpw("\n¿Qué desea hacer ahora? 1-> volver, 2-> ir adelante, 3-> abrir el cofre\n");
                    ans = sc.next().toLowerCase();

                    if (op3Check(ans)) {
                        tpw("\nOpción no válida, porfavor escriba '1' si quieres volver volver, '2' si quieres avanzar y '3' si quieres volver a interctuar con el cofre");
                    }
                } while (op3Check(ans));

                switch (ans) {
                    case "1" -> {
                        if (lugar == 36){
                            estuve = false;
                            ypos--;
                         } else {
                            estuve = true;
                            xpos++;
                            ypos++;
                        }
                    }
                    case "2" -> {
                        xpos--;
                        estuve = false;
                        if (lugar != 36) {
                            estuve = true;
                            ypos++;
                        }
                    }
                    case "3" -> {
                        return rooms[xpos][ypos];
                    }
                }
            } else {
                do {
                    tpw("\n¿Qué desea hacer ahora? 1-> volver atrás, 2-> abrir el cofre\n");
                    ans = sc.next().toLowerCase();

                    if (op2Check(ans)) {
                        tpw("\nOpción no válida, porfavor escriba '1' si quieres volver y '2' si quieres volver a interctuar con el cofre");
                    }
                } while (op2Check(ans));

                if (Objects.equals(ans, "1")) {
                    switch (lugar) {
                        case 5, 10, 19, 13 -> xpos++;
                    }
                }
            }
        }
        return rooms[xpos][ypos];
    }

    public static int salCofAb (){
        Scanner sc = new Scanner(System.in);
        int lugar = rooms[xpos][ypos];
        String ans;
        tpw("\nTe encuentras en una sala con un cofre en el medio.");
        tpw ("\nEl cofre está abierto, no hay nada más en la habitación\n");
        tpw(("\n(Vuelves a la sala anterior)"));
        if (lugar == 25 || lugar == 36){
            do {
                tpw("\n¿Qué desea hacer ahora? 1-> Avanzar, 2-> volver, 3-> inventario\n");
                ans = sc.next().toLowerCase();

                if (op3Check(ans)) {
                    tpw("\nOpción no válida, porfavor escriba '1' para avanzar, '2' para volver y '3' para abrir el inventario");
                }
            } while (op3Check(ans));



            switch (ans) {
                case "1" -> {
                    if(lugar == 36){
                        estuve = false;
                        xpos--;
                    } else {
                        estuve = true;
                        xpos--;
                        ypos++;
                    }
                }
                case "2" -> {
                    if (lugar == 36){
                        ypos--;
                    } else {
                        xpos++;
                        ypos++;
                    }
                }
                case "3"-> {
                    inv();
                    return rooms[xpos][ypos];
                }
            }
        } else {
            tpw("Es mejor volver\n");

            switch (rooms[xpos][ypos]) {
                case 5, 10, 19, 13 -> xpos++;
                case 35 -> {
                    estuve=true;
                    xpos++;
                }

                case 25 -> {
                    estuve = true;
                    xpos++;
                    ypos++;
                }
            }
        }
        return rooms[xpos][ypos];
    }

    public static int salVac(String nombre) {
        Scanner sc = new Scanner(System.in);
        String ans;
        //if (!invuse) {
            //preguntas();
        //}
        tpw("\nTe encuentras en una sala vacía, ¿a dónde te gustaría ir " + nombre + "?");

        switch (rooms[xpos][ypos]){
            case 12 ->{
                do {
                    tpw(" \n(1-> Izquierda, 2-> Derecha, 3-> Volver, 4 -> inventario): \n");
                    ans = sc.next();
                } while (op4Check(ans));

                switch (ans) {
                    case "1" -> {
                        xpos--;
                        invuse = false;
                    }

                    case "2" -> {
                        xpos--;
                        ypos++;
                        invuse = false;
                    }
                    case "3" -> {
                        xpos++;
                        ypos--;
                        invuse = false;
                    }
                    case "4" -> {
                        inv();
                        invuse = true;
                    }
                }
            }
            case 27,28 -> {
                if (!sombrero) {
                    do {
                        tpw(" \n(1-> Avanzar, 2-> Volver, 3-> Investigar 4 -> inventario): \n");
                        ans = sc.next();

                        if (op4Check(ans)){
                            tpw("Opción no válida, por favor escriba '1' si quieres avanzar, '2' si quieres volver, '3' si quieres investigar la habitación y '4' si quieres abrir el inventario");
                        }
                    } while (op4Check(ans));

                    switch (ans) {
                        case "1" -> {
                            xpos--;
                            invuse = false;
                        }

                        case "2" -> {
                            xpos++;
                            invuse = false;

                        }

                        case "3" -> {
                            gorro();
                            invuse = false;
                        }

                        case "4" -> {
                            inv();
                            invuse = true;
                        }
                    }
                } else {
                    do {
                        tpw(" \n(1-> Avanzar, 2-> Volver, 3 -> inventario): \n");
                        ans = sc.next();

                        if (op3Check(ans)){
                            tpw("Opción no válida, por favor escriba '1' si quieres avanzar, '2' si quieres volver y '3' si quieres abrir el inventario");
                        }
                    } while (op3Check(ans));

                    switch (ans) {
                        case "1" -> {
                            xpos--;
                            invuse = false;
                        }

                        case "2" -> {
                            xpos++;
                            invuse = false;
                        }

                        case "3" -> {
                            inv();
                            invuse = true;
                        }
                    }
                }
            }
            case 7 -> {
                estuve = false;
                do {
                    tpw(" \n(1-> Izquierda, 2-> Derecha, 3-> Volver, 4 -> inventario): \n");
                    ans = sc.next();

                    if(op4Check(ans)){
                    tpw("Opción no válida, por favor escriba '1' si ir a la izquierda, '2' si quieres ir a la derecha, '3' volver y '4' si quieres abrir el inventario");
                    }
                } while (op4Check(ans));

                switch (ans) {
                    case "1" -> {
                        xpos--;
                        ypos--;
                        invuse = false;
                    }

                    case "2" -> {
                        xpos--;
                        invuse = false;
                    }
                    case "3" -> {
                        xpos++;
                        invuse = false;
                    }
                    case "4" -> {
                        inv();
                        invuse = true;
                    }
                }
            }
            case 35 -> {
                estuve = true;
                do {
                    tpw(" \n(1-> Izquierda, 2-> Derecha, 3-> Volver, 4 -> inventario): \n");
                    ans = sc.next();

                    if (op4Check(ans)) {
                        tpw("Opción no válida, por favor escriba '1' si ir a la izquierda, '2' si quieres ir a la derecha, '3' volver y '4' si quieres abrir el inventario");
                    }
                } while (op4Check(ans));

                switch (ans) {
                    case "1" -> {
                        xpos--;
                        ypos++;
                        invuse = false;
                    }

                    case "2" -> {
                        ypos++;
                        invuse = false;
                    }
                    case "3" -> {
                        xpos++;
                        invuse = false;
                    }
                    case "4" -> {
                        inv();
                        invuse = true;
                    }
                }
            }
            case 33 -> {
                do {
                    tpw(" \n(1-> Avanzar, 2-> Volver, 3 -> inventario): \n");
                    ans = sc.next();

                    if (op3Check(ans)){
                        tpw("Opción no válida, por favor escriba '1' si quieres avanzar, '2' si quieres volver y '3' si quieres abrir el inventario");
                    }
                } while (op3Check(ans));

                switch (ans) {
                    case "1" -> {
                        ypos--;
                        invuse = false;
                    }

                    case "2" -> {
                        xpos++;
                        invuse = false;
                    }

                    case "3" -> {
                        inv();
                        invuse = true;
                    }
                }
            }
            case 30, 37 -> {
                System.out.println(estuve);
                do {
                    tpw(" \n(1-> Avanzar, 2-> Volver, 3 -> inventario): \n");
                    ans = sc.next();

                    if (op3Check(ans)){
                        tpw("Opción no válida, por favor escriba '1' si quieres avanzar, '2' si quieres volver y '3' si quieres abrir el inventario");
                    }
                } while (op3Check(ans));

                switch (ans) {
                    case "1" -> {
                        xpos--;
                        invuse = false;
                    }

                    case "2" -> {
                        if (estuve){
                            xpos++;
                            ypos--;
                        } else {
                            xpos++;
                        }
                        invuse = false;
                    }

                    case "3" -> {
                        inv();
                        invuse = true;
                    }
                }
            }
            default -> {
                do {
                    tpw(" (1-> Avanzar 2-> Volver, 3-> Inventario): ");
                    ans = sc.next();
                    if (op3Check(ans)) {
                        tpw("Opción no válida, por favor escriba '1' si quieres avanzar, '2' si quieres volver y '3' si quieres abrir el inventario");
                    }
                } while (op3Check(ans));

                switch (ans){
                    case "1" -> {
                        xpos--;
                        invuse = false;

                    }
                    case "2" -> {
                        switch (rooms[xpos][ypos]) {
                            case 3, 34 -> {
                                xpos++;
                                ypos++;
                                invuse = false;
                            }
                            case 4, 7, 26, 27, 28, 37 -> {
                                xpos++;
                                invuse = false;
                            }
                        }
                    }
                    case "3" -> {
                        inv();
                        invuse = true;
                    }
                }
            }
        }
        return rooms[xpos][ypos];
    }

    public static int salVid (String nombre){
        String ans;
        char pub;
        Scanner sc = new Scanner(System.in);
        tpw("\nAl entrar a la sala parece activarse una prueba especial");
        tpw("\nBienvenido a la prueba de las vidas.\nTienes la opción de tomar una prueba y, en caso de acertala, se otorgará 1 vida, de lo contrario, perderás 1 vida.\n");

        do {
            tpw(nombre + ", te gustaría hacer la prueba? Si te niegas, no podrás consguir vidas en futuras pruebas en esta sala (Y/N)\n");
            ans = sc.nextLine().toLowerCase();
            pub = ans.charAt(0);

            if (ynCheck(pub)){
                tpw("\nOpción no válida, escriba 'Y' si quieres hacer la prueba y 'N' si no\n");
                ans = sc.nextLine().toLowerCase();
                pub = ans.charAt(0);
            }
        }while (ynCheck(pub));

        if (rooms[xpos][ypos] == 7 || rooms[xpos][ypos] == 33) {
            estuve = false;
            if (pub == 'y') {
                preguntas(nombre);
            } else {
                tpw("\nLa prueba se ha cancelado\n");
            }
            pregvid1 = true;
        } else {
            if (rooms[xpos][ypos] == 35){
                estuve = true;
            }
            if (pub == 'y') {
                preguntas(nombre);
            } else {
                tpw("\nLa prueba se ha cancelado\n");
            }
            pregvid2 = true;
        }
        invuse = true;
        return rooms[xpos][ypos];
    }

    public static int salMed (String nombre){
        Scanner sc = new Scanner(System.in);
        String ans;
        char pub;

        if (fin && !over){
            tpw("\nObservas un camino abierto.\n");
            do {
                tpw("Que desea hacer? (1-> Avanzar 2-> Volver, 3-> Inventario): \n");
                ans = sc.next();
                if (op3Check(ans)) {
                    tpw("Opción no válida, por favor escriba '1' si quieres avanzar, '2' si quieres volver y '3' si quieres abrir el inventario");
                }
            } while (op3Check(ans));

            switch (ans){
                case "1" -> {
                    ypos--;
                    ypos--;
                    invuse = false;
                }
                case "2" -> {
                    xpos--;
                    ypos++;
                }
                case "3" -> {
                    inv();
                    invuse = true;
                }
            }
        } else if (over){
            xpos--;
            ypos++;
            return rooms[xpos][ypos];
        } else {
            tpw("Bienvenido a esta prueba, se te va a hacer una pregunta, si respondes correctamente, podrás continuar y se te dará 2 vidas, de lo contrario, se te hechará de la sala y no podrás volver, además se te restrá 1 vida\n");

            do {
                tpw("Estás listo para la prueba, " + nombre + "? (Y/N)");
                ans = sc.nextLine().toLowerCase();
                pub = ans.charAt(0);

                if (ynCheck(pub)) {
                    tpw("Opción no válida, por favor introduce 'Y' si quieres hacer la prueba y 'N' si no");
                    ans = sc.nextLine().toLowerCase();
                    pub = ans.charAt(0);
                }
            } while (ynCheck(pub));
            if (pub == 'y') {
                preguntaDif(nombre);
                fin = true;
                return rooms[xpos][ypos];
            } else {
                tpw("\nLa prueba se ha cancelado.\nEres expulsado a la sala anterior.\n");
                ypos++;
                xpos--;
                over = true;
            }
        }
        return rooms[xpos][ypos];
    }

    public static void preguntas(){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        char pub;
        String[] quest = {
                "¿Cuánto es  8 + 5?",
                "¿Cuanto es 10 * 4 - 3?",
                "¿En qué estado está el agua a 30ºC?",
                "¿Cuantos lados tiene un hexágono?",
                "¿Cual es el planeta más grande?",
                "¿Cual es el sexto planeta a partir del sol?",
                "¿Es la serpiente un animal vertebrado o invertebrado?",
                "¿Son las arañas insectos?",
                "¿Cuántos minutos tiene una hora?",
                "¿Qué instrumento se utiliza para medir la temperatura?",
                "¿Cuál es el símbolo químico del oro?",
                "¿En qué continente se encuentra España?"
        };

        String ans;
        String resp;

        tpw("\nAparece una prueba enfrente tuya:\nResponde correctamente a la siguiente pregunta para superar la prueba, en caso de fallar, se te restará una vida\nLa respuesta tiene que ser la más corta posible mientras que sea un palabra existente o en número si es posible, además, o se contará como error... y recuerda las tildes.\nSi tienes algo que te ayude a responder, escriba 'ayuda'\n");

        int pos = r.nextInt(quest.length);
        String preg = quest[pos] ;

        switch (pos){
            case 0 -> resp = "13";
            case 1 -> resp = "37";
            case 2 -> resp = "líquido";
            case 3 -> resp  = "6";
            case 4 -> resp = "júpiter";
            case 5 -> resp = "saturno";
            case 6 -> resp = "vertebrado";
            case 7 -> resp = "no";
            case 8 -> resp = "60";
            case 9 -> resp = "termómetro";
            case 10 -> resp = "au";
            case 11 -> resp = "europa";
            default -> resp = "";
        }

        do {
            tpw("Pregunta: " + preg + "\n");
            ans = sc.nextLine().toLowerCase().replaceAll("\\s+", "");

            if (Objects.equals(ans, "ayuda")) {
                if (notepadQuest.isEmpty()) {
                    tpw("\nNo tienes nada apuntado\n");
                } else {
                    tpw("\nEstas son las preguntas que te has apuntado");
                    for (int i = 0; i < notepadQuest.size(); i++) {
                        int j = 1 + i;
                        tpw("\n" + j + ".");
                        tpw("\n" + notepadQuest.get(i));
                        tpw("\n" + notepadAns.get(i) + "\n\n");
                    }
                }
            }
        }while (Objects.equals(ans, "ayuda"));

        if (Objects.equals(ans, resp)){
            tpw("\nRespuesta correcta, continue con su aventura.\n");

            do {
                tpw("\nTe gustaría apuntarte la prueba en un papel? (Y/N)\n");
                ans = sc.next();
                pub = ans.charAt(0);

                if (ynCheck(pub)){
                    tpw("\nOpción inválida, escriba 'Y' si quieres escribir en el papel o 'N' si no\n");
                }
            }while (ynCheck(pub));

            if (pub == 'y'){
                //Se crea una variable 's' que cambia de valor como si fuera i++, donde cada valor es cada String dentro de notepadQuest
                for (String s : notepadQuest) {
                    if (Objects.equals(s, preg)) {
                        tpw("\nEsta pregunta ya está apuntada\n");
                        return;
                    }
                }
                tpw("\nEscribiste la pregunta y la respuesta en el papel.\n");
                notepadQuest.add(preg);
                notepadAns.add(resp);
            }
        } else {
                tpw("\nRespuesta incorrecta, -1 vida\n");
                vidas--;
                sigueVivo();
        }
    }

    public static void preguntas(String nombre){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        String[] quest = {
                "¿Cuánto es  34 + 5 - 21?",
                "¿Cuanto es (9 * 6 + 10)/4?",
                "¿Capital de Canadá?",
                "¿Cuantos lados tiene un decágono?",
                "¿En qué continente está Singapur?",
                "¿Qué es la luna?",
                "¿Qué tipo de animal es un delfín?",
        };

        String ans;
        String resp;

        tpw("\nMuy bien " + nombre + ", aparece una prueba enfrente tuya:\nResponde correctamente a la siguiente pregunta para superar la prueba, en caso de fallar, se te restará una vida\nLa respuesta tiene que ser la más corta posible mientras que sea un palabra existente o en número si es posible, o se contará como error...y recuerda las tildes.");

        int pos = r.nextInt(quest.length);
        String preg = quest[pos] ;

        switch (pos){
            case 0 -> resp = "18";
            case 1 -> resp = "16";
            case 2 -> resp = "ottawa";
            case 3 -> resp  = "10";
            case 4 -> resp = "asia";
            case 5 -> resp = "satélite";
            case 6 -> resp = "mamífero";
            default -> resp = "";
        }

        tpw("Pregunta: " + preg + "\n");
        ans = sc.nextLine().toLowerCase().replaceAll("\\s+", "");

        if (Objects.equals(ans, resp)){
            tpw("\nRespuesta correcta, ganaste una vida.\nContinue con su aventura.\n");
            vidas++;
        } else {
            tpw("\nRespuesta incorrecta, -1 vida\n");
            vidas--;
            sigueVivo();
        }
        invuse = true;
    }

    public static void preguntaDif (String nombre){
        Scanner sc = new Scanner(System.in);
        String resp;

        String ans;
        Random r = new Random();
        String[] quest = {
                "¿Cuánto es  (28/2 + 62*3)/(sqrt((5*4)+5))?",
                "¿cual es el animal mas rápido del mundo? (2 palabras)",
                "¿Capital de Madagascar?",
                "¿Cual es el radio de la tierra aproximado a 4 cifras significativas en km? (Sin espacios ni caractéres especiales)",
                "¿En qué continente está Papúa Nueva Guinea?",
                "¿Cual es el nombre de la serie de metales al que pertenece el magnesio (En plural)?",
                "¿En qué año se descubrió Urano?",
        };


        tpw("\nMuy bien " + nombre + ", aparece una prueba enfrente tuya:\nResponde correctamente a la siguiente pregunta para superar la prueba, en caso de fallar, se te restará una vida\nLa respuesta tiene que ser la más corta posible mientras que sea un palabra existente o en número si es posible, o se contará como error... y recuerda las tildes.\n");

        int pos = r.nextInt(quest.length);
        String preg = quest[pos] ;

        switch (pos){
            case 0 -> resp = "40";
            case 1 -> resp = "halcónperegrino";
            case 2 -> resp = "antananarivo";
            case 3 -> resp  = "6371";
            case 4 -> resp = "oceanía";
            case 5 -> resp = "alcalinotérreos";
            case 6 -> resp = "1781";
            default -> resp = "";
        }

        tpw("Pregunta: " + preg + "\n");
        ans = sc.nextLine().toLowerCase().replaceAll("\\s+", "");

        if (Objects.equals(ans, resp)){
            tpw("\nRespuesta correcta, ganaste dos vidas.\nContinue con su aventura.\n");
            vidas++;
            vidas++;
        } else {
            tpw("\nRespuesta incorrecta, -1 vida.\nHas sido expulsado de la sala\n");
            vidas--;
            over = true;
            sigueVivo();
        }
    }

    public static void termino (){
        String per = ".";
        String yay;
        if (perro){
            switch (rooms[xpos][ypos]) {
                case 11 -> per = " y un nuevo leal compañero.";
                case 21 -> per = " acompañado de tu nuevo compañero.";
                case 22 -> per = ", diciendole adiós al perro que encontraste y viendo como se aleja a la distancia.";
            }
        }

        if (gema || gema2){
            if (gema && gema2){
                yay = "unas miseras gemas en las manos";
            } else {
                yay = "una misera gema en las manos";
            }
        } else {
            yay = "las manos vacías";
        }

        switch (rooms [xpos][ypos]){
            case 11 -> {
                tpw("\nTe encuentras en una sala con un gran cofre rodeado de una fortuna. \nTe acercas al cofre y al abrirlo te encuentras con el tesoro del templo del DRAGÓN HERÁLDICO GUIVERNO BLANCO. \nUna puerta se abre delante tuya, incitandote a salir con el fruto de tus esfuerzos" + per);

                tpw("\n\u001B[32m FINAL BUENO");
            }

            case 21 -> {
                tpw("\nTe encuentras en una sala con un pilar en el medio. \nEncima de este, un cofre iluminado por una luz procedente del exterior. \nAl abrirlo te encuentras con varios tesoros, pero no parece que sean tan legendarias como las historias decían que eran. \nUna puerta se abre dando al exterior, decides recoger los tesoro dentro del cofre y volver a tu hogar" + per);
                tpw("\n\u001B[33m FINAL NEUTRAL");
            }

            case 22 ->{
                tpw("\nTe encuentras en una sala con una puerta que da al exterior del templo. \nParece que esta puerta fue recientemente movida, pero no ves nada que de una indicación a un tesoro. \nAl final terminas volviendo con" + yay + per);

                tpw("\n\u001B[31m FINAL MALO");
            }
        }
        System.exit(0);
    }

    public static void inv (){
        Scanner sc = new Scanner(System.in);
        String ans;
        String acc;
        String check = " ";
        String use = " ";
        String cond = " ";

        if (inv.isEmpty()){
            tpw("\nNo hay nada en el inventario\n");
        } else {
            do {
                tpw("\n¿Qué quieres ver? ");
                tpw( "Si no quieres ver nada, escriba 'Salir'\n" );
                tpw(inv.toString() + ": ");
                ans = sc.nextLine().toLowerCase();

                if (invCheck(ans)){
                    tpw("\nNo tienes ese objeto");
                }
            } while (invCheck(ans));

            switch (ans) {
                case "papel" -> {
                    check = "\nUn papel que te has traído de tu hogar junto a un lápiz para escribir";

                    if (notepadQuest.isEmpty() || notepadAns.isEmpty()){
                        use = "\nEl papel está vacío";
                    } else {
                        use = "\nEstas son las cosas que te has apuntado";
                    }
                }
                case "clave de cifrado" -> {
                    if (clave) {
                        check = "\nUn papel con un cifrado, parece importante\n";
                        use = "\nEl papel dice: \nClave de codificación: a -> q, o -> x, e -> k, s -> w, c -> z, r -> ñ y n -> h";
                    } else {
                        tpw("\nNo tienes ese objeto\n");
                        return;
                    }
                }
                case "sombrero" -> {
                    if (sombrero){
                        check = "\nUn sombrero que cojiste prestado de un aventurero";
                        use = "\nEl gorro es un poco pequeño y no te cabe en la cabeza, pero te lo quedas de todas formas";
                    } else {
                        use = "\nNo tienes ese objeto";
                    }
                }
                case "vidas" -> {
                    check = "\nTambién se podria decir tus condiciones o cuantas vidas tienes";
                    use = "\nTienes " + vidas + " vidas";

                    if (vidas == 1){
                        cond = "Parece que estas para el arrastre";
                    } else if (vidas > 1 && vidas < 5){
                        cond = "Has tenido mejores días";
                    } else {
                        cond = "Tienes buen aspecto";
                    }
                }
                case "nota" -> {
                    check = "\nUn papel encontrado en la entrada que contiene un texto, ¿Quién lo habrá dejado?";
                    use = "\nEl papel lee:\n\u001B[3m'Quién sea que coja este papel, este templo está de pruebas hasta arriba, en casi todas las salas que he explorado he tenido que hacer una.\nIncluso si vuelvo una sala cuya prueba ya he superado, el templo me obliga ha hacer otra prueba de nuevo.\nTen cuidado al entrar a una sala,es posible que una prueba se active. Y una última cosa aventurero, esto es como un laberinto, a no se que tengas un mapa, te recomiendo que memorices por donde has ido\u001B[0m";
                }
                case "piedra preciosa" -> {
                    if (gema2){
                        check = "\nUna piedra brillante de color azul marino, no se puede identificar que tipo de piedra es en este momento";
                        if (rooms[xpos][ypos] == 16 || rooms[xpos][ypos] == 31){
                            use = "\nLa piedra encaja en la puerta";
                            piedab = true;
                        } else {
                            use = "\nEs una piedra hermosa, pero no puedes hacer nada con ella ahora mismo\n";
                        }
                    } else {
                        tpw("\nNo tienes ese objeto\n");
                        return;
                    }

                }
                case "llave" -> {
                    if (llaveGet) {
                        check = "\nUna llave de oro, no tiene mucho valor\n";
                        if (rooms[xpos][ypos] == 6 || rooms[xpos][ypos] == 15) {
                            use = "\nLa llave encaja perfectamente en el cerrojo";
                            llave = true;

                        } else {
                            use = "\nNo hay ningún sitio en donde usar la llave";
                        }
                    } else {
                        tpw("\nNo tienes ese objeto\n");
                        return;
                    }
                }
                case "gema" -> {
                    if (gema) {
                        check = "\nUna gema brillante de color verde, no se puede identificar que tipo de gema es en este momento";
                        use = "\nEs una gema hermosa, pero no parece tener utilidad\n";
                    } else {
                        tpw("\nNo tienes ese objeto\n");
                        return;
                    }
                }
                case "perro" -> {
                    if (perro) {
                        check = "\nUn perro encontrado dentro de un templo, te está siguiendo a todas lados\n";
                        switch (rooms[xpos][ypos]) {
                            case 1, 12, 2, 14, 16 -> {
                                if (over) {
                                    use = "\nEl perro se reboza por el suelo, no tiene mucho que decir";
                                } else {
                                    use = "\nEl perro se acerca a la puerta de la izquierda, parece que quiere le sigas";
                                }
                            }
                            case 6, 15 -> {
                                if (abierto) {
                                    use = "\nEl perro tiene interés por lo que haya por el camino de la derecha";
                                } else {
                                    use = "\nEl perro vuelve hacia atrás, parece que quiere que le sigas";
                                }
                            }
                            case 5, 10, 13, 25, 19, 8, 17, 3, 9, 28, 30, 31 ->
                                    use = "\nEl perro se reboza por el suelo, no tiene mucho que decir";
                            case 29, 27, 32, 38, 37, 36, 34, 33, 35 ->{
                                if (gema2){
                                    use = "\nEl perro se reboza por el suelo, no tiene mucho que decir";
                                } else {
                                    use = "\nEl perro te incita a volver atrás";
                                }
                            }
                            case 7 -> use = "\nEl perro mira hacia delante";
                            case 4, 26 -> {
                                if (!abierto) {
                                    use = "\nEl perro mira hacia atrás";
                                } else {
                                    use = "\nEl perro mira hacia delante";
                                }
                            }
                            case 18 -> use = "\n El perro te intenta guiar hacia la izquierda";
                        }
                    } else {
                        tpw("\nNo tienes ese objeto\n");
                        return;
                    }
                }
                case "salir" -> {
                    return;
                }
            }

            do {
                tpw("\n¿Qué quieres hacer? (1-> examinar, 2-> usar): \n");
                acc = sc.nextLine().toLowerCase();

                if (acc.isEmpty() || op2Check(acc) ){
                    tpw("Opción no válida, escriba '1' examinar y '2' para usar un objeto");
                }
            } while (acc.isEmpty() || op2Check(acc));

            if (Objects.equals(acc, "1")) {
                tpw(check);
            } else {
                tpw(use);

                if (Objects.equals(ans, "papel")){
                    for (int i = 0; i < notepadQuest.size(); i++) {
                        int j = 1+i;
                        tpw("\n" + j + ".");
                        tpw("\n" + notepadQuest.get(i));
                        tpw("\n" + notepadAns.get(i) + "\n");
                    }
                }

                if (Objects.equals(ans, "vidas")){
                    tpw("\n" + cond + "\n");
                }
            }
        }
    }

    public static void gorro(){
        Scanner sc = new Scanner(System.in);
        String ans;
        char exp;
        tpw("Hay un esqueleto de un aventurero que no tuvo la misma suerte que tú, pero tiene un sombero que está que flipas\n");

        do {
            tpw("Te gustaría cogerlo?(Y/N)\n");
            ans = sc.nextLine();
            exp = ans.charAt(0);

            if (ynCheck(exp)) {
                tpw("Opción no válida, por favor escriba 'Y' si quieres cogerlo o '2' si quieres dejarlo como está");
            }
        } while (ynCheck(exp));

        if (exp == 'y'){
            tpw("Cogiste un sombrero\n");
            inv.add("sombrero");
            sombrero = true;
        } else {
            tpw("No cojes el sombrero\n");
        }
    }

    public static boolean invCheck (String obj) {
        for (String checker : objetos) {
            if (Objects.equals(obj, checker)) {
                return false;
            }
        }
        return true;
    }

    public static boolean intCheck (String opc) { //Función para comprobar que la opción introducida es un número y no crashee si meto una letra
        if (!opc.isEmpty()) {
            for (int i = 0; i < opc.length(); i++) {
                if (opc.charAt(i) > '9' || opc.charAt(i) < '0' || opc.length() != 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean op4Check(String opc) { //Función para comprobar que la opción introducida sea 1 2 o 3 o 4
        if (intCheck(opc)) {
            return true;
        } else return opc.charAt(0) != '1' && opc.charAt(0) != '2' && opc.charAt(0) != '3' && opc.charAt(0) != '4';
    }

    public static boolean op3Check(String opc) { //Función para comprobar que la opción introducida sea 1 o 2 o 3
        if (intCheck(opc)) {
            return true;
        } else return opc.charAt(0) != '1' && opc.charAt(0) != '2' && opc.charAt(0) != '3';
    }

    public static boolean op2Check(String opc) { //Función para comprobar que la opción introducida sea 1 o 2
        if (intCheck(opc)) {
            return true;
        } else return opc.charAt(0) != '1' && opc.charAt(0) != '2';
    }

    public static boolean ynCheck (char opc){
        return opc != 'y' && opc != 'n';
    }
}
