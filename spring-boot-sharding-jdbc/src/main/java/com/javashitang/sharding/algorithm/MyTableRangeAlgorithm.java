package com.javashitang.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Author lilimin
 * @Date 2024/3/18
 */
public class MyTableRangeAlgorithm implements RangeShardingAlgorithm<String> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        String logicTableName = shardingValue.getLogicTableName();
        return Arrays.asList(logicTableName + "_2013", logicTableName + "_2014");
    }
}