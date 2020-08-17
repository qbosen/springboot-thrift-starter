package top.abosen.rpc.thrift.client

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.Configuration
import top.abosen.rpc.thrift.client.properties.ThriftClientProperties
import top.abosen.rpc.thrift.client.properties.ThriftClientPropertiesCondition
import top.abosen.rpc.thrift.client.scanner.ThriftClientBeanScanProcessor

/**
 * @author qiubaisen
 * @date 2020/8/14
 */

@Configuration
@Conditional(ThriftClientPropertiesCondition::class)
@EnableConfigurationProperties(ThriftClientProperties::class)
class ThriftClientAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    fun clientBeanPostProcessor() = ThriftClientBeanPostProcessor()

    @Bean
    @ConditionalOnMissingBean
    fun clientBeanScanProcessor() = ThriftClientBeanScanProcessor()

}