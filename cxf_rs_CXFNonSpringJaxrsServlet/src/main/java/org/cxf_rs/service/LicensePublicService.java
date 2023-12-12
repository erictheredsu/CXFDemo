package org.cxf_rs.service;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;
import org.cxf_rs.domain.GetVersionResult;
import org.cxf_rs.domain.IsUserLicensedParam;
import org.cxf_rs.domain.IsUserLicensedResult;

@Path("/license")
@Produces("*/*")
@Provider
public interface LicensePublicService {
    @POST
    @Path("/IsUserLicensed")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public IsUserLicensedResult IsUserLicensed(IsUserLicensedParam param);


    @GET
    @Path("/GetVersion")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public GetVersionResult GetVersion();

}
