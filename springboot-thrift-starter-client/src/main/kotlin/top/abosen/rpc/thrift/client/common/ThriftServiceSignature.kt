package top.abosen.rpc.thrift.client.common

/**
 * @author qiubaisen
 * @date 2020/8/17
 */
data class ThriftServiceSignature(
    val thriftServiceId: String,
    val thriftServiceClass: Class<*>,
    val version: Double
) {
    val marker = "$thriftServiceId#${thriftServiceClass.name}#$version"
}
