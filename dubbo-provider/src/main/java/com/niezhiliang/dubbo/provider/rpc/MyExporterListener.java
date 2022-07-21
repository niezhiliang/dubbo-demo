package com.niezhiliang.dubbo.provider.rpc;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Exporter;
import org.apache.dubbo.rpc.ExporterListener;
import org.apache.dubbo.rpc.RpcException;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/6/27 19:31
 */
@Activate
public class MyExporterListener implements ExporterListener {

    @Override
    public void exported(Exporter<?> exporter) throws RpcException {
        System.out.println(exporter.getInvoker().getInterface() + "---------exported");
    }

    @Override
    public void unexported(Exporter<?> exporter) {

    }
}
