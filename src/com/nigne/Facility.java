package com.nigne;

public class Facility {
	private Permit basePermit;
	public final static int RESIDENCE = 0;
    public Facility(){
    	
    }
	public Facility(int facilityCode, String owner, PermitNotice notice)
			throws PermitViolation {
		// ���܂݂̃X�e�[�g�����g�B�R���X�g���N�^���p�����[�^�����邱�Ƃł��߂�����
		// ��������Ȃ����A�قړ����悤�ȃR�[�h�����̂P�O���̃N���X�ɑ��݂���̂ŁA�R���X�g���N�^��
		// �p�����[�^�����Ă������ɂ͎��Ԃ��K�v
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

