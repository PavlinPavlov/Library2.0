package com.tu.library.services;

import com.tu.library.entity.TakenDetail;
import com.tu.library.entity.User;
import com.tu.library.repositories.TakenDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TakenDetailsService {

    @Autowired
    private TakenDetailsRepository takenDetailsRepo;

    public List<TakenDetail> findAll() {
        return takenDetailsRepo.findAll();
    }

    public List<TakenDetail> findAllByUser(User user) {
        return takenDetailsRepo.findAllByUser(user);
    }
}
