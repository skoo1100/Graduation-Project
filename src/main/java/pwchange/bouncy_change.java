package pwchange;

import java.io.UnsupportedEncodingException;

import org.bouncycastle.jcajce.provider.digest.Keccak.DigestKeccak;

public class bouncy_change {

		public String CryptoSHA3(String value, int hash) {
		
			// 1.x 버전
	        //~~DigestSHA3 md = new DigestSHA3(hash);~~
	        // 2.x 이상 부터 
	        DigestKeccak  md = new DigestKeccak(hash);
	        try {
	            md.update(value.getBytes("UTF-8"));
	        }
	        catch (UnsupportedEncodingException e){
	            e.printStackTrace();
	        }
	        byte[] digest = md.digest();

	        return org.bouncycastle.util.encoders.Hex.toHexString(digest);
	        // return 에서 bouncycastle쓴다는 것을 알 수 있음
	    }
		
}
