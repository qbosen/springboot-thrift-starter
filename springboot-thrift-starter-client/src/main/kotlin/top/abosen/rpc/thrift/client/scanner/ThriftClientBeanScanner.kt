package top.abosen.rpc.thrift.client.scanner

import org.apache.thrift.TServiceClient
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition
import org.springframework.beans.factory.config.BeanDefinitionHolder
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.beans.factory.support.GenericBeanDefinition
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.core.type.filter.AnnotationTypeFilter
import org.springframework.util.ClassUtils
import top.abosen.rpc.thrift.client.annotation.ThriftClient
import top.abosen.rpc.thrift.client.logger
import java.lang.reflect.ParameterizedType
import java.util.*

/**
 * @author qiubaisen
 * @date 2020/8/17
 */
class ThriftClientBeanScanner(registry: BeanDefinitionRegistry) : ClassPathBeanDefinitionScanner(registry) {

    override fun registerDefaultFilters() {
        this.addIncludeFilter(AnnotationTypeFilter(ThriftClient::class.java))
    }

    override fun isCandidateComponent(beanDefinition: AnnotatedBeanDefinition): Boolean {
        val metadata = beanDefinition.metadata
        return metadata.hasAnnotation(ThriftClient::class.java.name) && metadata.isInterface
    }

    override fun doScan(vararg basePackages: String?): MutableSet<BeanDefinitionHolder> {
        val definitionHolders = super.doScan(*basePackages)
        debug { "Packages scanned by thriftClientBeanDefinitionScanner is [${basePackages.joinToString(",")}]" }

        for (holder in definitionHolders) {
            val definition = holder.beanDefinition as GenericBeanDefinition
            debug { "Scanned and found thrift client, bean [${holder.beanName}] assigned from [${definition.beanClassName}]" }
            val beanClass = Class.forName(definition.beanClassName)
            val thriftClient = AnnotationUtils.findAnnotation(beanClass, ThriftClient::class.java) ?: continue
            val beanName = if (thriftClient.value.isNotBlank()) thriftClient.value else
                BeanDefinitionReaderUtils.uniqueBeanName(beanClass.name.decapitalize(), registry)

            with(definition.propertyValues){
                addPropertyValue(ThriftClientFactoryBean.BEAN_NAME, beanName)
                addPropertyValue(ThriftClientFactoryBean.BEAN_CLASS, beanClass)
                addPropertyValue(ThriftClientFactoryBean.BEAN_CLASS_NAME, beanClass.name)

            }
        }
        return definitionHolders
    }
    private fun getClientClassFromAnnotation(beanClass: Class<*>): Class<out TServiceClient> {
        val clientAwareType = beanClass.genericInterfaces[0] as ParameterizedType
        TODO()
    }

    companion object {
        private val log = logger()

        private inline fun debug(msg: () -> String) {
            if (log.isDebugEnabled) log.debug(msg())
        }
    }

}