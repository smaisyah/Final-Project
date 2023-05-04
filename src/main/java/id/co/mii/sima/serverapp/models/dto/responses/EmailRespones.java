package id.co.mii.sima.serverapp.models.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRespones {
    private String message;
    private boolean status;
}
