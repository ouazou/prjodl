/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.batch.component;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.opendaylight.periodictable.domaine.PeriodicElement;

public class PeriodicElementMapperTest {

    public static final float DELTA = 0.000000001f;
    private PeriodicElementMapper mapper;

    @Before
    public void setUp() throws Exception {

        mapper = new PeriodicElementMapper();
    }

    @Test
    public void mapValidationOfaThoroughLine() throws Exception {

        String
            line =
            "1,Hydrogen,H,1.00794,1,1,gas,bcc,Nonmetal,0.012,0.79,2.2,13.5984,"
            + "0.00008988,14.175,20.28,3,Cavendish,1766,14.304,1s1,1,1";
        PeriodicElement pe = mapper.map(line);
        Assert.assertNotNull(pe);
        Assert.assertEquals(1, pe.getAtomicNumber());
        Assert.assertEquals("Hydrogen", pe.getElement());
        Assert.assertEquals("H", pe.getSymbol());
        Assert.assertEquals(1.00794f, pe.getAtomicWeight(), DELTA);
        Assert.assertEquals(1, pe.getPeriod());
        Assert.assertEquals(1, pe.getGroup());
        Assert.assertEquals("gas", pe.getPhase().toString());
        Assert.assertEquals("bcc", pe.getMostStableCrystal().toString());
        Assert.assertEquals("Nonmetal", pe.getType().toString());
        Assert.assertEquals(0.012f, pe.getIonicRadius(), DELTA);
        Assert.assertEquals(0.79f, pe.getAtomicRadius(), DELTA);
        Assert.assertEquals(2.2f, pe.getElectroNegativity(), DELTA);
        Assert.assertEquals(13.5984f, pe.getFirstIonizationPotential(), DELTA);
        Assert.assertEquals(0.00008988f, pe.getDensity(), DELTA);
        Assert.assertEquals(14.175f, pe.getMeltingPoint(), DELTA);
        Assert.assertEquals(20.28f, pe.getBoilingPoint(), DELTA);
        Assert.assertEquals(3, pe.getIsotopes());
        Assert.assertEquals("Cavendish", pe.getDiscoverer());
        Assert.assertEquals(1766, pe.getYearOfDiscovery());
        Assert.assertEquals(14.304f, pe.getSpecificHeatCapacity(), DELTA);
        Assert.assertEquals("1s1", pe.getElectronConfiguration());
        Assert.assertEquals(1, pe.getDisplayRow());
        Assert.assertEquals(1, pe.getDisplayColumn());
    }



    @Test
    public void mapValidationOfaValidLineWithOutData() throws Exception {

        String
            line =
            ",,,,,,,,,,,,,,,,,,,,,,";
        PeriodicElement pe = mapper.map(line);
        Assert.assertNull(pe);

    }


    @Test
    public void mapValidationOfaNotValidLine() throws Exception {

        String
            line =
            "1,Hydrogen,H,,,,,,,,";
        PeriodicElement pe = mapper.map(line);
        Assert.assertNull(pe);

    }

    @Test
    public void mapValidationNullLine() throws Exception {
        PeriodicElement pe = mapper.map(null);
        Assert.assertNull(pe);

    }

    @Test
    public void mapValidationOfaValidLineWithEmpyColumns() throws Exception {

        String
            line =
            "1,,H,1.00794,1,1,gas,bcc,,0.012,0.79,2.2,13.5984,"
            + "0.00008988,14.175,20.28,3,Cavendish,1766,14.304,,1,0";
        PeriodicElement pe = mapper.map(line);
        Assert.assertNotNull(pe);
        Assert.assertEquals(1, pe.getAtomicNumber());
        Assert.assertNull(pe.getElement());
        Assert.assertEquals("H", pe.getSymbol());
        Assert.assertEquals(1.00794f, pe.getAtomicWeight(), DELTA);
        Assert.assertEquals(1, pe.getPeriod());
        Assert.assertEquals(1, pe.getGroup());
        Assert.assertEquals("gas", pe.getPhase().toString());
        Assert.assertEquals("bcc", pe.getMostStableCrystal().toString());
        Assert.assertNull(pe.getType());
        Assert.assertEquals(0.012f, pe.getIonicRadius(), DELTA);
        Assert.assertEquals(0.79f, pe.getAtomicRadius(), DELTA);
        Assert.assertEquals(2.2f, pe.getElectroNegativity(), DELTA);
        Assert.assertEquals(13.5984f, pe.getFirstIonizationPotential(), DELTA);
        Assert.assertEquals(0.00008988f, pe.getDensity(), DELTA);
        Assert.assertEquals(14.175f, pe.getMeltingPoint(), DELTA);
        Assert.assertEquals(20.28f, pe.getBoilingPoint(), DELTA);
        Assert.assertEquals(3, pe.getIsotopes());
        Assert.assertEquals("Cavendish", pe.getDiscoverer());
        Assert.assertEquals(1766, pe.getYearOfDiscovery());
        Assert.assertEquals(14.304f, pe.getSpecificHeatCapacity(), DELTA);
        Assert.assertNull(pe.getElectronConfiguration());
        Assert.assertEquals(1, pe.getDisplayRow());
        Assert.assertEquals(0, pe.getDisplayColumn());
    }


    @Test
    public void mapValidationOfNullEnums() throws Exception {

        String
            line =
            "1,Hydrogen,H,1.00794,1,1,,,,0.012,0.79,2.2,13.5984,"
            + "0.00008988,14.175,20.28,3,Cavendish,1766,14.304,1s1,1,1";
        PeriodicElement pe = mapper.map(line);
        Assert.assertNotNull(pe);
        Assert.assertEquals(1, pe.getAtomicNumber());
        Assert.assertEquals("Hydrogen", pe.getElement());
        Assert.assertEquals("H", pe.getSymbol());
        Assert.assertEquals(1.00794f, pe.getAtomicWeight(), DELTA);
        Assert.assertEquals(1, pe.getPeriod());
        Assert.assertEquals(1, pe.getGroup());
        Assert.assertNull(pe.getPhase());
        Assert.assertNull(pe.getMostStableCrystal());
        Assert.assertNull(pe.getType());

    }
}