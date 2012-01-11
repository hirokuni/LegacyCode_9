package com.nigne;

public class AndroidTestCase {
  public void setup() {
	  PermitRepository repository = new PermitRepository();
	  //・・何かの処理
	  
	  //ここでset関数(setTestingInstance)を使ってpermitをrepositoryに登録する
	  
	  //・・何かの処理
  }

  public void testCreate() throws Exception{
	PermitNotice notice = new PermitNotice(0,"a");
	//Want create facility in test code
	Facility facility = new Facility(Facility.RESIDENCE, "b", notice);
  }
}
