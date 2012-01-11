package com.nigne;

public class Facility {
	private Permit basePermit;
	public final static int RESIDENCE = 0;

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

class PermitViolation extends Exception {

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

class PermitRepository {
	// singletone�p�^�[���B�O���[�o���ϐ����g�����߂̎d�g�݂̈�B
	// �e�X�g�ɂ����đ�ςȂ̂́A���̃N���X���ǂ̃O���[�o���ϐ����g���Ă��邩��
	// ����������ŁA�������e�X�g�̂��߂ɓK�؂ȏ�Ԃɐݒ肵�Ȃ���΂Ȃ�Ȃ����ƁB
	// �����āA�ݒ肷���Ԃ����ꂼ��قȂ�ꍇ�́A�e�X�g�P�[�X���ɏ�Ԃ̐ݒ��
	// �s���K�v������B����͂��Ȃ�ދ��B

	// Singleton�̎�|�̓A�v���P�[�V�����̒���Singleton�̃C���X�^���X����ȏ���Ȃ��悤�ɂ��邱�Ƃł���A
	// �{�ԃR�[�h�i���i�R�[�h�j�ł�OK��������Ȃ��B�������e�X�g�ɂ����Ċe�e�X�g�͓Ɨ����ׂ��ŁA
	// ����Singleton�����ꂼ��̃e�X�g�œK�؂ȏ�Ԃɐݒ肷��K�v������B
	private static PermitRepository instance;

	private PermitRepository() {
	}

	public static PermitRepository getInstance() {
		if (instance == null) {
			return instance = new PermitRepository();
		}
		return instance;
	}

	public Permit findAssociatedPermit(PermitNotice notice) {
		return new Permit();//�{���ł͏������s���Ȃ̂ŁA�K���ȃR�[�h��ǉ�
	}
}
