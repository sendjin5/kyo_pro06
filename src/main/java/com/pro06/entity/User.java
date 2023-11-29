package com.pro06.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
@ToString
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;

    @Column(unique = true)
    private String id;
    private String pw;
    private String name;
    @Column(nullable = true)
    private String tel;
    @Column(nullable = true)
    private String email;
    @Column(nullable = true)
    private String addr1;
    @Column(nullable = true)
    private String addr2;
    @Column(nullable = true)
    private String postcode;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static User createuser(User user){
                user.setId(user.getId());
                user.setName(user.getName());
                user.setTel(user.getTel());
                user.setEmail(user.getEmail());
                user.setAddr1(user.getAddr1());
                user.setAddr2(user.getAddr2());
                user.setPostcode(user.getPostcode());
                user.setStatus(Status.ACTIVE);
                user.setRole(Role.USER);
                user.setPw(user.getPw());
                return user;

    }

}
