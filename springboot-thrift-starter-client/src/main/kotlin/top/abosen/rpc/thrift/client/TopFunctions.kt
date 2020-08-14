package top.abosen.rpc.thrift.client

import org.slf4j.LoggerFactory

/**
 * @author qiubaisen
 * @date 2020/8/14
 */
internal inline fun <reified T : Any> logger() = LoggerFactory.getLogger(T::class.java)!!

