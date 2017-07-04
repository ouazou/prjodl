/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.batch.component;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.opendaylight.periodictable.domaine.PeriodicElement;
import org.opendaylight.periodictable.domaine.Repository;

@RunWith(MockitoJUnitRunner.class)
public class PeriodicElementWriterTest {

    private Repository<Integer, PeriodicElement> repo = Mockito.mock(Repository.class);

    private PeriodicElementWriter ptw = new PeriodicElementWriter(repo);

    private PeriodicElement prel = new PeriodicElement();


    @Test
    public void writeZeroElement() throws Exception {
        ptw.write(Arrays.asList(new PeriodicElement[]{}));
        Mockito.verify(repo, Mockito.never()).save(prel);
    }

    @Test
    public void writeOneElement() throws Exception {
        ptw.write(Arrays.asList(new PeriodicElement[]{prel}));
        Mockito.verify(repo, Mockito.times(1)).save(prel);
    }

    @Test
    public void writeTwoElement() throws Exception {
        ptw.write(Arrays.asList(new PeriodicElement[]{prel, prel}));
        Mockito.verify(repo, Mockito.times(2)).save(prel);
    }

    @Test
    public void writeThreeElement() throws Exception {
        ptw.write(Arrays.asList(new PeriodicElement[]{prel, prel, prel}));
        Mockito.verify(repo, Mockito.times(3)).save(prel);
    }

    @Test
    public void writeFourElement() throws Exception {
        ptw.write(Arrays.asList(new PeriodicElement[]{prel, prel, prel, prel}));
        Mockito.verify(repo, Mockito.times(4)).save(prel);
    }

    @Test
    public void writeFiveElement() throws Exception {
        ptw.write(Arrays.asList(new PeriodicElement[]{prel, prel, prel, prel, prel}));
        Mockito.verify(repo, Mockito.times(5)).save(prel);
    }


}