package com.niezhiliang.dubbo.tracking.filter.dubbo;

import java.util.Objects;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.slf4j.MDC;

import com.niezhiliang.dubbo.tracking.constant.Constant;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/7/15 17:28
 */
@Activate(group = {CommonConstants.PROVIDER}, order = -2)
public class ProviderTraceIdFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = RpcContext.getContext().getAttachment(Constant.TRACE_ID);
        if (Objects.isNull(traceId)) {
            traceId = Constant.UNDEFINED;
        }
        try {
            MDC.put(Constant.TRACE_ID, traceId);
            return invoker.invoke(invocation);
        } finally {
            MDC.clear();
        }
    }
}
