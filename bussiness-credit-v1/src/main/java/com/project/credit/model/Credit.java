package com.project.credit.model;

import com.project.credit.internal.BaseModel;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "Credit")
public class Credit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private double mount;
    private int fee; //cuotas
    private BaseModel type;
    private String outlay_date;
}
