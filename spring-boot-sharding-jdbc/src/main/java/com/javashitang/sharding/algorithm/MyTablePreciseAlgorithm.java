package com.javashitang.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @Author lilimin
 * @Date 2024/3/18
 */
public class MyTablePreciseAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        String orderCode = shardingValue.getValue();
        int length = orderCode.length();
        String year = orderCode.substring(length - 4);
        String tableName = shardingValue.getLogicTableName() + "_" + year;
        if (availableTargetNames.contains(tableName)) {
            return tableName;
        } else {
            throw new UnsupportedOperationException("找不到表名");
        }
    }
}