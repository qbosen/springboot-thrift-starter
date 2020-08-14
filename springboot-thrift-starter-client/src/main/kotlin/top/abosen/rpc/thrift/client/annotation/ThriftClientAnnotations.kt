package top.abosen.rpc.thrift.client.annotation


import org.springframework.context.annotation.Import
import java.lang.annotation.Inherited

/**
 * @author qiubaisen
 * @date 2020/8/14
 */

@Target(AnnotationTarget.CLASS)
@Retention
@Inherited
annotation class ThriftClient(val serviceId: String, val version: Double = 1.0)

@Inherited
@Retention
@Import(ThriftClientConfigurationSelector::class)
annotation class EnableThriftClient