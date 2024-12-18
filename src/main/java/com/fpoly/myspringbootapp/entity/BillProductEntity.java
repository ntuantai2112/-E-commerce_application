package com.fpoly.myspringbootapp.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "bill_product", schema = "finalweb10", catalog = "")
public class BillProductEntity {
    private int id;
    private Integer quantity;
    private Integer unitPrice;
    private ProductEntity productByProductId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quantity", nullable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "unit_price", nullable = true)
    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillProductEntity that = (BillProductEntity) o;
        return id == that.id && Objects.equals(quantity, that.quantity) && Objects.equals(unitPrice, that.unitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, unitPrice);
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }
}
