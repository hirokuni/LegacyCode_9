package com.nigne;

public class AndroidTestCase {

  public void testCreate() throws Exception{
	PermitNotice notice = new PermitNotice(0,"a");
	//Want create facility in test code
	Facility facility = new Facility(Facility.RESIDENCE, "b", notice);
  }
}
