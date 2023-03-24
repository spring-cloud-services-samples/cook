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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CookController.class, properties = "spring.cloud.config.enabled=false")
public class CookControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private Menu menu;

	@Test
	public void contextLoads() {
	}

  @WithMockUser(value = "Cookie")
	@Test
	public void restaurant() throws Exception {
		given(this.menu.getSpecial())
				.willReturn("Tuna Melt");
		this.mvc.perform(get("/restaurant")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("Today's special is: Tuna Melt"));
	}

  @WithMockUser(value = "Cookie")
	@Test
	public void secretMenu() throws Exception {
		given(this.menu.getSecretMenu())
				.willReturn("Fish");
		this.mvc.perform(get("/restaurant/secret-menu")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("Fish"));
	}

  @WithMockUser(value = "Cookie")
	@Test
	public void dessertMenu() throws Exception {
		given(this.menu.getDessertMenu())
				.willReturn("Chocolate Ice Cream");
		this.mvc.perform(get("/restaurant/dessert-menu")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("Chocolate Ice Cream"));
	}

}
