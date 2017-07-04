/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.batch.component;

import org.opendaylight.periodictable.domaine.PeriodicElement;
import org.opendaylight.periodictable.domaine.PeriodicElement.PeriodicElementBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mapper utility.
 *
 * @author ouazou on 2017-07-02.
 */
public class PeriodicElementMapper implements LineMapper<PeriodicElement> {

    private static final Logger LOG = LoggerFactory.getLogger(PeriodicElementMapper.class);
    public static String Fields_SEPARATOR = ",";

    public PeriodicElement map(String line) {

        if (line == null) {
            return null;
        }

        String[] fields = line.split(Fields_SEPARATOR);

        if (fields.length == 23) {
            PeriodicElementBuilder builder = new PeriodicElementBuilder();
            builder
                .atomicNumber(fields[0])
                .element(fields[1])
                .symbol(fields[2])
                .atomicWeight(fields[3])
                .period(fields[4])
                .group(fields[5])
                .phase(fields[6])
                .mostStableCrystal(fields[7])
                .type(fields[8])
                .ionicRadius(fields[9])
                .atomicRadius(fields[10])
                .electroNegativity(fields[11])
                .firstIonizationPotential(fields[12])
                .density(fields[13])
                .meltingPoint(fields[14])
                .boilingPoint(fields[15])
                .isotopes(fields[16])
                .discoverer(fields[17])
                .yearOfDiscovery(fields[18])
                .specificHeatCapacity(fields[19])
                .electronConfiguration(fields[20])
                .displayRow(fields[21])
                .displayColumn(fields[22]);

            return builder.build();
        }
        LOG.trace("Could not map line {}", line);
        return null;
    }


}
