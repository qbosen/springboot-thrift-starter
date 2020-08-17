package top.abosen.rpc.thrift.client.common

import org.apache.thrift.TServiceClient

/**
 * @author qiubaisen
 * @date 2020/8/17
 */
interface ThriftClientAware<T : TServiceClient> {
    fun client(): T
}
