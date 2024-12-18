package com.fpoly.myspringbootapp.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "bill", schema = "finalweb10", catalog = "")
public class BillEntity {
    private int id;
    private Date buyDate;
    private Integer priceTotal;
    private UserEntity userByBuyerId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "buy_date", nullable = true)
    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    @Basic
    @Column(name = "price_total", nullable = true)
    public Integer getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Integer priceTotal) {
        this.priceTotal = priceTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillEntity that = (BillEntity) o;
        return id == that.id && Objects.equals(buyDate, that.buyDate) && Objects.equals(priceTotal, that.priceTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, buyDate, priceTotal);
    }

    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    public UserEntity getUserByBuyerId() {
        return userByBuyerId;
    }

    public void setUserByBuyerId(UserEntity userByBuyerId) {
        this.userByBuyerId = userByBuyerId;
    }
}
