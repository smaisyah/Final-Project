package id.co.mii.sima.serverapp.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "submition_id", nullable = false)
    private Submition submition;

    @Column(name = "return_date", nullable = false)
    private Date returnDate;

    @Column(name = "status", nullable = false)
    private String status;
}
