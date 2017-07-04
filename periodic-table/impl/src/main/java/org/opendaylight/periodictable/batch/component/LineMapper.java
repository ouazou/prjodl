/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.batch.component;

/**
 * Mapper utility.
 *
 * @param <T> generic type of the resulting object
 * @author ouazou on 2017-07-02.
 */
public interface LineMapper<T> {

    /**
     * Convert a String  to an object of type T.
     *
     * @param line of type String
     * @return Object of type T
     */
    T map(String line);
}
