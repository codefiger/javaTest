package com.test.trade;

import java.util.List;

/**
 * Created by figer on 11/10/2016.
 */
public interface IOrderTransferService {
  List<TransferResult> transferOrderByChannelRecord(List<ChannelRecord> channelRecordList);
}
