package com.trading.dashboard.dashboard.pojos.Ltp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true, chain = true)
@Builder
public class LtpList implements Serializable {

    private static final Long serialVersionUID = 1L;

    @JsonProperty("ltp_list")
    private List<LtpDto> ltpDtoList;
}
