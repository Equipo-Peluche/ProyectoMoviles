package com.apimovil.security;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mongodb.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtils {
	/**
	 * EncryptedKeyGenerator HEX 256
	 * <a> https://asecuritysite.com/encryption/plain </a>
	 */
	@Value("${jwt.secret.key}")
	private String secretKey;

	@Value("${jwt.time.expiration}")
	private String timeExpiration;

	public String generateAccessToken(String username) {
		String compact = Jwts.builder()
				/**
				 * Public part
				 */
				.issuedAt(Date.valueOf(LocalDate.now().plus(1, ChronoUnit.DAYS)))
				.subject(username)
				
				/**
				 * Private part
				 */
				.signWith(getSignatureKey())
				.compact();
		log.debug("JwtUtils: creandotoken " + compact);
		return compact;

	}

	/**
	 * Returns wether the token is valid or not
	 * 
	 * @param	token		Token sent
	 * 
	 * @return	boolean		Returns true if token is valid
	 */
	public Boolean isTokenValid(String token) {
		try {
			getAllClaims(token);
			return true;
		} catch (Exception e) {
			log.error("JWTUtils: Invalid Token. [JwtUtils:64] " + e.getMessage());
			return false;
		}
	}

	/**
	 * Returns username based on token
	 * 
	 * @param	token		Token sent
	 * 
	 * @return	String		Returns username of the user owning the token
	 */
	public String getUSerNameFromToken(String token) {
		return getClaim(token, Claims::getSubject);
	}

	/**
	 * Generates keys using HMAC-SHA with a secret key. The secret key decodes from 
	 * Base64 using "Decoders.BASE64.decode(secretKey)" that expects @param "secretKey"
	 * base64 encoded secret key.
	 * 
	 * This method generates a key to sign using HMAC-SHA with a secret key base64 based
	 * 
	 * @return	SecretKey		Returns secret key encoded
	 */
	private SecretKey getSignatureKey() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
	}

	private Claims getAllClaims(String token) {
		return Jwts.parser().verifyWith(getSignatureKey()).build().parseSignedClaims(token).getPayload();
	}

	private <T> T getClaim(String token, Function<Claims, T> claimsFunctin) {
		Claims allClaims = getAllClaims(token);
		return claimsFunctin.apply(allClaims);
	}

}
