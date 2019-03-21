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

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookController {

	private final Menu menu;

	private final DessertMenu dessertMenu;

	public CookController(Menu menu, DessertMenu dessertMenu) {
		this.menu = menu;
		this.dessertMenu = dessertMenu;
	}

	@RequestMapping("/restaurant")
	public String restaurant() {
		return String.format("Today's special is: %s", menu.getSpecial());
	}

	@RequestMapping("/restaurant/secret-menu")
	public String secretMenu() {
		return menu.getSecretMenu();
	}

	@RequestMapping("/restaurant/dessert-menu")
	public String dessertMenu() throws IOException {
		return dessertMenu.fetchMenu();
	}

}
