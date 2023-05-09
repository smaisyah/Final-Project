package id.co.mii.sima.serverapp.models.dto.requests;

import java.util.Map;

import lombok.Data;

@Data
public class EmailRequest {
    // private String from;
    private String to;
    private String subject;
    private String body;
    private String attach;

    private Map<String, Object> map;
}
