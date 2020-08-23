package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewsPage;
import pages.SearchPage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.screenshot;

public class TestesQuestaoQuatro {

    private static HomePage Home;
    private static SearchPage Search;
    private static NewsPage News;

    @BeforeSuite
    public void acessarPaginaInicial() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://www.globo.com";
        Configuration.timeout = 10000;
        Home = new HomePage();
        Search = new SearchPage();
        News = new NewsPage();
    }

    @Test
    public void buscarNoticia() {
        Home.open()
                .search("Corona Virus");
        Search.filterDate()
                .paginacao()
                .itens().findBy(text("Rússia anuncia vacinação em massa contra o coronavírus para outubro")).click();
        News.tituloNoticia().shouldHave(text("Rússia anuncia vacinação em massa contra o coronavírus para outubro"));

    }

    @AfterMethod
    public void finish() {
        String tempShot = screenshot("temp_shot");

        try {
            BufferedImage bimage = ImageIO.read(new File(tempShot));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            ImageIO.write(bimage, "png", baos);
            byte[] screenshot = baos.toByteArray();

        } catch (Exception ex) {
            System.out.println("Screenshot error: " + ex.getMessage());
        }
    }
}
