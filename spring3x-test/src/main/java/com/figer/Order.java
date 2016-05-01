package com.figer;

public class Order {

  //订单状态，将三组订单状态用这个值后三位表示
  private byte status = 0x00;

  //付款
  public void pay() {
    this.status |= Status.已付款.getValue();
  }

  //发货
  public void send() {
    this.status |= Status.已发货.getValue();
  }

  //签收
  public void receive() {
    this.status |= Status.已签收.getValue();
  }

  //获取已付款状态
  public boolean hasPaid() {
    return (this.status & Status.已付款.getValue()) > 0;
  }

  //获取已发货状态
  public boolean hasSent() {
    return (this.status & Status.已发货.getValue()) > 0;
  }

  //获取已签收状态
  public boolean hasReceived() {
    return (this.status & Status.已签收.getValue()) > 0;
  }

  //main()
  public static void main(String args[]) {

    Order order = new Order();
    order.send();

    System.out.println(order.hasPaid());
    System.out.println(order.hasSent());
    System.out.println(order.hasReceived());
  }
}

//订单状态枚举类
enum Status {

  已付款((byte)0x01),
  已发货((byte)0x02),
  已签收((byte)0x04);

  private Status(byte b) {
    this.value = b;
  }

  private byte value;

  public byte getValue() {
    return value;
  }

}