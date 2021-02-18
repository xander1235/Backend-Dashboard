package com.trading.dashboard.dashboard.pojos.Ltp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(fluent = true, chain = true)
public class LtpDto implements Serializable {

    private static final Long serialVersionUID = 1L;

    @NotNull(message = "ltp must no be null")
    @JsonProperty("ltp")
    private Float ltp;

    private Date time;

    @NotEmpty(message = "name must not be blank")
    @JsonProperty("name")
    private String name;

    @NotEmpty(message = "type must not be blank")
    @JsonProperty("type")
    private String type;

    @JsonProperty("mark")
    private boolean mark;
}
