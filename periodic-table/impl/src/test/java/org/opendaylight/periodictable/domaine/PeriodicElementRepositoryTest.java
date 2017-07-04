/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.domaine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class PeriodicElementRepositoryTest {

    private PeriodicElementRepository repo =
        (PeriodicElementRepository) PeriodicElementRepository.getInstance();

    @Before
    public void setup() {

        for (int i = 0; i < 5; i++) {
            PeriodicElement prel = new PeriodicElement();
            prel.setAtomicNumber(i);
            prel.setSymbol("element" + i);
            repo.save(prel);
        }

    }

    @Test
    public void saveTestValidation() {
        assertEquals(5, repo.getMap().size());
    }

    @Test
    public void findByIdTestValidation() {

        for (int i = 0; i < 5; i++) {
            PeriodicElement prel = repo.findById(i);
            assertNotNull(prel);
            assertEquals(i, prel.getAtomicNumber());
            assertEquals("element" + i, prel.getSymbol());
        }

    }

    @Test
    public void findAllTestValidation() {
        assertEquals(5, repo.findAll().size());
    }
}