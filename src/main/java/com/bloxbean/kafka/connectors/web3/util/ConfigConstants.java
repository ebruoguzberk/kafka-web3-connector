package com.bloxbean.kafka.connectors.web3.util;

/**
 * Declares various reusable constants
 */
public final class ConfigConstants {
    public static final String VERSION = "0.1";

    public static final String WEB3_RPC_URL = "web3_rpc_url";
    public static final String TOPIC = "topic";
    public static final String TRANSACTION_TOPIC = "transaction_topic";
    public static final String START_BLOCK = "start_block";
    public static final String BLOCK_TIME_IN_SEC = "block_time";
    public static final String NO_BLOCKS_FOR_FINALITY="no_of_blocks_for_finality";
    public static final String CHAIN_NAME = "chain_name";
    public static final String RESET = "reset";

    public static final String LAST_FETCHED_BLOCK_NUMBER = "last_fetched_block_number";

    public static final String IGNORE_BLOCK_FIELDS = "ignore_block_fields";
    public static final String IGNORE_TRANSACTION_FILEDS = "ignore_transaction_fields";

    //EventsSourceConnector properties
    public static final String EVENT_LOGS_FILTER_ADDRESSES = "event_logs_filter_addresses";
    public static final String EVENT_LOGS_FILTER_TOPICS = "event_logs_filter_topics";
    public static final String EVENT_LOGS_KAFKA_KEYS = "event_logs_kafka_keys"; //Comma separated value. Options: blockNumber, logIndex, address, topic, transactonHash, transactionIndex
}
