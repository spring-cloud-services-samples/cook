package cook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

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

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
