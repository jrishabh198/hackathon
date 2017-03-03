package com.example.rj.socius;
import android.net.TrafficStats;
/**
 * Created by shivam on 3/3/17.
 */

public class TrafficManager {

    private static long TOTAL_RX_BYTES;
    private static long TOTAL_TX_BYTES;
    private static long DATA_RX_BYTES;
    private static long DATA_TX_BYTES;
    private static long TOTAL_DATA_BYTES;
    private static long TOTAL_BYTES;

    public static void updateTotalDataUsage(){
        TOTAL_RX_BYTES = TrafficStats.getTotalRxBytes();
        TOTAL_TX_BYTES = TrafficStats.getTotalTxBytes();
        TOTAL_BYTES = TOTAL_RX_BYTES + TOTAL_TX_BYTES;
        DATA_RX_BYTES = TrafficStats.getMobileRxBytes();
        DATA_TX_BYTES = TrafficStats.getTotalTxBytes();
        TOTAL_DATA_BYTES = DATA_RX_BYTES + DATA_TX_BYTES;
    }

    public static long getTotalBytesTillNow(){
        return TrafficStats.getTotalRxBytes()+TrafficStats.getTotalTxBytes();
    }

    public static long getTotalBytesTillUpdate(){
        return TOTAL_BYTES;
    }

    public static long getTotalDataBytesTillNow(){
        return TrafficStats.getMobileRxBytes()+TrafficStats.getMobileTxBytes();
    }

    public static long getTotalMobileBytesTillUpdate(){
        return TOTAL_DATA_BYTES;
    }

    public static long getTotalWifiBytesTillNow(){
        return getTotalBytesTillNow()-getTotalDataBytesTillNow();
    }

    public static long getTotalWifiBytesTillUpdate(){
        return getTotalBytesTillUpdate()-getTotalBytesTillUpdate();
    }

    public static long getTotalUsedbytes(){
        return getTotalBytesTillNow()-getTotalBytesTillUpdate();
    }


}
