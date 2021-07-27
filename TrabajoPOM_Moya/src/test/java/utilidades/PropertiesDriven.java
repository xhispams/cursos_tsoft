package utilidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDriven {

    public static String obtenerProperty(String nombre){

        //Instanciar un objeto de tipo properties
        Properties prop = new Properties();

        try {
            InputStream input = new FileInputStream("C:\\TrabajoPOM_Moya\\src\\main\\resources\\setup.properties");
            prop.load(input);
        } catch (Exception e) {
            System.out.println("Error al cargar archivo properties...");
            e.printStackTrace();
        }

        return prop.getProperty(nombre);

    }
}
