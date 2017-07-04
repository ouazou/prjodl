/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ouazou on 2017-07-02.
 */
public class FileWriter {

    private static final Logger LOG = LoggerFactory.getLogger(FileWriter.class);
    public static  String OUTPUT_FOLDER = "src/main/resources/";
    private PrintWriter writer;
    private String fileNameDefined;

    protected FileWriter() {

    }

    public FileWriter(String fileName) {
        LOG.debug("Opening File{} for writing.", fileName);
        this.fileNameDefined = new File(OUTPUT_FOLDER).getAbsolutePath()
                               +fileName;
        try {
            writer = new PrintWriter(new File(fileNameDefined), "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            LOG.error("Error while opening File{}.", fileNameDefined, e);
        }
    }

    public void write(String line) {
        writer.println(line);
    }

    public void close() {
        LOG.debug("Closing File{}.", fileNameDefined);
        if (writer != null) {

            writer.flush();
            writer.close();
        }
    }

    protected void setWriter(PrintWriter writer) {
        this.writer = writer;
    }
}
