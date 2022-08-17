package kr.co.iotree.sanghproject.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionManager {

    public static final String SESSION_COOKIE_NAME = "mySessionId"; // 왜 상수로 선언했을까? 값을 변하게 하지 않게 하기 위해 일까?
    // HashMap synchronized 키워드가 존재하지 않기 때문에 Multi-Thread 환경에서 사용할 수 없다는 특징을 가지고 있음
    // Hashtable 클래스의 단점을 보완하면서 Multi-Thread 환경에서 사용할 수 있도록 나온 클래스
    private Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    /*
    * 세션 생성
    * * seesionId 생성(임의의 추정 불가능한 랜덤 값)
    * * 세션 저장소에 sessionId와 보관할 값 저장
    * * sessionId로 응답 쿠키를 생성해서 클라이언트에 전달
    */
    public void createSession(Object value, HttpServletResponse response) {

        // 세션 id를 생성하고 값을 세션에 저장
        // UUDI : 네트워크 상에서 고유성이 보장되는 id를 만들기 위한 표준 규약, 중앙 환경이 아닌 분산 컴퓨팅 환경에서 사용되는 식별자
        // 세션을 UUDI로 생성된 식별자로 구분하기로 약속한 걸까?
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, value); // 왜 Object타입을 넣었을까? 아, Map에 키에는 스트링 값에는 오브젝트... 사람인가 나... 생각해보니 jsp 내장 객체도 다시 공부하자

        // 쿠키 생성 후 저장
        Cookie mySessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(mySessionCookie);
    }

    /*
    * 세션 조회... 누가 조회하는 건데? 로컬에 있는 쿠키가 조회하나?? 아래 코드 보니 서버가 조회하는 듯?
    * */
    public Object getSession(HttpServletRequest request, String cookieName) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie == null) {
            return null;
        }

        return sessionStore.get(sessionCookie.getValue());
    }

    /*
     * 세션 만료
     * */
    public void expire(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie != null) {
            // 키값을 제거하지 않고 매핑된 값을 제거하네? 지금보지 getKey 메소드 같은 거도 없음
            sessionStore.remove(sessionCookie.getValue());
        }
    }

    public Cookie findCookie(HttpServletRequest request, String cookieName) {
        if (request.getCookies() == null) {
            return null;
        }
        // stream.filter : 필터는 스트림 내 요소들을 하나씩 평가해서 걸러내는 작업,
        // 인자로 받는 predicate는 boolean을 리턴하는 함수형 인퍼페이스로 평가식이 들어간다.
        // 아래의 경우에는 리퀘스트로 받은 쿠키가 서버의 쿠키 이름과 같은 스트림만 리턴하는 것으로 보임
        // findFirst() vs findAny()
        // orElse() vs orElseGet() , Optional 클래스 객체가 가지고 있는 실제 값이 null 일 경우 어느 값으로 대체해서 return 해줘야 하는지를 정의
        // optional 클래스도 추가 공부할것
        return Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals(cookieName))
                .findAny()
                .orElse(null);
    }
}
