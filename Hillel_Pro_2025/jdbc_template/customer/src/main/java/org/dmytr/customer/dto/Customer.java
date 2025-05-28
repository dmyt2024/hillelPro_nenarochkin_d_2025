package org.dmytr.customer.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer {

    private int id;
    private String fullName;
    private String email;
    private int socialSecurityNumber;
}
