/*
 * Copyright 2018-2020 the original author or authors.
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

package org.bremersee.kml.v22;

import java.util.ServiceLoader;
import javax.xml.bind.JAXBException;
import org.bremersee.opengis.kml.v22.Kml;
import org.bremersee.xml.JaxbContextBuilder;
import org.bremersee.xml.JaxbContextDataProvider;
import org.bremersee.xml.SchemaMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

/**
 * XML schema test.
 *
 * @author Christian Bremer
 */
class JaxbContextBuilderTest {

  private static final ResourceLoader RESOURCE_LOADER = new DefaultResourceLoader();

  private static JaxbContextBuilder jaxbContextBuilder;

  /**
   * Create jaxb context.
   */
  @BeforeAll
  static void createJaxbContext() {
    jaxbContextBuilder = JaxbContextBuilder.builder()
        .withSchemaMode(SchemaMode.ALWAYS)
        .processAll(ServiceLoader.load(JaxbContextDataProvider.class));
  }

  /**
   * Test kml.
   *
   * @throws JAXBException the jaxb exception
   */
  @Test
  void testKml() throws Exception {

    Kml kml = (Kml) jaxbContextBuilder
        .buildUnmarshaller()
        .unmarshal(RESOURCE_LOADER.getResource("classpath:KML_Samples.kml").getInputStream());

    Assertions.assertNotNull(kml);
  }

}
