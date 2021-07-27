package Entidad;

public class Gordito {

    private int rut;
    private String nombre;
    private int edad;
    private int telefono;
    private int [] pesomensual;


    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int[] getPesomensual() {
        return pesomensual;
    }

    public void setPesomensual(int[] pesomensual) {
        this.pesomensual = pesomensual;
    }

    public Gordito(int rut, String nombre, int edad, int telefono ) {

        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.pesomensual = new int[12];

        for (int i = 0; i < this.pesomensual.length; ++i) {

            int pesoAleatorio = (int) (Math.random() * (251 - 70)+70);
            this.pesomensual[i] = pesoAleatorio;
            System.out.println("Mes: " + (i + 1) + ", Peso Mensual: " + this.pesomensual[i]);


        }

    }

    public int promedioPesoAnual(){
        int suma=0;
        int Promedio=0;
        for (int i=0; i<pesomensual.length; ++i){
            suma = suma + this.pesomensual[i];
            Promedio = suma / this.pesomensual.length;
        }
        return Promedio;

    }

    public int[] masDeXKilos(int x){
        int [] resultado = new int[12];

        for (int i=0;i<pesomensual.length;i++){
            if(pesomensual[i]>x){
                resultado[i]= pesomensual[i];
            }
            else{
                resultado[i]=0;
            }
        }
        int suma =0;
        for (int i=0;i<resultado.length;i++){
            suma = suma +resultado[i];
        }
        if(suma==0){
            resultado = null;
            System.out.println("No existen pesos mayor al indicado");
        }
        return resultado;
    }


    public String indiceMasaCorporal(){
        double estatura = 1.65;
        int i = this.pesomensual.length;
        String alertaimc = " ";

        double imc = this.pesomensual[i-1]/(estatura*estatura);
        System.out.println("El IMC de diciembre es:"+imc);
        if(imc >=18.5 && imc <25.0){
            alertaimc = "IMC Normal";
        }
        if(imc >=25.0 && imc <30.0){
            alertaimc = "Sobrepeso";
        }
        else if (imc > 30.0){

            alertaimc = "Obeso";
        }
        return alertaimc;
    }

}

