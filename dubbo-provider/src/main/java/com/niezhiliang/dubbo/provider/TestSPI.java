package com.niezhiliang.dubbo.provider;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.ExporterListener;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/6/28 9:45
 */
public class TestSPI {
    public static void main(String[] args) {
        ExporterListener my = ExtensionLoader.getExtensionLoader(ExporterListener.class).getExtension("my");
    }
}
