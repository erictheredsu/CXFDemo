package org.cxf_rs.server;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

import org.cxf_rs.service.LicenseServiceImpl;

public class CXFApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> s = new HashSet<Class<?>>();
        s.add(JacksonJsonProvider.class);
        return s;
    }

    private Set<Object> singletons = new HashSet<Object>();

    public CXFApplication() {
        System.setProperty("enableFileAudit", "true");
        singletons.add(new LicenseServiceImpl());

        JacksonJsonProvider jacksonProvider = new JacksonJsonProvider();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        jacksonProvider.setMapper(mapper);
        singletons.add(jacksonProvider);

        //Try to load SLD datasource.

    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}