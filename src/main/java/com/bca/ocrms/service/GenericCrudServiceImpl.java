package com.bca.ocrms.service;

import java.util.List;

public interface GenericCrudServiceImpl<D, ID>{
        D save(D d);
        List<D> findAll();
        D findById(ID id);
        void deleteById(ID id);
}
