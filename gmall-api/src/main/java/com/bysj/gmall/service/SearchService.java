package com.bysj.gmall.service;

import com.bysj.gmall.bean.PmsSearchParam;
import com.bysj.gmall.bean.PmsSearchSkuInfo;

import java.io.IOException;
import java.util.List;

public interface SearchService {
    List<PmsSearchSkuInfo> list(PmsSearchParam pmsSearchParam) throws IOException;
}
