package com.project.credit.internal;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditAddRequest {
    @Nullable
    private String id;

    @Valid
    @NotNull
    private double mount;

    @Valid
    @NotNull
    private int fee;

    @Nullable
    private BaseModel type;

    @Valid
    @NotNull
    private String outlay_date;
}
