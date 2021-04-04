package com.guba.springbootcassandra.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class User {

    @PrimaryKey
    private Integer id;

    private String name;

    private String address;

    private Integer age;
}
