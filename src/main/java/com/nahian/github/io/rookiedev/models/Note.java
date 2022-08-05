package com.nahian.github.io.rookiedev.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notes")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Note  implements Serializable {

    private static final long serialVersionUID = 7842270156250203363L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String note;

}
