package org.sid.modelsisspringbootfullstack.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder

public class ProdcutType {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "prodcutType", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> productList;
}
