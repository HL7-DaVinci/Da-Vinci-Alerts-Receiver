package org.hl7.davinci.alerts.refimpl.receiver.config;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FhirConfig {

  @Bean
  FhirContext fhirContext() {
    return FhirContext.forR4();
  }

  @Bean
  IParser iParser(FhirContext fhirContext) {
    return fhirContext.newJsonParser()
        .setPrettyPrint(true);
  }

}
