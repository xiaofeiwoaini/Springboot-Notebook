package com.xiaofu.sharding.model;

import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;

public class TOrder {

    @TableId(value = "order_id")
    private Long orderId;

    //private Long userId;

    private String orderNo;

    private String createName;

    private BigDecimal price;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    //public Long getUserId() {
    //    return userId;
    //}
    //
    //public void setUserId(Long userId) {
    //    this.userId = userId;
    //}

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TOrder{" +
                "orderId=" + orderId +
                ", orderNo='" + orderNo + '\'' +
                ", createName='" + createName + '\'' +
                ", price=" + price +
                '}';
    }
}