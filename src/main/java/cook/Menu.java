package cook;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class Menu {

  @Value("${cook.special}")
  String special;

  @Value("${secretMenu}")
  String secretMenu;

  public String getSpecial() {
    return special;
  }

  public String getSecretMenu() {
    return secretMenu;
  }

}
