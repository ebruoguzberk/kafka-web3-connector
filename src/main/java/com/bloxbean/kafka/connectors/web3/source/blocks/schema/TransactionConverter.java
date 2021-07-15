package com.bloxbean.kafka.connectors.web3.source.blocks.schema;

import kong.unirest.json.JSONObject;
import org.apache.kafka.connect.data.Struct;

import java.util.Set;

import static com.bloxbean.kafka.connectors.web3.source.blocks.schema.TransactionSchema.*;
import static com.bloxbean.kafka.connectors.web3.util.HexConverter.hexToBigIntegerStr;

public class TransactionConverter {

    public static Struct convertFromJSON(String blockHash, JSONObject txnJson, Set<String> ignoredFields,  String timestamp,String chainName) {
        Struct txnStruct = new Struct(SCHEMA);

        if (!ignoredFields.contains(BLOCK_HASH))
            txnStruct.put(BLOCK_HASH, blockHash);
        if (!ignoredFields.contains(BLOCK_NUMBER))
            txnStruct.put(BLOCK_NUMBER, hexToBigIntegerStr(txnJson.optString(BLOCK_NUMBER)));
        if (!ignoredFields.contains(FROM))
            txnStruct.put(FROM, txnJson.optString(FROM));
        if (!ignoredFields.contains(TO))
            txnStruct.put(TO, txnJson.optString(TO));
        if (!ignoredFields.contains(NRG))
            txnStruct.put(NRG, hexToBigIntegerStr(txnJson.optString(NRG)));
        if (!ignoredFields.contains(NRG_PRICE))
            txnStruct.put(NRG_PRICE, hexToBigIntegerStr(txnJson.optString(NRG_PRICE)));
        if (!ignoredFields.contains(GAS))
            txnStruct.put(GAS, hexToBigIntegerStr(txnJson.optString(GAS)));
        if (!ignoredFields.contains(GAS_PRICE))
            txnStruct.put(GAS_PRICE, hexToBigIntegerStr(txnJson.optString(GAS_PRICE)));
        if (!ignoredFields.contains(HASH))
            txnStruct.put(HASH, txnJson.optString(HASH));

        if (!ignoredFields.contains(INPUT))
            txnStruct.put(INPUT, txnJson.optString(INPUT));

        if (!ignoredFields.contains(NONCE))
            txnStruct.put(NONCE, hexToBigIntegerStr(txnJson.optString(NONCE)));
        if (!ignoredFields.contains(TRANSACTION_INDEX))
            txnStruct.put(TRANSACTION_INDEX, hexToBigIntegerStr(txnJson.optString(TRANSACTION_INDEX)));
        if (!ignoredFields.contains(VALUE))
            txnStruct.put(VALUE, hexToBigIntegerStr(txnJson.optString(VALUE)));
        if (!ignoredFields.contains(TIMESTAMP))
            if (hexToBigIntegerStr(txnJson.optString(TIMESTAMP)).equals("")) {
                txnStruct.put(TIMESTAMP, timestamp);
            } else {
                txnStruct.put(TIMESTAMP, hexToBigIntegerStr(txnJson.optString(TIMESTAMP)));
            }

        if (!ignoredFields.contains(V))
            txnStruct.put(V, txnJson.optString(V));
        if (!ignoredFields.contains(R))
            txnStruct.put(R, txnJson.optString(R));
        if (!ignoredFields.contains(S))
            txnStruct.put(S, txnJson.optString(S));
        if (!ignoredFields.contains(CHAIN_NAME))
            txnStruct.put(CHAIN_NAME, chainName);
        return txnStruct;
    }
}
