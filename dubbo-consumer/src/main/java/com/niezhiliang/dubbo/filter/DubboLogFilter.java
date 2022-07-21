package com.niezhiliang.dubbo.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * @author niezhiliang
 * @date 2022/3/15 19:44
 */
@Activate(group = CommonConstants.CONSUMER)
public class DubboLogFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext.getContext().setAttachment("hello", "world");
        RpcContext.getContext().getUrl().addParameter("haha", "xixi");
        System.out.println("-*-------------");
        return invoker.invoke(invocation);
    }
}
