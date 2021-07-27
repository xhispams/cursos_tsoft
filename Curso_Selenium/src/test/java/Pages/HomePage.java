package Pages;

import Utilidades.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends ClaseBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //localizadores
    By locatorBtnHazteFan = By.xpath("//a[@id='btn_bch_menu_hazte_cliente']");
    By locatorMenuProductos = By.xpath("//a[@id='btn_bch_menu_productos']");
    By locatorBtnPlayStore = By.xpath("//body/div[@id='speech-api']/div[2]/div[1]/div[1]/div[3]/a[1]/div[1]/div[1]/div[1]/p[1]/span[1]");
    By locatorBtnApp = By.className("col-3 offset-1 bch-apps-header-logo-playstore");
    //acciones de la page
    public void irAHazteFan(String s){
        click(esperarElementoAClickear(locatorBtnHazteFan));
    }

    public void irAPlaySore(){
        click(esperarElementoAClickear(locatorBtnPlayStore));
    }

    public void iraApp(){
        click(esperarElementoAClickear(locatorBtnApp));
    }
    public void irAPac(){
        click(esperarElementoAClickear(locatorMenuProductos));
    }
}
