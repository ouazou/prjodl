/*
 * Copyright © 2016 Zouarab and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.periodictable.impl;

import java.util.concurrent.Future;
import org.opendaylight.periodictable.domaine.PeriodicElement;
import org.opendaylight.periodictable.domaine.PeriodicElementRepository;
import org.opendaylight.periodictable.domaine.Repository;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.periodictable.rpc.rev150105.GetElementInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.periodictable.rpc.rev150105.GetElementOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.periodictable.rpc.rev150105.GetElementOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.periodictable.rpc.rev150105.PeriodictableRpcService;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;

/**
 * Created by ouazou on 2017-07-01.
 */
public class PeriodicTableServiceImpl implements PeriodictableRpcService {

    private Repository<Integer, PeriodicElement> repo = PeriodicElementRepository.getInstance();

    @Override
    public Future<RpcResult<GetElementOutput>> getElement(GetElementInput input) {
        GetElementOutputBuilder helloBuilder = new GetElementOutputBuilder();
        PeriodicElement element = repo.findById(input.getAtomicNumber());
        helloBuilder.setSymbol(element.getSymbol());
        return RpcResultBuilder.success(helloBuilder.build()).buildFuture();
    }
}