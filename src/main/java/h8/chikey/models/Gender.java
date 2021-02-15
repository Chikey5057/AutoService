package h8.chikey.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name ="gender")

public class Gender {
    @Id
    @NonNull
    @Column(name ="Code")
    private char genderID;
    @NonNull
    @Column(name ="Name")
    private String gender;



    @OneToMany(mappedBy = "gender")
    Set<Client> set;

    @Override
    public String toString() {
        return "Gender{" +
                "genderID=" + genderID +
                ", gender='" + gender + '\'' +
                '}';
    }
}
