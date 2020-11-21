package com.myapplication.xt.respository;

import com.myapplication.xt.entity.Xt_canteen_rsv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Xt_canteen_rsvRepository extends JpaRepository<Xt_canteen_rsv,Long>, JpaSpecificationExecutor<Xt_canteen_rsv> {
}