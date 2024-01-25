package dev.skynet.alpha.adapters.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationStartListener implements ApplicationListener<ApplicationStartedEvent> {

  @Value("${spring.datasource.url}")
  private String dataSourceUrl;


  @Override
  public void onApplicationEvent(ApplicationStartedEvent ignored) {


    log.info("Environment variables for latest v2 version:");
    log.info("Database Client created with: [baseUrl: {}]",
             dataSourceUrl
    );

  }
}
