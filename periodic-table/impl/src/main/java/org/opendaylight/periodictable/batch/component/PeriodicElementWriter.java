/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.batch.component;

import java.util.List;
import org.opendaylight.periodictable.domaine.PeriodicElement;
import org.opendaylight.periodictable.domaine.Repository;

/**
 * Created by ouazou on 2017-07-02.
 */
public class PeriodicElementWriter implements ItemWriter<PeriodicElement> {

    private Repository<Integer, PeriodicElement> repo;

    public PeriodicElementWriter(
        Repository<Integer, PeriodicElement> repo) {
        this.repo = repo;
    }

    public Repository<Integer, PeriodicElement> getRepo() {
        return repo;
    }

    public void setRepo(Repository<Integer, PeriodicElement> repo) {
        this.repo = repo;
    }

    @Override
    public void write(List<PeriodicElement> items) {
        for (PeriodicElement item : items) {
            repo.save(item);
        }
    }
}
