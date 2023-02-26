package com.nsoft.offers.streams.kafka;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

public class EvenOddPartitioner implements Partitioner {
	
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        int partition;
        try {
            partition = Integer.parseInt(key.toString()) % 2;
        } catch (NumberFormatException e) {
            partition = 0;
        }
        return partition;
    }

    @Override
    public void close() {}

    @Override
    public void configure(Map<String, ?> configs) {}
}
