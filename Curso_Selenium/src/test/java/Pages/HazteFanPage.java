package Pages;

import Utilidades.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HazteFanPage extends ClaseBase {
    public HazteFanPage(WebDriver driver) {
        super(driver);
    }

    //localizadores de elementos
    By locatorAppBanco = By.xpath("//body/div[@id='speech-api']/div[2]/div[1]/div[1]/div[3]/a[1]/div[1]/div[1]/div[1]/p[1]/span[1]");
    By locatorBtnLaQuiero = By.id("btn_bch_fan_la_quiero");
    By locatorTxtRut = By.xpath("//input[@id='input-oferta-producto-rut']");
    By locatorTxtNroSerie = By.xpath("//input[@id='input-oferta-producto-serie']");
    By locatorTxtEmail = By.xpath("//input[@id='input-email-login']");
    By locatorTxtNroTelefono = By.xpath("//input[@id='input-telefono-login']");
    By locatorBtnComenzar = By.xpath("//span[@id='btn_bch_fan-ir-a-comenzar-flujo']");
    By locatorMsjeCaptcha = By.xpath("body.context-home.context-home-show:nth-child(2) div.mat-bch:nth-child(5) div.widget-definition:nth-child(3) div.home-header-background-image.header-tres.pb-0.steps-nuevos-2:nth-child(1) section.limiter div.row:nth-child(2) div.py-0.col-12.col-6.col-lg-7.col-xl-8 div.row:nth-child(1) div.d-none.col-12.col-sm-8.col-md-6.home-header-logo-form.v-application--is-ltr.fan-animation.d-block.mx-auto.mx-md-0 > p.google-recaptcha.mt-2.mb-0.ta-c.google-recaptcha-link");

    //localizadores de mensajería
    By locatorMsjeRutInvalido = By.xpath("//div[contains(text(),'Rut inválido')]");
    By locatorMsjeNroSerieInvalido = By.xpath("//div[contains(text(),'Número de serie no tiene el formato correcto')]");
    By locatorMsjeEmailInvalido = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]");
    By locatorMsjeNroCelularInvalido = By.xpath("//div[contains(text(),'Número no válido')]");
    By locatorNombreLink = By.className("home-pre-title");
    By locatorBtndeComenzar = By.linkText("COMENZ");
    By locatorBancoChile = By.xpath("Banco de Chile");
    By locatorCaptcha = By.partialLinkText("Proteg");

    //acciones de la page
    public void msjereCaptcha(){
        click(esperarElementoPresenteEnPagina(locatorMsjeCaptcha));
    }

    public void nombreDescripcionLink(){
        click(esperarElementoPresenteEnPagina(locatorBtnLaQuiero));
    }

    public void BtnLaQuiero(){
        click(esperarElementoAClickear(locatorBtnLaQuiero));
    }

    public void mensajeRut(String rut){
        click(esperarElementoPresenteEnPagina(locatorBtnLaQuiero));
        agregarTexto(esperarElementoPresenteEnPagina(locatorTxtRut),rut);

    }

    public void mensajeNroSerie(String s, String s1){
        click(esperarElementoPresenteEnPagina(locatorBtnLaQuiero));
        agregarTexto(esperarElementoPresenteEnPagina(locatorTxtRut),"123456785");
        agregarTexto(esperarElementoPresenteEnPagina(locatorTxtNroSerie),"123123");
    }

    public void mensajeEmail(String s, String s1, String s2){
        click(esperarElementoPresenteEnPagina(locatorBtnLaQuiero));
        agregarTexto(esperarElementoPresenteEnPagina(locatorTxtRut),"123456785");
        agregarTexto(esperarElementoPresenteEnPagina(locatorTxtNroSerie),"123456789");
        agregarTexto(esperarElementoPresenteEnPagina(locatorTxtEmail),"a@a");
    }

    public void mensajeCelular(String s, String s2, String s3, String s4){
        click(esperarElementoPresenteEnPagina(locatorBtnLaQuiero));
        agregarTexto(esperarElementoPresenteEnPagina(locatorTxtRut),"123456785");
        agregarTexto(esperarElementoPresenteEnPagina(locatorTxtNroSerie),"123456789");
        agregarTexto(esperarElementoPresenteEnPagina(locatorTxtEmail),"a@a.cl");
        agregarTexto(esperarElementoAClickear(locatorTxtNroTelefono),"95011");

    }

    public void clickBtnComenzar(String s, String s1, String s2, String s3, String s4){
        click(esperarElementoPresenteEnPagina(locatorBtnLaQuiero));
        agregarTexto(esperarElementoPresenteEnPagina(locatorTxtRut),"123456785");
        agregarTexto(esperarElementoPresenteEnPagina(locatorTxtNroSerie),"123456789");
        agregarTexto(esperarElementoPresenteEnPagina(locatorTxtEmail),"a@a.cl");
        agregarTexto(esperarElementoAClickear(locatorTxtNroTelefono),"50112053");
    }

    public void appBanco(){
        click(esperarElementoPresenteEnPagina(locatorAppBanco));
        obtenerTexto(esperarElementoAClickear(locatorAppBanco));
    }

    public String ObtenerNombreLink(){
        return obtenerTexto(esperarElementoPresenteEnPagina(locatorNombreLink));
    }
    public String ObtenerErrorRutInvalido(){
        return obtenerTexto(esperarElementoPresenteEnPagina(locatorMsjeRutInvalido));
    }

    public String ObtenerErrorNroSerieInvalido(){
        return obtenerTexto(esperarElementoPresenteEnPagina(locatorMsjeNroSerieInvalido));
    }

    public String ObtenerErrorEmailInvalido(){
        return obtenerTexto(esperarElementoPresenteEnPagina(locatorMsjeEmailInvalido));
    }

    public String ObtenerErrorNroCelularInvalido(){
        return obtenerTexto(esperarElementoPresenteEnPagina(locatorMsjeNroCelularInvalido));
    }
    public String clickComenzar(){
        return obtenerTexto(esperarElementoPresenteEnPagina(locatorBtnComenzar));
    }
    public String ObtenerNombreBanco(){
        return obtenerTexto(esperarElementoPresenteEnPagina(locatorAppBanco));
    }
    public String mensajeCaptcha(String s, String s1, String s2, String s3, String s4, String s5){
        return obtenerTexto(esperarElementoPresenteEnPagina(locatorMsjeCaptcha));
    }

}
