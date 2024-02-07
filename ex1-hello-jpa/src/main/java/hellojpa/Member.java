package hellojpa;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@SequenceGenerator(name = "member_sequence_gen",sequenceName = "member_seq", initialValue = 1, allocationSize = 1)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_sequence_gen")
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
