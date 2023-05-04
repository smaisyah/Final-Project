package id.co.mii.sima.serverapp.models.dto.requests;

import lombok.Data;

@Data
public class EmailRequest {
    private String name;
    // private String from;
    private String to;
    private String subject;
    private String body;
    private String attach;
}
