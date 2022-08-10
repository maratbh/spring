package kz.bitlab.bootcampspring.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String surname;
    private int exam;
    private String mark;

    public String getMarkToScreen() {
        String Letter = "A";
        int e = this.getExam();
        if (e >= 90) Letter = "A";
        else if (e >= 75 && e <= 89) Letter = "B";
        else if (e >= 60 && e <= 74) Letter = "C";
        else if (e >= 50 && e <= 59) Letter = "D";
        else Letter = "F";

        return Letter;
    }
}