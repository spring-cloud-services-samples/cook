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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.pivotal.cfenv.core.CfCredentials;
import io.pivotal.cfenv.core.CfEnv;
import io.pivotal.cfenv.core.CfEnvSingleton;

@SpringBootApplication
@Configuration
public class CookApplication {
	private static final Logger log = LoggerFactory.getLogger(CookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CookApplication.class, args);
	}

	@Bean
	public CfEnv cfEnv() throws JsonProcessingException {
		CfCredentials credentials = CfEnvSingleton.getCfEnvInstance().findCredentialsByTag("configuration");
		log.info(new ObjectMapper().writeValueAsString(credentials.getDerivedCredentials()));
		return new CfEnv();
	}

}
