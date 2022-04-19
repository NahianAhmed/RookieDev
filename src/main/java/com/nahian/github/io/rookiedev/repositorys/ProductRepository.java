package com.nahian.github.io.rookiedev.repositorys;

import com.nahian.github.io.rookiedev.models.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}
