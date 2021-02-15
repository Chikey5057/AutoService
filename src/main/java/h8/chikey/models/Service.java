package h8.chikey.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor

@Table(name ="service")
public class Service {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int serviceId;
    @NonNull
    @Column(name = "Title")
    private String title;
    @NonNull
    @Column(name = "Count")
    private  int count;
    @NonNull
    @Column(name = "Discount")
    private double discount;
    @NonNull
    @Column(name = "DurationInSeconds")
    private int timeInSecond;


    @OneToMany(mappedBy = "serviceId")
    Set<ClientService> setService;

    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", dicount=" + discount +
                ", timeInSecond=" + timeInSecond +
                '}';
    }
}
