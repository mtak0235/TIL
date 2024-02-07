package hellojpa;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDatae;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;
    public Member() {
    }

}
