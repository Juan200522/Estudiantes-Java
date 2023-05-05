package estudiantes;

import javax.swing.JOptionPane;

public class Procesos {

	private static String[] nombresEstudiantes = new String[100];
    private static int[] edadesEstudiantes = new int[100];
    private static int numEstudiantes = 0;

    public static void main(String[] args) {
        int opcion = 0;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    agregarNuevoEstudiante();
                    break;
                case 2:
                    imprimirListaEstudiantes();
                    break;
                case 3:
                    calcularPromedioEdadesEstudiantes();
                    break;
                case 4:
                    encontrarEstudiantesConMayorEdad();
                    break;
                case 5:
                    encontrarEstudiantesMenorEdad();
                    break;
                case 6:
                    contarEstudiantesMayoresEdad();
                    break;
                case 7:
                    buscarEstudiantePorNombre();
                    break;
                case 8:
                    buscarEstudiantesPorEdad();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Adiós!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.",null,JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 9);
    }

    private static int mostrarMenu() {
        String menu = "Seleccione una opción:\n\n"
                + "1. Agregar nuevo estudiante\n"
                + "2. Imprimir la lista de todos los estudiantes\n"
                + "3. Calcular promedio de las edades\n"
                + "4. Encontrar estudiantes de mayor edad\n"
                + "5. Encontrar estudiantes de menor edad\n"
                + "6. Contar estudiantes mayores de edad\n"
                + "7. Buscar estudiante por nombre\n"
                + "8. Buscar estudiantes por edad\n"
                + "9. Salir";
        String opcion = JOptionPane.showInputDialog(null, menu);
        return Integer.parseInt(opcion);
    }

    private static void agregarNuevoEstudiante() {
        String nombre = JOptionPane.showInputDialog(null, "Nombre del estudiante:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad del estudiante:"));
        nombresEstudiantes[numEstudiantes] = nombre;
        edadesEstudiantes[numEstudiantes] = edad;
        numEstudiantes++;
    }

    private static void imprimirListaEstudiantes() {
        String lista = "Lista de estudiantes:\n\n";
        for (int i = 0; i < numEstudiantes; i++) {
            lista += nombresEstudiantes[i] + " - " + edadesEstudiantes[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    private static void calcularPromedioEdadesEstudiantes() {
        int sumaEdades = 0;
        for (int i = 0; i < numEstudiantes; i++) {
            sumaEdades += edadesEstudiantes[i];
        }
        double promedio = (double) sumaEdades / numEstudiantes;
        JOptionPane.showMessageDialog(null,"El promedio de edades es: " + promedio);
    }

    private static void encontrarEstudiantesConMayorEdad() {
        int maxEdad = Integer.MIN_VALUE;
        for (int i = 0; i < numEstudiantes; i++) {
            if (edadesEstudiantes[i] > maxEdad) {
                maxEdad = edadesEstudiantes[i];
            }
        }
        String estudiantes = "Estudiantes de mayor edad:\n\n";
        for (int i = 0; i < numEstudiantes; i++) {
            if (edadesEstudiantes[i] == maxEdad) {
                estudiantes += "Nombre:" + nombresEstudiantes[i] + "\n" + "Edad:" + edadesEstudiantes[i] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, estudiantes);
    }

    private static void encontrarEstudiantesMenorEdad() {
        int minEdad = Integer.MAX_VALUE;
        for (int i = 0; i < numEstudiantes; i++) {
            if (edadesEstudiantes[i] < minEdad) {
                minEdad = edadesEstudiantes[i];
            }
        }
        String estudiantes = "Estudiantes de menor edad:\n\n";
        for (int i = 0; i < numEstudiantes; i++) {
            if (edadesEstudiantes[i] == minEdad) {
                estudiantes += "Nombre:" + nombresEstudiantes[i] +"\n" +  " Edad: " + edadesEstudiantes[i] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, estudiantes);
    }

    private static void contarEstudiantesMayoresEdad() {
        int contador = 0;
        for (int i = 0; i < numEstudiantes; i++) {
            if (edadesEstudiantes[i] >= 18) {
                contador++;
            }
        }
        JOptionPane.showMessageDialog(null, "Hay " + contador + " estudiantes mayores de edad.");
    }

    private static void buscarEstudiantePorNombre() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante a buscar:");
        int indice = -1;
        for (int i = 0; i < numEstudiantes; i++) {
            if (nombresEstudiantes[i].equalsIgnoreCase(nombre)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún estudiante con ese nombre.");
        } else {
            JOptionPane.showMessageDialog(null, "El estudiante encontrado es: " + nombresEstudiantes[indice] + "Con Edad de:" + edadesEstudiantes[indice]);
        }
    }

    private static void buscarEstudiantesPorEdad() {
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad de los estudiantes a buscar:"));
        String estudiantes = "Estudiantes con edad:" + edad + ":\n\n";
        for (int i = 0; i < numEstudiantes; i++) {
            if (edadesEstudiantes[i] == edad) {
                estudiantes += "Nombre:" + nombresEstudiantes[i] + "\n" + "Edad:" + edadesEstudiantes[i] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, estudiantes);


    }
 }
