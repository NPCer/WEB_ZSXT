package com.myapplication.xt.service;

import com.myapplication.xt.entity.Xt_canteen_rsv;

import java.util.List;


public interface Xt_canteen_rsvService {
    public boolean saveOrUpdate(Xt_canteen_rsv xt_canteen_rsv);
    public Xt_canteen_rsv getById(Long id);
    public boolean delete(Long id);
    public Xt_canteen_rsv getXt_canteen_rsv(Long id);
    public List<Xt_canteen_rsv> getAll();
}