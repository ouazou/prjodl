/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.tools;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by ouazou on 2017-07-03.
 */
public class NumberConverterTools {


    private static final int INT_ZERO = 0;
    private static final float FLOAT_ZERO = 0.0f;

    public static int convert2Int(String number) {
        try {
            if (StringUtils.isNotBlank(number)) {
                return Integer.parseInt(number);
            }
        } catch (NumberFormatException ex) {

        }
        return INT_ZERO;
    }

    public static float convert2Float(String number) {
        if (StringUtils.isNotBlank(number)) {
            return Float.parseFloat(number);
        }
        return FLOAT_ZERO;
    }

}
