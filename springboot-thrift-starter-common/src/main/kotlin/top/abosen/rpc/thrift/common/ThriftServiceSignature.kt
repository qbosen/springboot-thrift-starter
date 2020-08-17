package top.abosen.rpc.thrift.common

/**
 * @author qiubaisen
 * @date 2020/8/17
 */
data class ThriftServiceSignature(
    val serviceId: String,
    val serviceClass: Class<*>,
    val version: Double
) {
    val marker = "$serviceId#${serviceClass.name}#$version"
}
