package com.myapplication.xt.service.Imp1;

import com.myapplication.xt.entity.Xt_canteen_rsv;
import com.myapplication.xt.respository.Xt_canteen_rsvRepository;
import com.myapplication.xt.service.Xt_canteen_rsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Xt_canteen_rsvServiceImp1 implements Xt_canteen_rsvService {

    @Autowired
    private Xt_canteen_rsvRepository xt_canteen_rsvRepository;

    @Override
    public boolean saveOrUpdate(Xt_canteen_rsv xt_canteen_rsv) {
        try {
            xt_canteen_rsvRepository.save(xt_canteen_rsv);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public Xt_canteen_rsv getById(Long id) {
        return xt_canteen_rsvRepository.findById(id).get();
    }

    @Override
    public boolean delete(Long id) {
        try {
            xt_canteen_rsvRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public Xt_canteen_rsv getXt_canteen_rsv(Long id) {
        return xt_canteen_rsvRepository.getOne(id);
    }

    @Override
    public List<Xt_canteen_rsv> getAll() {
        return xt_canteen_rsvRepository.findAll();
    }
}