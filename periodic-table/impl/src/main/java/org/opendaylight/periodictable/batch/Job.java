/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.batch;

import java.util.ArrayList;
import java.util.List;
import org.opendaylight.periodictable.batch.component.FileItemReader;
import org.opendaylight.periodictable.batch.component.ItemWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Job that reads items from a stream a process them.
 *
 * @param <T> the type of elements processed.
 * @author ouazou on 2017-07-02.
 */

public class Job<T> {

    private static final Logger LOG = LoggerFactory.getLogger(Job.class);

    private ItemWriter<T> writer;
    private FileItemReader<T> reader;

    /**
     * Set the ItemWriter.
     *
     * @param writer of type ItemWriter
     * @return the current Job instance
     */
    public Job setWriter(ItemWriter<T> writer) {
        this.writer = writer;
        return this;
    }

    /**
     * set The File Item Reader.
     *
     * @param reader of type FileItemReader
     * @return the current Job instance
     */
    public Job setReader(FileItemReader<T> reader) {
        this.reader = reader;
        return this;
    }

    /**
     * Read the items from a stream and process them.
     */
    public void execute() {
        List<T> items = new ArrayList<>();
        try {
            while (reader.hasNext()) {
                items.add(reader.doRead());
            }
            writer.write(items);
        } finally {
            reader.close();
        }


    }


}
