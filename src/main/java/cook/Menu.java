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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import io.pivotal.spring.cloud.service.config.PlainTextConfigClient;

// code_snippet cookSpecialOne start java
@RefreshScope
@Component
public class Menu {

  @Autowired
  private PlainTextConfigClient plainTextConfigClient;

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

  public String getPlainRecipeText() {
    Resource recipe = plainTextConfigClient.getConfigFile("cook-plain.txt");

    try (BufferedReader buffer = new BufferedReader(
			new InputStreamReader(recipe.getInputStream()))) {
 			return buffer.lines().collect(Collectors.joining("\n"));
 		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
  }

}
