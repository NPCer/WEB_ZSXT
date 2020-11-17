package com.miluyas.killer0.service;

import com.miluyas.killer0.vo.BookVO;
import com.miluyas.killer0.vo.DataVO;

public interface BookService {
    public DataVO<BookVO> findData();
}
