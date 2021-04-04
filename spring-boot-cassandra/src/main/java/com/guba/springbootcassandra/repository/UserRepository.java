package com.guba.springbootcassandra.repository;

import com.guba.springbootcassandra.model.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CassandraRepository<User, Integer> {

    @AllowFiltering
    List<User> findByAgeGreaterThan(Integer age);
}
