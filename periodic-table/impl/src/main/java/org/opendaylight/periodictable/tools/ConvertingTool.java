/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * XML/Json Conveting Utility.
 *
 * @author ouazou on 2017-07-02.
 */
public class ConvertingTool {

    public static final boolean FORMAT_TO_JSON = true;
    public static final boolean FORMAT_TO_XML = false;
    private static final Logger LOG = LoggerFactory.getLogger(ConvertingTool.class);

    /**
     * Convert an object to Json or XML.
     *
     * @param object Object to convert
     * @param clazz  Class type of the object to convert
     * @param toJson if true convert to Json else convert to XML
     * @param <T>    the generic type of the object to convert
     * @return A String containing the object in Json/XML format
     */
    public static <T> String convert(T object, Class<T> clazz, boolean toJson) {

        LOG.trace("Converting object {} toJson:{} ", object, toJson);
        try {
            if (toJson) {
                return convertToJson(object);
            } else {
                return convertXML(object, clazz);
            }
        } catch (IOException | JAXBException e) {
            LOG.error("error when converting object {}", object, e);
        }

        return null;
    }

    private static <T> String convertToJson(T object) throws IOException {
        StringWriter sw = new StringWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(sw, object);
        return sw.toString();
    }

    private static <T> String convertXML(T object, Class<T> clazz) throws IOException,
                                                                          JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        JAXBElement jxe = new JAXBElement(new QName(clazz.getSimpleName()), clazz, object);
        StringWriter sw = new StringWriter();
        marshaller.marshal(jxe, sw);
        return sw.toString();
    }


}
