/*
 * Copyright 2018 the original author or authors.
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

import java.util.Arrays;
import java.util.Collection;
import org.bremersee.xml.JaxbContextData;
import org.bremersee.xml.JaxbContextDataProvider;

/**
 * KML jaxb context data provider.
 *
 * @author Christian Bremer
 */
public class KmlJaxbContextDataProvider implements JaxbContextDataProvider {

  /**
   * The KML XML name space.
   */
  @SuppressWarnings("WeakerAccess")
  public static final String KML_NS = "http://www.opengis.net/kml/2.2";

  /**
   * The name space of google's kml extension.
   */
  @SuppressWarnings("WeakerAccess")
  public static final String KML_GX_NS = "http://www.google.com/kml/ext/2.2";

  /**
   * Name spache of xAL: eXtensible Address Language
   */
  @SuppressWarnings("WeakerAccess")
  public static final String XAL_NS = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0";

  /**
   * Name space of w3.org Atom
   */
  @SuppressWarnings("WeakerAccess")
  public static final String ATOM_NS = "http://www.w3.org/2005/Atom";

  @Override
  public Collection<JaxbContextData> getJaxbContextData() {
    return Arrays.asList(
        new JaxbContextData(
            KML_NS,
            "http://schemas.opengis.net/kml/2.2.0/ogckml22.xsd",
            org.bremersee.opengis.kml.v22.ObjectFactory.class.getPackage().getName()),
        new JaxbContextData(
            KML_GX_NS,
            "https://developers.google.com/kml/schema/kml22gx.xsd",
            org.bremersee.google.kml.v22.ext.ObjectFactory.class.getPackage().getName()),
        new JaxbContextData(
            XAL_NS,
            "http://docs.oasis-open.org/election/external/xAL.xsd",
            org.bremersee.oasis.xal.ObjectFactory.class.getPackage().getName()),
        new JaxbContextData(
            ATOM_NS,
            "http://schemas.opengis.net/kml/2.2.0/atom-author-link.xsd",
            org.bremersee.w3c.atom.ObjectFactory.class.getPackage().getName()));
  }

}
