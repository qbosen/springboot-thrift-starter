package top.abosen.rpc.thrift.client.properties

import org.springframework.boot.autoconfigure.condition.ConditionOutcome
import org.springframework.boot.autoconfigure.condition.SpringBootCondition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.type.AnnotatedTypeMetadata
import top.abosen.rpc.thrift.client.properties.ThriftClientProperties.Companion.SPRING_THRIFT_CLIENT_PACKAGE_TO_SCAN
import top.abosen.rpc.thrift.client.properties.ThriftClientProperties.Companion.SPRING_THRIFT_CLIENT_SERVICE_MODEL

/**
 * 当配置了客户端包路径时，才进行自动配置
 * @author qiubaisen
 * @date 2020/8/17
 */
class ThriftClientPropertiesCondition : SpringBootCondition() {
    override fun getMatchOutcome(context: ConditionContext?, metadata: AnnotatedTypeMetadata?): ConditionOutcome {
        val packageToScan = context?.environment?.getProperty(SPRING_THRIFT_CLIENT_PACKAGE_TO_SCAN)
        val serviceModel = context?.environment?.getProperty(SPRING_THRIFT_CLIENT_SERVICE_MODEL)

        return ConditionOutcome(
            !packageToScan.isNullOrBlank() && serviceModel != null,
            "Thrift server service model is $serviceModel and scan package:[$packageToScan]"
        )
    }
}