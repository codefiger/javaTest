package com.figer.tools.shanbay;

/**
 * Created by figer on 20/11/2016.
 */
public class CreateWordListResp {
  private String msg;
  private String status_code;
  private Data data;

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getStatus_code() {
    return status_code;
  }

  public void setStatus_code(String status_code) {
    this.status_code = status_code;
  }

  public Data getData() {
    return data;
  }

  public void setData(Data data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "CreateWordListResp{" +
        "msg='" + msg + '\'' +
        ", status_code='" + status_code + '\'' +
        ", data=" + data +
        '}';
  }
}
