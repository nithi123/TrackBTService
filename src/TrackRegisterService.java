import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;


@Path("/Register")
public class TrackRegisterService {
	@GET
	@Path("/zone")
	@Produces("text/plain")
	public Response RegisterZone(@QueryParam("name") String name,@QueryParam("address") String address) throws ClassNotFoundException, SQLException{
		TrackDao dao=new TrackDao();
		dao.insertZone(name,address);
		return Response.status(200).entity("Success").build();
	}

	@GET
	@Path("/device")
	@Produces("text/plain")
	public Response RegisterDevice(@QueryParam("name") String name,@QueryParam("address") String address,@QueryParam("zone")String zone) throws ClassNotFoundException, SQLException{
		TrackDao dao=new TrackDao();
		dao.insertDevice(name, address, zone);
		return Response.status(200).entity("Success").build();
	}
}
