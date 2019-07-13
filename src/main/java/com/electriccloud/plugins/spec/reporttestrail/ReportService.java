package com.electriccloud.plugins.spec.reporttestrail;

public interface ReportService {

  void sendResults();

  void addPass(String methodName);

  void addFail(String methodName, String errorMessage);

  void addSkip(String methodName);
}
