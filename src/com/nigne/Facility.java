package com.nigne;

public class Facility {
	private Permit basePermit;
	public final static int RESIDENCE = 0;

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
	// singletoneパターン。グローバル変数を使うための仕組みの一つ。
	// テストにおいて大変なのは、そのクラスがどのグローバル変数を使っているかを
	// 理解した上で、それらをテストのために適切な状態に設定しなければならないこと。
	// そして、設定する状態がそれぞれ異なる場合は、テストケース毎に状態の設定を
	// 行う必要がある。これはかなり退屈。

	// Singletonの趣旨はアプリケーションの中でSingletonのインスタンスを一つ以上作れないようにすることであり、
	// 本番コード（製品コード）ではOKかもしれない。しかしテストにおいて各テストは独立すべきで、
	// このSingletonをそれぞれのテストで適切な状態に設定する必要がある。
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
		return new Permit();//本書では処理が不明なので、適当なコードを追加
	}
}
