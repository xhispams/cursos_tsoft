package Utilidades;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClaseBase {
        //atributos
        protected WebDriver driver;
        protected WebDriverWait wait;

        //métodos


    public ClaseBase(WebDriver driver) {
        this.driver = driver;
    }
        //accesadores y mutadores (WebDriver)

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

        //acciones del browser
    //cargar browser
    public void cargarBrowser(String url){
        this.driver.get(url);

    }
    //Cerrar y Maximizar Browser
    public void cerrarBrowser(){
        this.driver.close();
    }
    public void maximizarBrowser(){ this.driver.manage().window().maximize();}

    //obtener texto vía localizador
    public String obtenerTexto(By localizador){
        return this.driver.findElement(localizador).getText();
    }
    //obtener texto vía webelement
    public String obtenerTexto(WebElement elemento){
        return  elemento.getText();
    }

    //refrescar página
    public void refrescarPagina(){
        this.driver.navigate().refresh();
    }
    //agregar texto
    public void agregarTexto(By localizador,String texto){
        this.driver.findElement(localizador).sendKeys(texto);
    }

    public void agregarTexto(WebElement elemento, String texto){
        elemento.sendKeys(texto);
    }
    //click
    public void click(By localizador){
        this.driver.findElement(localizador).click();
    }
    public void click(WebElement elemento){
        elemento.click();
    }
    //conexión con el browser
    public WebDriver conexionDriver(String browser,String ruta, String property){
    switch(browser){ //firefox,firefox,IE,edge
        case "chrome":
            System.setProperty(property,ruta);
            this.driver = new ChromeDriver();
            break;
        case "firefox":
            System.setProperty(property,ruta);
            this.driver = new FirefoxDriver();
            break;
        case "ie":
            System.setProperty(property,ruta);
            this.driver = new InternetExplorerDriver();
            break;
    }
    return this.driver;
}
//Esperas
    public void esperarXsegundos(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            System.out.println("error al esperar...");
            e.printStackTrace();
        }
    }
    //Espera dinámica por elemento a clickear
    public WebElement esperarElementoAClickear(By localizador){
        this.wait = new WebDriverWait(this.driver,20);
        return wait.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    public WebElement esperarElementoPresenteEnPagina(By localizador){
        this.wait = new WebDriverWait(this.driver,20);
        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }


}
