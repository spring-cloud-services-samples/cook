/*
 * Copyright 2017-Present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
