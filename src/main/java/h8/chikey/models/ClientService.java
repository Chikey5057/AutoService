package h8.chikey.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name ="clientservise")

public class ClientService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientServiceID;

    @NonNull
    @ManyToOne
    private Client clientId;

    @NonNull
    @ManyToOne
    private Service serviceId;

    @NonNull
    @Column(name = "StartTime")
    private Date startTime;

    @Override
    public String toString() {
        return "ClientService{" +
                "clientServiceID=" + clientServiceID +
                ", clientId=" + clientId +
                ", serviceId=" + serviceId +
                ", startTime=" + startTime +
                '}';
    }
}
