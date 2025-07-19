package org.mbcboard.apiserver.models.board.dto.getBoardList;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Getter
@Setter
@ToString
@Builder // 세터를 사용하지 않고 빌터 페턴을 사용 아래 2개 어너노테이션 필수
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
public class GetBoardListReq {

    @Builder.Default // 빌터페턴시작시 초기값이 들어감.
    private int page = 1;  // 첫페이지

    @Builder.Default
    private int size = 5; // 게시물 수

    private String scope;  // t, c, w , t c, t w ,t w c  ..... (다중검색용)

    private String search;  // 폼박스에 검색 내용

    private String link;  // 프론트에 페이징번호 클릭시 처리되는 문자열
    // list?page=3&type=w&keyword=kkw


    public String getLink(){

        if(link == null){
            StringBuilder builder = new StringBuilder(); // String + 연산자로 사용하면 객체가 많이생김
            // 이를 해결하기 위한 기법

            builder.append("page=" + this.page); // page=1
            builder.append("&size=" + this.size); // page=1&size=10

            if(scope != null && scope.length() >0 ){
                // 타입이 있을 때
                builder.append("&scope=" + scope); // page=1&size=10&type=???

            } // 타입이 있을 때 if문 종료

            if(search != null){
                try {
                    builder.append("&search=" + URLEncoder.encode(search,"UTF-8"));
                    // page=1&size=10&type=???&keyword=????
                }catch (UnsupportedEncodingException e){
                    log.info(e.getStackTrace());
                    log.info("UTF-8 처리중 오류발생");
                } // try문 종료
            } // 키워드 if문 종료
            link = builder().toString(); // 최종 결과물이 문자열로 변환되어 link에 저장
        } // if 문 종료
        return link; // page=1&size=10&type=???&keyword=????

    }// 메서드 종료


    // 추가메서드
    public String[] getScopes(){
        // 프론트에서 문자열이 여러개가 넘어오면 배열로 변환
        if(scope ==null || scope.isEmpty()){
            // 넘어온 값이 널이거나 비어 있으면
            return null;
        }
        return scope.split(" "); // 차후에 프론트에 폼박스 확인하고 조절!!!!
        // 문자열로 넘어온 값일 분할하여 배열에 꼽는다.
    }

    /**
     * @param sortColumns
     * 정렬 column 명
     * @return
     */
    public Pageable getPageable(String...sortColumns){ // String...props 배열이 몇개가 들어올지 모를때
        if (sortColumns.length > 0)
            return PageRequest.of(this.page-1, this.size, Sort.by(sortColumns).descending());
        //                    페이지번호     게시물 수    정렬기법
        else
            return PageRequest.of(this.page-1, this.size);
    }
}
