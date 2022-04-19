package com.nahian.github.io.rookiedev.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1932406270459127683L;

    @Id
    private String id;
    private String name;
    private String description;
    private Double price;
}
