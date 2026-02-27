public class Main {

    public static void ordenarBurbuja(Equipo[] eq) {
        for (int i = 0; i < eq.length - 1; i++) {
            for (int j = 0; j < eq.length - 1 - i; j++) {
                if (eq[j].puntaje < eq[j + 1].puntaje) {
                    Equipo temp = eq[j];
                    eq[j] = eq[j + 1];
                    eq[j + 1] = temp;
                }
            }
        }
    }

    public static void quicksort(Equipo[] eq, int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particion(eq, inicio, fin);
            quicksort(eq, inicio, pivote - 1);
            quicksort(eq, pivote + 1, fin);
        }
    }

    public static int particion(Equipo[] eq, int inicio, int fin) {
        int pivot = eq[fin].puntaje;
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (eq[j].puntaje > pivot) {
                i++;
                Equipo temp = eq[i];
                eq[i] = eq[j];
                eq[j] = temp;
            }
        }

        Equipo temp = eq[i + 1];
        eq[i + 1] = eq[fin];
        eq[fin] = temp;

        return i + 1;
    }

    // =====================================
    // MÉTODO PARA MOSTRAR EN TABLA
    // =====================================
    public static void mostrarTabla(Equipo[] eq) {
        System.out.printf("%-20s | %-7s\n", "EQUIPO", "PUNTAJE");
        System.out.println("----------------------|---------");

        for (Equipo e : eq) {
            System.out.printf("%-20s | %7d\n", e.nombre, e.puntaje);
        }
    }

    public static void main(String[] args) {

        Equipo[] equipos = {
                new Equipo("Barcelona", 78),
                new Equipo("Real Madrid", 85),
                new Equipo("América", 70),
                new Equipo("PSG", 90),
                new Equipo("Juventus", 65),
                new Equipo("Manchester City", 88),
                new Equipo("Bayern Múnich", 92),
                new Equipo("Liverpool", 83),
                new Equipo("Chelsea", 74),
                new Equipo("Inter", 80),
                new Equipo("Milan", 68),
                new Equipo("Cruz Azul", 60)
        };

        Equipo[] burbuja = equipos.clone();
        Equipo[] rapido = equipos.clone();v

        System.out.println("============================");
        System.out.println("  ORDEN ORIGINAL");
        System.out.println("============================");
        mostrarTabla(equipos);

        ordenarBurbuja(burbuja);
        System.out.println("\n============================");
        System.out.println("  ORDENADO CON BURBUJA");
        System.out.println("============================");
        mostrarTabla(burbuja);

        quicksort(rapido, 0, rapido.length - 1);
        System.out.println("\n============================");
        System.out.println("  ORDENADO CON QUICKSORT");
        System.out.println("============================");
        mostrarTabla(rapido);
    }
}
