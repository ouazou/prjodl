/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.RpcRegistration;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.periodictable.batch.Job;
import org.opendaylight.periodictable.batch.component.FileItemReader;
import org.opendaylight.periodictable.batch.component.PeriodicElementMapper;
import org.opendaylight.periodictable.batch.component.PeriodicElementWriter;
import org.opendaylight.periodictable.domaine.PeriodicElement;
import org.opendaylight.periodictable.domaine.PeriodicElementRepository;
import org.opendaylight.periodictable.domaine.Repository;
import org.opendaylight.periodictable.tools.ConvertingTool;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.periodictable.rpc.rev150105.PeriodictableRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PeriodicTableProvider {

    public static final String
        CSV_DATA_CSV ="/csv/data.csv";
    private static final Logger LOG = LoggerFactory.getLogger(PeriodicTableProvider.class);
    private final DataBroker dataBroker;
    private final RpcProviderRegistry rpcProviderRegistry;
    private RpcRegistration<PeriodictableRpcService> serviceRegistration;
    private Repository<Integer, PeriodicElement> instance = PeriodicElementRepository.getInstance();

    public PeriodicTableProvider(final DataBroker dataBroker,
                                 final RpcProviderRegistry rpcProviderRegistry) {
        this.dataBroker = dataBroker;
        this.rpcProviderRegistry = rpcProviderRegistry;

    }

    /**
     * Method called when the blueprint container is created.
     */
    public void init() {
        serviceRegistration =
            rpcProviderRegistry
                .addRpcImplementation(PeriodictableRpcService.class,
                                      new PeriodicTableServiceImpl());
        LOG.info("PeriodicTableProvider Session Initiated");
        loadData();
        logInfoData();
        LOG.info("PeriodicTableProvider Session Initiated");
    }

    private void logJson() {
        LOG.info("logging out data...................");
        for (PeriodicElement element : instance.findAll()) {

            LOG.info("PeriodicElement {}",
                     ConvertingTool
                         .convert(element, PeriodicElement.class, ConvertingTool.FORMAT_TO_JSON));

        }
    }

    private void logInfoData() {
        LOG.info("logging out data...................");
        for (PeriodicElement element : instance.findAll()) {
            LOG.info("PeriodicElement id {} :{}", element.getAtomicNumber(), element);
        }
    }

    private void loadData() {
        LOG.info("Loading data from file{}..........", CSV_DATA_CSV);
        Job<PeriodicElement> job = new Job<PeriodicElement>()
            .setReader(new FileItemReader<>(CSV_DATA_CSV, new PeriodicElementMapper()))
            .setWriter(new PeriodicElementWriter(instance));
        job.execute();
    }

    /**
     * Method called when the blueprint container is destroyed.
     */
    public void close() {
        serviceRegistration.close();
        LOG.info("PeriodicTableProvider Closed");
    }
}