package com.nigne;

public class PermitRepository {
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

	// �e�X�g�p��PermitRepository�C���X�^���X������āA������Z�b�g�ł���悤�ɂȂ����B
	public static void setTestingInstance(PermitRepository newInstance) {
		instance = newInstance;
	}

	public static PermitRepository getInstance() {
		if (instance == null) {
			return instance = new PermitRepository();
		}
		return instance;
	}

	public Permit findAssociatedPermit(PermitNotice notice) {
		// Permit�̃f�[�^�x�[�X�ɐڑ�����
		
		// notice�Ŏg�p����l��I��
		
		// �X������permit����������݂��邩���m�F���A���݂��Ȃ��ꍇ�̓G���[��ʒm����
		
		// �Y������permit��Ԃ�
		
		return new Permit();// �{���ł͏������s���Ȃ̂ŁA�K���ȃR�[�h��ǉ�
	}
}
