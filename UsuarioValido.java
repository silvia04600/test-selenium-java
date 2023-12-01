package Steps.Novo.usuario;

import br.com.chiquinha.validarTexto.Pages.HomePage;
import br.com.chiquinha.validarTexto.Pages.RegistrosPage;
import br.com.chiquinha.validarTexto.Pages.SecretaPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Teste da Funcionalidade De Validacao")
public class UsuarioValido {
    private WebDriver navegador;

    @BeforeEach
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));


    }
    @Test
    @DisplayName("Validar O Texto De Saudaçao")
    public void testValidarOTextoDeSaudaçao() {

        //acessar o site do taskit
        HomePage homePage = new HomePage(navegador);
        homePage.acessaPaginaDoTaskit();

        //abrir pagina de registro
        homePage.entraNoSiteTaskit();

        //entra com usuario
        RegistrosPage registrosPage = new RegistrosPage(navegador);
        registrosPage.registrarNovoUsuario("sylvya.sf@gmail.com", "tas4066");


        //localizador da saudaçao
        SecretaPage secretaPage = new SecretaPage(navegador);
        String Saudacao = secretaPage.pegarASaudaçao();
        Assertions.assertEquals("Hi, silvia", Saudacao);

    }


}
