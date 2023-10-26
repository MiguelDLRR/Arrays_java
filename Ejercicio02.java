package actividad02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio02 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcion = 0;

        String[][] puntuaciones = new String[4][4];

        // puntuaciones = RellenarDatos.introducirNotas(puntuaciones);
        puntuaciones[0][0] = "M01";
        puntuaciones[0][1] = "8";
        puntuaciones[0][2] = "9";
        puntuaciones[0][3] = "10";
        puntuaciones[1][0] = "M02";
        puntuaciones[1][1] = "6";
        puntuaciones[1][2] = "9";
        puntuaciones[1][3] = "8";
        puntuaciones[2][0] = "M03";
        puntuaciones[2][1] = "4";
        puntuaciones[2][2] = "5";
        puntuaciones[2][3] = "5";
        puntuaciones[3][0] = "M04";
        puntuaciones[3][1] = "10";
        puntuaciones[3][2] = "4";
        puntuaciones[3][3] = "9";

        // Seguidamente se mostrará por consola todos los valores almacenados en el
        // array
        System.out.println("Los valores del array bidimensional son: ");
        for (String[] puntuacione : puntuaciones) {
            for (String puntuacione1 : puntuacione) {
                System.out.print(puntuacione1 + "   ");
            }
            System.out.println("");
        }
        System.out.println("");

        do {

            System.out.print("\n Indica la opción del siguiente menu de opciones:\n" + "1. Mostar el nombre de las asignaturas.\n"
                    + "2. Mostrar la puntuación mayor de cada una de las asignaturas.\n"
                    + "3. Modificar la puntuación de una asignatura.\n"
                    + "4. Mostrar todos los valores del array bidimensional \n" + "0. Salir.\n");

            while (true) {
                try {
                    String op = br.readLine();
                    opcion = Integer.parseInt(op);
                    break;
                } catch (Exception e) {
                    System.out.println("No has introducido un valor valido.");
                }
            }

            switch (opcion) {

                case 1:
                    // Mostrar el nombre de todas las asignaturas
                    System.out.println("Las asignaturas introducidas son: ");
                    for (String[] puntuacione : puntuaciones) {
                        System.out.print(puntuacione[0] + "   ");
                    }
                    System.out.println("");
                    break;
                case 2:
                    // Mostrar la puntuación mayor de cada una de las asignaturas
                    // recorremos todas las asignaturas
                    for (int posicion = 0; posicion < puntuaciones.length; posicion++) {
                        // calculamos el valor menor
                        double valorMayor = Double.parseDouble(puntuaciones[posicion][1]);
                        for (int j = 1; j < puntuaciones[0].length; j++) {
                            if (valorMayor < Double.parseDouble(puntuaciones[posicion][j])) {
                                valorMayor = Double.parseDouble(puntuaciones[posicion][j]);
                            }
                        }
                        System.out.println("El valor mayor de " + puntuaciones[posicion][0] + "  es:" + valorMayor);

                    }
                    break;
                case 3:
                    // Modificar la puntuación de una asignatura.
                    int posAsignatura, posPuntuacion;
                    double puntuacion;
                    System.out.println("Indica el número de asignatura (entre 0 y " + (puntuaciones.length - 1)
                            + ") de la que quieres cambiar un valor.");
                    try {
                        posAsignatura = Integer.parseInt(br.readLine());
                        System.out.println("Indica el número de puntuacion (entre 1 y " + (puntuaciones[0].length - 1)
                                + ")  que quieres cambiar.");
                        posPuntuacion = Integer.parseInt(br.readLine());
                        if (posPuntuacion >= 1 && posPuntuacion < puntuaciones[0].length) {
                            System.out.println("El valor actual en la posicion " + posAsignatura + ", " + posPuntuacion
                                    + " es:" + puntuaciones[posAsignatura][posPuntuacion]);
                        } else {
                            System.out.println("La posicion indicada no es correcta");
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("La posicion indicada no es correcta");
                        break;
                    }
                    try {
                        System.out.println("Indica el nuevo valor(entre 0 y 10) ");
                        puntuacion = Double.parseDouble(br.readLine());
                        if (puntuacion >= 0 && puntuacion <= 10) {
                            puntuaciones[posAsignatura][posPuntuacion] = puntuacion + "";
                        }

                    } catch (Exception e) {
                        System.out.println("El valor no es correcto");
                        break;
                    }
                    System.out.print("Los valores de " + puntuaciones[posAsignatura][0] + " son:");
                    for (int k = 1; k < puntuaciones[posAsignatura].length; k++) {
                        System.out.print(puntuaciones[posAsignatura][k] + " | ");

                    }
                    System.out.println();

                    break;

                case 4:
                    System.out.println("Los valores del array bidimensional son: ");
                    for (String[] puntuacione : puntuaciones) {
                        for (String puntuacione1 : puntuacione) {
                            System.out.print(puntuacione1 + "   ");
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    break;
                case 0:
                    System.out.println("Cerrando Aplicacion. Hasta pronto!");
                    break;

                default:
                    System.out.println("La opcion elegida no es valida.");
            }

        } while (opcion != 0);

    }
}
