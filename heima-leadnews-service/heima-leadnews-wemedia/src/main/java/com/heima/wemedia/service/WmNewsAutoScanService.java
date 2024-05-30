package com.heima.wemedia.service;

import org.springframework.scheduling.annotation.Async;

public interface WmNewsAutoScanService {

    /**
     * 自媒体文章审核
     * @param id  自媒体文章id
     */
    @Async
    public void autoScanWmNews(Integer id);
}