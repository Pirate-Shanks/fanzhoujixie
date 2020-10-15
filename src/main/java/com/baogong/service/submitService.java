package com.baogong.service;

import com.baogong.pojo.CompleteTable;
import com.baogong.pojo.Table;

public interface submitService {
    public int submit(Table table);
    public int updateTask(CompleteTable table);
}
