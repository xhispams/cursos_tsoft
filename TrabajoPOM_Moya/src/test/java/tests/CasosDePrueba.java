package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.HazteFanPage;
import utilidades.DataDriven;
import utilidades.PropertiesDriven;

import java.util.ArrayList;

public class CasosDePrueba {
    //definir atributos
    private WebDriver driver;
    private String url;
    private ArrayList<String> datos;

    private Pages.HomePage homePage;
    private Pages.HazteFanPage hazteFanPage;

    @BeforeSuite
    public void prepracionSuite(){
        System.out.println("Iniciando suite de pruebas");
    }

    @BeforeClass
    public void preparacionClase(){
        homePage = new Pages.HomePage(driver);
        homePage.conexionDriver(PropertiesDriven.obtenerProperty("browser"),PropertiesDriven.obtenerProperty("propertyDriver"),
                PropertiesDriven.obtenerProperty("rutaDriver"));

        hazteFanPage = new hazteFanPage(homePage.getDriver());
    }

    @BeforeMethod
    public void preparacionTest(){
        homePage.cargarSitio(PropertiesDriven.obtenerProperty("url"));
        homePage.maximizarVentana();
    }


    @Test
    public void CPM0001_Validar_NombredescripcionLink(){
        homePage.irAHazteFan();
        Assert.assertEquals(hazteFanPage.ObtenerNombreLink(),"Abre tu cuenta 100% Online");
    }

    @Test
    public void CPM0002_Validar_mensaje_de_RutInvalido_CtaFan() {
        datos = utilidades.DataDriven.getData("CPM0002_Validar_mensaje_de_RutInvalido_CtaFan");
        homePage.irAHazteFan();
        cuentafanPage.mensajeRut(datos.get(1));
        Assert.assertEquals(cuentafanPage.ObtenerErrorRutInvalido(), datos.get(2));
    }
    @Test
    public void CP003_registrar_usuario_persona_con_rut_ya_existente(){
        datos = DataDriven.getData("CP003_registrar_usuario_persona_con_rut_ya_existente");
        homePage.Ir_a_Ingreso_Login();

        formularioRegistroUsuarioPersonasPage.ingresoRegistro(datos.get(1),datos.get(2),datos.get(3),datos.get(4),datos.get(5),
                datos.get(6), datos.get(7));
        Assert.assertEquals(formularioRegistroUsuarioPersonasPage.MensajeErrorRutExistente(),datos.get(8));

    }
    @Test
    public void CP004_registrar_usuario_persona_con_mail_ya_utilizado(){
        datos = DataDriven.getData("CP004_registrar_usuario_persona_con_mail_ya_utilizado");
        homePage.Ir_a_Ingreso_Login();
        formularioRegistroUsuarioPersonasPage.ingresoRegistro(datos.get(1),datos.get(2),datos.get(3),datos.get(4),datos.get(5),
                datos.get(6), datos.get(7));
        Assert.assertEquals(formularioRegistroUsuarioPersonasPage.MensajeErrorMailExistente(),datos.get(8));

    }

    @Test
    public void CP005_consultar_boleta_no_afecta_o_excenta_electronica_sin_validacion_captcha() {
        datos = DataDriven.getData("CP005_consultar_boleta_no_afecta_o_excenta_electronica_sin_validacion_captcha");
        homePage.Ir_a_Consulta_Boleta();
        formularioBoletaCompraPage.ingresoFormularioBoleta(datos.get(1),datos.get(2),datos.get(3),datos.get(4),datos.get(5));;
        Assert.assertEquals(formularioBoletaCompraPage.MensajeErrorBoleta(),datos.get(6));
    }


    @Test
    public void CP006_registrar_usuario_empresa_confirmar_mail_no_coincide(){
        datos = DataDriven.getData("CP006_registrar_usuario_empresa_confirmar_mail_no_coincide");
        homePage.Ir_a_Ingreso_Login();
        formularioRegistroUsuarioEmpresasPage.RegistroEmpresasMailNoCoinciden(datos.get(1),datos.get(2));
        Assert.assertEquals(formularioRegistroUsuarioEmpresasPage.MensajeMailNoCoinciden(),datos.get(3));

    }
    @Test
    public void CP007_registrar_usuario_empresa_claves_no_coinciden(){
        datos = DataDriven.getData("CP007_registrar_usuario_empresa_claves_no_coinciden");
        homePage.Ir_a_Ingreso_Login();
        formularioRegistroUsuarioEmpresasPage.RegistroEmpresasClavesNoCoinciden(datos.get(1),datos.get(2));
        Assert.assertEquals(formularioRegistroUsuarioEmpresasPage.MensajeClavesNoCoinciden(),datos.get(3));

    }

    @Test
    public void CP008_ingresar_seguimiento_compra_folio_mail_incorrectos(){
        datos = DataDriven.getData("CP008_ingresar_seguimiento_compra_folio_mail_incorrectos");
        homePage.Ir_a_Seguimiento_Compra();
        formularioSeguimientoCompraPage.ingresoFormularioSeguimientoCompra(datos.get(1),datos.get(2));
        Assert.assertEquals(formularioSeguimientoCompraPage.MensajeErrorSeguimientoCompra(),datos.get(3));

    }

    @AfterTest
    public void afterTest(){
        homePage.cerrarBrowser();
    }

}

