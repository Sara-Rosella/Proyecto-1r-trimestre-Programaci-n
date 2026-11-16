# El templo del Dragón Heráldico Guiverno Blanco

Juego de aventura conversacional por consola, desarrollado en Java como Proyecto Modular de **Programación** (1.º DAM, 1.ª evaluación).

**Integrantes:** Marcos Castro, Pablo Espinal y Sara Rosella

**Repositorio:** [https\://github.com/Sara-Rosella/Proyecto-1r-trimestre-Programacion](https://github.com/Sara-Rosella/Proyecto-1r-trimestre-Programacion)  
**Java:** JDK 21  
**IDE utilizado:** IntelliJ IDEA  
---

## **1\. Descripción**

Te adentras en el templo del Dragón Heráldico Guiverno Blanco, donde permanece oculto un tesoro que muchos aventureros han intentado conseguir. Para alcanzarlo tendrás que explorar salas, elegir caminos, encontrar objetos y superar pruebas. Tus decisiones y el número de vidas que conserves influirán en el desenlace.

## **2\. Características**

* Exploración de distintas salas conectadas mediante un mapa.  
* Decisiones que modifican el recorrido.  
* Tres finales narrativos diferentes y un final de partida por pérdida de vidas.  
* Inventario con objetos que pueden examinarse o utilizarse.  
* Puertas y caminos condicionados por objetos y por el progreso.  
* Sistema de vidas.  
* Minijuegos de anagramas, palabra codificada y ahorcado.  
* Prueba de ruleta con un número aleatorio.  
* Preguntas de conocimiento general.  
* Selección aleatoria de palabras y preguntas en determinadas pruebas.

## **3\. Requisitos**

Para poder ejecutar el juego se necesita:

* Un ordenador con Windows, Linux o macOS.  
* Java JDK 21 instalado.  
* IntelliJ IDEA instalado para abrir y ejecutar el proyecto siguiendo estas instrucciones.  
* La carpeta completa del proyecto.

## **4\. Instalación y ejecución**

Para poder jugar a **El templo del Dragón Heráldico Guiverno Blanco**, es necesario descargar el proyecto e instalar los programas necesarios para ejecutarlo.

No es necesario tener conocimientos de programación para seguir estos pasos.

### **4.1. Descargar el proyecto**

1. Accede al repositorio de GitHub del proyecto.  
2. Pulsa el botón verde **Code**.  
3. Selecciona la opción **Download ZIP**.  
4. Una vez descargado, busca el archivo ZIP en tu ordenador.  
5. Haz clic derecho sobre él y selecciona **Extraer todo** (en Windows) o la opción equivalente de tu sistema operativo.  
6. Se creará una carpeta con todos los archivos del proyecto. Conserva su contenido y no elimines ninguna de las carpetas o archivos incluidos.

### **4.2. Instalar Java JDK 21**

El juego está desarrollado en Java, por lo que es necesario instalar el entorno de desarrollo de Java (JDK).

1. Accede a la página oficial de Oracle: [https\://www\.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)  
2. Busca la versión **JDK 21**.  
3. Descarga el instalador correspondiente a tu sistema operativo.  
4. Ejecuta el archivo descargado y sigue las instrucciones de instalación.  
5. Una vez finalizada la instalación, Java estará preparado para utilizarse.

### **4.3. Instalar IntelliJ IDEA**

Para abrir y ejecutar el proyecto utilizaremos IntelliJ IDEA, un programa que permite trabajar con aplicaciones desarrolladas en Java.

1. Accede a la página oficial de JetBrains: [https\://www\.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)  
2. Descarga IntelliJ IDEA.  
3. Ejecuta el instalador y sigue los pasos indicados.  
4. Una vez instalado, abre el programa.

### **4.4. Abrir el proyecto**

1. Abre IntelliJ IDEA.  
2. En la pantalla inicial, selecciona **Open** (Abrir).  
3. Busca la carpeta del proyecto que has extraído anteriormente.  
4. Selecciona la carpeta principal del proyecto, `ProyectoTrimestre1.`  
5. Pulsa **Open** para abrirlo.  
6. Espera a que IntelliJ IDEA termine de cargar los archivos del proyecto.

### **4.5. Ejecutar el juego**

1. Una vez abierto el proyecto, localiza el archivo `ProyectoV3.java` dentro de la carpeta del código fuente.  
2. Abre el archivo haciendo doble clic sobre él.  
3. Busca el método `main`, que es el punto desde el que comienza la ejecución del programa.  
4. Pulsa el icono verde de ejecución que aparece junto al método `main` y selecciona **Run 'ProyectoV3.main()'**.  
5. Se abrirá una consola en la parte inferior de IntelliJ IDEA, donde comenzará la aventura.

**¡Ya puedes jugar\!** Sigue las instrucciones que aparecen en pantalla para avanzar por las diferentes salas, tomar decisiones y descubrir los distintos finales.

## **5\. Cómo jugar**

### **Inicio**

Al comenzar, el juego presenta la historia y solicita el nombre del aventurero. Después aparece la primera sala y comienza la exploración.

### **Movimiento y decisiones**

Lee las opciones que aparecen en pantalla e introduce el número correspondiente. Dependiendo de la sala, podrás avanzar, volver, elegir entre caminos o abrir el inventario. Algunas decisiones pueden cambiar las rutas disponibles.

### **Inventario**

En las opciones que lo permitan, abre el inventario e introduce el nombre de un objeto. El programa permite examinarlo o utilizarlo. También puedes consultar el estado de las vidas y las anotaciones guardadas en el papel.

### **Vidas**

La partida comienza con **7 vidas**. Algunas pruebas y acontecimientos pueden restarlas o conceder vidas adicionales. Si el contador llega a cero, la aventura termina.

### **Objetos**

| Objeto | Descripción |
| ----- | ----- |
| Perro | Compañero que puede orientar al jugador en determinadas salas. |
| Llave | Permite abrir ciertas puertas. |
| Clave de cifrado | Muestra la correspondencia de letras de la prueba de palabra codificada. |
| Gema | Objeto que se puede encontrar en un cofre o detrás de una puerta. |
| Piedra preciosa | Se utiliza para abrir una puerta concreta. |
| Sombrero | Objeto opcional que se puede encontrar investigando una sala. |
| Nota | Advierte sobre las pruebas que pueden aparecer en el templo. |
| Papel | Guarda las preguntas y respuestas que el jugador decide apuntar. |
| Vidas | Permite consultar cuántas vidas quedan. |

### **Pruebas y minijuegos**

* **Anagrama:** ordena las letras mostradas para descubrir la palabra. Los intentos fallidos restan vidas. Es posible escribir `escapar`, con la penalización indicada por el juego.  
* **Palabra codificada:** descubre la palabra original a partir de las letras sustituidas. La clave encontrada durante la aventura puede servir de ayuda. Se puede escribir `salir` para abandonar la prueba.  
* **Ahorcado:** adivina la palabra introduciendo letras o intentando resolverla completa. Los fallos restan vidas.  
* **Ruleta:** intenta adivinar un número aleatorio entre 1 y 20\. Si aciertas, ganas cinco vidas; si fallas, pierdes una.  
* **Preguntas:** responde a preguntas de conocimiento general. Las respuestas incorrectas pueden restar vidas y algunas pruebas ofrecen recompensas por acertar.

## **6\. Finales**

La aventura cuenta con tres finales narrativos:

* **Final bueno:** se alcanza el gran tesoro del templo.  
* **Final neutral:** se encuentra un tesoro, aunque no resulta ser tan extraordinario como se esperaba.  
* **Final malo:** el aventurero consigue salir, pero sin encontrar el tesoro.

También existe un final de partida cuando el jugador se queda sin vidas.

## **7\. Estructura del código**

La lógica del juego se encuentra en la clase principal `ProyectoV3`.

Algunos de los métodos principales son:

| Método | Responsabilidad |
| ----- | ----- |
| `main()` | Inicializa la partida y solicita el nombre del jugador. |
| `room()` | Selecciona el comportamiento correspondiente a la sala actual. |
| `entrada()` | Gestiona las decisiones de la entrada. |
| `inv()` | Permite consultar, examinar y utilizar objetos. |
| `salCof()` | Gestiona la interacción con los cofres. |
| `salVac()` | Gestiona las salas vacías y sus opciones. |
| `anagrama()` | Implementa la prueba del anagrama y la navegación posterior. |
| `palcod()` | Implementa la prueba de palabra codificada y la navegación posterior. |
| `ahorcado()` | Implementa el minijuego del ahorcado y la navegación posterior. |
| `termino()` | Muestra el desenlace narrativo correspondiente. |
| `sigueVivo()` | Comprueba si el jugador conserva vidas. |

El mapa se almacena en un array bidimensional y el inventario utiliza un `ArrayList<String>`. El programa también utiliza variables de estado para recordar objetos obtenidos, pruebas superadas y puertas abiertas.

## **8\. Autores**

* Marcos Castro  
* Pablo Espinal  
* Sara Rosella

## **9\. Licencia**

No se ha especificado una licencia de distribución para este proyecto.