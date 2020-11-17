package com.miluyas.killer0.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.miluyas.killer0.entity.Book;
import com.miluyas.killer0.entity.Catalog;
import com.miluyas.killer0.mapper.BookMapper;
import com.miluyas.killer0.mapper.CatalogMapper;
import com.miluyas.killer0.service.BookService;
import com.miluyas.killer0.vo.BookVO;
import com.miluyas.killer0.vo.DataVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public DataVO<BookVO> findData() {
        DataVO dataVO=new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(bookMapper.selectCount(null));//返回所有数据，null为无条件

        List<Book> bookList=bookMapper.selectList(null);
        List<BookVO> bookVOList=new ArrayList<>();
        for(Book book : bookList){
            BookVO bookVO=new BookVO();
            BeanUtils.copyProperties(book,bookVO);//将book实例里的数据給VO空壳
            QueryWrapper wrapper= new QueryWrapper();
            wrapper.eq("catalog_id",book.getCategoryleveloneId());

            Catalog catalog=catalogMapper.selectOne(wrapper);
            if(catalog!=null){
                bookVO.setCategorylevelone(catalog.getCatalogName());

            }

            wrapper= new QueryWrapper();
            wrapper.eq("catalog_id",book.getCategoryleveltwoId());

            catalog=catalogMapper.selectOne(wrapper);
            if(catalog!=null){
                bookVO.setCategoryleveltwo(catalog.getCatalogName());

            }

            bookVOList.add(bookVO);

        }
        dataVO.setData(bookVOList);
//        return bookVOList;
        return dataVO;
    }
}
