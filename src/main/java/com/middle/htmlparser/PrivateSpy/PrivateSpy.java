package com.middle.htmlparser.PrivateSpy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.RestController;


@Setter @Getter @ToString
@RestController
@Table @Entity
public class PrivateSpy {
    @Id
    @GeneratedValue
    private int id;

    private String twitterUrl;
    private String facebookUrl;
    private String address;
}
