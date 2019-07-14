package com.electriccloud.plugins.spec

import spock.lang.Ignore
import spock.lang.IgnoreIf
import spock.lang.Specification
import spock.lang.Unroll

import com.electriccloud.plugins.spec.reporttestrail.spock.ReportSpockResults

@ReportSpockResults
@IgnoreIf({ System.getenv("TESTRAIL_RUN_TESTS") != 'true' })
class VerifySpockListener extends Specification {

  void "existing" (){
    when: 'first step'
    println "log"

    then:
    def testParam = '1'

    expect: 'second step'
    arg == testParam

    where:
    arg << ['1']
  }

  void "success"() {
    when:

    expect:
    1 == 1
  }

  void "fail"() {
    when:

    expect:
    0 == 1
  }

  @Ignore
  void "skip"() {
    when:

    expect:
    1 == 1
  }

  @Unroll
  void "parameterised (#left ?? #right)"() {
    when:

    expect:
    left == right

    where:
    left | right
    1    | 1
    1    | 2
  }
}
