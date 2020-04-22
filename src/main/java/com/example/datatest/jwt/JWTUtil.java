package com.example.datatest.jwt;

import java.util.Calendar;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * JWT
 * 
 * @Author xuebiao
 * @Date 2020年4月22日
 * @Description: 使用JJWT，它是为了更友好在JVM上使用JWT，是基本于JWT, JWS, JWE, JWK框架的Java实现。
 *               生成，解析token，完成
 */
public class JWTUtil {

	private static final String SECRET_KEY = "123456xb";
	private static final int CALENDAR_INTERVAL = 10;// 有效期（ 天）

	public static String createJWT(Integer userId, String name) {

		Date iatDate = new Date();
		// expire time
		Calendar nowTime = Calendar.getInstance();
		// 有10天有效期
		nowTime.add(Calendar.DATE, CALENDAR_INTERVAL);
		Date expiresDate = nowTime.getTime();
		Claims claims = Jwts.claims();
		claims.put("name", name);
		claims.put("userId", userId);
		claims.setAudience("admin");
		claims.setIssuer("admin");
		String token = Jwts.builder()
				.setHeaderParam("typ", "JWT").setClaims(claims).setNotBefore(iatDate).setExpiration(expiresDate)
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();

		return token;

	}
	
	public static Claims parseJWT(String jwt) {
		try {
			Claims claims = Jwts.parser()  //得到DefaultJwtParser
			        .setSigningKey(SECRET_KEY)//设置签名的秘钥
			        .parseClaimsJws(jwt).getBody();//设置需要解析的jwt
			return claims;
		} catch (ExpiredJwtException e) {
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return  null;
	}
}
