package InformesGestionarSolicitud.PageObjects;

import InformesGestionarSolicitud.Base.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.sql.SQLException;

public class IntranetPage extends base {


    public IntranetPage(WebDriver driver){
        super(driver);
    }

    //Panel para ingresar el codigo de tramite a validar
    String baseCodigoTramite=(JOptionPane.showInputDialog("Ingrese el codigo de tramite"));

    //Estados de las pruebas para el nombre de las capturas
    String status_F = "_Fail";
    String status_P = "_Pass";

    //Agregamos los localizadores

    //****************Login**************//

    By LoginUser = By.id("logUPN_UserName");
    By LoginPass = By.id("logUPN_Password");
    By LoginButton = By.id("logUPN_LoginButton");

    //****************Main****************//

    By MainPageLocator = By.xpath("//*[@id=\"logo_UPN13\"]");
    By DireccionButton = By.linkText("Dirección");

    //****************Direccion****************//

    By DireccionPageLocator = By.xpath("//*[@id=\"mainNav\"]/div[1]/a");

    //Modulo Informes -> Gestionar Solicitud**************//

    By ModuloDireccionInformes = By.xpath("//*[@id=\"item0_19\"]/a");
    By OpcionInformesGestionarSolicitud = By.partialLinkText("Gestionar Solicitud");
    By TramiteRdButtonCodigo = By.id("ContentPlaceHolder1_RBtnModo_1");
    By TramiteText = By.id("ContentPlaceHolder1_txtParametro");
    By TramiteButtonBuscar = By.id("ContentPlaceHolder1_BtnBuscar");

    By SeleccionarTramite = By.xpath("/html/body/form/div[3]/div/div[2]/div/div/div/div/div[2]/div[5]/div/div/table/tbody/tr/td[2]/a");
    By NumeroSolicitudIsDisplayed = By.id("ContentPlaceHolder1_lblIdSolicitud");

    //Login WebElements***********************************
    public void credencialesLogin() {
        sendKeys(baseUser, LoginUser);
        sendKeys(basePass, LoginPass);
    }

    public void loginIntranet() {
        click(LoginButton);

    }

//Main***********************************

    public void intranetMainDisplayed() {


        if (isDisplayed(MainPageLocator)) {
            click(DireccionButton);
        } else {

            //screenShoot(status_F);
            screenAsShoot(status_F);
            System.out.println("No ingresó al Main de Intranet, aqui tomo un screen que tendra como nombre 'Fail'");
        }
    }


//Direccion***********************************

    public void validarDireccionMain() {


        if (isDisplayed(DireccionPageLocator)) {
            System.out.println("ingresó al portal direccion y se visualizan todos los modulos");
            //screenShoot(status_P);
           // screenAsShoot(status_P);
        } else {

            System.out.println("No ingresó al portal direccion y no se visualizan todos los modulos");
            //screenShoot(status_F);
            screenAsShoot(status_F);
        }

    }

    public void clickModuloInformes() {
        click(ModuloDireccionInformes);

    }

    public void clickOpcionGestionarSolicitud() {
        click(OpcionInformesGestionarSolicitud);
    }

    public void setearCodigoTramite() {

        click(TramiteRdButtonCodigo);

        if (isDisplayed(TramiteText)) {

            sendKeys(baseTramite(baseCodigoTramite), TramiteText);
            click(TramiteButtonBuscar);

        } else {
            System.out.println("No cargó TextBox para setear tramite");
            //screenShoot(status_F);
            screenAsShoot(status_F);
        }

    }

    public void seleccionarTramite() {

        if (isDisplayed(SeleccionarTramite)){
            click(SeleccionarTramite);

            if (isDisplayed(NumeroSolicitudIsDisplayed)) {

                //screenShoot(status_P);
                screenAsShoot(status_P);

            } else {

                System.out.println("No cargó completamente la pagina de visualizacion del tramite");
                //screenShoot(status_F);
                screenAsShoot(status_F);
            }

        }else {
            System.out.println("No se encontró tramite");
            screenAsShoot(status_F);
        }


    }
}
