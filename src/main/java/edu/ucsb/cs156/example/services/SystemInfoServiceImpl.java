package edu.ucsb.cs156.example.services;


import edu.ucsb.cs156.example.models.SystemInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

// This class relies on property values
// For hints on testing, see: https://www.baeldung.com/spring-boot-testing-configurationproperties

@Slf4j
@Service("systemInfo")
@ConfigurationProperties
public class SystemInfoServiceImpl extends SystemInfoService {
  
  /**
   * This method returns a boolean based on the value 'spring.h2.console.enabled' in the application properties
   * for whether or not to display the link to the h2 console.
   * 
   * @return boolean
   */ 
  @Value("${spring.h2.console.enabled:false}")
  private boolean springH2ConsoleEnabled;

  /**
   * This method returns a boolean based on the value 'app.showSwaggerUILink' in the application properties
   * for whether or not to display the link to swagger-ui. 
   * 
   * @return boolean
   */ 
  @Value("${app.showSwaggerUILink:false}")
  private boolean showSwaggerUILink;

  /**
   * This method returns the system information.
   * @see edu.ucsb.cs156.example.models.SystemInfo
   * @return the system information
   */
  public SystemInfo getSystemInfo() {
    SystemInfo si = SystemInfo.builder()
    .springH2ConsoleEnabled(this.springH2ConsoleEnabled)
    .showSwaggerUILink(this.showSwaggerUILink)
    .build();
  log.info("getSystemInfo returns {}",si);
  return si;
  }

}
