package InformesGestionarSolicitud.Tests;

import InformesGestionarSolicitud.PageObjects.IntranetPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import InformesGestionarSolicitud.Base.base;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class C_testFlujoIntranetDireccion {

    private WebDriver driver;
    IntranetPage intranetPage;
    base base;

    @Before
    public void setUP(){
        intranetPage = new IntranetPage(driver);
        base = new base(driver);

        driver = intranetPage.chromeWebDriverConnection();
        intranetPage.getURL("https://intranetcert.upn.edu.pe/WebLogin/Login.aspx");
    }

    @After
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        // driver.quit();
    }

    @Test

    public void tests() {


        intranetPage.credencialesLogin();
        intranetPage.loginIntranet();

        intranetPage.intranetMainDisplayed();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        intranetPage.validarDireccionMain();
        intranetPage.clickModuloInformes();
        intranetPage.clickOpcionGestionarSolicitud();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        intranetPage.setearCodigoTramite();
        intranetPage.seleccionarTramite();

        //prueba gitit statusgit
        
      

    }
}
