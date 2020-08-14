package top.abosen.rpc.thrift.client.annotation

import org.springframework.context.EnvironmentAware
import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.core.annotation.AnnotationAttributes
import org.springframework.core.env.Environment
import org.springframework.core.type.AnnotationMetadata
import top.abosen.rpc.thrift.client.ThriftClientAutoConfiguration
import top.abosen.rpc.thrift.client.logger


/**
 * @author qiubaisen
 * @date 2020/8/14
 */
class ThriftClientConfigurationSelector : DeferredImportSelector, EnvironmentAware {
    private lateinit var environment: Environment
    val log = logger<ThriftClientConfigurationSelector>()

    companion object {
        //todo 统一管理
        const val SERVICE_MODEL = "spring.thrift.client.service-model"
        val SERVICE_MODEL_SET: Set<String> =
            hashSetOf("simple", "nonBlocking", "threadPool", "hsHa", "threadedSelector")
    }

    override fun setEnvironment(environment: Environment) {
        this.environment = environment
    }

    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        // 如果不包含
        if (!SERVICE_MODEL_SET.contains(environment.getProperty(SERVICE_MODEL))) {
            return arrayOf()
        }
        //todo
        val annotationAttributes = AnnotationAttributes.fromMap(
            importingClassMetadata.getAnnotationAttributes(EnableThriftClient::class.java.name)
        )

        return arrayOf(ThriftClientAutoConfiguration::class.java.name)
    }
}