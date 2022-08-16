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
    private String name;
    private String description;
    private BigDecimal prica;
    private LocalDateTime createdOne;
    private Boolean status;

    public Product() {
    }

    public Product(Long id, String name, String description, BigDecimal prica, LocalDateTime createdOne, Boolean status) {
        this.id = id;
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
        return Objects.equals(getId(), product.getId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getPrica(), product.getPrica()) && Objects.equals(getCreatedOne(), product.getCreatedOne()) && Objects.equals(getStatus(), product.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrica(), getCreatedOne(), getStatus());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", prica=" + prica +
                ", createdOne=" + createdOne +
                ", status=" + status +
                '}';
    }
}
