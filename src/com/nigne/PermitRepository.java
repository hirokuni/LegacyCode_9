package com.nigne;

public class PermitRepository {
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

	// テスト用のPermitRepositoryインスタンスを作って、それをセットできるようになった。
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
		// Permitのデータベースに接続する
		
		// noticeで使用する値を選ぶ
		
		// 街頭するpermitが一つだけ存在するかを確認し、存在しない場合はエラーを通知する
		
		// 該当するpermitを返す
		
		return new Permit();// 本書では処理が不明なので、適当なコードを追加
	}
}
