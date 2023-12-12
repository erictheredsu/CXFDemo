package org.cxf_rs.service;

import org.cxf_rs.domain.GetVersionResult;
import org.cxf_rs.domain.IsUserLicensedParam;
import org.cxf_rs.domain.IsUserLicensedResult;

public class LicenseServiceImpl implements org.cxf_rs.service.LicensePublicService {
    @Override
    public IsUserLicensedResult IsUserLicensed(IsUserLicensedParam param) {
        IsUserLicensedResult resp = new IsUserLicensedResult();
        if(param.wstrUser != null)
        {
            resp.ReturnCode = 0;
            resp.IsUserLicensed = true;
        }
        else
        {
            resp.ReturnCode = 1000004;
            resp.IsUserLicensed = false;
        }

        return resp;
    }

    @Override
    public GetVersionResult GetVersion() {
        GetVersionResult resp = new GetVersionResult();
        resp.ReturnCode = 10000;
        resp.sVersion = "10.00.250";
        return resp;
    }
}
