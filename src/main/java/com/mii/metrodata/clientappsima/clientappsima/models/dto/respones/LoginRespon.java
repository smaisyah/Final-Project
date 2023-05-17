package com.mii.metrodata.clientappsima.clientappsima.models.dto.respones;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRespon {

    private String username;
    private String email;
    private List<String> authorities;

}
