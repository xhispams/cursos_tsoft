package Interfaz;
import Entidad.Gordito;
import java.util.Arrays;

public class Aplicacion {

    public Aplicacion() {
    }

    public static void main(String[] args) {
        Gordito gordito = null;

        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    gordito = creargordito();
                    break;
                case 2:
                    if (gordito == null) {
                        System.out.println("Ingrese Información Persona");
                    } else {
                        System.out.println("El Nombre es: " + gordito.getNombre());
                        System.out.println("El Rut es: " + gordito.getRut());
                        System.out.println("La Edad es: " + gordito.getEdad());
                        System.out.println("El Telefono es:  " + gordito.getTelefono());
                        System.out.println("El Peso Mensual : " + Arrays.toString(gordito.getPesomensual()));
                    }
                    break;
                case 3:
                    if (gordito == null) {
                        System.out.println("Ingrese Información Persona");
                    } else {
                        System.out.println("El peso promedio anual es:" + gordito.promedioPesoAnual());
                    }
                    break;
                case 4:
                    if (gordito == null) {
                        System.out.println("Ingrese Información Persona");
                    } else {
                        System.out.println("Ingrese Peso para Corroborar Meses con Peso Mayor (Minimo 70 kg) ");
                        int pesoinsertado = Leer.datoInt();

                        int[] nuevaLista = gordito.masDeXKilos(pesoinsertado);

                        if (nuevaLista == null) {

                        } else {
                            for (int i = 0; i < nuevaLista.length; i++) {
                                if (nuevaLista[i] > pesoinsertado)
                                    System.out.println("[" + i + "] =" + nuevaLista[i]);

                            }
                        }
                        break;

                    }
                case 5:
                    if (gordito == null) {
                        System.out.println("Ingrese el peso de la Persona");
                    } else {
                        System.out.println("El mes de diciembre estuvo :" + gordito.indiceMasaCorporal());
                    }
                    break;

            }
        } while (opcion!=6);


    }

    public static int menu (){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("             Clinica Queda Regio");
        System.out.println("********************************************");
        System.out.println("1) Ingresar Datos Paciente");
        System.out.println("2) Mostrar Datos Paciente Registrado");
        System.out.println("3) Peso Promedio Anual");
        System.out.println("4) Meses de Mayor Peso");
        System.out.println("5) Condicion IMC");
        System.out.println("6) Salir");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Ingrese la Opción ...");
        return Leer.datoInt();

    }

    public static Gordito creargordito(){

        int rut;
        String nombre;
        int edad;
        int telefonoContacto;

        System.out.println("Ingrese Rut");
        rut=Leer.datoInt();
        System.out.println("Ingrese Nombre");
        nombre=Leer.dato();
        System.out.println("Ingrese Edad");
        edad=Leer.datoInt();
        System.out.println("Ingrese Telefono");
        telefonoContacto=Leer.datoInt();

        System.out.println("Registro Exitoso");

        return new Gordito(rut, nombre, edad, telefonoContacto);

    }

}
