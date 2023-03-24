/*
 * Copyright 2017-Present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
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

@RefreshScope
@Component
public class Menu {

	private final String special;

	private final String secretMenu;

	private final String dessertMenu;

	public Menu(
			@Value("${cook.special:none}") String special,
			@Value("${secretMenu:none}") String secretMenu,
			@Value("${dessertMenu:none}") String dessertMenu) {
		this.special = special;
		this.secretMenu = secretMenu;
		this.dessertMenu = dessertMenu;
	}

	public String getSpecial() {
		return special;
	}

	public String getSecretMenu() {
		return secretMenu;
	}

	public String getDessertMenu() {
		return dessertMenu;
	}
}
