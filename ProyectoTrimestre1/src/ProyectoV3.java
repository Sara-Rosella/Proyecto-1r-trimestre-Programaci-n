import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

//2 y 14 --> minijuegos
//1 --> entrada, -1 --> sala secreta
//3, 4, 7, 12, 26, 16 --> salas vacías
//5, 10, 13, 25, 19 --> cofre
//8, 17 --> ruletas
//11, 21, 22 --> finales
//6, 15 --> puertas

public class ProyectoV3 {
    static int[][] rooms = {
            {0, 0, 0, 0, 21, 22},
            {0, 11, 0, 0, 18, 19},
            {0, 9, 10, 0, 16, 17},
            {0, 7, 8, 0, 15, 0},
            {5, 6, 0, 25, 26, 0},
            {3, 4, 0, 13, 14, 0},
            {0, 2, 0, 12, 0, 0},
            {0, 0,  1, 0, 0, 0},
            {0, 0, -1, 0, 0, 0}
    };

    static int xpos;
    static int ypos;
    static boolean perro;
    static boolean llave;
    static boolean clave;
    static int vidas;
    static boolean anafin;
    static boolean palcodfin;
    static boolean ahorcfin;
    static boolean estuve;
    static boolean rulefin;
    static boolean abierto;
    static boolean cofab;
    static ArrayList<String> inv = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String nombre;
        vidas = 7;
        ahorcfin = false;
        cofab = false;
        abierto = false;
        rulefin = false;
        perro = false;
        clave = false;
        llave = false;
        anafin = false;
        estuve = false;
        palcodfin = false;
        tpw("Bienvenido estimado aventurero al templo del DRAGÓN HERÁLDICO GUIVERNO BLANCO.\nDurante siglos un tesoro ha permanecido oculto en este lugar, centenares de aventureros lo han intentado conseguir sin exito pereciendo en el intento.\n¿Serás el primero en superar todas la pruebas que te deparen tus elecciones durante el camino? Tengo ganas de comprobarlo...\nAhora valiente aventurero,¿Cuál es tu nombre?:");
        nombre = sc.nextLine();

        tpw(nombre + "... ese nombre suena a éxito, suerte para tu aventura la vas a necesitar...");

        xpos = 7;
        ypos = 2;


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
                case 5, 10, 13, 25, 19 ->{
                    if (cofab) {
                        curoom = SalCofAb();
                    } else {
                        curoom = SalCof();
                    }
                }
                case 3, 4, 7, 12, 26, 16 -> curoom = SalVac(nombre);
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
                case 11, 21, 22 -> termino();
            }
        } while (curoom != 0);

    }

    public static int entrada (String nombre) {
        Scanner sc = new Scanner(System.in);
        String ans;

        tpw("\nTe encuentras en la primera sala, una sala vacía normal y corriente, sin ningún tipo de prueba o reto visible.\nMiras tu entorno y ves 3 posibles caminos, izquierda, derecha y un pequeño conducto detrás de ti.");

        do {
            tpw("\n" + nombre + ", ¿Qué camino quieres escoger (1-> Izquierda, 2-> Derecha, 3-> Conducto, 4-> Inventario): ");
            ans = sc.next();
        } while (Op4Check(ans));

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
            tpw("\n" + nombre + ", ¿Qué quieres hacer? (1-> Ir a la Izquierda, 2-> Ir a la Derecha, 3-> Inventario): ");
            ans = sc.next();
        } while (Op3Check(ans));

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

        tpw("\nBienvenido viajero " + nombre + " a la prueba del anagrama.\nEsta prueba consiste en reordenar las letras de la cadena dada para adivinar la palabra escondida detrás de ese desorden.\nTeniendo en cuenta su dificultad te doy la opción de rendirte, a cambio perderás 3 vidas solo tendrás que introducir 'salir'.");
        tpw("\nANAGRAMA: " + sb);
        tpw("\nPor favor, " + nombre + ", introduzca su intento: ");
        intento = sc.nextLine();


        while (!intento.equalsIgnoreCase(palabra) && vidas > 0 && !intento.equalsIgnoreCase("salir")){
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
            tpw("Las paredes parecen moverse");
        } else if (intento.equalsIgnoreCase("salir")) {
            vidas-= 3;
            tpw("\nEstá bien puedes marchar pero me quedaré con 3 de tus vidas.");
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
        } while (Op3Check(ans));

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
        char[] cadena2 = {'q', 'x', 'k', 'w', 'l', 'h', 'j'};
        char c;


        for (int i = 0; i < palabra.length(); i++){
            c = palabra.charAt(i);
            sb.append(codifica(cadena1, cadena2, c));
        }


        tpw("\nBienvenido viajero " + nombre + ", esta prueba se llama 'palabra codificada' y como su propio nombre indica, consiste en adivinar la palabra codificada mostrada.\nDurante la aventura has podido encontrar alguna pista para resolverlo pero si no la encontraste solo me queda desearte buena suerte. \nTendrás los mismos intentos que vidas restantes tengas, cada fallo te restará 1 vida piénsalo antes de resolver a lo loco.");
        tpw("\nLa palabra codificada es: ");
        tpw(sb.toString());


        if (clave){
            tpw("\nClave de codificación: a -> q, o -> x, e -> k, s -> w, c -> l, r -> h y n -> j");
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
                tpw("\nClave de codificación: a -> q, o -> x, e -> k, s -> w, c -> l, r -> h y n -> j");
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
            palcodfin = true;
        }
        return rooms[xpos][ypos];
    }

    public static int palcod(String nombre){
        Scanner sc = new Scanner(System.in);
        String ans;
        estuve = false;
        tpw("\nEn la sala se pueden ver dos caminos se abren enfrente.\n");

        do {
            tpw(nombre + ", ¿Qué camino quieres escoger?(1-> Izquierda, 2-> Derecha, 3 -> Inventario): ");
            ans = sc.next();
        } while (Op3Check(ans));

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

    public static int salaSecreta () { //En esta funcion quiero que pregunte 3 veces si quiero tomar el camino para llegar a la sala secreta
        String n;
        Scanner sc = new Scanner(System.in);

        tpw("\nTe encuentras en un pasillo que no parece tener final, ¿qué quiere hacer? (1-> Seguir hacia adelante, 2-> Darte la vuelta y volver al incio): ");
        n = sc.next();


        while (Op2Check(n)){
            tpw("\nOpción no válida, por favor introduzca 1 para seguir o 2 para darte la vuelta: ");
            n = sc.next();
        }


        switch (n) {
            case "1":
                for (int i = 0; i < 3; i++) {
                    tpw("\nTodavía sigues sin ver el final..., ¿quieres seguir recorriendo este pasillo? (1-> Sí, 2-> No): ");
                    n = sc.next();
                    while (Op2Check(n)) {
                        tpw("\nOpción no válida, por favor introduzca 1 para seguir o 2 para darte la vuelta: ");
                        n = sc.next();
                    }


                    if (n.charAt(0) == '2') {
                        tpw("\nVuelves a la sala inicial");
                        xpos--;
                        return rooms[xpos][ypos];
                    }
                }
                break;
            case "2":
                tpw("\nVuelves a la sala inicial");
                xpos--;
                return rooms[xpos][ypos];
        }
        tpw("Consigues llegar al final del pasillo donde te encuentras un perro quien te mira con cara de expectación y miedo.\nDespués de unos minutos se acerca a ti amistosamente y parece estar listo para seguirte durante tu aventura.");
        perro = true;
        inv.add("Perro");
        xpos--;
        return rooms[xpos][ypos];
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


        for (int i = 0; i < pal.length(); i++) {
            show[i] = '_';
        }



        tpw("\nTienes " + vidas + " intentos para adivinar la palabra");


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
                } while (Op3Check(ans));

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
                } while (Op4Check(ans));

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

    public static void sigueVivo() { //Funcion para comprobar las vidas al acabar las pruebas
        if (vidas <= 0) {
            tpw("\nTE HAS QUEDADO SIN VIDAS. FIN DE LA AVENTURA.");
            System.exit(0);
        }
    }

    public static boolean IntCheck (String opc) { //Función para comprobar que la opción introducida es un número y no crashee si meto una letra
        if (!opc.isEmpty()) {
            for (int i = 0; i < opc.length(); i++) {
                if (opc.charAt(i) > '9' || opc.charAt(i) < '0' || opc.length() != 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean Op4Check(String opc) { //Función para comprobar que la opción introducida sea 1 2 o 3 o 4
        if (IntCheck(opc)) {
            return true;
        } else return opc.charAt(0) != '1' && opc.charAt(0) != '2' && opc.charAt(0) != '3' && opc.charAt(0) != '4';
    }

    public static boolean Op3Check(String opc) { //Función para comprobar que la opción introducida sea 1 o 2 o 3
        if (IntCheck(opc)) {
            return true;
        } else return opc.charAt(0) != '1' && opc.charAt(0) != '2' && opc.charAt(0) != '3';
    }

    public static boolean Op2Check(String opc) { //Función para comprobar que la opción introducida sea 1 o 2
        if (IntCheck(opc)) {
            return true;
        } else return opc.charAt(0) != '1' && opc.charAt(0) != '2';
    }

    public static boolean ynCheck (char opc){
        return opc != 'y' && opc != 'n';
    }

    public static int puertallav (String nombre){
        Scanner sc = new Scanner(System.in);
        String ans;
        tpw("\nTe encuentras ante una puerta cerrada. Parece que necesita una llave\n");

        do {
            tpw(nombre + ", ¿Qué te gustaría hacer? (1-> Volver, 2-> Inventario): ");
            ans = sc.nextLine();
        } while (Op2Check(ans));

        if (Objects.equals(ans, "1")){
            if (rooms[xpos][ypos] == 6){
                xpos++;
                return rooms[xpos][ypos];
            } else {
                if (estuve){
                    xpos++;
                    ypos--;
                } else {
                    xpos++;
                }
            }
        } else {
            inv();
        }

        if (llave){
            tpw("\nLe das una vuelta a la llave y abres la puerta.");

            tpw ("\nSe te presenta dos caminos\n");
            do {
                tpw(nombre + ", ¿Qué camino quieres escoger? (1-> Izquierda, 2-> Derecha, 3-> Inventario): ");
                ans = sc.next();
            } while (Op3Check(ans));

            switch (ans){
                case "1" -> xpos--;
                case "2" -> {
                    xpos--;
                    ypos++;
                }
                case "3" -> inv();
            }
        } else {
            tpw("\nA lo mejor deberías volver sobre tus pasos\n");
            sc.next();
            tpw("\n(Vuelves a la sala anterior)");
            if (rooms[xpos][ypos] == 6){
                xpos++;
                return rooms[xpos][ypos];
            } else {
                if (estuve){
                    xpos++;
                    ypos--;
                } else {
                    xpos++;
                }
            }
        }
        return rooms[xpos][ypos];
    }

    public static int puertaab (String nombre){
        Scanner sc = new Scanner(System.in);
        String ans;
        tpw("\nTe encuentras en una sala con una puerta abierta, la cual dirige a dos caminos.\n");

            do {
                tpw(nombre + ", ¿Qué quieres hacer? (1-> Ir a la Izquierda, 2-> Ir a la Derecha, 3 -> Inventario): ");
                ans = sc.next();
            } while (Op3Check(ans));

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

    public static int SalCof (){
        Scanner sc = new Scanner(System.in);
        String ans;
        char yn;

        tpw("\nTe encuentras en una sala con un cofre en el medio.");

        do {
            tpw("\n¿Te gustaría abrir el cofre? (Y/N): ");
            ans = sc.next().toLowerCase();
            yn = ans.charAt(0);

            if (ynCheck(yn)){
                tpw("\nOpción no válida, porfavor escriba 'Y' para abrir el cofre y 'N' para no interactuar: ");
            }
        } while(ynCheck(yn));

        if (yn == 'y'){
           String obtain;
            switch (rooms[xpos][ypos]){
               case 5 ->{
                   obtain ="una llave";
                   llave = true;
                   xpos++;
                   cofab = true;
                   inv.add("llave");
               }
               case 25 -> {
                   obtain ="una llave";
                   llave = true;
                   xpos++;
                   ypos++;
                   cofab = true;
                   inv.add("llave");
               }
               case 10, 19 -> {
                   obtain = "una vida extra";
                   vidas++;
                   xpos++;
                   cofab = true;
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
            tpw("\nNo hay nada más en esta sala, es mejor volver\n");
        } else {
            do {
                tpw("\n¿Qué desea hacer ahora? 1-> volver atrás, 2-> abrir el cofre\n");
                ans = sc.next().toLowerCase();

                if (Op2Check(ans)){
                    tpw("\nOpción no válida, porfavor escriba '1' para volver y '2' para volver a interctuar con el cofre");
                }
            } while(Op2Check(ans));

            if (Objects.equals(ans,"1")){
                switch (rooms[xpos][ypos]) {
                    case 5, 10, 19, 13 -> xpos++;

                    case 25 -> {
                        estuve = true;
                        xpos++;
                        ypos++;
                    }

                }
            }
        }
        return rooms[xpos][ypos];
    }

    public static int SalCofAb (){
        tpw("\nTe encuentras en una sala con un cofre en el medio.");
        tpw ("\nEl cofre está abierto, no hay nada más en la habitación\n");

                switch (rooms[xpos][ypos]) {
                    case 5, 10, 19, 13 -> xpos++;

                    case 25 -> {
                        estuve = true;
                        xpos++;
                        ypos++;
                    }
                }
        return rooms[xpos][ypos];
    }

    public static int SalVac(String nombre){
        Scanner sc = new Scanner(System.in);
        String ans;

        tpw("\nTe encuentras en una sala vacía, ¿a dónde te gustaría ir " + nombre + "?");

        if (rooms[xpos][ypos] == 12){
            do {
                tpw(" \n(1-> Izquierda, 2-> Derecha, 3-> Volver, 4 -> inventario): \n");
                ans = sc.next();
            } while (Op4Check(ans));

            switch (ans){
                case "1" -> xpos--;

                case "2" -> {
                    xpos--;
                    ypos++;
                }
                case "3" ->{
                    xpos++;
                    ypos--;
                }
                case "4" -> inv();
            }
        }else {
            do {
                tpw(" (1-> Avanzar 2-> Volver, 3-> Inventario): ");
                ans = sc.next();
            } while (Op3Check(ans));

            switch (ans){
                case "1" -> xpos--;
                case "2" -> {
                    switch (rooms[xpos][ypos]) {
                        case 3 -> {
                            xpos++;
                            ypos++;
                        }
                        case 4, 7, 16, 26 -> xpos++;
                    }
                }
                case "3" -> inv();
            }
        }
        return rooms[xpos][ypos];
    }

    public static int ruleta(){
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int numAleat = rnd.nextInt(20) + 1; //rango del 1 al 20
        int intento;


        tpw("\nEsta prueba consiste en intentar adivinar el número oculto. Si lo adivinas la recompensa puede ser muuuy valiosa, mientras que si fallas sufrirás un pequeño castigo.\n EL número se encuentra entre el 1 y el 20");
        tpw("\nAhora estimado viajero, introduce tu número elegido: ");
        intento = sc.nextInt();


        while (intento < 1 || intento > 20){
            tpw("\nNúmero no valido, por favor introduzca otro: ");
            intento = sc.nextInt();
        }

        if (intento == numAleat){
            tpw("\nFelicidades, acertaste el número secreto. Se te recompensará con 5 vidas extra para terminar tu aventura, espero que sepas usarlas.\nEl número de vidas actualmente es: ");
            vidas+=5;
            System.out.print(vidas);
        } else {
            tpw("\nNúmero incorrecto. Tu castigo: perder 1 vida.\n");
            vidas--;
            sigueVivo();
            tpw("\nTe quedan " + vidas + " vidas");
            tpw("La respuesta correcta era: " + numAleat + ", mala suerte");
        }
        rulefin = true;
        cofab = true;
        return rooms[xpos][ypos];
    }

    public static int ruletav2(){
        Scanner sc = new Scanner(System.in);
        String ans;

        tpw("\nLa sala está vacía, que te gustaría hacer?");

        do {
            tpw(" \n(1-> Avanzar, 2-> Volver, 3-> Inventario): \n");
            ans = sc.next();
        } while (Op3Check(ans));

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

    public static void inv (){
        Scanner sc = new Scanner(System.in);
        String ans;
        String acc;
        String check = " ";
        String use = " ";

        if (inv.isEmpty()){
            tpw("No hay nada en el inventario");
        } else {
            do {
                tpw("\n¿Qué quieres ver? ");
                tpw(inv.toString() + ": ");
                ans = sc.nextLine().toLowerCase();
            } while (!invCheck(ans));

            switch (ans) {
                case "clave de cifrado" -> {
                    check = "\nUn papel con un cifrado, parece importante";
                    use = "\nEl papel dice: \nClave de codificación: a -> q, o -> x, e -> k, s -> w, c -> l, r -> h y n -> j";
                }

                case "llave" -> {
                    check = "\nUna llave de oro, no tiene mucho valor";
                    if (rooms[xpos][ypos] == 6 || rooms[xpos][ypos] == 15) {
                        use = "\nLa llave encaja perfectamente en el cerrojo";
                        llave = true;
                    } else {
                        use = "\nNo hay ningún sitio en donde usar la llave";
                    }
                }

                case "perro" -> {
                    check = "\nUn perro encontrado dentro de un templo, te sigue a todas partes";
                    switch (rooms[xpos][ypos]) {
                        case 1, 12, 2, 14 ->
                                use = "\nEl perro se acerca a la puerta de la izquierda, parece que quiere le sigas";
                        case 6, 15 -> {
                            if (abierto) {
                                use = "\nEl perro tiene interés por lo que haya por el camino de la derecha";
                            } else {
                                use = "\nEl perro vuelve hacia atrás, parece que quiere que le sigas";
                            }
                        }
                        case 5, 10, 13, 25, 19, 8, 17, 3, 9 ->
                                use = "\nEl perro se reboza por el suelo, no tiene mucho que decir";
                        case 7, 16 -> use = "\nEl perro mira hacia delante";
                        case 4, 26 -> {
                            if (!abierto) {
                                use = "\nEl perro mira hacia atrás";
                            } else {
                                use = "\nEl perro mira hacia delante";
                            }
                        }
                        case 18 -> use = "\n El perro te intenta guiar hacia la izquierda";
                    }
                }
            }

            do {
                tpw("\n¿Qué quieres hacer? (1-> examinar, 2-> usar): ");
                acc = sc.nextLine().toLowerCase();
            } while (Op2Check(acc));

            if (Objects.equals(acc, "1")) {
                tpw(check);
            } else {
                tpw(use);
            }
        }
    }

    public static boolean invCheck (String obj) {
        return switch (obj) {
            case "perro", "llave", "clave de cifrado" -> true;
            default -> false;
        };
    }

    public static void termino (){
        String per = ".";

        if (perro){
            switch (rooms[xpos][ypos]) {
                case 11 -> per = " y un nuevo leal compañero.";
                case 21 -> per = " acompañado de tu nuevo compañero.";
                case 22 -> per = ", diciendole adiós al perro que encontraste y viendo como se aleja a la distancia.";
            }
        }
        switch (rooms [xpos][ypos]){
            case 11 -> tpw("\nTe encuentras en una sala con un gran cofre rodeado de una fortuna. \nTe acercas al cofre y al abrirlo te encuentras con el tesoro del templo del DRAGÓN HERÁLDICO GUIVERNO BLANCO. \nUna puerta se abre delante tuya, incitandote a salir con el fruto de tus esfuerzos" + per);
            case 21 -> tpw("\nTe encuentras en una sala con un pilar en el medio. \nEncima de este, un cofre iluminado por una luz procedente del exterior. \nAl abrirlo te encuentras con varios tesoros, pero no parece que sean tan legendarias como las historias decían que eran. \nUna puerta se abre dando al exterior, decides recoger los tesoro y volver a tu hogar" + per);
            case 22 ->tpw("\nTe encuentras en una sala con una puerta que da al exterior del templo. \nParece que esta puerta fue recientemente movida, pero no ves nada que de una indicación a un tesoro. \nAl final terminas volviendo con las manos vacías" + per);
        }
        System.exit(0);
    }
}
