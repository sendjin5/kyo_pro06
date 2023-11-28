package com.pro06.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "User")
@Getter @Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;

    @Column(unique = true)
    private String id;
    private String pw;
    private String name;
    private String tel;
    private String email;
    private String addr1;
    private String addr2;
    private String postcode;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User createuser(PasswordEncoder passwordEncoder){
        User user = new User();
                user.setId(user.getId());
                user.setName(user.getName());
                user.setTel(user.getTel());
                user.setEmail(user.getEmail());
                user.setAddr1(user.getAddr1());
                user.setAddr2(user.getAddr2());
                user.setPostcode(user.getPostcode());
                user.setStatus(Status.ACTIVE);
                user.setRole(Role.USER);
                String ppw = passwordEncoder.encode(user.getPw());
                user.setPw(ppw);
                return user;

    }

}
