package com.egoist.oniontool.dao.elasticsearch;

import com.egoist.oniontool.pojo.elasticsearch.ThridPlatformLogDetailDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ThirdPlatformLogRepository extends ElasticsearchRepository<ThridPlatformLogDetailDoc, Long> {
}
