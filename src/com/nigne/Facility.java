package com.nigne;

public class Facility {
	private Permit basePermit;
	public final static int RESIDENCE = 0;
    public Facility(){
    	
    }
	public Facility(int facilityCode, String owner, PermitNotice notice)
			throws PermitViolation {
		// 問題含みのステートメント。コンストラクタをパラメータ化することでやり過ごせる
		// かもしれないが、ほぼ同じようなコードが他の１０ものクラスに存在するので、コンストラクタを
		// パラメータ化しても解決には時間が必要
		Permit associatedPermit = PermitRepository.getInstance()
				.findAssociatedPermit(notice);

		if (associatedPermit.isValid()) {
			basePermit = associatedPermit;
		} else if (!notice.isValid()) {
			Permit permit = new Permit(notice);
			permit.validate();
			basePermit = permit;
		} else
			throw new PermitViolation();
	}
}


class Permit {

	public Permit(PermitNotice notice) {

	}

	public Permit() {

	}

	boolean isValid() {
		return true;
	}

	public void validate() {

	}

}

