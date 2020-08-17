package top.abosen.rpc.thrift.client.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty
import top.abosen.rpc.thrift.common.ServiceModel

/**
 * @author qiubaisen
 * @date 2020/8/17
 */

@ConfigurationProperties(prefix = "spring.thrift.client")
class ThriftClientProperties(
    var serviceModel: ServiceModel = ServiceModel.default,
    var packageToScan: String = "",
    @NestedConfigurationProperty
    var pool: ThriftClientPoolProperties = ThriftClientPoolProperties()
) {
    companion object {
        const val SPRING_THRIFT_CLIENT_PACKAGE_TO_SCAN = "spring.thrift.client.package-to-scan"
        const val SPRING_THRIFT_CLIENT_SERVICE_MODEL = "spring.thrift.client.service-model"
    }
}

class ThriftClientPoolProperties(
    var retryTimes: Int = 3,
    var connectTimeout: Int = 10000,
    var poolMaxTotalPerKey: Int = 60,
    var poolMaxIdlePerKey: Int = 40,
    var poolMinIdlePerKey: Int = 3,
    var poolMaxWait: Long = 180000,
    var testOnCreate: Boolean = true,
    var testOnBorrow: Boolean = true,
    var testOnReturn: Boolean = true,
    var testWhileIdle: Boolean = true
)