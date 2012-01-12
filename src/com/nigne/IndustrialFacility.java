package com.nigne;

public class IndustrialFacility extends Facility {
	Permit basePermit;

	//�R���X�g���N�^�ɑ΂��ēn���ׂ�OriginationPermit����邱�Ƃ�����B
	public IndustrialFacility(int facilityCode, String owner,
			OriginationPermit permit) throws PermitViolation {
		super();
		Permit associatedPermit = PermitRepository.getInstance()
				.findAssociatedFromOrigination(permit);

		if (associatedPermit.isValid() && !permit.isValid()) {
			basePermit = associatedPermit;
		} else if (!permit.isValid()) {
			permit.validate();
			basePermit = permit;
		} else {
			throw new PermitViolation(permit);
		}
	}
}
