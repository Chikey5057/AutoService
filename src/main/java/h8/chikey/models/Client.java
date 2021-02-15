package h8.chikey.models;

import lombok.*;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name ="client")

public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int clientID;

    @NonNull
    @Column(name ="FirstName")
    private String firstName;

    @NonNull
    @Column(name ="LastName")
    private String lastName;

    @NonNull
    @Column(name ="Patronymic")
    private String patronymic;

    @NonNull
    @Column(name ="Birthday")
    private Date birthday;

    @NonNull
    @Column(name ="RegistrationDate")
    private Date registrationDate;

    @NonNull
    @Column(name ="Email")
    private String email;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "GenderCode")
    private Gender gender;


    @NonNull
    @Column(name ="Phone")
    private String phone;
    @NonNull
    @Column(name ="PhotoPath")
    private String PhotoPath;

    @OneToMany(mappedBy = "clientId")
    Set<ClientService> setClient;

    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", PhotoPath='" + PhotoPath + '\'' +
                '}';
    }
}
