package clases;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Gordito {

    private String rut;
    private String nombre;
    private int edad;
    private String telefono;
    private int [] pesoMensual;
    private double altura;
    private String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};


    public Gordito(String rut, String nombre, int edad, double altura, String telefono) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.telefono = telefono;
        this.pesoMensual =new int[12];

        for(int i=0;i<pesoMensual.length;i++){
            pesoMensual[i]= (int) (Math.random()*(250-70)+70);
        }
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() { return edad; }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public int[] getPesoMensual() {
        return pesoMensual;
    }

    public void setPesoMensual(int[] pesoMensual) {
        this.pesoMensual = pesoMensual;
    }

    public double getAltura() { return altura; }

    public void setAltura(double altura) { this.altura = altura; }

    public String[] getMeses() { return meses; }

    public static Gordito crearPersona(){
        Scanner sc = new Scanner(System.in);

        String rut, nom, telefono;
        int edad;
        double altura;

        do{
            System.out.println("Ingrese rut (sin punto ni guión): ");
            rut = sc.nextLine();
        } while (rut.length()<8 || rut.length()>=10);

        do {
            System.out.println("Ingrese primer nombre: ");
            nom = sc.nextLine();
        } while (nom.length()<3);
        do {
            System.out.println("Ingrese edad: ");
            edad = sc.nextInt();
            sc.nextLine();
        } while (edad<0 || edad>100); // es raro conocer a alguien que viva más de 100.

        do{
            System.out.println("Ingrese altura: ");
            altura = sc.nextDouble();
            sc.nextLine();
        } while (altura<0.50 || altura>2.50); // Hombre más pequeño vs más grande del mundo.

        do{
            System.out.println("Ingrese teléfono (CL): ");
            telefono = sc.nextLine();
        } while (telefono.length()<11 && telefono.length()>9); // Con o sin +56
        System.out.println("------------------------------");
        System.out.println("Se ha creado con éxito a "+nom);
        System.out.println("------------------------------");
        return new Gordito(rut,nom,edad,altura,telefono);
    }

    public int getPesoPromedio(){

        int suma = 0;
        int promedio = 0;

        for(int i = 0; i<getPesoMensual().length;i++){
            suma = suma + getPesoMensual()[i];
        }
        promedio = suma / getPesoMensual().length;
        return promedio;
    }

    public double getIMC(int mes){
        double imc = 0;
        int peso = getPesoMensual()[mes];
        double altura =  Math.pow(getAltura(),2);

        imc = (peso/altura);

        DecimalFormat f = new DecimalFormat("##.##");
        String s = f.format(imc);

        //imc = Double.parseDouble(s);

        return imc;
    }

    public double getUltimoMes(){
        int mes = getMeses().length-1; // ultimo mes
        double peso = getIMC(mes);

        return peso;
    }

    public String[] getMasDeXKilos(int peso){

        String [] newArr = new String[12];
        Boolean vacio = true;
        for(int i=0; i<getMeses().length;i++){
            if(getPesoMensual()[i]>peso){
                vacio = false;
                String m = "En "+getMeses()[i]+" pesaste: "+getPesoMensual()[i]+"kg";
                newArr[i] = m;
            }
        }

        for (Object ob : newArr) {
            if (ob == null) {
                vacio = true;
            } else {
                vacio = false;
                break;
            }
        }

        if(vacio.equals(true)){
            newArr=null;
        }

        return newArr;
    }

}

