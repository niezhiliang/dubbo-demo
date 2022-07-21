package com.niezhiliang.dubbo.provider.rpc;

import org.apache.dubbo.rpc.Exporter;
import org.apache.dubbo.rpc.ExporterListener;
import org.apache.dubbo.rpc.RpcException;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/6/28 10:08
 */
public class MyExporterListenerWrapper implements ExporterListener {

    private ExporterListener exporterListener;

    public MyExporterListenerWrapper(ExporterListener exporterListener) {
        this.exporterListener = exporterListener;
    }

    @Override
    public void exported(Exporter<?> exporter) throws RpcException {
        System.out.println("exported before....");
        exporterListener.exported(exporter);
        System.out.println("exported after....");
    }

    @Override
    public void unexported(Exporter<?> exporter) {

    }
}
