package com.electriccloud.plugins.spec.reporttestrail.spock;

import com.electriccloud.plugins.spec.reporttestrail.ReportServiceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spockframework.runtime.extension.AbstractGlobalExtension;

/**
 * Custom spock global extension, which at the end of test suite execution sends results to Test Rail.
 */
public class SpockGlobalExtension extends AbstractGlobalExtension {

  private static final Logger logger = LoggerFactory.getLogger(SpockGlobalExtension.class);

  @Override
  public void stop() {
    try {
      ReportServiceProvider.getReportService().sendResults();
    } catch (Exception e) {
      logger.error("Could not send results to TestRail.", e);
    }
    super.stop();
  }
}
