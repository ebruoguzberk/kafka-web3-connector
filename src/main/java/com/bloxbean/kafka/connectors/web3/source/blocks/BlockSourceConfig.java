package com.bloxbean.kafka.connectors.web3.source.blocks;

import com.bloxbean.kafka.connectors.web3.util.StringUtil;
import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.*;

import static com.bloxbean.kafka.connectors.web3.util.ConfigConstants.*;

public class BlockSourceConfig extends AbstractConfig {

    public BlockSourceConfig(ConfigDef config, Map<String, String> parsedConfig) {
        super(config, parsedConfig);
    }

    public BlockSourceConfig(Map<String, String> parsedConfig) {
        this(conf(), parsedConfig);
    }

    public static ConfigDef conf() {
        final ConfigDef configDef = new ConfigDef();
        configDef.define(WEB3_RPC_URL, ConfigDef.Type.STRING, "http://localhost:8545", ConfigDef.Importance.HIGH, "Web3 rpc address (http://<host>:<port>)");
        configDef.define(TOPIC, ConfigDef.Type.STRING, "", ConfigDef.Importance.HIGH, "Destination topic for Blocks");
        configDef.define(TRANSACTION_TOPIC, ConfigDef.Type.STRING, "", ConfigDef.Importance.HIGH, "Destination topic for Transactions");
        configDef.define(START_BLOCK, ConfigDef.Type.LONG, 0, ConfigDef.Importance.HIGH, "Start Block Number");
        configDef.define(BLOCK_TIME_IN_SEC, ConfigDef.Type.INT, 10, ConfigDef.Importance.HIGH, "Block time in sec");
        configDef.define(NO_BLOCKS_FOR_FINALITY, ConfigDef.Type.INT, 0, ConfigDef.Importance.HIGH, "No of blocks to wait for finality");
        configDef.define(CHAIN_NAME, ConfigDef.Type.STRING, "", ConfigDef.Importance.HIGH, "SKALE Chain Name will be used as high watermark in topic");

        configDef.define(IGNORE_BLOCK_FIELDS, ConfigDef.Type.LIST, IGNORE_BLOCK_FIELDS,
                ConfigDef.Importance.HIGH,
                "Comma separated list of block fields to exclude");
        configDef.define(IGNORE_TRANSACTION_FILEDS, ConfigDef.Type.LIST, IGNORE_TRANSACTION_FILEDS,
                ConfigDef.Importance.HIGH,
                "Comma separated list of transaction fields to exclude");

        return configDef;
    }

    public String getWeb3RpcUrl() {
        return getString(WEB3_RPC_URL);
    }

    public String getTopic() {
        return getString(TOPIC);
    }

    public String getTrasactionTopic() {
        return getString(TRANSACTION_TOPIC);
    }

    public boolean isSeparateTransactionTopic() {
        if(!StringUtil.isEmpty(getTrasactionTopic()))
            return true;
        else
            return false;
    }

    public long getStartBlock() {
        return getLong(START_BLOCK);
    }

    public int getBlockTime() {
        return getInt(BLOCK_TIME_IN_SEC);
    }

    public int getNoBlocksForFinality() {
        return getInt(NO_BLOCKS_FOR_FINALITY);
    }

    public Set<String> getIgnoreBlockFields() {
        List<String> keys = getList(IGNORE_BLOCK_FIELDS);
        if(keys != null && !keys.isEmpty())
            return new HashSet(keys);
        else
            return Collections.EMPTY_SET;
    }

    public Set<String> getIgnoreTransactionFields() {
        List<String> keys = getList(IGNORE_TRANSACTION_FILEDS);
        if(keys != null && !keys.isEmpty())
            return new HashSet<>(keys);
        else
            return Collections.EMPTY_SET;
    }

    public String getChainName() {
        return getString(CHAIN_NAME);
    }
}
