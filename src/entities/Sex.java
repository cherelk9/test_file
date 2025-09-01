package entities;

import java.io.Serializable;

public enum Sex implements Serializable {
    MALE('M'),
    FEMALE('F');
    char gender;
    Sex(char gender) {
        gender = gender;
    }
}