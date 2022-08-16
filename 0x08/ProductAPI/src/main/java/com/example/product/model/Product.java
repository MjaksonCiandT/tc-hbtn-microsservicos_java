package com.example.product.model;

import java.util.Objects;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String description;
    private BigDecimal prica;
    private LocalDateTime createdOne;
    private Boolean status;

    public Product() {
    }

    public Product(Long id, String code, String name, String description, BigDecimal prica, LocalDateTime createdOne, Boolean status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.prica = prica;
        this.createdOne = createdOne;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrica() {
        return prica;
    }

    public void setPrica(BigDecimal prica) {
        this.prica = prica;
    }

    public LocalDateTime getCreatedOne() {
        return createdOne;
    }

    public void setCreatedOne(LocalDateTime createdOne) {
        this.createdOne = createdOne;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getId().equals(product.getId()) && getCode().equals(product.getCode()) && getName().equals(product.getName()) && getDescription().equals(product.getDescription()) && getPrica().equals(product.getPrica()) && getCreatedOne().equals(product.getCreatedOne()) && getStatus().equals(product.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getName(), getDescription(), getPrica(), getCreatedOne(), getStatus());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", prica=" + prica +
                ", createdOne=" + createdOne +
                ", status=" + status +
                '}';
    }
}
