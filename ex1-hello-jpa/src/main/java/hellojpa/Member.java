package hellojpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//@Entity
@Setter
@Getter
//@SequenceGenerator(name = "member_sequence_gen",sequenceName = "member_seq", initialValue = 1, allocationSize = 1)
@TableGenerator(name = "member_seq_gen",table = "min_sequences", pkColumnValue = "member_seq", allocationSize = 1)

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_sequence_gen")
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "member_seq_gen")
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
