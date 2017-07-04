/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.batch.component;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileItemReaderTest {


    private FileItemReader<Car> itemReader;

    @Before
    public void setup() {
        FileItemReader.INPUT_FOLDER="src/test/resources/csv/";
        itemReader = new FileItemReader<>("/car.csv", new LineMapper<Car>() {
            @Override
            public Car map(String line) {
                Car car = new Car();
                car.setType(line.split(",")[0]);
                car.setYear(line.split(",")[1]);
                return car;
            }
        });
    }

    @Test
    public void testDoRead() throws Exception {
        Car car = itemReader.doRead();
        Assert.assertEquals("Mazda", car.getType());
        Assert.assertEquals("2015", car.getYear());
        car = itemReader.doRead();
        Assert.assertEquals("VW", car.getType());
        Assert.assertEquals("2017", car.getYear());
    }

    @Test
    public void testHasNext() throws Exception {
        itemReader.doRead();
        Assert.assertEquals(true, itemReader.hasNext());
        itemReader.doRead();
        Assert.assertEquals(false, itemReader.hasNext());
    }

    @Test(expected =IllegalStateException.class )
    public void testClose() throws Exception {
        itemReader.close();
        itemReader.hasNext();

    }

    static class Car {

        private String type;
        private String year;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }
    }
}