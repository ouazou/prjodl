/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.domaine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ouazou on 2017-07-02.
 */
public class PeriodicElementRepository implements Repository<Integer, PeriodicElement> {

    private static Repository<Integer, PeriodicElement> periodicElementRepository;
    private Map<Integer, PeriodicElement> map = new HashMap<>();


    private PeriodicElementRepository() {
    }

    public static Repository<Integer, PeriodicElement> getInstance() {
        if (periodicElementRepository == null) {

            periodicElementRepository = new PeriodicElementRepository();
        }

        return periodicElementRepository;
    }

    public Map<Integer, PeriodicElement> getMap() {
        return map;
    }

    public void setMap(Map<Integer, PeriodicElement> map) {
        this.map = map;
    }

    @Override
    public void save(PeriodicElement object) {

        map.put(object.getAtomicNumber(), object);

    }

    @Override
    public PeriodicElement findById(Integer id) {
        return map.get(id);
    }

    @Override
    public List<PeriodicElement> findAll() {
        return new ArrayList(map.values());
    }


}
