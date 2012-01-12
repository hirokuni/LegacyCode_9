package com.nigne;

import java.util.HashMap;
import java.util.Map;

public class TestingPermitRepository extends PermitRepository {
  private Map permits = new HashMap();

  public void addAssociatedPermit(PermitNotice notice, Permit permit){
	  permits.put(notice, permit);
  }

  public Permit findAssociatedPermit(PermitNotice notice){
	  return (Permit)permits.get(notice);
  }
}
