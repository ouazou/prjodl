/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.tools;

import static org.junit.Assert.*;


import org.junit.Test;

public class NumberConverterToolsTest {

    @Test
    public void testConvert2Int() throws Exception {

        assertEquals(0, NumberConverterTools.convert2Int("0"));
        assertEquals(20, NumberConverterTools.convert2Int("20"));
        assertEquals(0, NumberConverterTools.convert2Int("10.00"));
        assertEquals(0, NumberConverterTools.convert2Int(""));
        assertEquals(0, NumberConverterTools.convert2Int(null));
    }

    @Test
    public void testConvert2Float() throws Exception {

        assertEquals(0, NumberConverterTools.convert2Float("0.000"),0.0f);
        assertEquals(20, NumberConverterTools.convert2Float("20.000"),0.0f);
        assertEquals(10.0f, NumberConverterTools.convert2Float("10.00"),0.0f);
        assertEquals(0, NumberConverterTools.convert2Float(""),0.0f);
        assertEquals(0, NumberConverterTools.convert2Float(null),0.0f);
    }
}