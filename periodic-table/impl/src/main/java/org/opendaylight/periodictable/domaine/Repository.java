/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.domaine;

import java.util.List;

/**
 * Created by ouazou on 2017-07-02.
 */
public interface Repository<K, T> {

    void save(T object);

    T findById(K id);

    List<T> findAll();


}
