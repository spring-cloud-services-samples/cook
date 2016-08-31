package cook;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

// code_snippet cookSpecialOne start java
@RefreshScope
@Component
public class Menu {

  @Value("${cook.special}")
  String special;
// code_snippet cookSpecialOne end

  @Value("${secretMenu}")
  String secretMenu;

// code_snippet cookSpecialTwo start java
  public String getSpecial() {
    return special;
  }
// code_snippet cookSpecialTwo end

  public String getSecretMenu() {
    return secretMenu;
  }

}
