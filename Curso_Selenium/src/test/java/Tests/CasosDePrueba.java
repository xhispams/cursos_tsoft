package Tests;

import Pages.HazteFanPage;
import Pages.HomePage;
import Utilidades.DataDriven;
import Utilidades.PropertiesDriven;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;


public abstract class CasosDePrueba {
    //Atributos
    private WebDriver driver;
    private String url;
    private ArrayList<String> datos;

    //Crear las pages
    private HomePage homePage;
    private HazteFanPage hazteFanPage;

    @BeforeSuite
    public void preparacionSuite(){
        System.out.println("Inicio de Suite de Pruebas");
    }

    @BeforeClass
    public void preparacionClase(){
        homePage = new HomePage(driver);
        homePage.conexionDriver(PropertiesDriven.obtenerProperty("browser"), PropertiesDriven.obtenerProperty("propertyDriver"), PropertiesDriven.obtenerProperty("rutaDriver"));
        hazteFanPage = new HazteFanPage(homePage.getDriver());
    }

    @BeforeMethod
    public void preparacionTests(){
        homePage.cargarBrowser(PropertiesDriven.obtenerProperty("url"));
        homePage.maximizarBrowser();

    }

    @Test
    public void CPM0001_Validar_NombredescripcionLink(){
        datos = DataDriven.getData("CPM0001_Validar_NombredescripcionLink");
        homePage.irAHazteFan(datos.get(1));
        Assert.assertEquals(hazteFanPage.ObtenerNombreLink(),datos.get(1));
    }

    @Test
    public void CPM0002_Validar_mensaje_de_RutInvalido_CtaFan(String rut){
        datos = DataDriven.getData("CPM0002_Validar_mensaje_de_RutInvalido_CtaFan");
        homePage.irAHazteFan(datos.get(1));
        hazteFanPage.mensajeRut(datos.get(1));
        Assert.assertEquals(hazteFanPage.ObtenerErrorRutInvalido(),datos.get(2));

    }

    @Test
    public void CPM0003_Validar_mensaje_de_NroSerie_FormatoIncorrecto_CtaFan(){
        datos = DataDriven.getData("CPM0003_Validar_mensaje_de_NroSerie_FormatoIncorrecto_CtaFan");
        homePage.irAHazteFan(datos.get(1));
        hazteFanPage.mensajeNroSerie(datos.get(1),datos.get(2));
        Assert.assertEquals(hazteFanPage.ObtenerErrorNroSerieInvalido(),datos.get(3));

    }
    @Test
    public void CPM0004_Validacion_de_PlayStore_AppBanco(){
        datos = DataDriven.getData("CPM0004_Validacion_de_PlayStore_AppBanco");
        homePage.irAHazteFan(datos.get(1));
        Assert.assertEquals(hazteFanPage.ObtenerNombreBanco(),datos.get(2));
    }

    @Test
    public void CPM0005_Validar_mensaje_de_EmailIncorrecto(){
        datos = DataDriven.getData("CPM0005_Validar_mensaje_de_EmailIncorrecto");
        homePage.irAHazteFan(datos.get(1));
        hazteFanPage.mensajeEmail(datos.get(1),datos.get(2),datos.get(3));
        Assert.assertEquals(hazteFanPage.ObtenerErrorEmailInvalido(),datos.get(4));

    }

    @Test
    public void CPM0006_Validar_mensaje_de_TelefonoCelularIncorrecto(){
        datos = DataDriven.getData("CPM0006_Validar_mensaje_de_TelefonoCelularIncorrecto");
        homePage.irAHazteFan(datos.get(1));
        hazteFanPage.mensajeCelular(datos.get(1),datos.get(2),datos.get(4),datos.get(4));
        Assert.assertEquals(hazteFanPage.ObtenerErrorNroCelularInvalido(),datos.get(5));
    }
    @Test
    public void CPM0007_Validar_btnComenzar(){
        datos = DataDriven.getData("CPM0007_Validar_btnComenzar");
        homePage.irAHazteFan(datos.get(1));
        hazteFanPage.clickBtnComenzar(datos.get(1),datos.get(2),datos.get(3),datos.get(4),datos.get(5));
        Assert.assertEquals(hazteFanPage.clickComenzar(),datos.get(6));
    }
    @Test
    public void CPM0008_Validar_mensaje_reCaptcha(){
        datos = DataDriven.getData("CPM0008_Validar_mensaje_reCaptcha");
        homePage.irAHazteFan(datos.get(1));
        hazteFanPage.mensajeCaptcha(datos.get(1),datos.get(2),datos.get(3),datos.get(4),datos.get(5),datos.get(6));
        Assert.assertEquals(hazteFanPage,datos.get(7));
    }
}
