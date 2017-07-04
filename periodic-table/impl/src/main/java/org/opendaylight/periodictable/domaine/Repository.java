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
 * A repository utility.
 *
 * @param <K> Key of the object to store in the repository
 * @param <T> The object to store in the repository
 * @author ouazou on 2017-07-02.
 */
public interface Repository<K, T> {

    /**
     * Save the object.
     *
     * @param object of type T
     */
    void save(T object);

    /**
     * Find the object by it's key.
     *
     * @param id The key
     * @return An object of type T
     */
    T findById(K id);

    /**
     * Find all the object from the repository.
     *
     * @return a list of T
     */
    List<T> findAll();


}
