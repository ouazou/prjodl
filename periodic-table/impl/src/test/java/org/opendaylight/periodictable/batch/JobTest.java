/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.batch;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.opendaylight.periodictable.batch.component.FileItemReader;
import org.opendaylight.periodictable.batch.component.ItemWriter;


public class JobTest {

    private ItemWriter<Integer> writer = Mockito.mock(ItemWriter.class);
    private FileItemReader<Integer> reader = Mockito.mock(FileItemReader.class);

    private Job job;

    @Before
    public void setup() {

        writer = Mockito.mock(ItemWriter.class);
        reader = Mockito.mock(FileItemReader.class);
        job = new Job<Integer>()
            .setReader(reader)
            .setWriter(writer);
    }


    @Test
    public void testExecute() throws Exception {
        Mockito.when(reader.hasNext())
            .thenReturn(true)
            .thenReturn(true)
            .thenReturn(false);
        Mockito.when(reader.doRead())
            .thenReturn(10)
            .thenReturn(20);
        job.execute();
        Mockito.verify(writer, Mockito.times(1)).write(Arrays.asList(new Integer[]{10, 20}));
        Mockito.verify(reader, Mockito.times(1)).close();

    }
}