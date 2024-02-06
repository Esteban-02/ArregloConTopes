import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class main {

    public static final int MAX_CELDAS = 100;
    public static record TopArray(
            int[] arreglo,
            AtomicInteger tope){}


    /**
     * crea un arreglo vacio
     * @return Retorna el arreglo creado
     */
    public static TopArray inicarArreglo(){
        return new TopArray (new int[MAX_CELDAS],new AtomicInteger(-1));
    }

    /**
     * retorna true si el arregl esta vacio, FALSE si no
     * @param a El arreglo evaluado
     * @return TRUE si esta vacio, FALSE sino
     */

    public static boolean esVacio(TopArray a){
        return a.tope.get()==-1;
    }

    /**
     * Retorna TRUE si esta completo, es decir si tiene MAX_CELDAS
     * elementos,FALSE sino;
     * @param a El aareglo a ser evaluado
     * @return TRUE si esta completo, FALSE si no
     *
     */

    public static boolean esCompleto(TopArray a){
        return a.tope.get()==MAX_CELDAS-1;
    }

    /**
     * Agrega el elemento n pasado como argumento,
     * dicho elemento se agrega al final del arreglo <br><br>
     * <b>PRECONDICION:</b> El arreglo no debe estar lleno
     *
     * @param n Es el numero a ser gregado.
     * @param a Es el arreglo en el cual sera ingresado.
     */
    public static void add(int n, TopArray a){
        a.tope.set(a.tope.get()+1);
        a.arreglo[a.tope.get()]=n;
    }

    /**
     * Impirme la salida de los elementos de a en formato <br>
     * X1 X2 X3 ....... Xn <br><br>
     * si el arreglo esta vacio no hace nada
     * @param a El arreglo a imprimir
     */

    public static void imprimirArreglo(TopArray a){
        for (int i = 0; i < a.tope.get(); i++) {
            System.out.print(a.arreglo[i]+" ");
        }
    }

    /**
     * Esta la primera ociurrencia de n en el arreglo... si no existe en el arreglo
     * no se hace nada.
     * @param i
     * @param a
     */

    public static void remove (int i, TopArray a){

        for (int j = 0; j < cantidad(a); j++) {
            if (a.arreglo[j]==i){
                a.arreglo[j] = 0;
            }
        }
    }

    /**
     * Remueve todas las ocurrencias de n en a. Si no existe en el arreglo
     * no se hace nada.
     * @param n
     * @param a
     */

    public static void removeAll(int n, TopArray a){
        for (int i = 0; i < cantidad(a); i++) {
            a.arreglo[i]=0;
        }

    }

    /**
     * Cantidad de elementos en a.
     * @param a Elemento cuya cantidad de elementos se desea conocer
     * @return el numero de elementos en el arreglo
     */

    public static int cantidad(TopArray a){
        return a.tope.get()+1;
    }

    public static void main(String[] args) {

        TopArray miArreglo = inicarArreglo();
        var generador = new Random();
        var lectura = new Scanner(System.in);
        int cantidad = generador.nextInt(10)+1;
        int opc;
        System.out.println("Se van a agregar "+cantidad+" numeros en el arreglo");
        do {
            add(generador.nextInt(10),miArreglo );

        }while (cantidad(miArreglo)<=cantidad);
        imprimirArreglo(miArreglo);

        System.out.println("\nPara borrar ingresa \n1 para borrar un numero \n2 para borrar todo");
        opc = lectura.nextInt();
        switch (opc){
            case 1:
                System.out.print("Ingresa un numero de la lista para borrar >> ");
                int num = lectura.nextInt();
                remove(num, miArreglo);
                break;

            case 2:
                removeAll(0, miArreglo);
                System.out.println("Se ha borrado todo los datos del arreglo");
                break;
            default:
                System.out.println("Error");
                break;
        }
        imprimirArreglo(miArreglo);

    }
}