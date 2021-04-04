package com.guba.springbootcassandra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @PrimaryKey
    private Integer id;

    private String name;

    private String address;

    private Integer age;
}
