package com.example.examplesecurity.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.examplecommon.util.DateUtils;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static final String SECRET = "t1o2k3e4n5_s9e8c7r6e5t";
    private static final String ISSUER = "star_jwt";
    public static String genJwt(Map<String, String> claims) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE,30);
            Date date1 = calendar.getTime();
            System.out.println(date1);

            JWTCreator.Builder builder = JWT.create().withIssuer(ISSUER).withExpiresAt(date1);
            claims.forEach(builder::withClaim);
            return builder.sign(algorithm);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Map<String, String> verifyToken(String token)  {
        Map<String, String> ret = new HashMap();
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
            DecodedJWT jwt =  verifier.verify(token);
            Map<String, Claim> map = jwt.getClaims();
            map.forEach((k,v)->ret.put(k,v.asString()));

            ret.put("exp",map.get("exp").asDate().toString());
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
        return ret;
    }

    public static void main(String[] args){
        Map<String, String> claims = new HashMap<String, String>();
        /*
        "appKey": "string",
        "appSecret": "string"
        appKey: sh_12345
        appSecret：12879228a4294b41b07c1d7dc462dc31
        */
        claims.put("appKey","sh_12345");
        claims.put("appSecret","12879228a4294b41b07c1d7dc462dc31");
        String token = genJwt(claims);
        System.out.println(token);

        Map<String, String> claims1 = new HashMap<String, String>();
        claims1 = verifyToken(token);
        System.out.println(claims1.get("appKey"));
        System.out.println(claims1.get("appSecret"));


    }
}
