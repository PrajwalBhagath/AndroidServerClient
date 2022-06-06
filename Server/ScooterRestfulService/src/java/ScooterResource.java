
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Collection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Brock
 */

@Named
@Path("/scooters")
public class ScooterResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllScooters()
    {
        StringBuilder buffer = new StringBuilder();

        buffer.append("[");

        Collection<Scooter> allScooters = scootersBean.getScooters();
        for (Scooter scooter : allScooters) {
            buffer.append(scooter.getJsonString());
        }

        buffer.append("]");

        return buffer.toString();
    }
}
