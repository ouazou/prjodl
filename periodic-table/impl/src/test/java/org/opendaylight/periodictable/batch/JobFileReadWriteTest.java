/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.batch;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.periodictable.batch.component.FileItemReader;
import org.opendaylight.periodictable.batch.component.PeriodicElementMapper;
import org.opendaylight.periodictable.batch.component.PeriodicElementWriter;
import org.opendaylight.periodictable.domaine.PeriodicElement;
import org.opendaylight.periodictable.domaine.PeriodicElementRepository;
import org.opendaylight.periodictable.domaine.Repository;
import org.opendaylight.periodictable.tools.ConvertingTool;
import org.opendaylight.periodictable.tools.FileWriter;

/**
 * Created by ouazou on 2017-07-03.
 */
public class JobFileReadWriteTest {

    @Before
    public void setup() {
        FileItemReader.INPUT_FOLDER = "src/test/resources/";
        FileWriter.OUTPUT_FOLDER = "target";
        Job<PeriodicElement> job = new Job<PeriodicElement>()
            .setReader(new FileItemReader<>("/csv/data.csv", new PeriodicElementMapper()))
            .setWriter(new PeriodicElementWriter(PeriodicElementRepository.getInstance()));
        job.execute();

    }

    @Test
    public void testWritJsonToFile() throws IOException {

        Repository<Integer, PeriodicElement> instance = PeriodicElementRepository.getInstance();
        FileWriter writer = new FileWriter("/file.json");
        for (PeriodicElement element : instance.findAll()) {
            writer.write(ConvertingTool
                             .convert(element, PeriodicElement.class,
                                      ConvertingTool.FORMAT_TO_JSON));
        }
        writer.close();
        Assert.assertTrue(FileUtils.readFileToString(new File(FileWriter.OUTPUT_FOLDER+"/file.json")).contains(
            "{\"atomicNumber\":1,\"element\":null,\"symbol\":\"H\",\"atomicWeight\":1.00794,\"period\":1,\"group\":1,\"phase\":\"gas\",\"mostStableCrystal\":\"bcc\",\"type\":null,\"ionicRadius\":0.012,\"atomicRadius\":0.79,\"electroNegativity\":2.2,\"firstIonizationPotential\":13.5984,\"density\":8.988E-5,\"meltingPoint\":14.175,\"boilingPoint\":20.28,\"isotopes\":3,\"discoverer\":\"Cavendish\",\"yearOfDiscovery\":1766,\"specificHeatCapacity\":14.304,\"electronConfiguration\":null,\"displayRow\":1,\"displayColumn\":1}"));
    }

    @Test
    public void testWritXmlToFile() throws IOException {

        Repository<Integer, PeriodicElement> instance = PeriodicElementRepository.getInstance();

        FileWriter writer = new FileWriter("/file.xml");
        for (PeriodicElement element : instance.findAll()) {
            writer.write(ConvertingTool
                             .convert(element, PeriodicElement.class,
                                      ConvertingTool.FORMAT_TO_XML));
        }

        writer.close();

        Assert.assertTrue(FileUtils.readFileToString(new File(FileWriter.OUTPUT_FOLDER+"/file.xml")).contains(
            "<PeriodicElement><atomicNumber>1</atomicNumber><atomicRadius>0.79</atomicRadius><atomicWeight>1.00794</atomicWeight><boilingPoint>20.28</boilingPoint><density>8.988E-5</density><discoverer>Cavendish</discoverer><displayColumn>1</displayColumn><displayRow>1</displayRow><electroNegativity>2.2</electroNegativity><firstIonizationPotential>13.5984</firstIonizationPotential><group>1</group><ionicRadius>0.012</ionicRadius><isotopes>3</isotopes><meltingPoint>14.175</meltingPoint><mostStableCrystal>BCC</mostStableCrystal><period>1</period><phase>GAS</phase><specificHeatCapacity>14.304</specificHeatCapacity><symbol>H</symbol><yearOfDiscovery>1766</yearOfDiscovery></PeriodicElement>"));


    }


}
