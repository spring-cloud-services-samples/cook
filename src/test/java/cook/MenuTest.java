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


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {

	@Test
	public void emptyMenu() {
		var menu = new Menu(null, null, null);
		assertThat(menu.getSpecial()).isNullOrEmpty();
		assertThat(menu.getSecretMenu()).isNullOrEmpty();
		assertThat(menu.getDessertMenu()).isNullOrEmpty();
	}

	@Test
	public void menu() {
		var menu = new Menu("Tofu Noodles", "Tofu BBQ", "Mapo Tofu");
		assertThat(menu.getSpecial())
				.isNotEmpty()
				.isEqualTo("Tofu Noodles");
		assertThat(menu.getSecretMenu())
				.isNotEmpty()
				.isEqualTo("Tofu BBQ");
		assertThat(menu.getDessertMenu())
				.isNotEmpty()
				.isEqualTo("Mapo Tofu");
	}

}
