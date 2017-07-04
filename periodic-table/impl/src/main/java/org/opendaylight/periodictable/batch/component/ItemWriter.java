/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.batch.component;

import java.util.List;

/**
 * Item writer Utility.
 *
 * @param <T> item type to be write to stream
 * @author ouazou on 2017-07-02.
 */
public interface ItemWriter<T> {

    /**
     * Write a list of objects to a stream.
     *
     * @param items of type T
     */
    void write(List<T> items);

}
