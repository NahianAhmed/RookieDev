package com.nahian.github.io.rookiedev.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
}
