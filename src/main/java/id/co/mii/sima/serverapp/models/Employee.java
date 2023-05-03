package id.co.mii.sima.serverapp.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @OneToOne(mappedBy = "employee")
    private User user;

    @Column(name = "nip", nullable = false)
    private Integer nip;

    @Column(name = "employee_name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "phone_number", nullable = false)
    private Integer phone;

    @Column(name = "address", nullable = false)
    private String anddress;

    @Column(name = "manager_id", nullable = false, insertable = false, updatable = false)
    private Integer managerId;
    
    @OneToMany(mappedBy = "manager")
    private List<Employee> subordinates;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", nullable = false)
    private Department department;
}
