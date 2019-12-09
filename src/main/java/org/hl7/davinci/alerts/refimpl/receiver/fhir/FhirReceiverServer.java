package org.hl7.davinci.alerts.refimpl.receiver.fhir;

import ca.uhn.fhir.rest.server.HardcodedServerAddressStrategy;
import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.RestfulServer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/fhir/*"}, displayName = "FHIR Receiver")
public class FhirReceiverServer extends RestfulServer {

  private static final long serialVersionUID = 1L;

  private SystemProvider systemProvider;

  @Autowired
  public FhirReceiverServer(SystemProvider systemProvider) {
    this.systemProvider = systemProvider;
  }

  @Override
  protected void initialize() throws ServletException {
    String serverBaseUrl = "http://demo.com/fhir";
    setServerAddressStrategy(new HardcodedServerAddressStrategy(serverBaseUrl));

    registerProvider(systemProvider);

    List<IResourceProvider> resourceProviders = new ArrayList<>();
    setResourceProviders(resourceProviders);
  }

}
