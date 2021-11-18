package com.example.docker_demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * hello
 *
 * @Author cwr
 */
@Entity
@Table(name = "hello")
@Data
@NoArgsConstructor
public class HelloEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long            id;

    private String          name;
}
