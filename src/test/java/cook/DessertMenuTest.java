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

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

import io.pivotal.spring.cloud.config.client.PlainTextConfigClient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.core.io.InputStreamResource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class DessertMenuTest {

	private DessertMenu dessertMenu;

	@Mock
	private PlainTextConfigClient plainTextConfigClient;

	@BeforeEach
	public void setUp() {
		this.dessertMenu = new DessertMenu(this.plainTextConfigClient);
	}

	@Test
	public void fetchMenu() throws Exception {
		given(plainTextConfigClient.getPlainTextResource("cloud", "master", "dessert.json"))
				.willReturn(new InputStreamResource(new ByteArrayInputStream("Jello".getBytes(Charset.forName("UTF-8")))));
		assertThat(dessertMenu.fetchMenu()).isNotEmpty().isEqualTo("Jello");
	}

}
