package com.test.trade.domain;

import java.util.EnumSet;

/**
 * Created by figer on 12/10/2016.
 */
public enum OrderCommonStatus {
  canceled,
  submit_failure,
  confirm_failure,
  confirm_success,

  //fax
  fax_created,
  fax_canceling,
  fax_processing,
  fax_confirming,
  fax_reserved_1,
  fax_reserved_2,
  fax_reserved_3,
  fax_reserved_4,
  fax_reserved_5,


  //p2p

  ;

  public EnumSet<OrderCommonStatus> getFinalStatusSet(){
    return EnumSet.of(canceled, submit_failure, confirm_failure, confirm_success);
  }

  public boolean isFinalStatus(OrderCommonStatus status){
    return getFinalStatusSet().contains(status);
  }

}
