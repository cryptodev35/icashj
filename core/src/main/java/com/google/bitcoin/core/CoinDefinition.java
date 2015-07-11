package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "iCash";
    public static final String coinTicker = "ICASH";
    public static final String coinURIScheme = "icash";
    public static final String cryptsyMarketId = "0";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START = "[7X]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;


    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://blocktree.io/e/ICASH/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = BLOCKEXPLORER_BASE_URL_PROD;

    public static final String DONATION_ADDRESS = "Xdeh9YTLNtci5zSL4DDayRSVTLf299n9jv";  //Hash Engineering donation DASH address
    public static final String DONATION_ADDRESS_TESTNET = "";  //Hash Engineering donation DASH address

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(24 * 60 * 60);  // 24 hours per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(2.5 * 60);  // 2.5 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //36 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static final BigInteger MAX_MONEY = BigInteger.valueOf(22000000).multiply(Utils.COIN);                 //main.h:  MAX_MONEY
    //public static final String MAX_MONEY_STRING = "200000000";     //main.h:  MAX_MONEY

    public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(100000);   // MIN_TX_FEE
    public static final BigInteger DUST_LIMIT = BigInteger.valueOf(1000); //main.h CTransaction::GetMinFee        0.01 coins

    public static final int PROTOCOL_VERSION = 70075;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70066;        //version.h MIN_PROTO_VERSION
    public static final int BIP0031_VERSION = 60000;

    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 5555;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 15555;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 102;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 21;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final boolean allowBitcoinPrivateKey = false; //for backward compatibility with previous version of digitalcoin
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long oldPacketMagic = 0xfbc0b6db;      //0xfb, 0xc0, 0xb6, 0xdb
    public static final long PacketMagic = 0xbf0c6bbd;

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1426791863L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (935108);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "000006a63aa14e3e92326794b94a80fe35363b08dba7a5739c72abca50325e7c"; //main.cpp: hashGenesisBlock
    static public String genesisMerkleRoot = "a0a667925ae1db124b7edc3c15867fca166f1d02cb8112ca1bfa88b98e7ac4dc";
    static public int genesisBlockValue = 50;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "04ffff001d01044c504920446f6ee28099742057616e7420546f2042656c6f6e6720546f20416e7920436c756220546861742057696c6c204163636570742050656f706c65204c696b65204d652041732041204d656d626572";   //"limecoin se convertira en una de las monedas mas segura del mercado, checa nuestros avances"
    static public String genesisTxOutBytes = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "198.52.227.176",
            "198.52.227.174",
    };

    public static int minBroadcastConnections = 0;   //0 for default; we need more peers.

    //
    // TestNet - dimecoin - not tested
    //
    public static final boolean supportsTestNet = true;
    public static final int testnetAddressHeader = 139;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 19;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xcee2caff;      //
    public static final String testnetGenesisHash = "000006a63aa14e3e92326794b94a80fe35363b08dba7a5739c72abca50325e7c";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1426791863L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (935108L);                         //main.cpp: LoadBlockIndex





    //main.cpp GetBlockValue(height, fee)
    public static final BigInteger GetBlockReward(int height)
    {
        int COIN = 1;
        BigInteger nSubsidy = Utils.toNanoCoins(100, 0);
        if (height == 1)
            nSubsidy = Utils.toNanoCoins(420000, 0);
        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 4730400;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
            "testnet-seed.icash.io",
            "testnet-seed.icash.qa",
            "23.23.186.131"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "048240a8748a80a286b270ba126705ced4f2ce5a7847b3610ea3c06513150dade2a8512ed5ea86320824683fc0818f0ac019214973e677acd1244f6d0571fc5103";
    public static final String TESTNET_SATOSHI_KEY = "04517d8a699cb43d3938d7b24faaff7cda448ca4ea267723ba614784de661949bf632d6304316b244646dea079735b9a6fc4af804efb4752075b9fe2245e14e412";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.icash.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.icash.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.icash.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {

        checkpoints.put(  0, new Sha256Hash("000006a63aa14e3e92326794b94a80fe35363b08dba7a5739c72abca50325e7"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "iMhA7G2sC6txUpGoxEqHRLVHtAWMMggoNm";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "XHWZACiujAkH3Mac68914qPGLBhtP6kNf2KtazWQKoUj5WHF7XJp";

}
