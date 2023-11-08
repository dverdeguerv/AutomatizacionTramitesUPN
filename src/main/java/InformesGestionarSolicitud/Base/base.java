package InformesGestionarSolicitud.Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

    private WebDriver driver;

    public base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeWebDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    //Buscar los elementos

    public WebElement buscarElemento(By locator) {
        return driver.findElement(locator);
    }

    //Buscar una lista de elementos
    public List<WebElement> buscarListaElementos(By locator) {
        return driver.findElements(locator);
    }

    //Obtener un WebElement
    public String getTextWebElement(WebElement element) {
        return element.getText();
    }

    //obtener un locator
    public String getTextLocator(By locator) {

        return driver.findElement(locator).getText();
    }

    //Enviar Texto

    public void sendKeys(String inputText, By locator) {//Este sendKeys es el nombre del metodo

        driver.findElement(locator).sendKeys(inputText);//Este sendKeys es parte del findElement()
    }

    //Realizar la accion click

    public void click(By locator) {
        driver.findElement(locator).click();


    }
    //validar si un elemento se encuentra listo para ser utilizado

    public Boolean isDisplayed(By locator) {

        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //Recibir la URL de una pagina

    public void getURL(String url) {
        driver.get(url);
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyy HH.mm.ss");
        Date date = new Date();
        return dateFormat.format(date);

    }

    public void screenAsShoot(String status) {

        try {
            Screenshot myFullScreen = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(driver);
            //Definir la ubicacion donde se desea guardar
            String rutaScreenShoot = "./src/main/resources/screenShoots/";
            ImageIO.write(myFullScreen.getImage(), "PNG", new File(rutaScreenShoot+getDate()+status+".png"));

        } catch (Exception e) {

        }

    }

    public void screenShoot(String status) {

        try {

            File myScreenShoot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //Definir la ubicacion donde se desea guardar
            String rutaScreenShoot = "./src/main/resources/screenShoots/";

            //Copia el archiv de la captura de pantalla a la ubicacion especificada

            FileUtils.copyFile(myScreenShoot, new File(rutaScreenShoot + getDate() + status + ".jpg"));
        } catch (Exception e) {

        }
    }
    //Conexion BD



    public String baseUser = "tyc";
    public String basePass = "Cambio203@@@";

    public String baseTramite(String codigo){
        return codigo;
    }





}
