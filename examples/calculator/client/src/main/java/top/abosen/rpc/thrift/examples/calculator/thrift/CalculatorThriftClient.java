package top.abosen.rpc.thrift.examples.calculator.thrift;

import top.abosen.rpc.thrift.client.annotation.ThriftClient;
import top.abosen.rpc.thrift.client.common.ThriftClientAware;
import top.abosen.rpc.thrift.examples.calculator.tutorial.Calculator;

/**
 * @author qiubaisen
 * @date 2020/8/17
 */
@ThriftClient
public interface CalculatorThriftClient extends ThriftClientAware<Calculator.Client> {
}
