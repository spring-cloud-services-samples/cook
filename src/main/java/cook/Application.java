package cook;

import java.io.IOException;
import org.springframework.beans.BeansException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.spring.cloud.service.config.PlainTextConfigClient;

@RestController
@SpringBootApplication
public class Application {

    @Autowired
    PlainTextConfigClient configClient;

    @Autowired
    private Menu menu;

    @RequestMapping("/restaurant")
    public String restaurant() {
      return String.format("Today's special is: %s", menu.getSpecial());
    }

    @RequestMapping("/restaurant/secret-menu")
    public String secretMenu() {
      return menu.getSecretMenu();
    }

    @RequestMapping("/restaurant/dessert-menu")
    String request() throws BeansException, IOException {
      return convertStreamToString(configClient.getConfigFile("cloud", "master", "dessert.json").getInputStream());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    static String convertStreamToString(java.io.InputStream is) {
      java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
      return s.hasNext() ? s.next() : "";
    }

}
