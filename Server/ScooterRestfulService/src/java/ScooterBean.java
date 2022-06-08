
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Brock
 */
@Singleton
public class ScooterBean {

    private List<Scooter> scooters;

    @PostConstruct
    public void init() {
        scooters = new ArrayList<Scooter>();
        addScooter(1, -36.8495, 174.7592, true);
        addScooter(2, -36.8488, 174.7646, false);
        addScooter(3, -36.8541, 174.7673, true);
        addScooter(4, -36.8514, 174.7617, false);
    }

    public void addScooter(int id, double latitude, double longitude, boolean available) {
        scooters.add(new Scooter(id, latitude, longitude, available));
    }

    public boolean removeScooter(int id) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                scooters.remove(scooter);
                return true;
            }
        }
        return false;
    }

    public Collection<Scooter> getScooters() {
        return scooters;
    }

    public void bookScooter(int id, boolean available) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id) {
                scooter.setAvailable(available);
                return;
            }
        }
    }
}
