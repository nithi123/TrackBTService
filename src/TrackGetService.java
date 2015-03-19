import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

@Path("/get")
public class TrackGetService {
	@GET
	@Path("/zones")
	@Produces("text/plain")
	public Response getZone(@QueryParam("address") String address) throws ClassNotFoundException, SQLException{
		TrackDao dao=new TrackDao();
	
		return Response.status(200).entity("Success").build();
	}
}
