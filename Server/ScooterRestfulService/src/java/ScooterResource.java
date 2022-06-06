
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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

    @EJB
    private ScooterBean scooterBean;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllScooters()
    {
        StringBuilder buffer = new StringBuilder();

        buffer.append("[");

        Collection<Scooter> allScooters = scooterBean.getScooters();
        for (Scooter scooter : allScooters) {
            buffer.append(scooter.getJsonString());
            buffer.append(",");
        }
        buffer.deleteCharAt(buffer.length() - 1);

        buffer.append("]");

        return buffer.toString();
    }

    @PATCH
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/book/{id}/{available}")
    public void bookScooter(@PathParam("id") int id, @PathParam("available") boolean available) {
        scooterBean.bookScooter(id, available);
    }
}
