package ru.praktikum.stellarburgers.nomoreparties.site.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResponseUserData extends ResponseBaseData {
    private User user;
}
