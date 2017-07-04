/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.tools;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Number converter , convert to int and float.
 *
 * @author ouazou on 2017-07-03.
 */
public class NumberConverterTools {


    private static final int INT_ZERO = 0;
    private static final float FLOAT_ZERO = 0.0f;
    private static final Logger LOG = LoggerFactory.getLogger(NumberConverterTools.class);

    /**
     * Convert to int.
     *
     * @param number of type string representing the int number
     * @return a int value or zero
     */
    public static int convert2Int(String number) {
        try {
            if (StringUtils.isNotBlank(number)) {
                return Integer.parseInt(number);
            }
        } catch (NumberFormatException ex) {
            LOG.warn("Error converting to int ;{}", number, ex);
        }
        return INT_ZERO;
    }

    /**
     * Convert to float.
     *
     * @param number of type string representing the float number
     * @return a float value or zero
     */
    public static float convert2Float(String number) {
        if (StringUtils.isNotBlank(number)) {
            return Float.parseFloat(number);
        }
        return FLOAT_ZERO;
    }

}
