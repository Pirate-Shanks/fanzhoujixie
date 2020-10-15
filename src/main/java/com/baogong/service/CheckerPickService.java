package com.baogong.service;

import com.baogong.pojo.CheckerPick;
import com.baogong.pojo.CompleteTable;

import java.util.List;

public interface CheckerPickService {

        public List<CompleteTable> checkerFindOwnTask(CheckerPick checkerPick);
        public int checkerFindOwnTaskPages(CheckerPick checkerPick);

   public List<String> findMyOwnSection(String user_id);

    List<CompleteTable> queryDataByOwnWorkSection(CheckerPick checkerPick );
    public int queryDataByOwnWorkSectionPages(CheckerPick checkerPick);

   public  int managerCheckerPickPages(CheckerPick checkerPick);

   public List<CompleteTable> managerCheckerPickData(CheckerPick checkerPick);

    public int weChatCheckerPickTaskSize(CheckerPick checkerPick);
}
