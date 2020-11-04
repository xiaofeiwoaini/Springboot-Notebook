package com.xiaofu.sharding.model;

import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;

public class TOrderItem {

    @TableId(value = "item_id")
    private Long itemId;

    //private Long orderId;

    private String orderNo;

    private String itemName;

    private BigDecimal price;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    //public Long getOrderId() {
    //    return orderId;
    //}
    //
    //public void setOrderId(Long orderId) {
    //    this.orderId = orderId;
    //}

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}