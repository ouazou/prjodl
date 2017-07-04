/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.batch.component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * File items read. Read items of Type T from a text file. Created by ouazou on 2017-07-02.
 *
 * @param <T> the type of elements read.
 */
public class FileItemReader<T> {

    private static final Logger LOG = LoggerFactory.getLogger(FileItemReader.class);
    public static  String INPUT_FOLDER = "src/main/resources/";
    private Scanner lineScanner;
    private String fileNameDefined;
    private LineMapper<T> lineMapper;

    /**
     * Constructor
     *
     * @param fileName   path of the file stream
     * @param lineMapper Mapper extract the object of type T
     */
    public FileItemReader(String fileName, LineMapper<T> lineMapper) {
        LOG.debug("Opening File{} for reading.", fileName);
        this.fileNameDefined = new File(INPUT_FOLDER).getAbsolutePath()
                               +fileName;
        this.lineMapper = lineMapper;
        try {
            lineScanner = new Scanner(new File(fileNameDefined));
        } catch (FileNotFoundException e) {
            LOG.error("File {} not found ", fileNameDefined);
        }
    }

    /**
     * Read un object from text file;
     *
     * @return object of Type T
     */
    public T doRead() {
        return lineMapper.map(lineScanner.next());
    }

    /**
     * Returns true if there another item in the stream.
     *
     * @return Boolean  true if there another item in the stream
     */
    public boolean hasNext() {
        return lineScanner.hasNext();
    }

    /**
     * Close the stream.
     */
    public void close() {
        LOG.debug("Closing File{} for writing.", fileNameDefined);
        if (lineScanner != null) {
            lineScanner.close();
        }
    }


}
