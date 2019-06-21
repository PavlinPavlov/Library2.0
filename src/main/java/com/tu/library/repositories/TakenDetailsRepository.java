package com.tu.library.repositories;

import com.tu.library.entity.TakenDetail;
import com.tu.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TakenDetailsRepository extends JpaRepository<TakenDetail, Long> {
    List<TakenDetail> findAll();

    List<TakenDetail> findAllByUser(User user);
}
