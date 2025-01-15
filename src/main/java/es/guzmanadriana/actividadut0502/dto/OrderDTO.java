package es.guzmanadriana.actividadut0502.dto;


import java.sql.Timestamp;

public class OrderDTO {
    private Integer orderId;
    private Double total;
    private Timestamp orderDate;

    public OrderDTO(Integer orderId, Double total, Timestamp orderDate) {
        this.orderId = orderId;
        this.total = total;
        this.orderDate = orderDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
}
