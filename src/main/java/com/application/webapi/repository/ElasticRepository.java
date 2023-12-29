package com.application.webapi.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.application.webapi.model.Dokumen;

import org.springframework.stereotype.Repository;
@Repository
public interface ElasticRepository extends ElasticsearchRepository<Dokumen, String> {
}