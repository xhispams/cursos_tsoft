package interfaz;

import interfaz.Gordito;

import java.util.Scanner;

public class Aplicacion {

    public static void main(String[] args) {

        Gordito gordito = null;
        int opcion;
        Scanner sc = new Scanner(System.in);

        do{
            opcion = menu();
            switch (opcion){
                case 1:
                    //gordito = new Gordito("185933407","Matias",28,1.84,"56979693268");
                    gordito = gordito.crearPersona();
                    System.out.println("Rut: "+gordito.getRut());
                    System.out.println("Nombre: "+gordito.getNombre());
                    System.out.println("Edad: "+gordito.getEdad());
                    System.out.println("Altura: "+gordito.getAltura());
                    System.out.println("Teléfono: "+gordito.getTelefono());
                    System.out.println("------------------------------");
                    for(int i = 0; i<gordito.getMeses().length; i++){
                        System.out.println((i+1)+". "+gordito.getMeses()[i]+": "+gordito.getPesoMensual()[i]+"kg");
                    }

                    break;

                case 2:
                    if(gordito != null) {
                        System.out.println("Peso promedio: " + gordito.getPesoPromedio()+"kg.");
                    } else {
                        System.out.println("Error. Por favor, ingrese una persona.");
                    }
                    break;

                case 3:
                    if(gordito!=null) {
                        System.out.println("Numericamente, seleccione el mes para calcular su IMC: ");
                        int mes = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Su IMC en el mes de " + gordito.getMeses()[mes - 1] + " es: " + gordito.getIMC(mes - 1));
                    } else {
                        System.out.println("Error. Por favor, ingrese una persona.");
                    }
                    break;

                case 4:
                    if(gordito!=null) {
                        System.out.println("Se mostrará una lista con los meses en los que haya pesado más que la cantidad ingresada.");
                        System.out.println("Por favor, ingrese peso: ");
                        int pesoACalcular = sc.nextInt();
                        String [] arrPesos = gordito.getMasDeXKilos(pesoACalcular);
                        System.out.println("--------------");
                        for(int i =0; i<gordito.getMeses().length;i++){
                            if(arrPesos != null){
                                if(arrPesos[i] != null){
                                    System.out.println(arrPesos[i]);
                                }
                            } else  {
                                System.out.println("En ningún mes pesó más de "+pesoACalcular+"kg.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Error. Por favor, ingrese una persona.");
                    }
                    break;

                case 5:
                    if(gordito!=null) {
                        double ultimo = gordito.getUltimoMes();
                        if(18.5<=ultimo && ultimo < 25){
                            System.out.println("Según el mes de Diciembre, su status es: Normal");
                        } else if(25 <= ultimo && ultimo < 25){
                            System.out.println("Según el mes de Diciembre, su status es: Sobrepeso");
                        } else if(ultimo>=30){
                            System.out.println("Según el mes de Diciembre, su status es: Obeso");
                        }

                    } else {
                        System.out.println("Error. Por favor, ingrese una persona.");
                        break;
                    }

                case 6:
                    System.out.println("Saliendo de la aplicación.");
                    System.exit(0);
            }
        }while (opcion != 6);



        for(int i=0;i< gordito.getPesoMensual().length;i++){
            System.out.println("Peso "+gordito.getMeses()[i]+": "
                    +gordito.getPesoMensual()[i]);
        }

        System.out.println("Peso promedio: "+gordito.getPesoPromedio());


    }

    public static int menu() {

        int n;
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("Clínica Queda Regio");
        System.out.println("-------------------------------------");
        System.out.println("1) Ingresar persona.");
        System.out.println("2) Obtener peso promedio.");
        System.out.println("3) Obtener IMC.");
        System.out.println("4) Meses con más de 'x' kilos");
        System.out.println("5) Obtener status de peso según IMC del último mes.");
        System.out.println("6) Salir");
        System.out.println("-------------------------------------");
        System.out.println("Favor ingrese una opción para continuar...");

        n = sc.nextInt();
        return n;
    }

}
