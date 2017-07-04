/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.tools;

import org.junit.Assert;
import org.junit.Test;

public class ConvertingToolTest {

    @Test
    public void testConvert() throws Exception {

        Element element = new Element("parts");
        String json = ConvertingTool.convert(element, Element.class, ConvertingTool.FORMAT_TO_JSON);
        String xml = ConvertingTool.convert(element, Element.class, ConvertingTool.FORMAT_TO_XML);

        Assert.assertEquals("{\"name\":\"parts\"}", json);
        Assert.assertEquals("<Element><name>parts</name></Element>", xml);
    }

    public static class Element {

        private String name;

        public Element() {

        }

        public Element(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}