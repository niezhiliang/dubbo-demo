package com.niezhiliang.dubbo.tracking.filter.dubbo;

import java.util.Objects;
import java.util.UUID;

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
@Activate(group = {CommonConstants.CONSUMER}, order = -1)
public class ConsumerTraceIdFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = MDC.get(Constant.TRACE_ID);
        if (Objects.isNull(traceId)) {
            traceId = UUID.randomUUID().toString();
        }
        RpcContext.getContext().setAttachment(Constant.TRACE_ID, traceId);
        return invoker.invoke(invocation);
    }
}
