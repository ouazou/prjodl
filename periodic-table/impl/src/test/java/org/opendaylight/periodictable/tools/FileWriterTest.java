/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.tools;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class FileWriterTest {

    private PrintWriter writer;
    private FileWriter fileWriter;


    @Before
    public void setup() throws FileNotFoundException, UnsupportedEncodingException {
        writer = Mockito.mock(PrintWriter.class);
        fileWriter = new FileWriter();
        fileWriter.setWriter(writer);
    }

    @Test
    public void testWrite() throws Exception {
        fileWriter.write("Line");
        Mockito.verify(writer, Mockito.times(1)).println("Line");
    }

    @Test
    public void testClose() throws Exception {
        fileWriter.close();
        Mockito.verify(writer, Mockito.times(1)).flush();
        Mockito.verify(writer, Mockito.times(1)).close();
    }
}