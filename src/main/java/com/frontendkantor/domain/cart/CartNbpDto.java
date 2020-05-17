package com.frontendkantor.domain.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartNbpDto {
    private Long cartId;
    private String created;
    private Long userId;

    public CartNbpDto(String created) {
        this.created = created;
    }
}
